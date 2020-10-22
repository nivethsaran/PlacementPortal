package controllers;

import models.Faculty;
import models.Student;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import java.io.File;
import java.sql.*;
import java.util.ArrayList;

public class AuthenticationController {

    Connection con;

    public AuthenticationController()
    {
        try {
            this.con = DriverManager.getConnection
                    ("jdbc:mysql://localhost:3306/preparely", "root",
                            "1234");
        }
        catch (SQLException e)
        {
            System.out.println("Connection Error:"+e.getLocalizedMessage());
        }
    }

    public static void main(String args[])
    {
//        try {
//            Class.forName("com.mysql.cj.jdbc.Driver");
//        }
//        catch(ClassNotFoundException e) {
//            System .out.println("Class not found "+ e);
//        }
        AuthenticationController authenticationController=new AuthenticationController();
//        authenticationController.getStudentData();
//        authenticationController.getFacultyData();
        authenticationController.parseFacultyXML("E:\\Java_Projects\\PlacementPortalFrontend\\review2\\XML\\faculty.xml");
        authenticationController.parseStudentXML("E:\\Java_Projects\\PlacementPortalFrontend\\review2\\XML\\student.xml");
    }

    public void parseStudentXML(String xml)
    {
        try {
            DocumentBuilderFactory docBuilderFactory;
            docBuilderFactory = DocumentBuilderFactory.newInstance();
            DocumentBuilder docBuilder =
                    docBuilderFactory.newDocumentBuilder();
            Document doc = docBuilder.parse(new File(xml));
            doc.getDocumentElement().normalize();
            String tablename="student";
            NodeList listOfProducts = doc.getElementsByTagName("student");
            System.out.println(listOfProducts.getLength());
            Statement stmt = con.createStatement();
            for (int i = 0; i < listOfProducts.getLength(); i++) {
                Node product = listOfProducts.item(i);
                Element productElement = (Element) product;
                String fullname= productElement.getElementsByTagName("fullname").item(0).getTextContent();
                String rollno= productElement.getElementsByTagName("rollno").item(0).getTextContent();
                String authpassword=productElement.getElementsByTagName("authpassword").item(0).getTextContent();
                String avatarurl= productElement.getElementsByTagName("avatarurl").item(0).getTextContent();
                String mobilenumber = productElement.getElementsByTagName("mobilenumber").item(0).getTextContent();
                String email = productElement.getElementsByTagName("email").item(0).getTextContent();
                String department = productElement.getElementsByTagName("department").item(0).getTextContent();
                String SQL_QUERY= "INSERT INTO "+tablename+ " VALUES ('"+
                        fullname+"','"+
                        rollno+"','"+
                        authpassword+"','"+
                        avatarurl+"','"+
                        mobilenumber+"','"+
                        email+"','"+
                        department+"')";

                System.out.println(SQL_QUERY);
                stmt.executeUpdate(SQL_QUERY);

            }
            System.out.println("Inserted records into the table...");
        }
        catch(Exception e)
        {
            System.out.println(e.getLocalizedMessage());
        }
    }

    public void parseFacultyXML(String xml)
    {
        try {
            DocumentBuilderFactory docBuilderFactory;
            docBuilderFactory = DocumentBuilderFactory.newInstance();
            DocumentBuilder docBuilder =
                    docBuilderFactory.newDocumentBuilder();
            Document doc = docBuilder.parse(new File(xml));
            doc.getDocumentElement().normalize();
            String tablename="faculty";
            NodeList listOfProducts = doc.getElementsByTagName("faculty");
            System.out.println(listOfProducts.getLength());
            Statement stmt = con.createStatement();
            for (int i = 0; i < listOfProducts.getLength(); i++) {
                Node product = listOfProducts.item(i);
                Element productElement = (Element) product;
                String fullname= productElement.getElementsByTagName("fullname").item(0).getTextContent();
                String facultyid= productElement.getElementsByTagName("facultyid").item(0).getTextContent();
                String authpassword=productElement.getElementsByTagName("authpassword").item(0).getTextContent();
                String avatarurl= productElement.getElementsByTagName("avatarurl").item(0).getTextContent();
                String mobilenumber = productElement.getElementsByTagName("mobilenumber").item(0).getTextContent();
                String email = productElement.getElementsByTagName("email").item(0).getTextContent();
                String department = productElement.getElementsByTagName("department").item(0).getTextContent();
                String SQL_QUERY= "INSERT INTO "+tablename+ " VALUES ('"+
                        fullname+"','"+
                        facultyid+"','"+
                        authpassword+"','"+
                        avatarurl+"','"+
                        mobilenumber+"','"+
                        email+"','"+
                        department+"')";

                System.out.println(SQL_QUERY);
                stmt.executeUpdate(SQL_QUERY);

            }
            System.out.println("Inserted records into the table...");
        }
        catch(Exception e)
        {
            System.out.println(e.getLocalizedMessage());
        }
    }

    public ArrayList<Student> getStudentData()
    {
        ArrayList<Student> students=new ArrayList<Student>();
        try {
            Statement stmt = con.createStatement();
            ResultSet rs = stmt.executeQuery
                    ("SELECT * FROM student");
            while (rs.next()) {
                Student currStudent=new Student(
                        rs.getString("fullname"),
                        rs.getString("rollno"),
                        rs.getString("authpassword"),
                        rs.getString("avatarurl"),
                        rs.getString("mobilenumber"),
                        rs.getString("email"),
                        rs.getString("department")
                );
                System.out.println(currStudent.toString());
                students.add(currStudent);
            }
            return students;
        }
        catch (SQLException e)
        {
            System.out.println(e.getLocalizedMessage());
            return null;
        }
    }



    public ArrayList<Faculty> getFacultyData()
    {
        ArrayList<Faculty> faculties=new ArrayList<Faculty>();
        try {
            Statement stmt = con.createStatement();
            ResultSet rs = stmt.executeQuery
                    ("SELECT * FROM faculty");
            while (rs.next()) {
                Faculty currFaculty=new Faculty(
                        rs.getString("fullname"),
                        rs.getString("facultyid"),
                        rs.getString("authpassword"),
                        rs.getString("avatarurl"),
                        rs.getString("mobilenumber"),
                        rs.getString("email"),
                        rs.getString("department")
                );
                System.out.println(currFaculty.toString());
                faculties.add(currFaculty);
            }
            return faculties;
        }
        catch (SQLException e)
        {
            System.out.println(e.getLocalizedMessage());
            return null;
        }
    }
}



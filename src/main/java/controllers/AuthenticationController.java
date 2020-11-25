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

import static utils.CONSTANTS.*;

public class AuthenticationController {

    Connection con;

    public AuthenticationController()
    {

        try {
//            DriverManager.registerDriver(new com.mysql.jdbc.Driver ());
            Class.forName("com.mysql.cj.jdbc.Driver");
            this.con = DriverManager.getConnection
                    (SQL_CONN_STRING, SQL_USERNAME,
                            SQL_PASSWORD);
        }
        catch (SQLException e)
        {
            System.out.println("Connection Error:"+e.getLocalizedMessage());
        } catch (ClassNotFoundException e) {
            System.out.println("Class Not Found Error:"+e.getLocalizedMessage());
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
        authenticationController.getAllStudentData();
//        authenticationController.getFacultyData();
//        authenticationController.parseFacultyXML("E:\\Java_Projects\\PlacementPortalFrontend\\review2\\XML\\faculty.xml");
//        authenticationController.parseStudentXML("E:\\Java_Projects\\PlacementPortalFrontend\\review2\\XML\\student.xml");
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

    public ArrayList<Student> getAllStudentData()
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


    public Student getStudentData(String rollnoinput)
    {
        try {
            Statement stmt = con.createStatement();
            Student currStudent = new Student(null,null,null,null, null,
                    null,null);
            String query = "SELECT * FROM student where rollno = '" + rollnoinput + "'";
            System.out.println(query);
            ResultSet rs = stmt.executeQuery(query);
            int rowCount = 0;
            while (rs.next()) {
                rowCount++;
                currStudent=new Student(
                        rs.getString("fullname"),
                        rs.getString("rollno"),
                        rs.getString("authpassword"),
                        rs.getString("avatarurl"),
                        rs.getString("mobilenumber"),
                        rs.getString("email"),
                        rs.getString("department")
                );
            }
            if(rowCount>0)
            return currStudent;
            else
            {
                return null;
            }
        }
        catch (SQLException e)
        {
            System.out.println(e.getLocalizedMessage());
            return null;
        }
    }



    public Faculty getFacultyData(String facid)
    {
        try {
            Statement stmt = con.createStatement();
            Faculty currFaculty = new Faculty(null,null,null,null, null,
                    null,null);
            ResultSet rs = stmt.executeQuery
                    ("SELECT * FROM faculty where facultyid = '" + facid + "'");
            int rowCount = 0;
            while (rs.next()) {
                rowCount++;
               currFaculty = new Faculty(
                        rs.getString("fullname"),
                        rs.getString("facultyid"),
                        rs.getString("authpassword"),
                        rs.getString("avatarurl"),
                        rs.getString("mobilenumber"),
                        rs.getString("email"),
                        rs.getString("department")
                );
            }
            if(rowCount>0)
            {
                return currFaculty;
            }
            else {
                return null;
            }
        }
        catch (SQLException e)
        {
            System.out.println(e.getLocalizedMessage());
            return null;
        }
    }

    public ArrayList<Faculty> getAllFacultyData()
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

    public boolean insertFaculty(Faculty faculty)
    {
        try{
            Statement stmt = con.createStatement();

            String SQL_QUERY = "INSERT INTO FACULTY VALUES ('"+faculty.getFullname()+"','"+faculty.getFacultyid()+"','"+faculty.getAuthpassword()+"','"+faculty.getAvatarurl()+"','"+faculty.getMobilenumber()+"','"+faculty.getEmail()+"','"+faculty.getDepartment()+"')";
            stmt.executeUpdate(SQL_QUERY);
            return true;
        }
        catch (SQLException e)
        {
            System.out.println(e.getLocalizedMessage());
            return false;
        }
    }

    public boolean insertStudent(Student student)
    {
        try{
            Statement stmt = con.createStatement();
            String SQL_QUERY = "INSERT INTO STUDENT VALUES ('"+student.getFullname()+"','"+student.getRollno()+"','"+student.getAuthpassword()+"','"+student.getAvatarurl()+"','"+student.getMobilenumber()+"','"+student.getEmail()+"','"+student.getDepartment()+"')";
            stmt.executeUpdate(SQL_QUERY);
            return true;
        }
        catch (SQLException e)
        {
            System.out.println(e.getLocalizedMessage());
            return false;
        }
    }
}



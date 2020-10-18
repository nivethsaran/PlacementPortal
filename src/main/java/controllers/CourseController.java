package controllers;

import models.Courses;
import models.Quiz;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import java.io.File;
import java.sql.*;
import java.util.ArrayList;
//TODO : Tablenames arent proper in INSERT STATEMENTS, DO FIX IT

public class CourseController {

    Connection con;
    public CourseController()
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
        CourseController controller=new CourseController();
        controller.getCourses();
    }

    public void parseCourseXML(String xml)
    {
        try {
            DocumentBuilderFactory docBuilderFactory;
            docBuilderFactory = DocumentBuilderFactory.newInstance();
            DocumentBuilder docBuilder =
                    docBuilderFactory.newDocumentBuilder();
            Document doc = docBuilder.parse(new File(xml));
            doc.getDocumentElement().normalize();
            String tablename=
                    doc.getDocumentElement().getNodeName();
            NodeList listOfProducts = doc.getElementsByTagName("course");
            System.out.println(listOfProducts.getLength());
            Statement stmt = con.createStatement();
            for (int i = 0; i < listOfProducts.getLength(); i++) {
                Node product = listOfProducts.item(i);
                Element productElement = (Element) product;
                String courseid= productElement.getElementsByTagName("courseid").item(0).getTextContent();
                String coursename=productElement.getElementsByTagName("coursename").item(0).getTextContent();
                String topicname= productElement.getElementsByTagName("topicname").item(0).getTextContent();
                String department = productElement.getElementsByTagName("department").item(0).getTextContent();
                String courseurl = productElement.getElementsByTagName("courseurl").item(0).getTextContent();
                String facultyid = productElement.getElementsByTagName("facultyid").item(0).getTextContent();
                String SQL_QUERY= "INSERT INTO "+tablename+ " VALUES ('"+
                        courseid+"','"+
                        coursename+"','"+
                        topicname+"','"+
                        department+"','"+
                        courseurl+"','"+
                        facultyid+"')";

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

    public ArrayList<Courses> getCourses()
    {
        ArrayList<Courses> courses=new ArrayList<Courses>();
        try {
            Statement stmt = con.createStatement();
            ResultSet rs = stmt.executeQuery
                    ("SELECT * FROM courses");
            while (rs.next()) {
                Courses currCourse=new Courses(
                        rs.getInt("courseid"),
                        rs.getString("coursename"),
                        rs.getString("topicname"),
                        rs.getString("department"),
                        rs.getString("courseurl"),
                        rs.getString("facultyid")
                );
                System.out.println(currCourse.toString());
                courses.add(currCourse);
            }
            return courses;
        }
        catch (SQLException e)
        {
            System.out.println(e.getLocalizedMessage());
            return null;
        }
    }
}

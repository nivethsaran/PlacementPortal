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
import java.util.HashMap;
import java.util.Map;

import static utils.CONSTANTS.*;
//TODO : Tablenames arent proper in INSERT STATEMENTS, DO FIX IT

public class CourseController {

    Connection con;
    public CourseController()
    {
        try {
            this.con = DriverManager.getConnection
                    (SQL_CONN_STRING, SQL_USERNAME,
                            SQL_PASSWORD);
        }
        catch (SQLException e)
        {
            System.out.println("Connection Error:"+e.getLocalizedMessage());
        }
    }

    public static void main(String args[])
    {
        CourseController controller=new CourseController();
//        controller.getCourses();
//        controller.parseCourseXML("E:\\Java_Projects\\PlacementPortalFrontend\\review2\\XML\\courses.xml");
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

    public void addToCourse(String cname, String tname, String dept, String curl, String fac_id) throws ClassNotFoundException {
        try {
            Statement stmt = con.createStatement();
            String SQL_QUERY = "INSERT INTO courses (coursename, topicname, department, courseurl, facultyid) VALUES "+
                    "('"+cname+
                    "','" +tname+
                    "','"+dept+
                    "','"+curl+
                    "','"+ fac_id+ "')";

            stmt.executeUpdate(SQL_QUERY);
        }
        catch(SQLException e) {
            System .out.println("Exception occurred: "+ e);
        }
    }

    public void deleteFromCourse(int cid){
        try{Statement stmt = con.createStatement();
            stmt.executeUpdate("DELETE FROM courses WHERE " +
                    "courseid="+cid+";");
            System.out.println("deleted element.");
        } catch (SQLException e) {
            System .out.println("Exception occurred: "+ e);
        }
    }

    public void updateCourse(int cid, String coursename, String topicname, String department, String courseurl) throws ClassNotFoundException {
        try {
            Statement stmt = con.createStatement();
            String SQL_QUERY = "UPDATE courses SET " +
                    "coursename = '"+coursename+
                    "', topicname= '"+topicname+
                    "', department = '"+department+
                    "', courseurl = '"+courseurl+
                    "' WHERE courseid = "+cid+";";

            System.out.print("Executed: "+SQL_QUERY);
            stmt.executeUpdate(SQL_QUERY);
        }
        catch(SQLException e) {
            System .out.println("Exception occurred: "+ e);
        }
    }

    public boolean checkIfTopicNotExists(String topic, String dept){
        try{
            Statement stmt = con.createStatement();
            ResultSet rs = stmt.executeQuery("SELECT topicname FROM courses WHERE " +
                    "department='"+dept+"'");
            while(rs.next()){
                if(rs.getString("topicname").equals(topic)){
                    // if the topic already exists
                    return false;
                }
            }

            // if the topicname doesn't exist
            System.out.println("Topicname doesnt exists.");
            return true;
        }
        catch(SQLException e){
            System .out.println("Exception occurred: "+ e);
        }
        return false;
    }

    //    function to get the existing form fields
    public Map<String,String> getExistingValues(int cid) {

        Map<String,String> userpass = new HashMap<String,String>();

        try{
            Statement stmt = con.createStatement();
            ResultSet rs = stmt.executeQuery("SELECT coursename, topicname, department, courseurl FROM courses WHERE courseid='"+cid+"'");
            String coursename = null;
            String topicname = null;
            String department = null;
            String courseurl = null;
            while(rs.next()){
                coursename = rs.getString("coursename");
                topicname = rs.getString("topicname");
                department = rs.getString("department");
                courseurl = rs.getString("courseurl");
            }


            userpass.put("coursename", coursename);
            userpass.put("topicname", topicname);
            userpass.put("department", department);
            userpass.put("courseurl", courseurl);

            return userpass;
        }
        catch(SQLException e){
            System .out.println("Exception occurred: "+ e);
        }

        return userpass;
    }
}

package controllers;

import models.Courses;
import models.Quiz;

import java.sql.*;
import java.util.ArrayList;

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

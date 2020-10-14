package controllers;

import models.Faculty;
import models.Student;

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
        authenticationController.getStudentData();
        authenticationController.getFacultyData();

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

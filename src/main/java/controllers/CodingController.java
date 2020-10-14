package controllers;

import models.Coding;
import models.Courses;

import java.sql.*;
import java.util.ArrayList;

public class CodingController {

    Connection con;
    public CodingController()
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
        CodingController controller=new CodingController();
        controller.getCodingQuestions();
    }

    public ArrayList<Coding> getCodingQuestions()
    {
        ArrayList<Coding> codeQuestions=new ArrayList<Coding>();
        try {
            Statement stmt = con.createStatement();
            ResultSet rs = stmt.executeQuery
                    ("SELECT * FROM coding");
            while (rs.next()) {
                Coding currCodeQuestion=new Coding(
                        rs.getInt("problemid"),
                        rs.getString("problemname"),
                        rs.getString("problemdesc"),
                        rs.getString("problemdifficulty"),
                        rs.getString("facultyid")
                );
                System.out.println(currCodeQuestion.toString());
                codeQuestions.add(currCodeQuestion);
            }
            return codeQuestions;
        }
        catch (SQLException e)
        {
            System.out.println(e.getLocalizedMessage());
            return null;
        }
    }
}


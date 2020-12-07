package controllers;

import models.Coding;
import models.Courses;
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

public class CodingController {

    Connection con;
    public CodingController()
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
        CodingController controller=new CodingController();
//        controller.getCodingQuestions();
//        controller.parseProblemXML("E:\\Java_Projects\\PlacementPortalFrontend\\review2\\XML\\coding.xml");
        }


    public boolean insertCodingProblem(Coding problem )
    {
        try {
            Statement stmt = con.createStatement();
            String SQL_QUERY = "INSERT INTO CODING (problemname,problemdesc,problemdifficulty,facultyid) VALUES ('" +
                    problem.getProblemname() + "','" +
                    problem.getProblemdesc() + "','" +
                    problem.getProblemdifficulty() + "','" +
                    problem.getFacultyid() + "')";
            stmt.executeUpdate(SQL_QUERY);
            return true;

        }
        catch(Exception e)
        {
            System.out.println(e.getLocalizedMessage());
            return false;
        }
    }

    public boolean updateQuestion(Coding problem)
    {
        try {
            Statement stmt = con.createStatement();
            stmt.executeUpdate
                    ("update coding set problemname='"+problem.getProblemname()+"', problemdesc ='"+problem.getProblemdesc()+"', problemdifficulty = '"+problem.getProblemdifficulty()+"' where problemid="+problem.getProblemid());
//            stmt.executeUpdate(SQL_QUERY);
            return true;
        }
        catch (SQLException e)
        {
            System.out.println(e.getLocalizedMessage());
            return false;
        }
    }

    public boolean deleteQuestion(String problem)
    {
        try {
            Statement stmt = con.createStatement();
            stmt.executeUpdate
                    ("DELETE FROM CODING WHERE problemid = "+problem);
//            stmt.executeUpdate(SQL_QUERY);
            return true;
        }
        catch (SQLException e)
        {
            System.out.println(e.getLocalizedMessage());
            return false;
        }
    }

    public Coding getQuestionFromId(String id)
    {
        try {
            Statement stmt = con.createStatement();
            ResultSet rs = stmt.executeQuery
                    ("SELECT * FROM coding where problemid="+id);
            int rowCount=0;
            Coding currCodeQuestion = null;
            while (rs.next()) {
                rowCount++;
                currCodeQuestion =new Coding(
                        rs.getInt("problemid"),
                        rs.getString("problemname"),
                        rs.getString("problemdesc"),
                        rs.getString("problemdifficulty"),
                        rs.getString("facultyid")
                );
            }
            if(rowCount==0)
            {
                return null;
            }
            else
            {
                return currCodeQuestion;
            }
        }
        catch (SQLException e)
        {
            System.out.println(e.getLocalizedMessage());
            return null;
        }
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
//                System.out.println(currCodeQuestion.toString());
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


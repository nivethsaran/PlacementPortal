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
//        controller.getCodingQuestions();
        controller.parseProblemXML("E:\\Java_Projects\\PlacementPortalFrontend\\review2\\XML\\coding.xml");
        }


    public void parseProblemXML(String xml)
    {
        try {
            DocumentBuilderFactory docBuilderFactory;
            docBuilderFactory = DocumentBuilderFactory.newInstance();
            DocumentBuilder docBuilder =
                    docBuilderFactory.newDocumentBuilder();
            Document doc = docBuilder.parse(new File(xml));
            doc.getDocumentElement().normalize();
            String tablename="coding";
            NodeList listOfProducts = doc.getElementsByTagName("problem");
            System.out.println(listOfProducts.getLength());
            Statement stmt = con.createStatement();
            for (int i = 0; i < listOfProducts.getLength(); i++) {
                Node product = listOfProducts.item(i);
                Element productElement = (Element) product;
                String problemname= productElement.getElementsByTagName("problemname").item(0).getTextContent();
                int problemid= Integer.parseInt(productElement.getElementsByTagName("problemid").item(0).getTextContent());
                String problemdesc=productElement.getElementsByTagName("problemdesc").item(0).getTextContent();
                String problemdifficulty= productElement.getElementsByTagName("problemdifficulty").item(0).getTextContent();
                String facultyid = productElement.getElementsByTagName("facultyid").item(0).getTextContent();
                String SQL_QUERY= "INSERT INTO "+tablename+ " VALUES ('"+
                        problemid+"','"+
                        problemname+"','"+
                        problemdesc+"','"+
                        problemdifficulty+"','"+
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


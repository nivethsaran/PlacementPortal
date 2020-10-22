package controllers;

import models.Companyregistration;
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

public class CompanyRegistrationController {

    Connection con;
    public CompanyRegistrationController()
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
        CompanyRegistrationController controller=new CompanyRegistrationController();
//        controller.getRegForms();
        controller.parseFormXML("E:\\Java_Projects\\PlacementPortalFrontend\\review2\\XML\\companyregistration.xml");
    }


    public void parseFormXML(String xml)
    {
        try {
            DocumentBuilderFactory docBuilderFactory;
            docBuilderFactory = DocumentBuilderFactory.newInstance();
            DocumentBuilder docBuilder =
                    docBuilderFactory.newDocumentBuilder();
            Document doc = docBuilder.parse(new File(xml));
            doc.getDocumentElement().normalize();
            String tablename="companyregistration";
            NodeList listOfProducts = doc.getElementsByTagName("form");
            System.out.println(listOfProducts.getLength());
            Statement stmt = con.createStatement();
            for (int i = 0; i < listOfProducts.getLength(); i++) {
                Node product = listOfProducts.item(i);
                Element productElement = (Element) product;
                String facultyid= productElement.getElementsByTagName("facultyid").item(0).getTextContent();
                String formid=productElement.getElementsByTagName("formid").item(0).getTextContent();
                String companyname= productElement.getElementsByTagName("companyname").item(0).getTextContent();
                String deadline = productElement.getElementsByTagName("deadline").item(0).getTextContent();
                String formurl = productElement.getElementsByTagName("formurl").item(0).getTextContent();
                String SQL_QUERY= "INSERT INTO "+tablename+ " VALUES ('"+
                        facultyid+"','"+
                        formid+"','"+
                        companyname+"','"+
                        deadline+"','"+
                        formurl+"')";

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



    public ArrayList<Companyregistration> getRegForms()
    {
        ArrayList<Companyregistration> forms=new ArrayList<Companyregistration>();
        try {
            Statement stmt = con.createStatement();
            ResultSet rs = stmt.executeQuery
                    ("SELECT * FROM companyregistration");
            while (rs.next()) {
                Companyregistration form=new Companyregistration(
                        rs.getString("facultyid"),
                        rs.getInt("formid"),
                        rs.getString("companyname"),
                        rs.getString("deadline"),
                        rs.getString("formurl")
                );
                System.out.println(forms.toString());
                forms.add(form);
            }
            return forms;
        }
        catch (SQLException e)
        {
            System.out.println(e.getLocalizedMessage());
            return null;
        }
    }
}

package controllers;

import models.Coding;
import models.Feedback;
import models.PlacementExperience;
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
//TODO : Tablenames arent proper in INSERT STATEMENTS, DO FIX IT

public class FeedbackController {

    Connection con;
    public FeedbackController()
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
        FeedbackController controller=new FeedbackController();
//        controller.getFeedbacks();
//        controller.getPlacementExperience();
        controller.parseExperienceXML("E:\\Java_Projects\\PlacementPortalFrontend\\review2\\XML\\placementexperience.xml");
        controller.parseFeedbackXML("E:\\Java_Projects\\PlacementPortalFrontend\\review2\\XML\\feedback.xml");
    }

    public ArrayList<Feedback> getFeedbacks()
    {
        ArrayList<Feedback> feedbacks=new ArrayList<Feedback>();
        try {
            Statement stmt = con.createStatement();
            ResultSet rs = stmt.executeQuery
                    ("SELECT * FROM feedback");
            while (rs.next()) {
                Feedback currFeedback=new Feedback(
                        rs.getString("facultyid"),
                        rs.getInt("feedbackid"),
                        rs.getInt("pace"),
                        rs.getInt("onlinetoolsusgae"),
                        rs.getInt("effectiveness"),
                        rs.getInt("approachability"),
                        rs.getString("recommend"),
                        rs.getString("optadvanced"),
                        rs.getString("suggestions"),
                        rs.getInt("courseid")
                );
                System.out.println(currFeedback.toString());
                feedbacks.add(currFeedback);
            }
            return feedbacks;
        }
        catch (SQLException e)
        {
            System.out.println(e.getLocalizedMessage());
            return null;
        }
    }

    public ArrayList<PlacementExperience> getPlacementExperience()
    {
        ArrayList<PlacementExperience> placementExperiences=new ArrayList<PlacementExperience>();
        try {
            Statement stmt = con.createStatement();
            ResultSet rs = stmt.executeQuery
                    ("SELECT * FROM placementexperience");
            while (rs.next()) {
                PlacementExperience currExp=new PlacementExperience(
                        rs.getInt("experienceid"),
                        rs.getString("rollno"),
                        rs.getString("experience"),
                        rs.getString("companyname"),
                        rs.getString("posttime")
                );
                System.out.println(currExp.toString());
                placementExperiences.add(currExp);
            }
            return placementExperiences;
        }
        catch (SQLException e)
        {
            System.out.println(e.getLocalizedMessage());
            return null;
        }
    }

    public void parseExperienceXML(String xml)
    {
        try {
            DocumentBuilderFactory docBuilderFactory;
            docBuilderFactory = DocumentBuilderFactory.newInstance();
            DocumentBuilder docBuilder =
                    docBuilderFactory.newDocumentBuilder();
            Document doc = docBuilder.parse(new File(xml));
            doc.getDocumentElement().normalize();
            String tablename="placementexperience";
            NodeList listOfProducts = doc.getElementsByTagName("experience");
            System.out.println(listOfProducts.getLength());
            Statement stmt = con.createStatement();
            for (int i = 0; i < listOfProducts.getLength(); i++) {
                Node product = listOfProducts.item(i);
                Element productElement = (Element) product;

                String experienceid= productElement.getElementsByTagName("experienceid").item(0).getTextContent();
                String rollno=productElement.getElementsByTagName("rollno").item(0).getTextContent();
                String experiencecontent= productElement.getElementsByTagName("experiencecontent").item(0).getTextContent();
                String companyname = productElement.getElementsByTagName("companyname").item(0).getTextContent();
                String posttime = productElement.getElementsByTagName("posttime").item(0).getTextContent();

                String SQL_QUERY= "INSERT INTO "+tablename+ " VALUES ('"+
                        experienceid+"','"+
                        rollno+"','"+
                        experiencecontent+"','"+
                        companyname+"','"+
                        posttime+"')";

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

    public void parseFeedbackXML(String xml)
    {
        try {
            DocumentBuilderFactory docBuilderFactory;
            docBuilderFactory = DocumentBuilderFactory.newInstance();
            DocumentBuilder docBuilder =
                    docBuilderFactory.newDocumentBuilder();
            Document doc = docBuilder.parse(new File(xml));
            doc.getDocumentElement().normalize();
            String tablename="feedback";
            NodeList listOfProducts = doc.getElementsByTagName("feedback");
            System.out.println(listOfProducts.getLength());
            Statement stmt = con.createStatement();
            for (int i = 0; i < listOfProducts.getLength(); i++) {
                Node product = listOfProducts.item(i);
                Element productElement = (Element) product;

                String facultyid= productElement.getElementsByTagName("facultyid").item(0).getTextContent();
                String feedbackid=productElement.getElementsByTagName("feedbackid").item(0).getTextContent();
                String pace= productElement.getElementsByTagName("pace").item(0).getTextContent();
                String onlinetoolsusgae = productElement.getElementsByTagName("onlinetoolsusgae").item(0).getTextContent();
                String effectiveness = productElement.getElementsByTagName("effectiveness").item(0).getTextContent();
                String approachability = productElement.getElementsByTagName("approachability").item(0).getTextContent();
                String recommend = productElement.getElementsByTagName("recommend").item(0).getTextContent();
                String optadvanced = productElement.getElementsByTagName("optadvanced").item(0).getTextContent();
                String suggestions = productElement.getElementsByTagName("suggestions").item(0).getTextContent();
                String courseid = productElement.getElementsByTagName("courseid").item(0).getTextContent();

                String SQL_QUERY= "INSERT INTO "+tablename+ " VALUES ('"+
                        facultyid+"','"+
                        feedbackid+"','"+
                        pace+"','"+
                        onlinetoolsusgae+"','"+
                        effectiveness+"','"+
                        approachability+"','"+
                        recommend+"','"+
                        optadvanced+"','"+
                        suggestions+"','"+
                        courseid+"')";

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

    public void submitExperience(String roll, String content, String company, String posttime) throws ClassNotFoundException {
        try {
            Statement stmt = con.createStatement();
            String SQL_QUERY = "INSERT INTO placementexperience (rollno, experiencecontent, companyname, posttime) VALUES "+
                    "('"+roll+
                    "','" +content+
                    "','"+company+
                    "','"+ posttime+ "')";

            stmt.executeUpdate(SQL_QUERY);
        }
        catch(SQLException e) {
            System .out.println("Exception occurred: "+ e);
        }
    }

    public Map<String,String> getExistingValues(int cid) {

        Map<String,String> userpass = new HashMap<String,String>();

        try{
            Statement stmt = con.createStatement();
            ResultSet rs = stmt.executeQuery("SELECT rollno, experiencecontent, companyname, posttime FROM placementexperience WHERE experienceid='"+cid+"'");
            String rollno = null;
            String experiencecontent = null;
            String companyname = null;
            String posttime = null;
            while(rs.next()){
                rollno = rs.getString("rollno");
                experiencecontent = rs.getString("experiencecontent");
                companyname = rs.getString("companyname");
                posttime = rs.getString("posttime");
            }


            userpass.put("rollno", rollno);
            userpass.put("experiencecontent", experiencecontent);
            userpass.put("companyname", companyname);
            userpass.put("posttime", posttime);

            return userpass;
        }
        catch(SQLException e){
            System .out.println("Exception occurred: "+ e);
        }

        return userpass;
    }
}

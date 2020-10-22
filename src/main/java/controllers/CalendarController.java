package controllers;

import models.Companyregistration;
import models.Events;
import models.StudentNotes;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import java.io.File;
import java.sql.*;
import java.util.ArrayList;

public class CalendarController {

    Connection con;
    public CalendarController()
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
        CalendarController controller=new CalendarController();
//        controller.getEvents();
//        controller.getNotes();
        controller.parseEventXML("E:\\Java_Projects\\PlacementPortalFrontend\\review2\\XML\\events.xml");
        controller.parseNotesXML("E:\\Java_Projects\\PlacementPortalFrontend\\review2\\XML\\studentnotes.xml");
    }

    public ArrayList<Events> getEvents()
    {
        ArrayList<Events> events=new ArrayList<Events>();
        try {
            Statement stmt = con.createStatement();
            ResultSet rs = stmt.executeQuery
                    ("SELECT * FROM events");
            while (rs.next()) {
                Events event=new Events(
                        rs.getInt("eventid"),
                        rs.getString("eventdate"),
                        rs.getString("eventtitle"),
                        rs.getString("eventdesc")
                );
                System.out.println(event.toString());
                events.add(event);
            }
            return events;
        }
        catch (SQLException e)
        {
            System.out.println(e.getLocalizedMessage());
            return null;
        }
    }

    public void parseEventXML(String xml)
    {
        try {
            DocumentBuilderFactory docBuilderFactory;
            docBuilderFactory = DocumentBuilderFactory.newInstance();
            DocumentBuilder docBuilder =
                    docBuilderFactory.newDocumentBuilder();
            Document doc = docBuilder.parse(new File(xml));
            doc.getDocumentElement().normalize();
            String tablename="events";
            NodeList listOfProducts = doc.getElementsByTagName("event");
            System.out.println(listOfProducts.getLength());
            Statement stmt = con.createStatement();
            for (int i = 0; i < listOfProducts.getLength(); i++) {
                Node product = listOfProducts.item(i);
                Element productElement = (Element) product;
                String eventid= productElement.getElementsByTagName("eventid").item(0).getTextContent();
                String eventdate= productElement.getElementsByTagName("eventdate").item(0).getTextContent();
                String eventtitle=productElement.getElementsByTagName("eventtitle").item(0).getTextContent();
                String eventdesc= productElement.getElementsByTagName("eventdesc").item(0).getTextContent();
                String SQL_QUERY= "INSERT INTO "+tablename+ " VALUES ('"+
                        eventid+"','"+
                        eventdate+"','"+
                        eventtitle+"','"+
                        eventdesc+"')";

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

    public void parseNotesXML(String xml)
    {
        try {
            DocumentBuilderFactory docBuilderFactory;
            docBuilderFactory = DocumentBuilderFactory.newInstance();
            DocumentBuilder docBuilder =
                    docBuilderFactory.newDocumentBuilder();
            Document doc = docBuilder.parse(new File(xml));
            doc.getDocumentElement().normalize();
            String tablename="studentnotes";
            NodeList listOfProducts = doc.getElementsByTagName("note");
            System.out.println(listOfProducts.getLength());
            Statement stmt = con.createStatement();
            for (int i = 0; i < listOfProducts.getLength(); i++) {
                Node product = listOfProducts.item(i);
                Element productElement = (Element) product;
                String noteid= productElement.getElementsByTagName("noteid").item(0).getTextContent();
                String notetitle= productElement.getElementsByTagName("notetitle").item(0).getTextContent();
                String notecontent=productElement.getElementsByTagName("notecontent").item(0).getTextContent();
                String notedate= productElement.getElementsByTagName("notedate").item(0).getTextContent();
                String rollno= productElement.getElementsByTagName("rollno").item(0).getTextContent();
                String SQL_QUERY= "INSERT INTO "+tablename+ " VALUES ('"+
                        noteid+"','"+
                        notetitle+"','"+
                        notecontent+"','"+
                        notedate+"','"+
                        rollno+"')";

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

    public ArrayList<StudentNotes> getNotes()
    {
        ArrayList<StudentNotes> notes=new ArrayList<StudentNotes>();
        try {
            Statement stmt = con.createStatement();
            ResultSet rs = stmt.executeQuery
                    ("SELECT * FROM studentnotes");
            while (rs.next()) {
                StudentNotes note=new StudentNotes(
                        rs.getInt("noteid"),
                        rs.getString("notetitle"),
                        rs.getString("notecontent"),
                        rs.getString("notedate"),
                        rs.getString("rollno")
                );
                System.out.println(note.toString());
                notes.add(note);
            }
            return notes;
        }
        catch (SQLException e)
        {
            System.out.println(e.getLocalizedMessage());
            return null;
        }
    }
}

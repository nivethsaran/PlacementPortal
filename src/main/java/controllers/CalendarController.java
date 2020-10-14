package controllers;

import models.Companyregistration;
import models.Events;
import models.StudentNotes;

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
        controller.getEvents();
        controller.getNotes();
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

package controllers;
import java.sql.DriverManager;
import java.sql.SQLException;
import models.Events;
import java.sql.*;
import java.util.ArrayList;
import static utils.CONSTANTS.*;



public class CalendarController {
    Connection con;

    public CalendarController() {

        try {
//            DriverManager.registerDriver(new com.mysql.jdbc.Driver ());
            Class.forName("com.mysql.cj.jdbc.Driver");
            this.con = DriverManager.getConnection
                    (SQL_CONN_STRING, SQL_USERNAME,
                            SQL_PASSWORD);
        } catch (
                SQLException e) {
            System.out.println("Connection Error:" + e.getLocalizedMessage());
        } catch (ClassNotFoundException e) {
            System.out.println("Class Not Found Error:" + e.getLocalizedMessage());
        }
    }

    public ArrayList<Events> getAllEventsData(String inputDate) {
        ArrayList<Events> curevents = new ArrayList<Events>();
        try {
            Statement stmt = con.createStatement();
            ResultSet rs = stmt.executeQuery
                    ("SELECT * FROM events WHERE eventdate='" + inputDate + "'");
            while (rs.next()) {
                Events currEvents = new Events(
                        rs.getString("eventid"),
                        rs.getString("eventdate"),
                        rs.getString("eventtitle"),
                        rs.getString("eventdesc")
                );
                System.out.println(currEvents.toString());
                curevents.add(currEvents);
            }
            return curevents;
        } catch (SQLException e) {
            System.out.println(e.getLocalizedMessage());
            return null;
        }
    }

    public boolean insertEvent(Events cur_event) {
        try {
            System.out.println("HELLO");
            Statement stmt = con.createStatement();

            String SQL_QUERY = "INSERT INTO EVENTS VALUES ('" + cur_event.getEventid() + "','" + cur_event.getEventdate() + "','" + cur_event.getEventtitle() + "','" + cur_event.getEventdesc() + "')";
            stmt.executeUpdate(SQL_QUERY);
            System.out.println(SQL_QUERY);
            return true;
        } catch (SQLException e) {
            System.out.println(e.getLocalizedMessage());
            return false;
        }
    }


    public ArrayList<Events> getEvents()
    {
        ArrayList<Events> events=new ArrayList<Events>();
        try {
            Statement stmt = con.createStatement();
            ResultSet rs = stmt.executeQuery
                    ("SELECT * FROM events order by eventdate desc");
            while (rs.next()) {
                Events event=new Events(
                        rs.getString("eventid"),
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
}

package controllers;

import models.Coding;
import models.Feedback;
import models.PlacementExperience;

import java.sql.*;
import java.util.ArrayList;

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
        controller.getFeedbacks();
        controller.getPlacementExperience();
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
}

package controllers;

import models.Companyregistration;
import models.Courses;

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
        controller.getRegForms();
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

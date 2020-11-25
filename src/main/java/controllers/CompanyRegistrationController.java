package controllers;

import models.Coding;
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

import static utils.CONSTANTS.*;

public class CompanyRegistrationController {

    Connection con;
    public CompanyRegistrationController()
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
        CompanyRegistrationController controller=new CompanyRegistrationController();
//        controller.getRegForms();
//        controller.parseFormXML("E:\\Java_Projects\\PlacementPortalFrontend\\review2\\XML\\companyregistration.xml");
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
                        rs.getString("formurl"),
                        rs.getString("pay")
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

    public Companyregistration getFormFromId(String fid)
    {
        Companyregistration form=null;
        try {
            Statement stmt = con.createStatement();
            ResultSet rs = stmt.executeQuery
                    ("SELECT * FROM companyregistration where formid = "+fid);
            while (rs.next()) {
                form=new Companyregistration(
                        rs.getString("facultyid"),
                        rs.getInt("formid"),
                        rs.getString("companyname"),
                        rs.getString("deadline"),
                        rs.getString("formurl"),
                        rs.getString("pay")
                );
                return form;
            }
            return null;
        }
        catch (SQLException e)
        {
            System.out.println(e.getLocalizedMessage());
            return null;
        }
    }


    public boolean insertForm(Companyregistration form) {
        try {
            Statement stmt = con.createStatement();
            String SQL_QUERY = "insert into companyregistration(facultyid,companyname,deadline,formurl,pay) values ('" +
                    form.getFacultyid() + "','" +
                    form.getCompanyname() + "','" +
                    form.getDeadline() + "','" +
                    form.getFormurl() + "'," +
                    form.getPay() + ")";
            stmt.executeUpdate(SQL_QUERY);
            return true;

        }
        catch(Exception e)
        {
            System.out.println(e.getLocalizedMessage());
            return false;
        }
    }
}

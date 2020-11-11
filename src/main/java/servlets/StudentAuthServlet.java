package servlets;

import models.Faculty;
import models.Student;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Enumeration;

@WebServlet(urlPatterns = "/student_auth")
public class StudentAuthServlet extends HttpServlet {


    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp)
            throws IOException, ServletException {
        req.getRequestDispatcher("authentication/student_auth.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        if(req.getParameter("actiontype").equals("studsignup"))
        {
            String department = req.getParameter("rollno").substring(8,11);
            Student student = new Student(req.getParameter("fullname"),
                    req.getParameter("rollno"),
                    req.getParameter("passwordsignup"),
                    req.getParameter("imageurl"),
                    req.getParameter("mobile"),
                    req.getParameter("emailsignup"),
                    department);
            System.out.println(student.toString());
        }
        req.getRequestDispatcher("authentication/student_auth.jsp").forward(req,resp);
    }
}
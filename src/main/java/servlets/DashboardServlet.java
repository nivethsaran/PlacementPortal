package servlets;

import controllers.AuthenticationController;
import models.Faculty;
import models.Student;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(urlPatterns = "/dashboard")
public class DashboardServlet extends HttpServlet {


    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp)
            throws IOException, ServletException {

        req.getRequestDispatcher("dashboard/dashboard.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//        super.doPost(req, resp);
        if(req.getParameter("actiontype").equals("faclogin"))
        {
            String username = req.getParameter("facidsignin");
            String password = req.getParameter("password");
            String remember = req.getParameter("loginkeeping");
            AuthenticationController authenticationController = new AuthenticationController();
            Faculty faculty = authenticationController.getFacultyData(username);
            if(faculty!=null&&faculty.getAuthpassword().equals(password))
            {
                req.getRequestDispatcher("dashboard/dashboard.jsp").forward(req, resp);
                req.setAttribute("usertype","faculty");
                req.setAttribute("message", "");
                req.setAttribute("data",faculty);
                System.out.println(faculty.toString());
            }
            else
            {
                req.setAttribute("message", "WC");
                req.getRequestDispatcher("authentication/faculty_auth.jsp").forward(req, resp);
            }
        }
        else if(req.getParameter("actiontype").equals("studlogin"))
        {
            String username = req.getParameter("rollno");
            String password = req.getParameter("password");
            String remember = req.getParameter("loginkeeping");
            AuthenticationController authenticationController = new AuthenticationController();
            Student student = authenticationController.getStudentData(username);
            if(student!=null&&student.getAuthpassword().equals(password))
            {
                req.getRequestDispatcher("dashboard/dashboard.jsp").forward(req, resp);
                req.setAttribute("usertype","student");
                req.setAttribute("message", "");
                req.setAttribute("data",student);
                System.out.println(student.toString());
            }
            else
            {
                req.setAttribute("message", "WC");
                req.getRequestDispatcher("authentication/student_auth.jsp").forward(req, resp);
            }

        }
    }
}
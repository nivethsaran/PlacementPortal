package servlets.authentication;

import controllers.AuthenticationController;
import models.Faculty;
import models.Student;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebServlet(urlPatterns = "/dashboard")
public class DashboardServlet extends HttpServlet {


    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp)
            throws IOException, ServletException {
        if(req.getSession().getAttribute("userdata")==null)
        {
            resp.sendError(HttpServletResponse.SC_UNAUTHORIZED);
        }
        else
        {
            req.getRequestDispatcher("dashboard/dashboard.jsp").forward(req, resp);
        }

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
                req.getSession().setAttribute("userdata",faculty);
                req.getSession().setAttribute("usertype","faculty");
                req.getRequestDispatcher("dashboard/dashboard.jsp").forward(req, resp);
            }
            else if(faculty!=null&&!faculty.getAuthpassword().equals(password))
            {
                req.setAttribute("message", "Wrong Credentials");
                req.getRequestDispatcher("authentication/faculty_auth.jsp").forward(req, resp);
            }
            else
            {
                req.setAttribute("message", "Server Error");
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
                req.getSession().setAttribute("userdata",student);
                req.getSession().setAttribute("usertype","student");
                req.getRequestDispatcher("dashboard/dashboard.jsp").forward(req, resp);
            }
            else if(student!=null&&!student.getAuthpassword().equals(password))
            {
                req.setAttribute("message", "Wrong Credentials");
                req.getRequestDispatcher("authentication/student_auth.jsp").forward(req, resp);
            }
            else
            {
                req.setAttribute("message", "Server Error");
                req.getRequestDispatcher("authentication/student_auth.jsp").forward(req, resp);
            }

        }
    }
}
package servlets.authentication;

import controllers.AuthenticationController;
import models.Faculty;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(urlPatterns = "/faculty_auth")
public class FacultyAuthServlet extends HttpServlet {


    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp)
            throws IOException, ServletException {

        if(req.getSession().getAttribute("usertype")!=null && req.getSession().getAttribute("usertype").equals("faculty"))
        {
            resp.sendRedirect("./dashboard");
        }
        else {
            req.getRequestDispatcher("authentication/faculty_auth.jsp").forward(req, resp);
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {


        if(req.getParameter("actiontype").equals("facsignup"))
        {
            String department = req.getParameter("facidsignup").substring(8,11);
            Faculty faculty = new Faculty(req.getParameter("fullname"),
                    req.getParameter("facidsignup"),
                    req.getParameter("passwordsignup"),
                    req.getParameter("imageurl"),
                    req.getParameter("mobile"),
                    req.getParameter("emailsignup"),
                    department);
            System.out.println(faculty.toString());
            AuthenticationController controller = new AuthenticationController();
            if(controller.insertFaculty(faculty))
            {
                req.setAttribute("message","User added successfully");
            }
            else
            {
                req.setAttribute("message","Server error");
            }
        }
        req.getRequestDispatcher("authentication/faculty_auth.jsp").forward(req,resp);
    }
}
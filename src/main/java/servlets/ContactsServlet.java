package servlets;

import controllers.AuthenticationController;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(urlPatterns = "/contact")
public class ContactsServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        AuthenticationController controller = new AuthenticationController();
        if(req.getSession().getAttribute("usertype").equals("student"))
        {
            req.setAttribute("contacts",controller.getAllFacultyData());
            req.setAttribute("starting",req.getParameter("alphabet"));
        }
        else if(req.getSession().getAttribute("usertype").equals("faculty"))
        {
            req.setAttribute("contacts",controller.getAllStudentData());
            req.setAttribute("starting",req.getParameter("alphabet"));
        }
        req.getRequestDispatcher("contact/contact.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.getRequestDispatcher("coding/coding.jsp").forward(req, resp);
    }
}

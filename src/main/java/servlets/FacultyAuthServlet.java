package servlets;

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
        req.getRequestDispatcher("authentication/faculty_auth.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println(req.getParameter("facidsignup")+" "+
                        req.getParameter("emailsignup")+" "+
                        req.getParameter("passwordsignup")+" "+
                        req.getParameter("passwordsignup_confirm")+" "+
                        req.getParameter("fullname")+" "+
                        req.getParameter("imageurl")+" "+
                        req.getParameter("mobile")+" ");
        req.getRequestDispatcher("dashboard/dashboard.jsp").forward(req,resp);
    }
}
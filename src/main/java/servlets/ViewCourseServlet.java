package servlets;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.net.URLEncoder;

@WebServlet(urlPatterns = "/view-courses")
public class ViewCourseServlet extends HttpServlet{
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws IOException, ServletException {
        // get the session attrs 'role' for logged in user
        String role = (String)req.getSession().getAttribute("usertype");

        if(!role.equals("student")){
            resp.sendRedirect(req.getContextPath() + "/index.jsp?message="+ URLEncoder.encode("You are not a student!", "UTF-8"));
        }else {
            req.getRequestDispatcher("course/user/viewCourse.jsp").forward(req, resp);
            String action = req.getServletPath();
            System.out.println(action);
        }
    }
}

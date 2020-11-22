package servlets;

import controllers.CourseController;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.net.URLEncoder;
import java.util.Map;

@WebServlet(urlPatterns = "/edit-course")
public class EditCourseServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws IOException, ServletException {
        // get the session attrs 'role' for logged in user
        String role = (String)req.getSession().getAttribute("usertype");

        if(!role.equals("faculty")){
            resp.sendRedirect(req.getContextPath() + "/index.jsp?message="+ URLEncoder.encode("You are not a faculty!", "UTF-8"));
        }else {
            System.out.println(Integer.parseInt(req.getParameter("cid")));
            CourseController controller = new CourseController();
            Map<String, String> existing = controller.getExistingValues(Integer.parseInt(req.getParameter("cid")));

            String coursename = existing.get("coursename");
            String topicname = existing.get("topicname");
            String department = existing.get("department");
            String courseurl = existing.get("courseurl");

            req.setAttribute("cid", Integer.parseInt(req.getParameter("cid")));
            req.setAttribute("coursename", coursename);
            req.setAttribute("topicname", topicname);
            req.setAttribute("department", department);
            req.setAttribute("courseurl", courseurl);

            System.out.println("GET of edit form: " + coursename + " " + topicname + " " + department + " " + courseurl);

            req.getRequestDispatcher("course/admin/editCourse.jsp").forward(req, resp);
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws IOException, ServletException {
        int cid = Integer.parseInt(req.getParameter("cid"));
        String coursename = req.getParameter("course-name");
        String topicname = req.getParameter("topic");
        String department = req.getParameter("dept");
        String courseurl = req.getParameter("url");

        System.out.println("POST of edit form: "+cid+", "+coursename+", "+topicname+", "+department+" and  "+courseurl);

        try {
            CourseController controller = new CourseController();
            controller.updateCourse(cid,coursename,topicname,department,courseurl);
            System.out.println("Updated course.");
        }
        catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

        resp.sendRedirect("read-delete-update-course");
    }
}

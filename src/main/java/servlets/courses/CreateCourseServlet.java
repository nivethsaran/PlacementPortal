package servlets.courses;


import controllers.CourseController;
import models.Faculty;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.net.URLEncoder;

@WebServlet(urlPatterns = "/create-course")
public class CreateCourseServlet extends HttpServlet{
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws IOException, ServletException {
        // get the session attrs 'role' for logged in user
        String role = (String)req.getSession().getAttribute("usertype");

        if(!role.equals("faculty")){
            resp.sendRedirect(req.getContextPath() + "/index.jsp?message="+ URLEncoder.encode("You are not a faculty!", "UTF-8"));
        }else{
            req.getRequestDispatcher("course/admin/createCourse.jsp").forward(req, resp);
            String action = req.getServletPath();
            System.out.println(action);
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws IOException, ServletException{
        System.out.println("Executed doPost from courseAdmin");

        // get the session attrs 'role' and 'username'
        String role = (String)req.getSession().getAttribute("usertype");
        Faculty faculty = (Faculty) req.getSession().getAttribute("userdata");
        String username = faculty.getFacultyid();
        System.out.println("session variables => Role:"+role+",\tUsername:"+username);

        String courseName = req.getParameter("course-name");
        String topic = req.getParameter("topic");
        String dept = req.getParameter("dept");
        String url = req.getParameter("url");
        System.out.println(courseName+", "+topic+", "+dept+" and "+url+" submitted.");

        // check if it is a faculty. if not throw error on submit.
        if(!role.equals("faculty")){
            resp.sendRedirect(req.getContextPath() + "/create-course?message="+ URLEncoder.encode("You are not a faculty!", "UTF-8"));
        }
        // making sure all attrs are not null before executing query.
        else if(courseName==null||topic==null||dept==null||url==null){
            resp.sendRedirect(req.getContextPath() + "/create-course?message="+ URLEncoder.encode("Failed to add course.", "UTF-8"));
        }
        // if it came past those two hurdles.
        else{
            //  add it to db if same topic doesnt exist
            CourseController controller = new CourseController();
            if(controller.checkIfTopicNotExists(topic,dept)){
                try {
                    controller.addToCourse(courseName, topic, dept, url, username);
                    resp.sendRedirect(req.getContextPath() + "/create-course?message="+ URLEncoder.encode("Course added successfully.", "UTF-8"));
                } catch (ClassNotFoundException e) {
                    e.printStackTrace();
                }
            }
            // otherwise throw error
            else{
                resp.sendRedirect(req.getContextPath() + "/create-course?message="+ URLEncoder.encode("Failed to add course.", "UTF-8"));
            }
        }
    }
}
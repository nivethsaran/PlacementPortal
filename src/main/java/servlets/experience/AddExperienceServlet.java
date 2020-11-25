package servlets.experience;

import controllers.FeedbackController;
import models.Faculty;
import models.Student;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.net.URLEncoder;

@WebServlet(urlPatterns = "/submit-exp")
public class AddExperienceServlet extends HttpServlet{


    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws IOException, ServletException {
        // get the session attrs 'role' for logged in user
        String role = (String)req.getSession().getAttribute("usertype");

        if(!role.equals("student")){
            resp.sendRedirect(req.getContextPath() + "/index.jsp?message="+ URLEncoder.encode("You are not a student!", "UTF-8"));
        }else{
            req.getRequestDispatcher("placementexp/user/submitExp.jsp").forward(req, resp);
            String action = req.getServletPath();
            System.out.println(action);
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws IOException, ServletException{
        System.out.println("Executed doPost from expUser");

        // get the session attrs 'role' and 'username'
        String role = (String)req.getSession().getAttribute("usertype");
        String rollno = "";
        String username = "";
        if(role.equals("student"))
        {
            Student student = (Student)  req.getSession().getAttribute("userdata");
            rollno = student.getRollno();
        }
        else
        {
            Faculty faculty = (Faculty)  req.getSession().getAttribute("userdata");
            username = faculty.getFacultyid();
        }



        System.out.println("session variables => Role:"+role+",\tUsername:"+username+",\tRoll-Number:"+rollno);

        String companyName = req.getParameter("experience-company");
        String experience = req.getParameter("experience-box");
        String postDate = req.getParameter("date-posted");

        System.out.println("Submitted=>\t"+companyName+", "+experience+", "+postDate);

        if(!rollno.equals("") && !companyName.equals("") && !experience.equals("") && !postDate.equals("")){
            try {
                FeedbackController controller = new FeedbackController();
                controller.submitExperience(rollno,experience,companyName,postDate);
                resp.sendRedirect(req.getContextPath() + "/submit-exp?message="+ URLEncoder.encode("Experience submitted successfully.", "UTF-8"));
            } catch (ClassNotFoundException e) {
                e.printStackTrace();
                resp.sendRedirect(req.getContextPath() + "/submit-exp?message="+ URLEncoder.encode("Failed to submitted experience", "UTF-8"));
            }
        }else{
            resp.sendRedirect(req.getContextPath() + "/submit-exp?message="+ URLEncoder.encode("Failed to submitted experience", "UTF-8"));
        }
    }


}

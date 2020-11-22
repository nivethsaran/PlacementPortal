package servlets;
import controllers.FeedbackController;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.net.URLEncoder;
import java.util.Map;

@WebServlet(urlPatterns = "/view-exp")
public class ViewExperienceServlet extends HttpServlet{

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws IOException, ServletException {
        // get the session attrs 'role' for logged in user
        String role = (String)req.getSession().getAttribute("usertype");

        if(!role.equals("faculty")){
            resp.sendRedirect(req.getContextPath() + "/index.jsp?message="+ URLEncoder.encode("You are not a faculty!", "UTF-8"));
        }else {
            System.out.println(Integer.parseInt(req.getParameter("expid")));
            FeedbackController controller = new FeedbackController();
            Map<String, String> existing = controller.getExistingValues(Integer.parseInt(req.getParameter("expid")));

            String rollno = existing.get("rollno");
            String experiencecontent = existing.get("experiencecontent");
            String companyname = existing.get("companyname");
            String posttime = existing.get("posttime");

            req.setAttribute("expid", Integer.parseInt(req.getParameter("expid")));
            req.setAttribute("rollno", rollno);
            req.setAttribute("experiencecontent", experiencecontent);
            req.setAttribute("companyname", companyname);
            req.setAttribute("posttime", posttime);

            System.out.println("GET of edit form: " + rollno + " " + experiencecontent + " " + companyname + " " + posttime);

            req.getRequestDispatcher("placementexp/admin/detailedExp.jsp").forward(req, resp);
        }
    }

}


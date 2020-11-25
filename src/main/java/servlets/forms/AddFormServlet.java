package servlets.forms;

import controllers.CompanyRegistrationController;
import models.Companyregistration;
import models.Faculty;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(urlPatterns = "/addform")
public class AddFormServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp)
            throws IOException, ServletException {
        if (req.getSession().getAttribute("usertype") == null || req.getSession().getAttribute("usertype").equals("student")) {
            resp.sendError(HttpServletResponse.SC_UNAUTHORIZED);
        } else {
            req.getRequestDispatcher("forms/createform.jsp").forward(req, resp);
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        Faculty faculty = (Faculty) req.getSession().getAttribute("userdata");
        String facid = faculty.getFacultyid();
        String companyname = req.getParameter("companyname");
        String ctc = req.getParameter("ctc");
        String deadline = req.getParameter("deadline");
        String url = req.getParameter("url");
        Companyregistration form = new Companyregistration(facid,0,companyname,deadline,url,ctc);
        CompanyRegistrationController controller = new CompanyRegistrationController();
        if(controller.insertForm(form))
        {
            req.setAttribute("message","Successful");
        }
        else
        {
            req.setAttribute("message","Server Error");
        }
        req.getRequestDispatcher("forms/createform.jsp").forward(req, resp);
    }
}
package servlets.forms;

import controllers.CompanyRegistrationController;
import models.Companyregistration;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;

@WebServlet(urlPatterns = "/apply")
public class ApplyFormServlet extends HttpServlet {


    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp)
            throws IOException, ServletException {

        if(req.getSession().getAttribute("usertype")==null || req.getSession().getAttribute("usertype").equals("faculty"))
        {
            resp.sendError(HttpServletResponse.SC_FORBIDDEN);
        }
        else
        {
            String formid = req.getParameter("formid");
            CompanyRegistrationController controller = new CompanyRegistrationController();
            Companyregistration form = controller.getFormFromId(formid);
            if(form == null)
            {
                resp.sendError(HttpServletResponse.SC_NOT_FOUND);
            }
            else
            {
                req.setAttribute("form",form);
                req.getRequestDispatcher("forms/viewform.jsp").forward(req, resp);
            }
        }

    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.sendError(HttpServletResponse.SC_NOT_FOUND);
    }
}
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

@WebServlet(urlPatterns = "/viewform")
public class ViewFormServlet extends HttpServlet {


    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp)
            throws IOException, ServletException {

        CompanyRegistrationController controller = new CompanyRegistrationController();
        ArrayList<Companyregistration> forms = controller.getRegForms();
        req.setAttribute("forms",forms);
        req.getRequestDispatcher("forms/allforms.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.sendError(HttpServletResponse.SC_NOT_FOUND);
    }
}
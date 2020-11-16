package servlets;

import controllers.CodingController;
import models.Coding;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;

@WebServlet(urlPatterns = "/ide")
public class CodingServlet extends HttpServlet {


    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp)
            throws IOException, ServletException {

        CodingController codingController= new CodingController();
        ArrayList<Coding> problems = codingController.getCodingQuestions();
        if(problems!=null&&problems.size()!=0)
        {
            req.setAttribute("problems", problems);
        }
        req.getRequestDispatcher("coding/coding.jsp").forward(req, resp);
    }

}
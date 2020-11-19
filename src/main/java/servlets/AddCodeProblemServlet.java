package servlets;

import controllers.CodingController;
import models.Coding;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(urlPatterns = "/addproblem")
public class AddCodeProblemServlet extends HttpServlet {


    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp)
            throws IOException, ServletException {
        String pid = null;
        if(req.getParameter("pid")!=null)
        {
            pid=req.getParameter("pid");
            CodingController codingController = new CodingController();
            Coding problem = codingController.getQuestionFromId(pid);
            req.setAttribute("problem",problem);
            req.setAttribute("update",true);
        }
        else
        {
            req.setAttribute("update",false);
        }
        req.getRequestDispatcher("coding/addquestion.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String problemname = req.getParameter("questionname");
        String problemdesc = req.getParameter("questiondesc");
        String problemdiff = req.getParameter("difficulty");
        String facultyid = req.getParameter("facid");
        String actiontype = req.getParameter("actiontype");
        CodingController controller = new CodingController();
        if(actiontype.equals("update"))
        {
            String problemid = req.getParameter("probid");
            Coding problem = new Coding(Integer.parseInt(problemid),problemname,problemdesc,problemdiff,facultyid);
            if(controller.updateQuestion(problem))
            {
                req.setAttribute("inserted",true);
            }
            else
            {
                req.setAttribute("inserted",false);
            }
        }
        else if(actiontype.equals("add"))
        {
            Coding problem = new Coding(0,problemname,problemdesc,problemdiff,facultyid);
            if(controller.insertCodingProblem(problem))
            {
                req.setAttribute("inserted",true);
            }
            else
            {
                req.setAttribute("inserted",false);
            }
        }

        req.getRequestDispatcher("coding/addquestion.jsp").forward(req, resp);
    }
}
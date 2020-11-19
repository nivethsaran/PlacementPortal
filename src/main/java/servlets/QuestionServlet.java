package servlets;

import controllers.QuizController;
import models.Question;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;

@WebServlet(urlPatterns = "/questions")
public class QuestionServlet extends HttpServlet {


    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp)
            throws IOException, ServletException {
        req.getRequestDispatcher("").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String enteredPin = req.getParameter("pinstud");
        String quizid = req.getParameter("quizid");
        QuizController controller = new QuizController();
        String actualPin = controller.getPIN(quizid);
        ArrayList<Question> questions = null;
        if(actualPin.equals(enteredPin))
        {
            questions = controller.getQuestions(quizid);
            System.out.println(questions.size());
            req.setAttribute("questions",questions);
            req.getRequestDispatcher("quiz/quiz.jsp").forward(req, resp);
        }
        else
        {
            req.getRequestDispatcher("quiz/quizindex.jsp").forward(req, resp);
        }

    }
}
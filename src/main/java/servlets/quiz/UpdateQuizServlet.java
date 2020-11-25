package servlets.quiz;

import controllers.QuizController;
import models.Quiz;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;

@WebServlet(urlPatterns = "/deleteQuiz")
public class UpdateQuizServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String quizid = req.getParameter("quizid");
        QuizController controller = new QuizController();
        Quiz quiz = controller.getQuizFromId(quizid);

        if(req.getSession().getAttribute("usertype").equals("faculty"))
        {
            controller.deleteQuestionWithId(quizid);
            controller.deleteScoreWithId(quizid);
            controller.deleteQuizWithId(quizid);
            ArrayList<Quiz> quizzes = controller.getQuizzes();
            req.setAttribute("quizzes",quizzes);
            req.getRequestDispatcher("quiz/quizindex.jsp").forward(req, resp);

        }
        ArrayList<Quiz> quizzes = controller.getQuizzes();
        req.setAttribute("quizzes",quizzes);
        req.getRequestDispatcher("quiz/quizindex.jsp").forward(req, resp);
    }

}

package servlets.quiz;

import controllers.QuizController;
import models.Quiz;
import models.Scores;
import models.Student;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@WebServlet(urlPatterns = "/quiz")
public class QuizServlet extends HttpServlet {


    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp)
            throws IOException, ServletException {

        QuizController controller = new QuizController();
        ArrayList<Quiz> quizzes = controller.getQuizzes();
        ArrayList<Scores> scores = null;
        if(req.getSession().getAttribute("usertype")==null)
        {
            resp.sendError(HttpServletResponse.SC_UNAUTHORIZED);
        }
        else
        {
            if(req.getSession().getAttribute("usertype").equals("student")) {

                Student student= (Student) req.getSession().getAttribute("userdata");
                quizzes = controller.getQuizzesForStudent(student.getRollno());
                scores = controller.getScores(student.getRollno());
            }
            if(scores!=null)
                System.out.println(scores.size());
            req.setAttribute("quizzes",quizzes);
            req.setAttribute("scores", scores);
            req.getRequestDispatcher("quiz/quizindex.jsp").forward(req, resp);
        }

    }

}
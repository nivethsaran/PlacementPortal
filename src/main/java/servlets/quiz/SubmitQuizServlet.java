package servlets.quiz;

import controllers.QuizController;
import models.Question;
import models.Quiz;
import models.Scores;
import models.Student;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;

@WebServlet(urlPatterns = "/submitquiz")
public class SubmitQuizServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.sendError(HttpServletResponse.SC_NOT_FOUND);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        QuizController controller = new QuizController();
        String quizid = req.getParameter("quizid");
        ArrayList<Question> questions = controller.getQuestions(quizid);
        Quiz quiz = controller.getQuizFromId(quizid);
        int n = quiz.getNumofquestions();
        int score = 0;
        for(int i=1;i<=n;i++)
        {
            String answer="";
            if(req.getParameter("question"+i) == null)
            {
                continue;
            }
            else
            {
                answer = req.getParameter("question"+i);
            }
            String actualAnswer = questions.get(i-1).getAnswer();
            if(answer.equals(actualAnswer))
            {
                score++;
            }
        }
        Student student = (Student) req.getSession().getAttribute("userdata");

        Scores scores =new Scores(0, Integer.parseInt(quizid), student.getRollno(), n, score);
        if(controller.insertScores(scores)) {
            resp.sendRedirect("./quiz");
        }
        else
        {
            resp.sendRedirect("./quiz");
        }
    }
}
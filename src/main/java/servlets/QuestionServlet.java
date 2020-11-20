package servlets;

import controllers.QuizController;
import models.Question;
import models.Quiz;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

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
            Quiz quiz = controller.getQuizFromId(quizid);
            System.out.println(questions.size());
            req.setAttribute("quiz",quiz);
            req.setAttribute("questions",questions);
            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
            String starttime = quiz.getQuizdate() + " "+ quiz.getQuizstarttime();
            String endtime = quiz.getQuizdate() + " "+ quiz.getQuizendtime();
            Date startdatetime = null;
            Date enddatetime   = null;
            try {
               startdatetime = sdf.parse(starttime);
               enddatetime   = sdf.parse(endtime);
            } catch (ParseException e) {
                e.printStackTrace();
            }
            if(System.currentTimeMillis() > startdatetime.getTime() && System.currentTimeMillis() < enddatetime.getTime())
            {
                req.setAttribute("endtime",Math.min(System.currentTimeMillis()+ (quiz.getDuration()*60*1000),enddatetime.getTime()));
                System.out.println(Math.min(startdatetime.getTime()+ (quiz.getDuration()*60*1000),enddatetime.getTime()));
                req.getRequestDispatcher("quiz/quiz.jsp").forward(req, resp);
            }
            else
            {
                req.getRequestDispatcher("dashboard/dashboard.jsp").forward(req, resp);
            }
        }
        else
        {
            req.getRequestDispatcher("quiz/quizindex.jsp").forward(req, resp);
        }

    }
}
package servlets.quiz;

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
import java.util.stream.StreamSupport;

@WebServlet(urlPatterns = "/questions")
public class QuestionServlet extends HttpServlet {


    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp)
            throws IOException, ServletException {
        resp.sendError(HttpServletResponse.SC_FORBIDDEN);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String enteredPin = req.getParameter("pinstud");
        String quizid = req.getParameter("quizid");
        QuizController controller = new QuizController();
        String actualPin = controller.getPIN(quizid);
        ArrayList<Question> questions = null;
        System.out.println(actualPin+ " "+ enteredPin);
        if(enteredPin==null||enteredPin.equals(""))
        {
            enteredPin = "-1";
        }
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
                req.getSession().setAttribute("quizindexmessage","Quiz Currently Not Available");
                resp.sendRedirect("quiz");
            }
        }
        else
        {
            req.getSession().setAttribute("quizindexmessage","WRONG PIN, TRY AGAIN");
            resp.sendRedirect("quiz");
        }

    }
}
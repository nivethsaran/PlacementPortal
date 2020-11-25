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

@WebServlet(urlPatterns = "/addquiz")
public class AddQuizServlet extends HttpServlet {


    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp)
            throws IOException, ServletException {

        if(req.getSession().getAttribute("usertype")==null || req.getSession().getAttribute("usertype").equals("student"))
        {
            resp.sendError(HttpServletResponse.SC_UNAUTHORIZED);
        }
        else
        {
            req.getRequestDispatcher("quiz/addQuiz.jsp").forward(req, resp);
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        String quizname = req.getParameter("quizname");
        int nooq = Integer.parseInt(req.getParameter("nooq"));
        String quizdesc = req.getParameter("quizdesc");
        String date = req.getParameter("date");
        String starttime = req.getParameter("starttime");
        String endtime = req.getParameter("endtime");
        int duration = Integer.parseInt(req.getParameter("duration"));
        String dept = req.getParameter("dept");
        String topic = req.getParameter("topic");
        String facid = req.getParameter("facid");
        String PIN = "";
        if(req.getParameter("pin")!=null)
        {
            PIN = req.getParameter("pin");
        }
        else
        {
            PIN = "-1";
        }
        System.out.println(PIN);
        QuizController controller = new QuizController();
        Quiz quiz = new Quiz(0,facid,quizname,quizdesc,nooq,date,starttime,endtime,duration,dept,topic,Integer.parseInt(PIN));
        controller.insertQuiz(quiz);
        int quizid = controller.getQuizId();
        for(int i=1;i<=nooq;i++)
        {
            String questioncontent = req.getParameter("question"+i);
            String opta = req.getParameter("opt"+i+"a");
            String optb = req.getParameter("opt"+i+"b");
            String optc = req.getParameter("opt"+i+"c");
            String optd = req.getParameter("opt"+i+"d");
            String answer = req.getParameter("correct"+i);
            Question question = new Question(quizid,i,questioncontent, answer, opta, optb,optc,optd);
            if(controller.insertQuestion(question))
            {
                req.setAttribute("message","Inserted Successfulyy");
            }
            else
            {
                req.setAttribute("message","Server Error");
            }
//            System.out.println(question+" "+opta+" "+optb+" "+optc+" "+optd+" "+answer);
        }

        req.getRequestDispatcher("quiz/addQuiz.jsp").forward(req, resp);
    }
}
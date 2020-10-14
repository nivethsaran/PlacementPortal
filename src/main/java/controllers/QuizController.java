package controllers;

import models.Question;
import models.Quiz;
import models.Scores;
import models.Student;

import java.sql.*;
import java.util.ArrayList;

public class QuizController {

    Connection con;

    public QuizController()
    {
        try {
            this.con = DriverManager.getConnection
                    ("jdbc:mysql://localhost:3306/preparely", "root",
                            "1234");
        }
        catch (SQLException e)
        {
            System.out.println("Connection Error:"+e.getLocalizedMessage());
        }
    }

public static void main(String args[])
{
    QuizController controller=new QuizController();
    controller.getQuiz();
    controller.getQuestions(1);
    controller.getScores(1);
}

public ArrayList<Quiz> getQuiz()
{
    ArrayList<Quiz> quizzes=new ArrayList<Quiz>();
    try {
        Statement stmt = con.createStatement();
        ResultSet rs = stmt.executeQuery
                ("SELECT * FROM quiz");
        while (rs.next()) {
            Quiz currQuiz=new Quiz(
                    rs.getInt("quizid"),
                    rs.getString("facultyid"),
                    rs.getString("quizname"),
                    rs.getString("quizdescription"),
                    rs.getInt("numofquestions"),
                    rs.getString("quizdate"),
                    rs.getString("quizstarttime"),
                    rs.getString("quizendtime"),
                    rs.getInt("duration"),
                    rs.getString("department"),
                    rs.getString("topic"),
                    rs.getInt("pin")
            );
            System.out.println(currQuiz.toString());
            quizzes.add(currQuiz);
        }
        return quizzes;
    }
    catch (SQLException e)
    {
        System.out.println(e.getLocalizedMessage());
        return null;
    }
}

    public ArrayList<Question> getQuestions(int quizid)
    {
        ArrayList<Question> questions=new ArrayList<Question>();
        try {
            Statement stmt = con.createStatement();
            ResultSet rs = stmt.executeQuery
                    ("SELECT * FROM question where quizid="+quizid);
            while (rs.next()) {
                Question currQuestion=new Question(
                        rs.getInt("quizid"),
                        rs.getInt("questionid"),
                        rs.getString("question"),
                        rs.getString("answer")

                );
                System.out.println(currQuestion.toString());
                questions.add(currQuestion);
            }
            return questions;
        }
        catch (SQLException e)
        {
            System.out.println(e.getLocalizedMessage());
            return null;
        }
    }

    public ArrayList<Scores> getScores(int quizid)
    {
        ArrayList<Scores> scores=new ArrayList<Scores>();
        try {
            Statement stmt = con.createStatement();
            ResultSet rs = stmt.executeQuery
                    ("SELECT * FROM scores where quizid="+quizid);
            while (rs.next()) {
                Scores currScores=new Scores(
                        rs.getInt("scoreid"),
                        rs.getInt("quizid"),
                        rs.getString("rollno"),
                        rs.getInt("total"),
                        rs.getInt("score")
                );
                System.out.println(currScores.toString());
                scores.add(currScores);
            }
            return scores;
        }
        catch (SQLException e)
        {
            System.out.println(e.getLocalizedMessage());
            return null;
        }
    }

}

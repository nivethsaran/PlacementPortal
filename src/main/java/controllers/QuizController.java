package controllers;

import models.Question;
import models.Quiz;
import models.Scores;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import java.io.File;
import java.sql.*;
import java.util.ArrayList;

import static utils.CONSTANTS.*;

public class QuizController {

    Connection con;

    public QuizController()
    {
        try {
            this.con = DriverManager.getConnection
                    (SQL_CONN_STRING, SQL_USERNAME,
                            SQL_PASSWORD);
        }
        catch (SQLException e)
        {
            System.out.println("Connection Error:"+e.getLocalizedMessage());
        }
    }

public static void main(String args[])
{
    QuizController controller=new QuizController();
    System.out.println(System.currentTimeMillis());
//    ArrayList<Question> questions = controller.getQuestions("1");
//    System.out.println(questions.size());
//    controller.getQuiz();
//    controller.getQuestions(1);
//    controller.getScores(1);
//    controller.parseScoresXML("E:\\Java_Projects\\PlacementPortalFrontend\\review2\\XML\\scores.xml");
//    controller.parseQuizXML("E:\\Java_Projects\\PlacementPortalFrontend\\review2\\XML\\quiz.xml");
//    controller.parseQuestionsXML("E:\\Java_Projects\\PlacementPortalFrontend\\review2\\XML\\question.xml");
}


public String getPIN(String quizid)
{
    try {
        Statement stmt = con.createStatement();
        ResultSet rs = stmt.executeQuery
                ("SELECT pin FROM quiz where quizid="+quizid);
        int rowCount=0;
        while (rs.next()) {
            rowCount++;
            return Integer.toString(rs.getInt("pin"));
        }
        return null;
    }
    catch (SQLException e)
    {
        System.out.println(e.getLocalizedMessage());
        return null;
    }
}

public ArrayList<Quiz> getQuizzes()
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


    public ArrayList<Quiz> getQuizzesForStudent(String rollno)
    {
        ArrayList<Quiz> quizzes=new ArrayList<Quiz>();
        try {
            Statement stmt = con.createStatement();
            ResultSet rs = stmt.executeQuery
                    ("SELECT * FROM QUIZ WHERE quizid not in (select quizid from scores where rollno='"+rollno+"');");
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


public Quiz getQuizFromId(String id)
{

    try {
        Statement stmt = con.createStatement();
        ResultSet rs = stmt.executeQuery
                ("SELECT * FROM quiz where quizid="+id);
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
            return currQuiz;
        }
        return null;
    }
    catch (SQLException e)
    {
        System.out.println(e.getLocalizedMessage());
        return null;
    }
}

    public ArrayList<Question> getQuestions(String quizid)
    {
        ArrayList<Question> questions=new ArrayList<Question>();
        try {
            Statement stmt = con.createStatement();
            String SQL_QUERY ="SELECT * FROM question where quizid="+quizid;
            ResultSet rs = stmt.executeQuery
                    (SQL_QUERY);
            int rowCount=0;
            System.out.println(SQL_QUERY);
            while (rs.next()) {
                rowCount++;
                Question currQuestion=new Question(
                        rs.getInt("quizid"),
                        rs.getInt("questionid"),
                        rs.getString("questioncontent"),
                        rs.getString("answer"),
                        rs.getString("optiona"),
                        rs.getString("optionb"),
                        rs.getString("optionc"),
                        rs.getString("optiond")
                );
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

    public ArrayList<Scores> getScores(String rollno)
    {
        ArrayList<Scores> scores=new ArrayList<Scores>();
        try {
            Statement stmt = con.createStatement();
            ResultSet rs = stmt.executeQuery
                    ("SELECT * FROM scores where rollno='"+rollno+"'");
            while (rs.next()) {
                Scores currScores=new Scores(
                        rs.getInt("scoreid"),
                        rs.getInt("quizid"),
                        rs.getString("rollno"),
                        rs.getInt("total"),
                        rs.getInt("studentscore")
                );
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

    public void parseQuizXML(String xml)
    {
        try {
            DocumentBuilderFactory docBuilderFactory;
            docBuilderFactory = DocumentBuilderFactory.newInstance();
            DocumentBuilder docBuilder =
                    docBuilderFactory.newDocumentBuilder();
            Document doc = docBuilder.parse(new File(xml));
            doc.getDocumentElement().normalize();
            String tablename="quiz";
            NodeList listOfProducts = doc.getElementsByTagName("quiz");
            System.out.println(listOfProducts.getLength());
            Statement stmt = con.createStatement();
            for (int i = 0; i < listOfProducts.getLength(); i++) {
                Node product = listOfProducts.item(i);
                Element productElement = (Element) product;

                String quizid= productElement.getElementsByTagName("quizid").item(0).getTextContent();
                String facultyid=productElement.getElementsByTagName("facultyid").item(0).getTextContent();
                String quizname= productElement.getElementsByTagName("quizname").item(0).getTextContent();
                String quizdescription = productElement.getElementsByTagName("quizdescription").item(0).getTextContent();
                String numofquestions = productElement.getElementsByTagName("numofquestions").item(0).getTextContent();
                String quizdate = productElement.getElementsByTagName("quizdate").item(0).getTextContent();
                String quizstarttime = productElement.getElementsByTagName("quizstarttime").item(0).getTextContent();
                String quizendtime = productElement.getElementsByTagName("quizendtime").item(0).getTextContent();
                String duration = productElement.getElementsByTagName("duration").item(0).getTextContent();
                String department = productElement.getElementsByTagName("department").item(0).getTextContent();
                String topic = productElement.getElementsByTagName("topic").item(0).getTextContent();
                String pin = productElement.getElementsByTagName("pin").item(0).getTextContent();

                String SQL_QUERY= "INSERT INTO "+tablename+ " VALUES ('"+
                        quizid+"','"+
                        facultyid+"','"+
                        quizname+"','"+
                        quizdescription+"','"+
                        numofquestions+"','"+
                        quizdate+"','"+
                        quizstarttime+"','"+
                        quizendtime+"','"+
                        duration+"','"+
                        department+"','"+
                        topic+"','"+
                        pin+"')";

                System.out.println(SQL_QUERY);
                stmt.executeUpdate(SQL_QUERY);

            }
            System.out.println("Inserted records into the table...");
        }
        catch(Exception e)
        {
            System.out.println(e.getLocalizedMessage());
        }
    }

    public boolean insertQuiz(Quiz quiz) {
        try {
            Statement stmt = con.createStatement();
            String SQL_QUERY = "INSERT INTO quiz(facultyid,quizname,quizdescription,numofquestions,quizdate,quizstarttime,quizendtime,duration,department,topic,pin) values ('"+
                    quiz.getFacultyid() + "','" +
                    quiz.getQuizname() + "','" +
                    quiz.getQuizdescription() + "'," +
                    quiz.getNumofquestions() + ",'" +
                    quiz.getQuizdate() + "','" +
                    quiz.getQuizstarttime() + "','" +
                    quiz.getQuizendtime() + "'," +
                    quiz.getDuration() + ",'" +
                    quiz.getDepartment() + "','" +
                    quiz.getTopic() + "'," +
                    quiz.getPin() +
                    ")";
            System.out.println(SQL_QUERY);
            int rs = stmt.executeUpdate
                    (SQL_QUERY);
            return true;
        }
        catch (SQLException e)
        {
            System.out.println(e.getLocalizedMessage());
            return false;
        }
    }

    public boolean insertQuestion(Question question) {
        try {
            Statement stmt = con.createStatement();
            String SQL_QUERY = "INSERT INTO question(quizid,questionid,questioncontent,answer,optiona,optionb,optionc,optiond) values ("+
                    question.getQuizid() + "," +
                    question.getQuestionid() + ",'" +
                    question.getQuestioncontent() + "','" +
                    question.getAnswer() + "','" +
                    question.getOptiona() + "','" +
                    question.getOptionb() + "','" +
                    question.getOptionc() + "','" +
                    question.getOptiond() + "'" +
                    ")";
            System.out.println(SQL_QUERY);
            int rs = stmt.executeUpdate
                    (SQL_QUERY);
            return true;
        }
        catch (SQLException e)
        {
            System.out.println(e.getLocalizedMessage());
            return false;
        }
    }

    public int getQuizId()
    {
        try {
            Statement stmt = con.createStatement();
            String SQL_QUERY = "Select quizid from quiz order by quizid desc limit 1; ";
            System.out.println(SQL_QUERY);
            ResultSet rs = stmt.executeQuery(SQL_QUERY);
            while (rs.next()) {
                return rs.getInt("quizid");
            }
            return -1;
    }
        catch (SQLException e)
        {
            System.out.println(e.getLocalizedMessage());
            return -1;
        }
    }



    public boolean insertScores(Scores scores) {
        try {
            Statement stmt = con.createStatement();
            String SQL_QUERY = "INSERT INTO scores(quizid,rollno,total,studentscore) values ("+
                    scores.getQuizid() + ",'" +
                    scores.getRollno() + "'," +
                    scores.getTotal() + "," +
                    scores.getScore()+")";
            System.out.println(SQL_QUERY);
            int rs = stmt.executeUpdate
                    (SQL_QUERY);
            return true;
        }
        catch (SQLException e)
        {
            System.out.println(e.getLocalizedMessage());
            return false;
        }
    }


    public void deleteQuizWithId(String quizid) {
        try{
            Statement stmt = con.createStatement();
            String SQL_QUERY = "Delete from quiz where quizid="+quizid;
            System.out.println(SQL_QUERY);
            int rs = stmt.executeUpdate
                    (SQL_QUERY);
        }catch (SQLException e)
        {
            System.out.println(e.getLocalizedMessage());
        }
    }

    public void deleteScoreWithId(String quizid) {
        try{
            Statement stmt = con.createStatement();
            String SQL_QUERY = "Delete from scores where quizid="+quizid;
            System.out.println(SQL_QUERY);
            int rs = stmt.executeUpdate
                    (SQL_QUERY);
        }catch (SQLException e)
        {
            System.out.println(e.getLocalizedMessage());
        }
    }

    public void deleteQuestionWithId(String quizid) {
        try {
            Statement stmt1 = con.createStatement();
            String SQL_QUERY_Q = "DELETE FROM QUESTION WHERE QUIZID=" + quizid;
            System.out.println(SQL_QUERY_Q);
            int rs1 = stmt1 .executeUpdate
                    (SQL_QUERY_Q);
        } catch (SQLException e) {
            System.out.println(e.getLocalizedMessage());
        }
    }

}

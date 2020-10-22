package controllers;

import models.Question;
import models.Quiz;
import models.Scores;
import models.Student;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import java.io.File;
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
//    controller.getQuiz();
//    controller.getQuestions(1);
//    controller.getScores(1);

    controller.parseQuizXML("E:\\Java_Projects\\PlacementPortalFrontend\\review2\\XML\\quiz.xml");
    controller.parseScoresXML("E:\\Java_Projects\\PlacementPortalFrontend\\review2\\XML\\scores.xml");
    controller.parseQuestionsXML("E:\\Java_Projects\\PlacementPortalFrontend\\review2\\XML\\question.xml");
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


    public void parseScoresXML(String xml)
    {
        try {
            DocumentBuilderFactory docBuilderFactory;
            docBuilderFactory = DocumentBuilderFactory.newInstance();
            DocumentBuilder docBuilder =
                    docBuilderFactory.newDocumentBuilder();
            Document doc = docBuilder.parse(new File(xml));
            doc.getDocumentElement().normalize();
            String tablename="scores";
            NodeList listOfProducts = doc.getElementsByTagName("score");
            System.out.println(listOfProducts.getLength());
            Statement stmt = con.createStatement();
            for (int i = 0; i < listOfProducts.getLength(); i++) {
                Node product = listOfProducts.item(i);
                Element productElement = (Element) product;

                String scoreid= productElement.getElementsByTagName("scoreid").item(0).getTextContent();
                String quizid=productElement.getElementsByTagName("quizid").item(0).getTextContent();
                String rollno= productElement.getElementsByTagName("rollno").item(0).getTextContent();
                String total = productElement.getElementsByTagName("total").item(0).getTextContent();
                String studentscore = productElement.getElementsByTagName("studentscore").item(0).getTextContent();

                String SQL_QUERY= "INSERT INTO "+tablename+ " VALUES ('"+
                        scoreid+"','"+
                        quizid+"','"+
                        rollno+"','"+
                        total+"','"+
                        studentscore+"')";

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


    public void parseQuestionsXML(String xml)
    {
        try {
            DocumentBuilderFactory docBuilderFactory;
            docBuilderFactory = DocumentBuilderFactory.newInstance();
            DocumentBuilder docBuilder =
                    docBuilderFactory.newDocumentBuilder();
            Document doc = docBuilder.parse(new File(xml));
            doc.getDocumentElement().normalize();
            String tablename="question";
            NodeList listOfProducts = doc.getElementsByTagName("question");
            System.out.println(listOfProducts.getLength());
            Statement stmt = con.createStatement();
            for (int i = 0; i < listOfProducts.getLength(); i++) {
                Node product = listOfProducts.item(i);
                Element productElement = (Element) product;

                String quizid= productElement.getElementsByTagName("quizid").item(0).getTextContent();
                String questionid=productElement.getElementsByTagName("questionid").item(0).getTextContent();
                String questioncontent= productElement.getElementsByTagName("questioncontent").item(0).getTextContent();
                String answer = productElement.getElementsByTagName("answer").item(0).getTextContent();
                String optiona = productElement.getElementsByTagName("optiona").item(0).getTextContent();
                String optionb = productElement.getElementsByTagName("optionb").item(0).getTextContent();
                String optionc = productElement.getElementsByTagName("optionc").item(0).getTextContent();
                String optiond = productElement.getElementsByTagName("optiond").item(0).getTextContent();

                String SQL_QUERY= "INSERT INTO "+tablename+ " VALUES ('"+
                        quizid+"','"+
                        questionid+"','"+
                        questioncontent+"','"+
                        answer+"','"+
                        optiona+"','"+
                        optionb+"','"+
                        optionc+"','"+
                        optiond+"')";

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


}

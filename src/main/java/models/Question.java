package models;

public class Question {

    int quizid;
    int questionid;
    String question;
    String answer;

    public Question(int quizid, int questionid, String question, String answer) {
        this.quizid = quizid;
        this.questionid = questionid;
        this.question = question;
        this.answer = answer;
    }

    public int getQuizid() {
        return quizid;
    }

    public void setQuizid(int quizid) {
        this.quizid = quizid;
    }

    public int getQuestionid() {
        return questionid;
    }

    public void setQuestionid(int questionid) {
        this.questionid = questionid;
    }

    public String getQuestion() {
        return question;
    }

    public void setQuestion(String question) {
        this.question = question;
    }

    public String getAnswer() {
        return answer;
    }

    public void setAnswer(String answer) {
        this.answer = answer;
    }

    @Override
    public String toString() {
        return "question{" +
                "quizid=" + quizid +
                ", questionid=" + questionid +
                ", question='" + question + '\'' +
                ", answer='" + answer + '\'' +
                '}';
    }
}

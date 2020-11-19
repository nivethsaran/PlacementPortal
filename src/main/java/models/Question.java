package models;

public class Question {

    int quizid;
    int questionid;
    String questioncontent;
    String answer;
    String optiona;
    String optionb;
    String optionc;

    @Override
    public String toString() {
        return "Question{" +
                "quizid=" + quizid +
                ", questionid=" + questionid +
                ", questioncontent='" + questioncontent + '\'' +
                ", answer='" + answer + '\'' +
                ", optiona='" + optiona + '\'' +
                ", optionb='" + optionb + '\'' +
                ", optionc='" + optionc + '\'' +
                ", optiond='" + optiond + '\'' +
                '}';
    }

    public void setQuizid(int quizid) {
        this.quizid = quizid;
    }

    public void setQuestionid(int questionid) {
        this.questionid = questionid;
    }

    public void setQuestioncontent(String questioncontent) {
        this.questioncontent = questioncontent;
    }

    public void setAnswer(String answer) {
        this.answer = answer;
    }

    public void setOptiona(String optiona) {
        this.optiona = optiona;
    }

    public void setOptionb(String optionb) {
        this.optionb = optionb;
    }

    public void setOptionc(String optionc) {
        this.optionc = optionc;
    }

    public void setOptiond(String optiond) {
        this.optiond = optiond;
    }

    public int getQuizid() {
        return quizid;
    }

    public int getQuestionid() {
        return questionid;
    }

    public String getQuestioncontent() {
        return questioncontent;
    }

    public String getAnswer() {
        return answer;
    }

    public String getOptiona() {
        return optiona;
    }

    public String getOptionb() {
        return optionb;
    }

    public String getOptionc() {
        return optionc;
    }

    public String getOptiond() {
        return optiond;
    }

    public Question(int quizid, int questionid, String questioncontent, String answer, String optiona, String optionb, String optionc, String optiond) {
        this.quizid = quizid;
        this.questionid = questionid;
        this.questioncontent = questioncontent;
        this.answer = answer;
        this.optiona = optiona;
        this.optionb = optionb;
        this.optionc = optionc;
        this.optiond = optiond;
    }

    String optiond;
}

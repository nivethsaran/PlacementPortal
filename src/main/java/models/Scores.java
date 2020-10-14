package models;

public class Scores {

    int scoreid;
    int quizid;
    String rollno;
    int total;
    int score;

    public Scores(int scoreid, int quizid, String rollno, int total, int score) {
        this.scoreid = scoreid;
        this.quizid = quizid;
        this.rollno = rollno;
        this.total = total;
        this.score = score;
    }

    public int getScoreid() {
        return scoreid;
    }

    public void setScoreid(int scoreid) {
        this.scoreid = scoreid;
    }

    public int getQuizid() {
        return quizid;
    }

    public void setQuizid(int quizid) {
        this.quizid = quizid;
    }

    public String getRollno() {
        return rollno;
    }

    public void setRollno(String rollno) {
        this.rollno = rollno;
    }

    public int getTotal() {
        return total;
    }

    public void setTotal(int total) {
        this.total = total;
    }

    public int getScore() {
        return score;
    }

    public void setScore(int score) {
        this.score = score;
    }

    @Override
    public String toString() {
        return "scores{" +
                "scoreid=" + scoreid +
                ", quizid=" + quizid +
                ", rollno='" + rollno + '\'' +
                ", total=" + total +
                ", score=" + score +
                '}';
    }
}

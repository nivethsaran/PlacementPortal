package models;

public class Quiz {

    int quizid;
    String facultyid;
    String quizname;
    String quizdescription;
    int numofquestions;
    String quizdate;
    String quizstarttime;
    String quizendtime;
    int duration;
    String department;
    String topic;
    int pin;

    public Quiz(int quizid, String facultyid, String quizname, String quizdescription, int numofquestions, String quizdate, String quizstarttime, String quizendtime, int duration, String department, String topic, int pin) {
        this.quizid = quizid;
        this.facultyid = facultyid;
        this.quizname = quizname;
        this.quizdescription = quizdescription;
        this.numofquestions = numofquestions;
        this.quizdate = quizdate;
        this.quizstarttime = quizstarttime;
        this.quizendtime = quizendtime;
        this.duration = duration;
        this.department = department;
        this.topic = topic;
        this.pin = pin;
    }

    @Override
    public String toString() {
        return "quiz{" +
                "quizid=" + quizid +
                ", facultyid='" + facultyid + '\'' +
                ", quizname='" + quizname + '\'' +
                ", quizdescription='" + quizdescription + '\'' +
                ", numofquestions=" + numofquestions +
                ", quizdate='" + quizdate + '\'' +
                ", quizstarttime='" + quizstarttime + '\'' +
                ", quizendtime='" + quizendtime + '\'' +
                ", duration=" + duration +
                ", department='" + department + '\'' +
                ", topic='" + topic + '\'' +
                ", pin=" + pin +
                '}';
    }

    public int getQuizid() {
        return quizid;
    }

    public void setQuizid(int quizid) {
        this.quizid = quizid;
    }

    public String getFacultyid() {
        return facultyid;
    }

    public void setFacultyid(String facultyid) {
        this.facultyid = facultyid;
    }

    public String getQuizname() {
        return quizname;
    }

    public void setQuizname(String quizname) {
        this.quizname = quizname;
    }

    public String getQuizdescription() {
        return quizdescription;
    }

    public void setQuizdescription(String quizdescription) {
        this.quizdescription = quizdescription;
    }

    public int getNumofquestions() {
        return numofquestions;
    }

    public void setNumofquestions(int numofquestions) {
        this.numofquestions = numofquestions;
    }

    public String getQuizdate() {
        return quizdate;
    }

    public void setQuizdate(String quizdate) {
        this.quizdate = quizdate;
    }

    public String getQuizstarttime() {
        return quizstarttime;
    }

    public void setQuizstarttime(String quizstarttime) {
        this.quizstarttime = quizstarttime;
    }

    public String getQuizendtime() {
        return quizendtime;
    }

    public void setQuizendtime(String quizendtime) {
        this.quizendtime = quizendtime;
    }

    public int getDuration() {
        return duration;
    }

    public void setDuration(int duration) {
        this.duration = duration;
    }

    public String getDepartment() {
        return department;
    }

    public void setDepartment(String department) {
        this.department = department;
    }

    public String getTopic() {
        return topic;
    }

    public void setTopic(String topic) {
        this.topic = topic;
    }

    public int getPin() {
        return pin;
    }

    public void setPin(int pin) {
        this.pin = pin;
    }
}

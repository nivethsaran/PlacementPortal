package models;

public class Coding {

    int problemid;
    String problemname;
    String problemdesc;
    String problemdifficulty;
    String facultyid;

    public Coding(int problemid, String problemname, String problemdesc, String problemdifficulty, String facultyid) {
        this.problemid = problemid;
        this.problemname = problemname;
        this.problemdesc = problemdesc;
        this.problemdifficulty = problemdifficulty;
        this.facultyid = facultyid;
    }

    public int getProblemid() {
        return problemid;
    }

    public void setProblemid(int problemid) {
        this.problemid = problemid;
    }

    public String getProblemname() {
        return problemname;
    }

    public void setProblemname(String problemname) {
        this.problemname = problemname;
    }

    public String getProblemdesc() {
        return problemdesc;
    }

    public void setProblemdesc(String problemdesc) {
        this.problemdesc = problemdesc;
    }

    public String getProblemdifficulty() {
        return problemdifficulty;
    }

    public void setProblemdifficulty(String problemdifficulty) {
        this.problemdifficulty = problemdifficulty;
    }

    public String getFacultyid() {
        return facultyid;
    }

    public void setFacultyid(String facultyid) {
        this.facultyid = facultyid;
    }

    @Override
    public String toString() {
        return "coding{" +
                "problemid=" + problemid +
                ", problemname='" + problemname + '\'' +
                ", problemdesc='" + problemdesc + '\'' +
                ", problemdifficulty='" + problemdifficulty + '\'' +
                ", facultyid='" + facultyid + '\'' +
                '}';
    }
}

package models;

public class StudentNotes {

    int noteid;
    String notetitle;
    String notecontent;
    String notedate;
    String rollno;

    public StudentNotes(int noteid, String notetitle, String notecontent, String notedate, String rollno) {
        this.noteid = noteid;
        this.notetitle = notetitle;
        this.notecontent = notecontent;
        this.notedate = notedate;
        this.rollno = rollno;
    }

    public int getNoteid() {
        return noteid;
    }

    @Override
    public String toString() {
        return "studentnotes{" +
                "noteid=" + noteid +
                ", notetitle='" + notetitle + '\'' +
                ", notecontent='" + notecontent + '\'' +
                ", notedate='" + notedate + '\'' +
                ", rollno='" + rollno + '\'' +
                '}';
    }

    public void setNoteid(int noteid) {
        this.noteid = noteid;
    }

    public String getNotetitle() {
        return notetitle;
    }

    public void setNotetitle(String notetitle) {
        this.notetitle = notetitle;
    }

    public String getNotecontent() {
        return notecontent;
    }

    public void setNotecontent(String notecontent) {
        this.notecontent = notecontent;
    }

    public String getNotedate() {
        return notedate;
    }

    public void setNotedate(String notedate) {
        this.notedate = notedate;
    }

    public String getRollno() {
        return rollno;
    }

    public void setRollno(String rollno) {
        this.rollno = rollno;
    }
}

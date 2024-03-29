package models;

public class Companyregistration {

    String facultyid;
    int formid;
    String companyname;
    String deadline;
    String formurl;
    String pay;

    @Override
    public String toString() {
        return "Companyregistration{" +
                "facultyid='" + facultyid + '\'' +
                ", formid=" + formid +
                ", companyname='" + companyname + '\'' +
                ", deadline='" + deadline + '\'' +
                ", formurl='" + formurl + '\'' +
                ", pay='" + pay + '\'' +
                '}';
    }

    public String getFacultyid() {
        return facultyid;
    }

    public void setFacultyid(String facultyid) {
        this.facultyid = facultyid;
    }

    public int getFormid() {
        return formid;
    }

    public void setFormid(int formid) {
        this.formid = formid;
    }

    public String getCompanyname() {
        return companyname;
    }

    public void setCompanyname(String companyname) {
        this.companyname = companyname;
    }

    public String getDeadline() {
        return deadline;
    }

    public void setDeadline(String deadline) {
        this.deadline = deadline;
    }

    public String getFormurl() {
        return formurl;
    }

    public void setFormurl(String formurl) {
        this.formurl = formurl;
    }

    public String getPay() {
        return pay;
    }

    public void setPay(String pay) {
        this.pay = pay;
    }

    public Companyregistration(String facultyid, int formid, String companyname, String deadline, String formurl, String pay) {
        this.facultyid = facultyid;
        this.formid = formid;
        this.companyname = companyname;
        this.deadline = deadline;
        this.formurl = formurl;
        this.pay = pay;
    }
}

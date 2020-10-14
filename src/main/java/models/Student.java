package models;

public class Student {

    String fullname;
    String rollno;
    String authpassword;
    String avatarurl;
    String mobilenumber;
    String email;
    String department;

    @Override
    public String toString() {
        return "student{" +
                "fullname='" + fullname + '\'' +
                ", rollno='" + rollno + '\'' +
                ", authpassword='" + authpassword + '\'' +
                ", avatarurl='" + avatarurl + '\'' +
                ", mobilenumber='" + mobilenumber + '\'' +
                ", email='" + email + '\'' +
                ", department='" + department + '\'' +
                '}';
    }

    public String getFullname() {
        return fullname;
    }

    public void setFullname(String fullname) {
        this.fullname = fullname;
    }

    public String getRollno() {
        return rollno;
    }

    public void setRollno(String rollno) {
        this.rollno = rollno;
    }

    public String getAuthpassword() {
        return authpassword;
    }

    public void setAuthpassword(String authpassword) {
        this.authpassword = authpassword;
    }

    public String getAvatarurl() {
        return avatarurl;
    }

    public void setAvatarurl(String avatarurl) {
        this.avatarurl = avatarurl;
    }

    public String getMobilenumber() {
        return mobilenumber;
    }

    public void setMobilenumber(String mobilenumber) {
        this.mobilenumber = mobilenumber;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getDepartment() {
        return department;
    }

    public void setDepartment(String department) {
        this.department = department;
    }

    public Student(String fullname, String rollno, String authpassword, String avatarurl, String mobilenumber, String email, String department) {
        this.fullname = fullname;
        this.rollno = rollno;
        this.authpassword = authpassword;
        this.avatarurl = avatarurl;
        this.mobilenumber = mobilenumber;
        this.email = email;
        this.department = department;
    }

}

package models;

public class Faculty {

    String fullname;
    String facultyid;
    String authpassword;
    String avatarurl;
    String mobilenumber;
    String email;
    String department;

    public Faculty(String fullname, String facultyid, String authpassword, String avatarurl, String mobilenumber, String email, String department) {
        this.fullname = fullname;
        this.facultyid = facultyid;
        this.authpassword = authpassword;
        this.avatarurl = avatarurl;
        this.mobilenumber = mobilenumber;
        this.email = email;
        this.department = department;
    }

    public String getFullname() {
        return fullname;
    }

    public void setFullname(String fullname) {
        this.fullname = fullname;
    }

    public String getFacultyid() {
        return facultyid;
    }

    public void setFacultyid(String facultyid) {
        this.facultyid = facultyid;
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

    @Override
    public String toString() {
        return "faculty{" +
                "fullname='" + fullname + '\'' +
                ", facultyid='" + facultyid + '\'' +
                ", authpassword='" + authpassword + '\'' +
                ", avatarurl='" + avatarurl + '\'' +
                ", mobilenumber='" + mobilenumber + '\'' +
                ", email='" + email + '\'' +
                ", department='" + department + '\'' +
                '}';
    }
}

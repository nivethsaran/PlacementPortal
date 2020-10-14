package models;

public class Courses {

    int courseid;
    String coursename;
    String topicname;
    String department;
    String courseurl;
    String facultyid;

    public Courses(int courseid, String coursename, String topicname, String department, String courseurl, String facultyid) {
        this.courseid = courseid;
        this.coursename = coursename;
        this.topicname = topicname;
        this.department = department;
        this.courseurl = courseurl;
        this.facultyid = facultyid;
    }

    public int getCourseid() {
        return courseid;
    }

    public void setCourseid(int courseid) {
        this.courseid = courseid;
    }

    public String getCoursename() {
        return coursename;
    }

    public void setCoursename(String coursename) {
        this.coursename = coursename;
    }

    public String getTopicname() {
        return topicname;
    }

    public void setTopicname(String topicname) {
        this.topicname = topicname;
    }

    public String getDepartment() {
        return department;
    }

    public void setDepartment(String department) {
        this.department = department;
    }

    public String getCourseurl() {
        return courseurl;
    }

    public void setCourseurl(String courseurl) {
        this.courseurl = courseurl;
    }

    public String getFacultyid() {
        return facultyid;
    }

    public void setFacultyid(String facultyid) {
        this.facultyid = facultyid;
    }

    @Override
    public String toString() {
        return "courses{" +
                "courseid=" + courseid +
                ", coursename='" + coursename + '\'' +
                ", topicname='" + topicname + '\'' +
                ", department='" + department + '\'' +
                ", courseurl='" + courseurl + '\'' +
                ", facultyid='" + facultyid + '\'' +
                '}';
    }


}

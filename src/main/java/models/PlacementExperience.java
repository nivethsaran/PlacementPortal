package models;

public class PlacementExperience {

    int experienceid;
    String rollno;
    String experience;
    String companyname;
    String posttime;

    @Override
    public String toString() {
        return "placementexperience{" +
                "experienceid=" + experienceid +
                ", rollno='" + rollno + '\'' +
                ", experience='" + experience + '\'' +
                ", companyname='" + companyname + '\'' +
                ", posttime='" + posttime + '\'' +
                '}';
    }

    public int getExperienceid() {
        return experienceid;
    }

    public void setExperienceid(int experienceid) {
        this.experienceid = experienceid;
    }

    public String getRollno() {
        return rollno;
    }

    public void setRollno(String rollno) {
        this.rollno = rollno;
    }

    public String getExperience() {
        return experience;
    }

    public void setExperience(String experience) {
        this.experience = experience;
    }

    public String getCompanyname() {
        return companyname;
    }

    public void setCompanyname(String companyname) {
        this.companyname = companyname;
    }

    public String getPosttime() {
        return posttime;
    }

    public void setPosttime(String posttime) {
        this.posttime = posttime;
    }

    public PlacementExperience(int experienceid, String rollno, String experience, String companyname, String posttime) {
        this.experienceid = experienceid;
        this.rollno = rollno;
        this.experience = experience;
        this.companyname = companyname;
        this.posttime = posttime;
    }
}

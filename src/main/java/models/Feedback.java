package models;

public class Feedback {

    String facultyid;
    int feedbackid;
    int pace;
    int onlinetoolusage;
    int effectiveness;
    int approachability;
    String recommend;
    String optadvanced;
    String suggestions;
    int courseid;

    public Feedback(String facultyid, int feedbackid, int pace, int onlinetoolusage, int effectiveness, int approachability, String recommend, String optadvanced, String suggestions, int courseid) {
        this.facultyid = facultyid;
        this.feedbackid = feedbackid;
        this.pace = pace;
        this.onlinetoolusage = onlinetoolusage;
        this.effectiveness = effectiveness;
        this.approachability = approachability;
        this.recommend = recommend;
        this.optadvanced = optadvanced;
        this.suggestions = suggestions;
        this.courseid = courseid;
    }

    @Override
    public String toString() {
        return "feedback{" +
                "facultyid=" + facultyid +
                ", feedbackid=" + feedbackid +
                ", pace=" + pace +
                ", onlinetoolusage=" + onlinetoolusage +
                ", effectiveness=" + effectiveness +
                ", approachability=" + approachability +
                ", recommend='" + recommend + '\'' +
                ", optadvanced='" + optadvanced + '\'' +
                ", suggestions='" + suggestions + '\'' +
                ", courseid=" + courseid +
                '}';
    }

    public String getFacultyid() {
        return facultyid;
    }

    public void setFacultyid(String facultyid) {
        this.facultyid = facultyid;
    }

    public int getFeedbackid() {
        return feedbackid;
    }

    public void setFeedbackid(int feedbackid) {
        this.feedbackid = feedbackid;
    }

    public int getPace() {
        return pace;
    }

    public void setPace(int pace) {
        this.pace = pace;
    }

    public int getOnlinetoolusage() {
        return onlinetoolusage;
    }

    public void setOnlinetoolusage(int onlinetoolusage) {
        this.onlinetoolusage = onlinetoolusage;
    }

    public int getEffectiveness() {
        return effectiveness;
    }

    public void setEffectiveness(int effectiveness) {
        this.effectiveness = effectiveness;
    }

    public int getApproachability() {
        return approachability;
    }

    public void setApproachability(int approachability) {
        this.approachability = approachability;
    }

    public String getRecommend() {
        return recommend;
    }

    public void setRecommend(String recommend) {
        this.recommend = recommend;
    }

    public String getOptadvanced() {
        return optadvanced;
    }

    public void setOptadvanced(String optadvanced) {
        this.optadvanced = optadvanced;
    }

    public String getSuggestions() {
        return suggestions;
    }

    public void setSuggestions(String suggestions) {
        this.suggestions = suggestions;
    }

    public int getCourseid() {
        return courseid;
    }

    public void setCourseid(int courseid) {
        this.courseid = courseid;
    }
}


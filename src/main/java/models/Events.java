package models;

public class Events {

    int eventid;
    String eventdate;
    String eventtitle;
    String eventdesc;

    public Events(int eventid, String eventdate, String eventtitle, String eventdesc) {
        this.eventid = eventid;
        this.eventdate = eventdate;
        this.eventtitle = eventtitle;
        this.eventdesc = eventdesc;
    }

    @Override
    public String toString() {
        return "events{" +
                "eventid=" + eventid +
                ", eventdate='" + eventdate + '\'' +
                ", eventtitle='" + eventtitle + '\'' +
                ", eventdesc='" + eventdesc + '\'' +
                '}';
    }

    public int getEventid() {
        return eventid;
    }

    public void setEventid(int eventid) {
        this.eventid = eventid;
    }

    public String getEventdate() {
        return eventdate;
    }

    public void setEventdate(String eventdate) {
        this.eventdate = eventdate;
    }

    public String getEventtitle() {
        return eventtitle;
    }

    public void setEventtitle(String eventtitle) {
        this.eventtitle = eventtitle;
    }

    public String getEventdesc() {
        return eventdesc;
    }

    public void setEventdesc(String eventdesc) {
        this.eventdesc = eventdesc;
    }
}

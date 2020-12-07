package models;

public class Events {

    String eventid;
    String eventdate;
    String eventtitle;
    String eventdesc;

    public Events(String eventid, String eventdate, String eventtitle, String eventdesc) {
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

    public String getEventid() {
        return eventid;
    }

    public void setEventid(String eventid) {
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

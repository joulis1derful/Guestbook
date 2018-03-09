package model;

import java.util.Date;

public class Guestbook {
    private int id;
    private Date timestamp;
    private int visitor_id;

    public Guestbook(int id, Date timestamp, int visitor_id) {
        this.id = id;
        this.timestamp = timestamp;
        this.visitor_id = visitor_id;
    }

    public int getId() {
        return id;
    }

    public Date getTimestamp() {
        return timestamp;
    }

    public int getVisitor_id() {
        return visitor_id;
    }
}

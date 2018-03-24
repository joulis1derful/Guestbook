package model;

import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "guestbook")
public class Guestbook {
    @Id
    @GeneratedValue(generator = "increment")
    @GenericGenerator(name = "increment", strategy = "increment")
    private int id;
    @Column
    @Temporal(TemporalType.DATE)
    private Date timestamp;
    @Column
    private int visitor_id;

    public Guestbook() {
    }

    public Guestbook(Date timestamp, int visitor_id) {
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

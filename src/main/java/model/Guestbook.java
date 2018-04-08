package model;

import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;
import java.util.List;

@Entity
public class Guestbook implements Serializable {
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
        this.timestamp = new Date();
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

package model;

import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.io.Serializable;

@Entity
public class Page implements Serializable {
    @Id
    private int id;
    @Column
    private String name;
//    @ManyToOne
//    @JoinColumn(name = "page_id")
//    private Guestbook guestbook;

    public Page() {
    }

    public Page(String name) {
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

//    public Guestbook getGuestbook() {
//        return guestbook;
//    }
}

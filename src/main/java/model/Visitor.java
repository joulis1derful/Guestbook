package model;

import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.io.Serializable;

@Entity
public class Visitor implements Serializable {
   @Id
   @GeneratedValue(generator = "increment")
   @GenericGenerator(name = "increment", strategy = "increment")
   private int id;
   @Column
   private String fname;
   @Column
   private String lname;
   @Column
   private String email;
   @Column
   private String dob;
   @Column
   private String tel;
   @Column
   private String country;
   @Column
   private String city;
//   @ManyToOne
//   @JoinColumn(name = "guestbook_id")
//   private Guestbook guestbook;

    public Visitor() {
    }

    public Visitor(String fname, String lname, String email, String dob, String tel, String country, String city)
    {
        this.fname = fname;
        this.lname = lname;
        this.email = email;
        this.dob = dob;
        this.tel = tel;
        this.country = country;
        this.city = city;
    }

    public int getId() {
        return id;
    }

    public String getFname() {
        return fname;
    }

    public void setFname(String fname) {
        this.fname = fname;
    }

    public String getLname() {
        return lname;
    }

    public void setLname(String lname) {
        this.lname = lname;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getDob() {
        return dob;
    }

    public void setDob(String dob) {
        this.dob = dob;
    }

    public String getTel() {
        return tel;
    }

    public void setTel(String tel) {
        this.tel = tel;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

//    public Guestbook getGuestbook() {
//        return guestbook;
//    }
//
//    public void setGuestbook(Guestbook guestbook) {
//        this.guestbook = guestbook;
//    }

    @Override
    public String toString() {
        return "model.Visitor{" +
                "fname='" + fname + '\'' +
                ", lname='" + lname + '\'' +
                ", email='" + email + '\'' +
                ", dob='" + dob + '\'' +
                ", tel='" + tel + '\'' +
                ", country='" + country + '\'' +
                ", city='" + city + '\'' +
                '}';
    }
}


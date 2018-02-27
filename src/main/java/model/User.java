package model;

public class User {
   private String fname;
   private String lname;
   private String email;
   private String dob;
   private String tel;
   private String country;
   private String city;

    public User(String fname, String lname, String email, String dob, String tel, String country, String city)
    {
        this.fname = fname;
        this.lname = lname;
        this.email = email;
        this.dob = dob;
        this.tel = tel;
        this.country = country;
        this.city = city;
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

    @Override
    public String toString() {
        return "model.User{" +
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


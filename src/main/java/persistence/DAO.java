package persistence;

import model.User;
import model.User;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class DAO {

    public final static String DB_DRIVER = "com.mysql.jdbc.Driver";
    public final static String DB_URL = "jdbc:mysql://localhost:3306/mydbtest";
    public final static String DB_USERNAME = "root";
    public final static String DB_PASSWORD = "root";

    public static Connection getConnection() throws ClassNotFoundException, SQLException {
        Class.forName(DB_DRIVER);
        return DriverManager.getConnection(DB_URL, DB_USERNAME, DB_PASSWORD);
    }

    public static List<User> getPosts() throws SQLException, ClassNotFoundException {
        try (Connection c = getConnection();
             PreparedStatement ps = c.prepareStatement("SELECT fname, lname, email, dob, tel, country, city FROM guestbook");
             ResultSet resultSet = ps.executeQuery();) {
            ArrayList<User> users = new ArrayList<>();
            while (resultSet.next()) {
                String fname = resultSet.getString(1);
                String lname = resultSet.getString(2);
                String email = resultSet.getString(3);
                String dob = resultSet.getString(4);
                String tel = resultSet.getString(5);
                String country = resultSet.getString(6);
                String city = resultSet.getString(7);
                users.add(new User(fname, lname, email, dob, tel, country, city));
            }
            return users;
        }
    }

    public static void insertToDb(String fname, String lname, String email, String dob,
                           String tel, String country, String city) {
        try (Connection c = DAO.getConnection();
             PreparedStatement ps = c.prepareStatement("INSERT INTO guestbook values (?, ?, ?, ?, ?, ?, ?)");) {
            ps.setString(1, fname);
            ps.setString(2, lname);
            ps.setString(3, email);
            ps.setString(4, dob);
            ps.setString(5, tel);
            ps.setString(6, country);
            ps.setString(7, city);

            ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    public static void deletePost(String lname) throws ClassNotFoundException, SQLException{
        try (Connection c = getConnection();
             PreparedStatement ps = c.prepareStatement("DELETE from guestbook WHERE lname=?");
        ){
            ps.setString(1, lname);
            ps.executeUpdate();
        }
    }
    public static List<User> getWithCountry(String co) throws SQLException, ClassNotFoundException{
        try (Connection c = getConnection();
             PreparedStatement ps = c.prepareStatement("SELECT fname, lname, email, dob, tel, country, city FROM guestbook WHERE country=?");
             ) {
            ps.setString(1, co);
            ResultSet resultSet = ps.executeQuery();
            ArrayList<User> users = new ArrayList<>();
            while (resultSet.next()) {
                String fname = resultSet.getString(1);
                String lname = resultSet.getString(2);
                String email = resultSet.getString(3);
                String dob = resultSet.getString(4);
                String tel = resultSet.getString(5);
                String country = resultSet.getString(6);
                String city = resultSet.getString(7);
                users.add(new User(fname, lname, email, dob, tel, country, city));
            }
            return users;
        }
    }
    }

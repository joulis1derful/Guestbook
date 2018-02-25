package persistence;

import model.User;
import model.User;

import java.io.IOException;
import java.io.InputStream;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

public class DAO {

    private static Connection getConnection() throws ClassNotFoundException, SQLException, IOException {
        InputStream inputStream = DAO.class.getClassLoader()
                .getResourceAsStream("db.properties");
        Properties properties = new Properties();
        properties.load(inputStream);

        String dbDriver = properties.getProperty("db.driver");
        String connectionUrl = properties.getProperty("db.url");
        String username = properties.getProperty("db.username");
        String password = properties.getProperty("db.password");

        Class.forName(dbDriver);
        return DriverManager.getConnection(connectionUrl, username, password);
    }

    public static List<User> getUsers() {
        ArrayList<User> users = new ArrayList<>();
        try (Connection c = getConnection();
             PreparedStatement ps = c.prepareStatement("SELECT * FROM guestbook");
             ResultSet resultSet = ps.executeQuery();) {
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
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return users;
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
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void deletePost(String lname) {
        try (Connection c = getConnection();
             PreparedStatement ps = c.prepareStatement("DELETE from guestbook WHERE lname=?");
        ){
            ps.setString(1, lname);
            ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    public static List<User> getWithCountry(String cntr) {
        ArrayList<User> users = new ArrayList<>();
        try (Connection c = getConnection();
             PreparedStatement ps = c.prepareStatement("SELECT * FROM guestbook WHERE country=?");
             ) {
            ps.setString(1, cntr);
            ResultSet resultSet = ps.executeQuery();
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
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return users;
    }
}

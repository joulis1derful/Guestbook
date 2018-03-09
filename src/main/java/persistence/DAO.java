package persistence;

import model.ConnectionData;
import model.User;
import model.User;

import javax.xml.bind.*;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;
import java.util.Date;

public class DAO {

    private static Connection getConnection() throws ClassNotFoundException, SQLException, IOException {
//        InputStream inputStream = DAO.class.getClassLoader()
//                .getResourceAsStream("db.properties");
//        Properties properties = new Properties();
//        properties.load(inputStream);

//        String dbDriver = properties.getProperty("db.driver");
//        String url = properties.getProperty("db.url");
//        String username = properties.getProperty("db.username");
//        String password = properties.getProperty("db.username");

        try {
            JAXBContext jaxbContext = JAXBContext.newInstance(ConnectionData.class);
            Unmarshaller jaxbUnmarshaller = jaxbContext.createUnmarshaller();
            ConnectionData cd = (ConnectionData) jaxbUnmarshaller.unmarshal(new File("connectionData.xml"));
            String url = cd.getUrl();
            String username = cd.getUsername();
            String password = cd.getPassword();
            System.out.println(url);
            System.out.println(username);
            System.out.println(password);
            return DriverManager.getConnection(url, username, password);
        } catch (PropertyException e) {
            e.printStackTrace();
        } catch (JAXBException e) {
            e.printStackTrace();
        }

//        Class.forName(dbDriver);
        return null;
    }

    public static List<User> getUsers() {
        ArrayList<User> users = new ArrayList<>();
        try (Connection c = getConnection();
             PreparedStatement ps = c.prepareStatement("SELECT * FROM visitor");
             ResultSet resultSet = ps.executeQuery();) {
            while (resultSet.next()) {
                int id = resultSet.getInt(1);
                String fname = resultSet.getString(2);
                String lname = resultSet.getString(3);
                String email = resultSet.getString(4);
                String dob = resultSet.getString(5);
                String tel = resultSet.getString(6);
                String country = resultSet.getString(7);
                String city = resultSet.getString(8);
                users.add(new User(id, fname, lname, email, dob, tel, country, city));
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
             PreparedStatement ps = c.prepareStatement("INSERT INTO visitor (fname, lname, email, tel, dob, country, city) values (?, ?, ?, ?, ?, ?, ?)",
                     Statement.RETURN_GENERATED_KEYS);) {
            ps.setString(1, fname);
            ps.setString(2, lname);
            ps.setString(3, email);
            ps.setString(4, dob);
            ps.setString(5, tel);
            ps.setString(6, country);
            ps.setString(7, city);

            ps.executeUpdate();

            ResultSet key = ps.getGeneratedKeys();
            key.next();
            int visitor_id = key.getInt(1);
            System.out.println(key.getInt(1));
            PreparedStatement ps_guestbook = c.prepareStatement("INSERT into guestbook (time, visitor_id) VALUES (?, ?)");
            ps_guestbook.setTimestamp(1, new Timestamp(new Date().getTime()));
            ps_guestbook.setInt(2, visitor_id);
            ps_guestbook.executeUpdate();
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
             PreparedStatement ps = c.prepareStatement("DELETE from visitor WHERE lname=?");
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
             PreparedStatement ps = c.prepareStatement("SELECT * FROM visitor WHERE country=?");
             ) {
            ps.setString(1, cntr);
            ResultSet resultSet = ps.executeQuery();
            while (resultSet.next()) {
                int id = resultSet.getInt(1);
                String fname = resultSet.getString(2);
                String lname = resultSet.getString(3);
                String email = resultSet.getString(4);
                String dob = resultSet.getString(5);
                String tel = resultSet.getString(6);
                String country = resultSet.getString(7);
                String city = resultSet.getString(8);
                users.add(new User(id, fname, lname, email, dob, tel, country, city));
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

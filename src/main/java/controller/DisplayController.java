package controller;

import model.User;
import persistence.DAO;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

@WebServlet(name = "DisplayController", urlPatterns = "/users")
public class DisplayController extends HttpServlet {
    private List<User> users;
    public DisplayController() {
        super();
        users = new ArrayList<>();
    }
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String country = request.getParameter("country");
        users = DAO.getWithCountry(country);
        response.sendRedirect("/users");
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setAttribute("users", DAO.getUsers());
        request.setAttribute("filteredbycountry", users);
        request.getRequestDispatcher("users.jsp").forward(request,response);
    }
}

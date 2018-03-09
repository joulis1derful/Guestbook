package controller;

import model.User;
import persistence.DAO;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@WebServlet(name = "JoinUsersByVisitTimeController", urlPatterns = "/join")
public class JoinUsersByVisitTimeController extends HttpServlet {
    private List<User> users;
    public JoinUsersByVisitTimeController() {
        super();
        users = new ArrayList<>();
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String date = request.getParameter("date");
        users = DAO.getUsersWithVisitTime(date);
        request.setAttribute("users", users);
        for(User user : users) {
            System.out.println(user.getLname());
        }
        request.getRequestDispatcher("users.jsp").forward(request,response);
    }
}

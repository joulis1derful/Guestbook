package controller;

import model.Visitor;
import persistence.VisitorDAOImpl;
import service.VisitorService;
import service.VisitorServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "RegisterController", urlPatterns = "/register")
public class RegisterController extends HttpServlet {
    private VisitorService visitorService;
    public RegisterController() {
        super();
        visitorService = new VisitorServiceImpl();
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String fname = request.getParameter("fname");
        String lname = request.getParameter("lname");
        String email = request.getParameter("email");
        String dob = request.getParameter("dob");
        String tel = request.getParameter("tel");
        String country = request.getParameter("country");
        String city = request.getParameter("city");
        Visitor visitor = new Visitor(fname, lname, email, dob, tel, country, city);
        visitorService.insertVisitor(visitor);
        response.sendRedirect("/users");
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.getRequestDispatcher("register.jsp").forward(request, response);
    }
}

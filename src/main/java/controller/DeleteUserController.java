package controller;

import persistence.VisitorDAOImpl;
import service.VisitorService;
import service.VisitorServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "DeleteUserController", urlPatterns = "/visitors/delete")
public class DeleteUserController extends HttpServlet {
    private VisitorService visitorService;
    public DeleteUserController() {
        super();
        visitorService = new VisitorServiceImpl();
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String lname = request.getParameter("lname");
        visitorService.removeVisitor(lname);
        response.sendRedirect("/visitors");
    }
}

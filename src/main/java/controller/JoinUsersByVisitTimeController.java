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
import java.util.ArrayList;
import java.util.List;

@WebServlet(name = "JoinUsersByVisitTimeController", urlPatterns = "/join")
public class JoinUsersByVisitTimeController extends HttpServlet {
    private List<Visitor> visitors;
    private VisitorService visitorService;
    public JoinUsersByVisitTimeController() {
        super();
        visitorService = new VisitorServiceImpl();
        visitors = new ArrayList<>();
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//        String date = request.getParameter("date");
//        visitors = visitorService.findVisitor(date);
//        request.setAttribute("visitors", visitors);
//        for(Visitor visitor : visitors) {
//            System.out.println(visitor.getLname());
//        }
//        request.getRequestDispatcher("visitors.jsp").forward(request,response);
    }
}

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

@WebServlet(name = "DisplayController", urlPatterns = "/visitors")
public class DisplayController extends HttpServlet {
    private List<Visitor> visitors;
    private VisitorService visitorService;
    public DisplayController() {
        super();
        visitorService = new VisitorServiceImpl();
        visitors = new ArrayList<>();
    }
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String country = request.getParameter("country");
        visitors = visitorService.findVisitorsWithCountry(country);
        request.setAttribute("visitors", visitors);
        request.getRequestDispatcher("visitors.jsp").forward(request,response);
//        response.sendRedirect("/visitors");
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setAttribute("visitors", visitorService.findAllVisitors());
//        request.setAttribute("filteredbycountry", visitors);
        request.getRequestDispatcher("visitors.jsp").forward(request,response);
    }
}

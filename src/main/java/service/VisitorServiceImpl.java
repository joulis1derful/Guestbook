package service;

import model.Visitor;
import persistence.VisitorDAO;
import persistence.VisitorDAOImpl;

import java.util.List;

public class VisitorServiceImpl implements VisitorService {
    private VisitorDAO visitorDAO;

    public VisitorServiceImpl() {
        visitorDAO = new VisitorDAOImpl();
    }

    @Override
    public Visitor insertVisitor(Visitor visitor) {
        return visitorDAO.insertVisitor(visitor);
    }

    @Override
    public Visitor findVisitor(int id) {
        return visitorDAO.findVisitor(id);
    }

    @Override
    public List<Visitor> findAllVisitors() {
        return visitorDAO.findAllVisitors();
    }

    @Override
    public void removeVisitor(String lname) {
        visitorDAO.removeVisitor(lname);
    }

    @Override
    public List<Visitor> findVisitorsWithCountry(String country_name) {
        return visitorDAO.findVisitorsWithCountry(country_name);
    }

//    @Override
//    public List<Visitor> findVisitorsWithVisitTime(String time) {
//        return visitorDAO.findVisitorsWithVisitTime(time);
//    }
}

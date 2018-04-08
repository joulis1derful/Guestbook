package persistence;

import model.Visitor;

import java.util.List;

public interface VisitorDAO {
    public void insertVisitor(Visitor visitor);

    public Visitor findVisitor(int id);

    public List<Visitor> findAllVisitors();

    public void removeVisitor(String lname);

    public List<Visitor> findVisitorsWithCountry(String country_name);

//    public List<Visitor> findVisitorsWithVisitTime(String time);
}

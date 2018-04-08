package persistence;

import model.Visitor;

import java.util.List;
import java.util.Set;

public interface VisitorDAO {
    public void insertVisitor(Visitor visitor);

    public Visitor findVisitor(int id);

    public List<Visitor> findAllVisitors();

    public void removeVisitor(String lname);

    public List<Visitor> findVisitorsWithCountry(String country_name);

    public Set<String> getCountries();

//    public List<Visitor> findVisitorsWithVisitTime(String time);
}

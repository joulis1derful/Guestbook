package persistence;

import model.Guestbook;
import model.Visitor;
import util.EntityManagerUtility;

import javax.persistence.EntityManager;
import javax.persistence.RollbackException;
import javax.persistence.TypedQuery;
import javax.transaction.Transactional;
import java.util.*;

@Transactional
public class VisitorDAOImpl implements VisitorDAO {
    private EntityManager entityManager;

    @Override
    public void insertVisitor(Visitor visitor) {
        entityManager = EntityManagerUtility.getEntityManagerFactory().createEntityManager();
        try {
            entityManager.getTransaction().begin();
            entityManager.persist(visitor);
            entityManager.getTransaction().commit();
        } catch(RollbackException e) {
            e.printStackTrace();
        } finally {
            entityManager.close();
        }
    }

    @Override
    public Visitor findVisitor(int id) {
        entityManager = EntityManagerUtility.getEntityManagerFactory().createEntityManager();
        Visitor visitor = null;
        try {
            visitor = entityManager.find(Visitor.class, id);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            entityManager.close();
        }
        return visitor;
    }

    @Override
    public List<Visitor> findAllVisitors() {
        entityManager = EntityManagerUtility.getEntityManagerFactory().createEntityManager();
        List<Visitor> visitors = new ArrayList<>();
        try {
            TypedQuery<Visitor> query = entityManager.createQuery("SELECT v from Visitor v", Visitor.class);
            visitors = query.getResultList();
        } catch(Exception e) {
            e.printStackTrace();
        } finally {
            entityManager.close();
        }
        return visitors;
    }

    @Override
    public void removeVisitor(String lname) {
        entityManager = EntityManagerUtility.getEntityManagerFactory().createEntityManager();
        try {
            TypedQuery<Visitor> query = entityManager.createQuery("SELECT v from Visitor v where lname=?1", Visitor.class);
            query.setParameter(1, lname);
            Visitor visitor = findVisitor(query.getResultList().get(0).getId());
            if(visitor != null) {
                entityManager.getTransaction().begin();
                entityManager.remove(visitor);
                entityManager.getTransaction().commit();
            }
        } catch(Exception e) {
            e.printStackTrace();
        } finally {
            entityManager.close();
        }
    }

    @Override
    public List<Visitor> findVisitorsWithCountry(String country_name) {
        entityManager = EntityManagerUtility.getEntityManagerFactory().createEntityManager();
        List<Visitor> visitors = new ArrayList<>();
        try {
            if(country_name.equals("All")) {
                TypedQuery<Visitor> query = entityManager.createQuery("SELECT v FROM Visitor v", Visitor.class);
                visitors = query.getResultList();
            } else {
                TypedQuery<Visitor> query = entityManager.createQuery("SELECT v FROM Visitor v WHERE v.country = ?1", Visitor.class);
                query.setParameter(1, country_name);
                visitors = query.getResultList();
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            entityManager.close();
        }
        return visitors;
    }

    @Override
    public Set<String> getCountries() {
        entityManager = EntityManagerUtility.getEntityManagerFactory().createEntityManager();
        List<Visitor> visitors = new ArrayList<>();
        Set<String> countries = new HashSet<>();
        countries.add("All");
        try {
            TypedQuery<Visitor> query = entityManager.createQuery("SELECT v FROM Visitor v", Visitor.class);
            visitors = query.getResultList();
            visitors.forEach(item -> { countries.add(item.getCountry()); });
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            entityManager.close();
        }
        return countries;
    }

//    @Override
//    public List<Visitor> findVisitorsWithVisitTime(String time) {
//        TypedQuery<Visitor> query = entityManager.createQuery("SELECT v FROM Visitor v JOIN Guestbook g ON v.id = g.visitor_id WHERE CAST(?1 as DATE) <= ?1", Visitor.class);
//        query.setParameter(1, time);
//        return query.getResultList();
//    }
}

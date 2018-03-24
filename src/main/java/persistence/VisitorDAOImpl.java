package persistence;

import model.Guestbook;
import model.Visitor;
import util.EntityManagerUtility;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.TypedQuery;
import java.util.List;

public class VisitorDAOImpl implements VisitorDAO {
    private EntityManager entityManager;

    public VisitorDAOImpl() {
        EntityManagerFactory entityManagerFactory = EntityManagerUtility.getEntityManagerFactory();
        this.entityManager = entityManagerFactory.createEntityManager();
    }

    @Override
    public Visitor insertVisitor(Visitor visitor) {
        entityManager.getTransaction().begin();
        entityManager.persist(visitor);
        entityManager.getTransaction().commit();
        return visitor;
    }

    @Override
    public Visitor findVisitor(int id) {
        return entityManager.find(Visitor.class, id);
    }

    @Override
    public List<Visitor> findAllVisitors() {
        TypedQuery<Visitor> query = entityManager.createQuery("SELECT v from Visitor v", Visitor.class);
        return query.getResultList();
    }

    @Override
    public void removeVisitor(String lname) {
        TypedQuery<Visitor> query = entityManager.createQuery("SELECT id from Visitor v where lname=?1", Visitor.class);
        query.setParameter(1, lname);
        Visitor visitor = query.getResultList().get(0);
        if(visitor != null) {
            entityManager.getTransaction().begin();
            entityManager.remove(visitor);
            entityManager.getTransaction().commit();
        }
    }

    @Override
    public List<Visitor> findVisitorsWithCountry(String country_name) {
        TypedQuery<Visitor> query = entityManager.createQuery("SELECT v FROM Visitor v WHERE v.country = ?1", Visitor.class);
        query.setParameter(1, country_name);
        return query.getResultList();
    }

//    @Override
//    public List<Visitor> findVisitorsWithVisitTime(String time) {
//        TypedQuery<Visitor> query = entityManager.createQuery("SELECT v FROM Visitor v JOIN Guestbook g ON v.id = g.visitor_id WHERE CAST(?1 as DATE) <= ?1", Visitor.class);
//        query.setParameter(1, time);
//        return query.getResultList();
//    }
}

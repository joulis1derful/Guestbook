package util;

import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class EntityManagerUtility {
    private static EntityManagerFactory entityManagerFactory = Persistence
            .createEntityManagerFactory("GuestbookUnit");

    public static EntityManagerFactory getEntityManagerFactory() {
        return entityManagerFactory;
    }
}

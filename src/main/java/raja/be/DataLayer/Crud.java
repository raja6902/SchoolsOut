package raja.be.DataLayer;

import raja.be.ModelLayer.User;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class Crud {
    EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("datasource");

    public void createUser(User user) {
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        entityManager.getTransaction().begin();
        entityManager.persist(user);
        entityManager.getTransaction().commit();
        entityManager.close();
        entityManagerFactory.close();


    }

    public void deleteUser(String Login) {
        EntityManager entityManager = entityManagerFactory.createEntityManager();

        User user = entityManager.find(User.class, Login);
        if (user != null) {
            entityManager.getTransaction().begin();
            entityManager.remove(user);
            entityManager.getTransaction().commit();
        }
    }

    public void update(User user) {
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        entityManager.getTransaction().begin();
        entityManager.merge(user);
        entityManager.getTransaction().commit();
    }
    public void retrieveUser(String Login) {
        EntityManager entityManager = entityManagerFactory.createEntityManager();

        User user = entityManager.find(User.class, Login);
        if (user != null) {
            System.out.println(user.toString());
            entityManager.close();
            entityManagerFactory.close();
        }
    }
}

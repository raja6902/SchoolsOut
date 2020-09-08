package raja.be.Repository;

import raja.be.Model.User;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import java.util.List;

public class UserData {
    EmWorker emWorker = new EmWorker();
    EntityManager em = emWorker.createem();


    public void createUser(User user) {

        em.getTransaction().begin();
        em.persist(user);
        em.getTransaction().commit();
        em.close();
        emWorker.getEmf().close();



    }

    public void deleteUser(String Login) {

        User user = em.find(User.class, Login);
        if (user != null) {
            em.getTransaction().begin();
            em.remove(user);
            em.getTransaction().commit();
            System.out.println("Removed User"+  " " + Login );
            em.close();
            emWorker.getEmf().close();

        }
    }

    public void update(String Login, String password) {
        User user = em.find(User.class, Login);

        em.getTransaction().begin();
        user.setPasswordhash(password);
        em.merge(user);
        em.getTransaction().commit();
        em.close();
        emWorker.getEmf().close();

    }

    public void retrieveUser(String Login) {
        User user = em.find(User.class, Login);
        if (user != null) {
            System.out.println(user.toString());
            em.close();
            emWorker.getEmf().close();

        }
    }

    public List<User> findAllUser() {
        TypedQuery<User> query = em.createQuery("SELECT u FROM User u", User.class);
        return query.getResultList();



    }

}

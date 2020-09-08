package raja.be.Repository;

import raja.be.Model.Gender;
import raja.be.Model.Person;
import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import java.util.List;

public class PersonData {
    EmWorker emf = new EmWorker();
    EntityManager em = emf.createem();

    public void deletePerson(Integer id) {

        Person person = em.find(Person.class, id);
        if (person != null) {
            em.getTransaction().begin();
            em.remove(person);
            em.getTransaction().commit();
            System.out.println(person + "  this person's details been removed");
            em.close();

        }

    }

    public void updatePerson(Integer id, String firstName, String lastName, Gender gender) {
        Person person = em.find(Person.class, id);

        em.getTransaction().begin();
        person.setFirstName(firstName);
        person.setLastName(lastName);
        person.setGender(gender);
        em.merge(person);
        em.getTransaction().commit();
        em.close();


    }

    public void retrievePerson(Integer id) {
        Person person = em.find(Person.class, id);
        if (person != null) {
            System.out.println(person.toString());
            em.close();

        }
    }

    public List<Person> findAllPerson() {
        TypedQuery<Person> query = em.createQuery("SELECT p FROM Person p", Person.class);
        return query.getResultList();


    }
}
package raja.be.Repository;

import raja.be.Model.Course;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import java.util.List;

public class CourseData {
    EmWorker emw = new EmWorker();
    EntityManager em = emw.createem();


    public void deleteCourse(long id) {

        Course course = em.find(Course.class, id);
        if (course != null) {
            em.getTransaction().begin();
            em.remove(course);
            em.getTransaction().commit();
            System.out.println(course + "  this course details been removed");
            em.close();
            emw.getEmf().close();
        }

    }

    public void updateCourse(long id, String name, String description, String code, boolean active) {
        Course course = em.find(Course.class, id);

        em.getTransaction().begin();
        course.setName(name);
        course.setDescription(description);
        course.setCode(code);
        course.setActive(active);
        em.merge(course);
        em.getTransaction().commit();
        em.close();
        emw.getEmf().close();

    }

    public void retrieveCourse(long id) {
        Course course = em.find(Course.class, id);
        if (course != null) {
            System.out.println(course.toString());
            em.close();
            emw.getEmf().close();

        }
    }

    public List<Course> findAllCourses() {
        TypedQuery<Course> query = em.createQuery("SELECT c FROM Course c", Course.class);
        return query.getResultList();


    }
}


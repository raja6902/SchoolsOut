package raja.be.Repository;

import raja.be.Model.Grade;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import java.math.BigDecimal;
import java.util.List;

public class GradeData {
    EmWorker emWorker = new EmWorker();
    EntityManager em = emWorker.createem();


    public void createGrade(Grade grade) {

        em.getTransaction().begin();
        em.persist(grade);
        em.getTransaction().commit();
        em.close();


    }

    public void deleteGrade(Long id) {

        Grade grade = em.find(Grade.class, id);
        if (grade != null) {
            em.getTransaction().begin();
            em.remove(grade);
            em.getTransaction().commit();
            System.out.println("Removed Entry" + " " + id);
            em.close();
            emWorker.getEmf().close();

        }
    }

    public void update(Long id, BigDecimal gradeValue, String comment, String internalComment, boolean absent, boolean postponed) {
        Grade grade = em.find(Grade.class, id);

        em.getTransaction().begin();
        grade.setGradeValue(gradeValue);
        grade.setComment(comment);
        grade.setInternalComment(internalComment);
        grade.setAbsent(absent);
        grade.setPostponed(postponed);
        em.merge(grade);
        em.getTransaction().commit();
        em.close();
        emWorker.getEmf().close();

    }

    public void retrieveGrade(Long id) {
        Grade grade = em.find(Grade.class, id);
        if (grade != null) {
            System.out.println(grade.toString());
            em.close();
            emWorker.getEmf().close();

        }
    }


    public List<Grade>  gradebyExamid(Long id){
        TypedQuery<Grade> query = em.createQuery("SELECT g FROM Grade g WHERE g.exam.id = ? 1", Grade.class)
                .setParameter(1,id);
               return  query.getResultList();
    }

    public List<Grade> findAllGrade() {
        TypedQuery<Grade> query = em.createQuery("SELECT g FROM Grade u", Grade.class);
        return query.getResultList();


    }

}



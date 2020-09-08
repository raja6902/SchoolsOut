package raja.be.Repository;

import raja.be.Model.Exam;
import raja.be.Model.Grade;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import java.time.LocalDate;
import java.util.Arrays;
import java.util.List;

public class ExamData {
     EmWorker emw = new EmWorker();
     EntityManager em = emw.createem();

    public void createExam(Exam exam) {

        em.getTransaction().begin();
        em.persist(exam);
        em.getTransaction().commit();
        em.close();
        emw.getEmf().close();
    }

    public void deleteExam(long id) {

        Exam exam = em.find(Exam.class, id);
        if (exam != null) {
            em.getTransaction().begin();
            em.remove(exam);
            em.getTransaction().commit();
            System.out.println(exam + "  this exam's details been removed");
            em.close();
            emw.getEmf().close();
        }

    }

    public void updateExam(long id, String name, String description, LocalDate date, int weight, int total) {
        Exam exam = em.find(Exam.class, id);

        em.getTransaction().begin();
        exam.setName(name);
        exam.setDescription(description);
        exam.setDate(date);
        exam.setWeight(weight);
        exam.setTotal(total);
        em.merge(exam);
        em.getTransaction().commit();
        em.close();
        emw.getEmf().close();

    }

    public Exam retrieveExam(long id) {
        Exam exam = em.find(Exam.class, id);
        if (exam != null) {
            System.out.println(exam.toString());
            em.close();
            emw.getEmf().close();
        }
        return exam;
    }

    public void addSubExam(Exam  exam, Exam subExam){
        em.getTransaction().begin();
        subExam.setExamGroup(exam);
        exam.setSubExams(Arrays.asList(subExam));
        if(exam.getId()==null) {
            em.persist(exam);
            em.persist(subExam);
        }else{
            em.merge(exam);
            em.merge(subExam);
        }
        em.getTransaction().commit();
        }
    public List<Exam>  getSubExamByid(Long id){
        TypedQuery<Exam> query = em.createQuery("SELECT e FROM Exam e WHERE e.examGroup.id = ? 1", Exam.class)
                .setParameter(1,id);
        return  query.getResultList();
    }


    public List<Exam> findAllExam() {
        TypedQuery<Exam> query = em.createQuery("SELECT e FROM Exam e", Exam.class);
        return query.getResultList();


    }
}


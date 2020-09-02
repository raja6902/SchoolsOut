package raja.be;

import raja.be.DataLayer.Crud;
import raja.be.ModelLayer.*;
import raja.be.ModelLayer.Module;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        User raj = new User();
        Crud crud = new Crud();
        Course crs = new Course();
        Module mod = new  Module();
        Exam ex = new Exam();
        List<Exam> exam = new ArrayList<>();
        List<Module> mode = new ArrayList<>();
        ex.setDate(LocalDate.of(2020,06,15));
        ex.setDescription("Fundamental");
        ex.setModule(mod);
        ex.setName("one");
        ex.setTotal(70);
        ex.setWeight(50);
        exam.add(ex);
        mod.setDescription("");
        mod.setCourse(crs);
        mod.setName("Fundamental");
        mode.add(mod);
        crs.setActive(true);
        crs.setCode("blue");
        crs.setDescription("");
        crs.setImageURL("www.123");
        crs.setName("JavaEE");
        crs.setModules(mode);
        Person pers = new Person();
        pers.setFirstName("Raja");
        pers.setLastName("Khan");
        pers.setGender(Gender.Male);
        pers.setCourse(crs);



      raj.setLogin("number1");
      raj.setPasswordhash("112");
      raj.setActive(true);
      raj.setPerson(pers);
        EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("datasource");

        EntityManager entityManager = entityManagerFactory.createEntityManager();
        entityManager.getTransaction().begin();
        entityManager.persist(raj);
        entityManager.getTransaction().commit();
        System.out.println("data is committed");





    }
}
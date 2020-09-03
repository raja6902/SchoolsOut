package raja.be;

import raja.be.ModelLayer.*;
import raja.be.ModelLayer.Module;
import raja.be.Repository.PersonData;
import raja.be.Repository.UserData;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
//        User user = new User();
//        UserData usd = new UserData();
//        Course crs = new Course();
//        Module mod = new Module();
//        Exam ex = new Exam();
//        List<Exam> exam = new ArrayList<>();
//        List<Module> mode = new ArrayList<>();
//        ex.setDate(LocalDate.of(2020,9,11));
//        ex.setDescription("End Project");
//        ex.setModule(mod);
//        ex.setName("3rd");
//        ex.setTotal(99);
//        ex.setWeight(50);
//        exam.add(ex);
//        mod.setDescription("");
//        mod.setCourse(crs);
//        mod.setName("Fundamental");
//        mod.setExams(exam);
//        mode.add(mod);
//        crs.setActive(true);
//        crs.setCode("blue");
//        crs.setDescription("");
//        crs.setImageURL("www.125");
//        crs.setName("JavaEE");
//        crs.setModules(mode);
//        Person pers = new Person();
//        pers.setFirstName("Pearl");
//        pers.setLastName("DS");
//        pers.setGender(Gender.Female);
//        pers.setCourse(crs);
//
//
//
//     user.setLogin("number7");
//      user.setPasswordhash("117");
//      user.setActive(true);
//      user.setPerson(pers);
//      usd.createUser(user);
//
//

//    crs.getModules();
//    List<Module> modules = crs.getModules();
//    modules.forEach(System.out::println);
//    crs.getPeople();
//    List<Person> pers = crs.getPeople();
//    pers.forEach(System.out::println);
     // UserData usd = new UserData();
//       List<User> user = usd.findAllUser();
//       user.forEach(System.out::println);

       PersonData psd = new PersonData();
      List<Person> person = psd.findAllPerson();
      person.forEach(System.out::println);



     //   Course crs = em.find(Course.class, 5L);
     //   List<Person> pers = crs.getPeople();
    //   pers.forEach(System.out::println);


    }
}
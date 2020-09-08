package raja.be.Service;

import raja.be.Model.Exam;
import raja.be.Model.Grade;
import raja.be.Repository.EmWorker;
import raja.be.Repository.ExamData;
import raja.be.Repository.GradeData;


import java.util.List;

  public class ExamService {
      GradeData gradedata = new GradeData();
      ExamData ex = new ExamData();
      Grade gr = new Grade();

      public void outputExam(Long id) {
          List<Exam> list = ex.retrieveExam(id).getSubExams();
          list.forEach(System.out::println);
          List<Grade> grade = gradedata.gradebyExamid(id);
          grade.forEach(System.out::println);


      }


  }




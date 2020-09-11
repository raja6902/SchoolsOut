package raja.be.Service;

import raja.be.Model.Exam;
import raja.be.Model.Grade;
import raja.be.Repository.ExamData;
import raja.be.Repository.GradeData;
import java.util.List;

public class ExamService {
      GradeData gradedata = new GradeData();
      ExamData exs = new ExamData();

    public void outputExam(Long id) {
        //If the Exam has no SubExam than the Exam will be displayed with Grades(if available).
        if (exs.getSubExamById(id).isEmpty()) {
            exs.retrieveExam(id);
            List<Grade> grade = gradedata.gradeByExamId(id);
            grade.forEach(System.out::println);

        } else {
            // if Exam has SubExam than no Grade displayed for Parent Exam.
            //Only the Parent Exam will be displayed without Grades.
            // Sub Exam will be displayed with their Grades.
            List<Exam> list = exs.retrieveExam(id).getSubExams();


            for (Exam exam : list)
                gradedata.gradeByExamId(exam.getId()).forEach(System.out::println);


        }


    }


}










package raja.be.ModelLayer;

import javax.persistence.*;
import java.util.List;
@Entity
public class Module {

 @Id
 @GeneratedValue
private  Long id;
private String name;
@Lob
private String description;
@ManyToOne
private Course course;
@OneToMany(mappedBy = "module", cascade = CascadeType.PERSIST)
private List<Exam> exams;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Course getCourse() {
        return course;
    }

    public void setCourse(Course course) {
        this.course = course;
    }

    public List<Exam> getExams() {
        return exams;
    }

    public void setExams(List<Exam> exams) {
        this.exams = exams;
    }

    @Override
    public String toString() {
        return "Module{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", description='" + description + '\'' +
                ", exams=" + exams +
                '}';
    }
}

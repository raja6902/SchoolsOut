package raja.be.Model;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Entity
public class Exam<subExams> {
    @Id
    @GeneratedValue
    private Long id;
    private String name;
    @Lob
    private String Description;
    private LocalDate Date;
    private int weight;
    private int total;
    @ManyToOne(targetEntity = Module.class,cascade = {CascadeType.MERGE,CascadeType.PERSIST,CascadeType.REMOVE})
    private Module module;
    @ManyToOne(cascade = {CascadeType.MERGE,CascadeType.PERSIST})
    private Exam examGroup;
    @OneToMany(mappedBy = "examGroup", fetch = FetchType.EAGER, cascade = {CascadeType.MERGE,CascadeType.PERSIST})
    private List<Exam> subExams = new ArrayList<>();


    public List<Exam> getSubExams() {
        return subExams;
    }

    public void setSubExams(List<Exam> subExams) {
        this.subExams = subExams;
    }


    public Exam getExamGroup() {
        return examGroup;
    }

    public void setExamGroup(Exam examGroup) {
        this.examGroup = examGroup;
    }



    public Long getId() {
        return id;
    }

    public Exam setId(Long id) {
        this.id = id;
        return null;
    }

    public String getName() {
        return name;
    }

    public Exam setName(String name) {
        this.name = name;
        return this;
    }

    public String getDescription() {
        return Description;
    }

    public void setDescription(String description) {
        Description = description;
    }

    public LocalDate getDate() {
        return Date;
    }

    public Exam setDate(LocalDate date) {
        Date = date;
        return this;
    }

    public int getWeight() {
        return weight;
    }

    public void setWeight(int weight) {
        this.weight = weight;
    }

    public int getTotal() {
        return total;
    }

    public void setTotal(int total) {
        this.total = total;
    }

    public Module getModule() {
        return module;
    }

    public void setModule(Module module) {
        this.module = module;
    }

    @Override
    public String toString() {
        return "Exam{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", Description='" + Description + '\'' +
                ", Date=" + Date +
                ", weight=" + weight +
                ", total=" + total +
                '}';
    }
}

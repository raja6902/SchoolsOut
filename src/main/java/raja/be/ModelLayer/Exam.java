package raja.be.ModelLayer;

import javax.persistence.*;
import java.time.LocalDate;
@Entity
public class Exam {
    @Id
    @GeneratedValue
    private Long id;
    private String name;
    @Lob
    private String Description;
    private LocalDate Date;
    private int weight;
    private int total;
    @ManyToOne
    private Module module;

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
        return Description;
    }

    public void setDescription(String description) {
        Description = description;
    }

    public LocalDate getDate() {
        return Date;
    }

    public void setDate(LocalDate date) {
        Date = date;
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

package levi9petclinic.model;

import java.time.LocalDate;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "visits")
public class Visit extends BaseEntity {

    @Column(name = "visit_time")
    private LocalDate visitTime;
    @Column(name = "description")
    private String description;

    @ManyToOne
    @JoinColumn(name = "pet_id")
    private Pet pet;

    public LocalDate getVisitTime() {
        return visitTime;
    }

    public void setVisitTime(LocalDate visitTime) {
        this.visitTime = visitTime;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Pet getPet() {
        return pet;
    }

    public void setPet(Pet pet) {
        this.pet = pet;
    }
}

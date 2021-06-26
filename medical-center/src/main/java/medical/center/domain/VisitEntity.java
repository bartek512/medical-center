package medical.center.domain;


import medical.center.domain.enums.VisitStatus;

import javax.persistence.*;
import java.time.LocalDateTime;

@NamedQueries({
        @NamedQuery(name = "Visit.GetSumCostOfVisit",
                query = "SELECT SUM(v.price) FROM VisitEntity v WHERE" +
                        "(:startDate IS NULL OR v.startTime >= :startDate) AND (:endDate IS NULL OR v.startTime <= :endDate) AND v.patient.id = :id"),
}
)

@Entity
@Table(name = "visit")
public class VisitEntity extends AbstractEntity {

    @Column(name = "visit_status")
    @Enumerated(EnumType.STRING)
    private VisitStatus visitStatus;

    @Column(name = "start_time")
    LocalDateTime startTime;

    @Column(name = "price")
    private Double price;

    @ManyToOne
    private DoctorEntity doctor;

    @ManyToOne
    private PatientEntity patient;

    public VisitEntity() {
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public VisitStatus getVisitStatus() {
        return visitStatus;
    }

    public void setVisitStatus(VisitStatus visitStatus) {
        this.visitStatus = visitStatus;
    }

    public LocalDateTime getStartTime() {
        return startTime;
    }

    public void setStartTime(LocalDateTime time) {
        this.startTime = time;
    }

    public DoctorEntity getDoctor() {
        return doctor;
    }

    public void setDoctor(DoctorEntity doctor) {
        this.doctor = doctor;
    }

    public PatientEntity getPatient() {
        return patient;
    }

    public void setPatient(PatientEntity patient) {
        this.patient = patient;
    }
}

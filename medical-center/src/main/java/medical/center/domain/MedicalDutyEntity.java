package medical.center.domain;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
@Table(name = "medical_duty")
public class MedicalDutyEntity extends AbstractEntity {

    @Column
    private LocalDate date;

    @ManyToOne
    private MedicalCenterEntity medicalCenter;

    @ManyToOne
    private DoctorEntity doctorEntity;

    public MedicalDutyEntity() {
    }

    public LocalDate getDate() {
        return date;
    }

    public MedicalCenterEntity getMedicalCenter() {
        return medicalCenter;
    }

    public void setMedicalCenter(MedicalCenterEntity medicalCenter) {
        this.medicalCenter = medicalCenter;
    }

    public DoctorEntity getDoctorEntity() {
        return doctorEntity;
    }

    public void setDoctorEntity(DoctorEntity doctorEntity) {
        this.doctorEntity = doctorEntity;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }
}

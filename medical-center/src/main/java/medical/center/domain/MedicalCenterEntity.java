package medical.center.domain;


import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name = "medical_center")
public class MedicalCenterEntity extends AbstractEntity {


    @Column(name = "name")
    private String name;

    @Embedded
    private Address address;

    @OneToMany(mappedBy = "medicalCenter", cascade = CascadeType.REMOVE)
    private Set<PatientEntity> patients;

    @ManyToMany
    @JoinTable(name = "doctor_to_medical_center",
            joinColumns = @JoinColumn(name = "medical_center_id"),
            inverseJoinColumns = @JoinColumn(name = "doctor_id"))
    private Set<DoctorEntity> doctors;

    @OneToMany(mappedBy = "medicalCenter",cascade = CascadeType.REMOVE)
    @Column(name = "medical_duty")
    private Set<MedicalDutyEntity> medicalDuty;

    public MedicalCenterEntity() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }

    public Set<PatientEntity> getPatients() {
        return patients;
    }

    public void setPatients(Set<PatientEntity> patients) {
        this.patients = patients;
    }

    public Set<DoctorEntity> getDoctors() {
        return doctors;
    }

    public void setDoctors(Set<DoctorEntity> doctors) {
        this.doctors = doctors;
    }

    public Set<MedicalDutyEntity> getMedicalDuty() {
        return medicalDuty;
    }

    public void setMedicalDuty(Set<MedicalDutyEntity> medicalDuty) {
        this.medicalDuty = medicalDuty;
    }
}

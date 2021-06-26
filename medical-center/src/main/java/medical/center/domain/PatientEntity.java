package medical.center.domain;


import medical.center.domain.enums.Sex;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.Set;

@NamedQueries({

        @NamedQuery(name = "Patient.GetPatientsWithMaxCancelledVisits",

                query = " SELECT p FROM PatientEntity p WHERE NOT EXISTS (SELECT pp FROM PatientEntity pp JOIN pp.visit vv  WHERE " +
                        " vv.visitStatus = 'CANCELLED_PATIENT' AND (:startDate IS NULL OR vv.startTime >= :startDate) " +
                        " AND (:endDate IS NULL OR vv.startTime <= :endDate) GROUP BY pp" +
                        " HAVING COUNT(vv) > " +
                        " (SELECT COUNT(vvv) FROM PatientEntity ppp JOIN ppp.visit vvv WHERE vvv.visitStatus = 'CANCELLED_PATIENT' AND" +
                        " (:startDate IS NULL OR vvv.startTime >= :startDate) AND (:endDate IS NULL OR vvv.startTime <= :endDate) AND ppp.id = p.id ))"
        )
}
)

@Entity
@Table(name = "patient")
public class PatientEntity extends AbstractEntity {

    @Column(name = "sex")
    @Enumerated(EnumType.STRING)
    private Sex sex;

    @Column(name = "date_of_birth")
    private LocalDate dateOfBirth;

    @ManyToOne
    private MedicalCenterEntity medicalCenter;


    @OneToMany(mappedBy = "patient", cascade = CascadeType.REMOVE, fetch = FetchType.EAGER)
    private Set<VisitEntity> visit;


    @Column(nullable = false)
    private String firstName;

    @Column(nullable = false)
    private String lastName;

    @Column(nullable = false)
    private String telephoneNumber;

    @Column(nullable = false)
    private String email;

    @Column(name = "address")
    private Address address;


    public PatientEntity() {
    }


    public String getFirstName() {
        return firstName;
    }


    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }


    public String getLastName() {
        return lastName;
    }


    public void setLastName(String lastName) {
        this.lastName = lastName;
    }


    public String getTelephoneNumber() {
        return telephoneNumber;
    }

    public void setTelephoneNumber(String telephoneNumber) {
        this.telephoneNumber = telephoneNumber;
    }


    public String getEmail() {
        return email;
    }


    public void setEmail(String email) {
        this.email = email;
    }


    public Address getAddress() {
        return address;
    }


    public void setAddress(Address address) {
        this.address = address;
    }

    public Sex getSex() {
        return sex;
    }

    public void setSex(Sex sex) {
        this.sex = sex;
    }

    public LocalDate getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(LocalDate dateOfBrth) {
        this.dateOfBirth = dateOfBrth;
    }

    public MedicalCenterEntity getMedicalCenter() {
        return medicalCenter;
    }

    public void setMedicalCenter(MedicalCenterEntity medicalCenter) {
        this.medicalCenter = medicalCenter;
    }

    public Set<VisitEntity> getVisit() {
        return visit;
    }

    public void setVisit(Set<VisitEntity> visit) {
        this.visit = visit;
    }
}

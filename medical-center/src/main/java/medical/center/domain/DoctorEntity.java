package medical.center.domain;


import javax.persistence.*;
import java.util.Set;


@NamedQueries({
        @NamedQuery(name = "Doctor.GetDoctorWithLowestCountOfVisits",
                query = "SELECT d FROM DoctorEntity d JOIN d.visits v  GROUP BY d.id " +
                        "HAVING (SELECT COUNT(v) FROM VisitEntity v WHERE v.doctor = d AND (:startDate IS NULL OR v.startTime >= :startDate) AND (:endDate IS NULL OR v.startTime <= :endDate)) =  " +
                        "(SELECT MIN(SIZE(dd.visits)) FROM DoctorEntity dd JOIN dd.visits v) "
        ),

        @NamedQuery(name = "Doctor.GetDoctorsAssignedToOneMedicalCenter",
                query = "SELECT d FROM DoctorEntity d JOIN d.medicalCenters m WHERE m.id = :id AND d.medicalCenters.size = 1  " //+
        ),

        @NamedQuery(name = "Doctor.WithMostCancelledVisits",

                query = " SELECT d FROM DoctorEntity d  WHERE  NOT EXISTS (SELECT dd FROM DoctorEntity dd JOIN dd.visits vv  WHERE " +
                        " (vv.visitStatus = 'CANCELLED'  OR vv.visitStatus = 'CANCELLED_PATIENT') GROUP BY dd" +
                        " HAVING COUNT(vv) > " +
                        " (SELECT COUNT(ddd) FROM DoctorEntity ddd JOIN ddd.visits vvv WHERE (vvv.visitStatus = 'CANCELLED' OR vvv.visitStatus = 'CANCELLED_PATIENT') AND ddd.id = d.id))  "
        ),

        @NamedQuery(name = "Doctor.GetCountOfVisitsTwoMostVisitedDoctors",
                query = " SELECT COUNT(d) AS cou  FROM DoctorEntity d JOIN d.visits v WHERE v.doctor = d GROUP BY d ORDER BY cou DESC"
        ),

        @NamedQuery(name = "Doctor.GetTwoMostVisitedDoctors",
                query = " SELECT d FROM DoctorEntity d JOIN d.visits v WHERE v.doctor = d AND SIZE(d.visits) IN :counts GROUP BY d"
        )

}
)

@Entity
@Table(name = "doctor")
public class DoctorEntity extends AbstractEntity {

    @Column(name = "payment_per_hour")
    private Double paymentPerHour;


    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(name = "doctor_to_specialization",
            joinColumns = @JoinColumn(name = "doctor_id"),
            inverseJoinColumns = @JoinColumn(name = "specialization_id"))
    private Set<SpecializationEntity> specializations;


    @OneToMany(mappedBy = "doctor", cascade = CascadeType.REMOVE, fetch = FetchType.EAGER)
    private Set<VisitEntity> visits;

    @OneToMany(mappedBy = "doctorEntity", cascade = CascadeType.REMOVE, fetch = FetchType.EAGER)
    @Column(name = "doctor_id")
    private Set<MedicalDutyEntity> medicalDuty;


    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(name = "doctor_to_medical_center",
            joinColumns = @JoinColumn(name = "doctor_id"),
            inverseJoinColumns = @JoinColumn(name = "medical_center_id"))
    private Set<MedicalCenterEntity> medicalCenters;

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


    public DoctorEntity() {
    }

    public Set<VisitEntity> getVisits() {
        return visits;
    }

    public void setVisits(Set<VisitEntity> visits) {
        this.visits = visits;
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

    public Double getPaymentPerHour() {
        return paymentPerHour;
    }

    public void setPaymentPerHour(Double paymentPerHour) {
        this.paymentPerHour = paymentPerHour;
    }

    public Set<SpecializationEntity> getSpecializations() {
        return specializations;
    }

    public void setSpecializations(Set<SpecializationEntity> specializations) {
        this.specializations = specializations;
    }

    public Set<VisitEntity> getVisit() {
        return visits;
    }

    public void setVisit(Set<VisitEntity> visit) {
        this.visits = visit;
    }

    public Set<MedicalDutyEntity> getMedicalDuty() {
        return medicalDuty;
    }

    public void setMedicalDuty(Set<MedicalDutyEntity> medicalDuty) {
        this.medicalDuty = medicalDuty;
    }

    public Set<MedicalCenterEntity> getMedicalCenters() {
        return medicalCenters;
    }

    public void setMedicalCenters(Set<MedicalCenterEntity> medicalCenters) {
        this.medicalCenters = medicalCenters;
    }
}

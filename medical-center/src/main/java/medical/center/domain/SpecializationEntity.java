package medical.center.domain;


import medical.center.domain.enums.Specialization;


import javax.persistence.*;

@Entity
@Table(name = "specialization")
public class SpecializationEntity extends AbstractEntity {

    @Enumerated(EnumType.STRING)
    @Column(name = "specialization_name")
    private Specialization specializationName;

    public SpecializationEntity() {
    }

    public Specialization getName() {
        return specializationName;
    }

    public void setName(Specialization specializationName) {
        this.specializationName = specializationName;
    }
}

package medical.center.types;

import medical.center.domain.MedicalDutyEntity;

import java.util.Set;

public class DoctorTO {

    private Long id;

    private Double paymentPerHour;

    private Set<SpecializationTO> specializations;

    private Set<MedicalDutyEntity> medicalDutyTOS;

    private String city;

    private String street;

    private String postalCode;

    private String firstName;

    private String lastName;

    private String telephoneNumber;

    private String email;

    public DoctorTO(Long id, Double paymentPerHour, Set<SpecializationTO> specializations, String city, String street, String postalCode, String firstName, String lastName, String telephoneNumber, String email) {
        this.id = id;
        this.paymentPerHour = paymentPerHour;
        this.specializations = specializations;
        this.city = city;
        this.street = street;
        this.postalCode = postalCode;
        this.firstName = firstName;
        this.lastName = lastName;
        this.telephoneNumber = telephoneNumber;
        this.email = email;
    }

    public DoctorTO(Long id, Double paymentPerHour, Set<SpecializationTO> specializations, Set<MedicalDutyEntity> medicalDutyTOS, String city, String street, String postalCode, String firstName, String lastName, String telephoneNumber, String email) {
        this.id = id;
        this.paymentPerHour = paymentPerHour;
        this.specializations = specializations;
        this.medicalDutyTOS = medicalDutyTOS;
        this.city = city;
        this.street = street;
        this.postalCode = postalCode;
        this.firstName = firstName;
        this.lastName = lastName;
        this.telephoneNumber = telephoneNumber;
        this.email = email;
    }

    public Set<MedicalDutyEntity> getMedicalDutyTOS() {
        return medicalDutyTOS;
    }

    public void setMedicalDutyTOS(Set<MedicalDutyEntity> medicalDutyTOS) {
        this.medicalDutyTOS = medicalDutyTOS;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Double getPaymentPerHour() {
        return paymentPerHour;
    }

    public void setPaymentPerHour(Double paymentPerHour) {
        this.paymentPerHour = paymentPerHour;
    }

    public Set<SpecializationTO> getSpecializations() {
        return specializations;
    }

    public void setSpecializations(Set<SpecializationTO> specializations) {
        this.specializations = specializations;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    public String getPostalCode() {
        return postalCode;
    }

    public void setPostalCode(String postalCode) {
        this.postalCode = postalCode;
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

    public static DoctorTOBuilder builder() {
        return new DoctorTOBuilder();
    }


    public static final class DoctorTOBuilder {
        private Long id;
        private Double paymentPerHour;
        private Set<SpecializationTO> specializations;
        private Set<MedicalDutyEntity> medicalDutyTOS;
        private String city;
        private String street;
        private String postalCode;
        private String firstName;
        private String lastName;
        private String telephoneNumber;
        private String email;

        public DoctorTOBuilder() {
        }


        public DoctorTOBuilder withId(Long id) {
            this.id = id;
            return this;
        }

        public DoctorTOBuilder withPaymentPerHour(Double paymentPerHour) {
            this.paymentPerHour = paymentPerHour;
            return this;
        }

        public DoctorTOBuilder withSpecializations(Set<SpecializationTO> specializations) {
            this.specializations = specializations;
            return this;
        }

        public DoctorTOBuilder withMedicalDutyTOS(Set<MedicalDutyEntity> medicalDutyTOS) {
            this.medicalDutyTOS = medicalDutyTOS;
            return this;
        }

        public DoctorTOBuilder withCity(String city) {
            this.city = city;
            return this;
        }

        public DoctorTOBuilder withStreet(String street) {
            this.street = street;
            return this;
        }

        public DoctorTOBuilder withPostalCode(String postalCode) {
            this.postalCode = postalCode;
            return this;
        }

        public DoctorTOBuilder withFirstName(String firstName) {
            this.firstName = firstName;
            return this;
        }

        public DoctorTOBuilder withLastName(String lastName) {
            this.lastName = lastName;
            return this;
        }

        public DoctorTOBuilder withTelephoneNumber(String telephoneNumber) {
            this.telephoneNumber = telephoneNumber;
            return this;
        }

        public DoctorTOBuilder withEmail(String email) {
            this.email = email;
            return this;
        }

        public DoctorTO build() {
            DoctorTO doctorTO = new DoctorTO(id, paymentPerHour, specializations, city, street, postalCode, firstName, lastName, telephoneNumber, email);
            doctorTO.setMedicalDutyTOS(medicalDutyTOS);
            return doctorTO;
        }
    }
}

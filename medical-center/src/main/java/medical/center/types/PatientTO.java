package medical.center.types;

import medical.center.domain.enums.Sex;

import java.time.LocalDate;

public class PatientTO {

    private Long id;

    private Sex sex;

    private LocalDate dateOfBrth;

    private String city;

    private String street;

    private String postalCode;

    private String firstName;

    private String lastName;

    private String telephoneNumber;

    private String email;

    public PatientTO(Long id, Sex sex, LocalDate dateOfBrth, String city, String street, String postalCode, String firstName, String lastName, String telephoneNumber, String email) {
        this.id = id;
        this.sex = sex;
        this.dateOfBrth = dateOfBrth;
        this.city = city;
        this.street = street;
        this.postalCode = postalCode;
        this.firstName = firstName;
        this.lastName = lastName;
        this.telephoneNumber = telephoneNumber;
        this.email = email;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Sex getSex() {
        return sex;
    }

    public void setSex(Sex sex) {
        this.sex = sex;
    }

    public LocalDate getDateOfBrth() {
        return dateOfBrth;
    }

    public void setDateOfBrth(LocalDate dateOfBrth) {
        this.dateOfBrth = dateOfBrth;
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

    public static PatientTOBuilder aPatientTO() {
        return new PatientTOBuilder();
    }


    public static final class PatientTOBuilder {
        private Long id;
        private Sex sex;
        private LocalDate dateOfBrth;
        private String city;
        private String street;
        private String postalCode;
        private String firstName;
        private String lastName;
        private String telephoneNumber;
        private String email;

        public PatientTOBuilder() {
        }


        public PatientTOBuilder withId(Long id) {
            this.id = id;
            return this;
        }

        public PatientTOBuilder withSex(Sex sex) {
            this.sex = sex;
            return this;
        }

        public PatientTOBuilder withDateOfBrth(LocalDate dateOfBrth) {
            this.dateOfBrth = dateOfBrth;
            return this;
        }

        public PatientTOBuilder withCity(String city) {
            this.city = city;
            return this;
        }

        public PatientTOBuilder withStreet(String street) {
            this.street = street;
            return this;
        }

        public PatientTOBuilder withPostalCode(String postalCode) {
            this.postalCode = postalCode;
            return this;
        }

        public PatientTOBuilder withFirstName(String firstName) {
            this.firstName = firstName;
            return this;
        }

        public PatientTOBuilder withLastName(String lastName) {
            this.lastName = lastName;
            return this;
        }

        public PatientTOBuilder withTelephoneNumber(String telephoneNumber) {
            this.telephoneNumber = telephoneNumber;
            return this;
        }

        public PatientTOBuilder withEmail(String email) {
            this.email = email;
            return this;
        }

        public PatientTO build() {
            return new PatientTO(id, sex, dateOfBrth, city, street, postalCode, firstName, lastName, telephoneNumber, email);
        }
    }
}

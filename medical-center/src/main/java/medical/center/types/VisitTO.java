package medical.center.types;

import medical.center.domain.enums.VisitStatus;

import java.time.LocalDateTime;

public class VisitTO {

    private Long id;

    private VisitStatus visitStatus;

    LocalDateTime startTime;

    private Double price;

    private DoctorTO doctor;

    private PatientTO patient;


    public VisitTO(Long id, VisitStatus visitStatus, LocalDateTime startTime, Double price, DoctorTO doctor, PatientTO patient) {
        this.id = id;
        this.visitStatus = visitStatus;
        this.startTime = startTime;
        this.price = price;
        this.doctor = doctor;
        this.patient = patient;
    }


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
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

    public void setStartTime(LocalDateTime startTime) {
        this.startTime = startTime;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public DoctorTO getDoctor() {
        return doctor;
    }

    public void setDoctor(DoctorTO doctor) {
        this.doctor = doctor;
    }

    public PatientTO getPatient() {
        return patient;
    }

    public void setPatient(PatientTO patient) {
        this.patient = patient;
    }

    public static VisitTOBuilder builder() {
        return new VisitTOBuilder();
    }


    public static final class VisitTOBuilder {
        private LocalDateTime startTime;
        private Long id;
        private VisitStatus visitStatus;
        private Double price;
        private DoctorTO doctor;
        private PatientTO patient;

        public VisitTOBuilder() {
        }


        public VisitTOBuilder withId(Long id) {
            this.id = id;
            return this;
        }

        public VisitTOBuilder withVisitStatus(VisitStatus visitStatus) {
            this.visitStatus = visitStatus;
            return this;
        }

        public VisitTOBuilder withStartTime(LocalDateTime startTime) {
            this.startTime = startTime;
            return this;
        }

        public VisitTOBuilder withPrice(Double price) {
            this.price = price;
            return this;
        }

        public VisitTOBuilder withDoctor(DoctorTO doctor) {
            this.doctor = doctor;
            return this;
        }

        public VisitTOBuilder withPatient(PatientTO patient) {
            this.patient = patient;
            return this;
        }

        public VisitTO build() {
            return new VisitTO(id, visitStatus, startTime, price, doctor, patient);
        }
    }
}

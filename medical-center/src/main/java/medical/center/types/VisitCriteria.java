package medical.center.types;

import medical.center.domain.enums.VisitStatus;

import java.time.LocalDateTime;

public class VisitCriteria {

    VisitStatus visitStatus;

    LocalDateTime startTime;

    LocalDateTime endTime;

    String patientFirstName;

    String patientLastName;

    String doctorFirstName;

    String doctorLastName;

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

    public LocalDateTime getEndTime() {
        return endTime;
    }

    public void setEndTime(LocalDateTime endTime) {
        this.endTime = endTime;
    }

    public String getPatientFirstName() {
        return patientFirstName;
    }

    public void setPatientFirstName(String patientFirstName) {
        this.patientFirstName = patientFirstName;
    }

    public String getPatientLastName() {
        return patientLastName;
    }

    public void setPatientLastName(String patientLastName) {
        this.patientLastName = patientLastName;
    }

    public String getDoctorFirstName() {
        return doctorFirstName;
    }

    public void setDoctorFirstName(String doctorFirstName) {
        this.doctorFirstName = doctorFirstName;
    }

    public String getDoctorLastName() {
        return doctorLastName;
    }

    public void setDoctorLastName(String doctorLastName) {
        this.doctorLastName = doctorLastName;
    }

    public static VisitCriteriaBuilder builder() {
        return new VisitCriteriaBuilder();
    }

    public static final class VisitCriteriaBuilder {
        VisitStatus visitStatus;
        LocalDateTime startTime;
        LocalDateTime endTime;
        String patientFirstName;
        String patientLastName;
        String doctorFirstName;
        String doctorLastName;

        public VisitCriteriaBuilder() {
        }


        public VisitCriteriaBuilder withVisitStatus(VisitStatus visitStatus) {
            this.visitStatus = visitStatus;
            return this;
        }

        public VisitCriteriaBuilder withStartTime(LocalDateTime startTime) {
            this.startTime = startTime;
            return this;
        }

        public VisitCriteriaBuilder withEndTime(LocalDateTime endTime) {
            this.endTime = endTime;
            return this;
        }

        public VisitCriteriaBuilder withPatientFirstName(String patientFirstName) {
            this.patientFirstName = patientFirstName;
            return this;
        }

        public VisitCriteriaBuilder withPatientLastName(String patientLastName) {
            this.patientLastName = patientLastName;
            return this;
        }

        public VisitCriteriaBuilder withDoctorFirstName(String doctorFirstName) {
            this.doctorFirstName = doctorFirstName;
            return this;
        }

        public VisitCriteriaBuilder withDoctorLastName(String doctorLastName) {
            this.doctorLastName = doctorLastName;
            return this;
        }

        public VisitCriteria build() {
            VisitCriteria visitCriteria = new VisitCriteria();
            visitCriteria.setVisitStatus(visitStatus);
            visitCriteria.setStartTime(startTime);
            visitCriteria.setEndTime(endTime);
            visitCriteria.setPatientFirstName(patientFirstName);
            visitCriteria.setPatientLastName(patientLastName);
            visitCriteria.setDoctorFirstName(doctorFirstName);
            visitCriteria.setDoctorLastName(doctorLastName);
            return visitCriteria;
        }
    }
}



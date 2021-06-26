package medical.center.types;


import java.time.LocalDate;

public class MedicalDutyTO {

    private Long id;

    private LocalDate date;

    private MedicalCenterTO medicalCenter;

    private DoctorTO doctorEntity;

    public MedicalDutyTO(Long id, LocalDate date, MedicalCenterTO medicalCenter, DoctorTO doctorEntity) {
        this.id = id;
        this.date = date;
        this.medicalCenter = medicalCenter;
        this.doctorEntity = doctorEntity;
    }

    public MedicalDutyTO() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    public MedicalCenterTO getMedicalCenter() {
        return medicalCenter;
    }

    public void setMedicalCenter(MedicalCenterTO medicalCenter) {
        this.medicalCenter = medicalCenter;
    }

    public DoctorTO getDoctor() {
        return doctorEntity;
    }

    public void setDoctor(DoctorTO doctorEntity) {
        this.doctorEntity = doctorEntity;
    }


    public static MedicalDutyTOBuilder build() {
        return new MedicalDutyTOBuilder();
    }


    public static final class MedicalDutyTOBuilder {
        private Long id;
        private LocalDate date;
        private MedicalCenterTO medicalCenter;
        private DoctorTO doctorEntity;

        public MedicalDutyTOBuilder() {
        }


        public MedicalDutyTOBuilder withId(Long id) {
            this.id = id;
            return this;
        }

        public MedicalDutyTOBuilder withDate(LocalDate date) {
            this.date = date;
            return this;
        }

        public MedicalDutyTOBuilder withMedicalCenter(MedicalCenterTO medicalCenter) {
            this.medicalCenter = medicalCenter;
            return this;
        }

        public MedicalDutyTOBuilder withDoctor(DoctorTO doctorEntity) {
            this.doctorEntity = doctorEntity;
            return this;
        }

        public MedicalDutyTO build() {
            return new MedicalDutyTO(id, date, medicalCenter, doctorEntity);
        }
    }
}

package medical.center.repo;

import medical.center.domain.PatientEntity;

import java.time.LocalDateTime;
import java.util.List;

public interface CustomizedPatientRepository {

    List<PatientEntity> getMostCancelledVisitPatient(LocalDateTime startDate, LocalDateTime endDate);

}

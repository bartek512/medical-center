package medical.center.repo;

import medical.center.domain.PatientEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface PatientRepo extends JpaRepository<PatientEntity, Long>, CustomizedPatientRepository {

    PatientEntity getById(Long id);

    List<PatientEntity> findPatientEntitiesByMedicalCenterId(Long medicalCenterId);
}

package medical.center.repo;

import medical.center.domain.DoctorEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface DoctorRepo extends JpaRepository<DoctorEntity, Long>, CustomizedDoctorRepository {

    DoctorEntity getById(Long id);

    List<DoctorEntity> findDoctorEntityByMedicalCentersId(Long medicalCenterId);

}

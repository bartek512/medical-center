package medical.center.repo;

import medical.center.domain.MedicalCenterEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MedicalCenterRepo extends JpaRepository<MedicalCenterEntity, Long>, CustomizedMedicalCenterRepository {

    MedicalCenterEntity getById(Long id);

    void deleteById(Long id);
}

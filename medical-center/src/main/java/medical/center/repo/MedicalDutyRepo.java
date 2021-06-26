package medical.center.repo;

import medical.center.domain.MedicalDutyEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import javax.persistence.EntityManager;
import java.util.List;

public interface MedicalDutyRepo extends JpaRepository<MedicalDutyEntity, Long>, CustomizedMedicalDutyRepo {

    MedicalDutyEntity save(MedicalDutyEntity medicalDutyEntity);

    MedicalDutyEntity getById(Long id);

    EntityManager getEm();

    List<MedicalDutyEntity> findMedicalDutyEntityByMedicalCenterId(Long medicalCenterId);

    List<MedicalDutyEntity> findMedicalDutyEntityByDoctorEntityId(Long doctorId);
}

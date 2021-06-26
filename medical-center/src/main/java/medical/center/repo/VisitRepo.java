package medical.center.repo;

import medical.center.domain.VisitEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface VisitRepo extends JpaRepository<VisitEntity, Long>, CustomizedVisitRepository {

    VisitEntity getById(Long id);

    VisitEntity save(VisitEntity visitEntity);

    void deleteById(Long id);

    List<VisitEntity> findVisitEntityByPatientId(Long patientId);

    List<VisitEntity> findVisitEntityByDoctorId(Long doctorId);
}

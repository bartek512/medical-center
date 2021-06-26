package medical.center.repo;

import medical.center.domain.VisitEntity;
import medical.center.types.VisitCriteria;

import java.time.LocalDateTime;
import java.util.List;

public interface CustomizedVisitRepository {

    Double getSumaricCostOfVisit(Long patientId, LocalDateTime startDate, LocalDateTime endDate);

    List<VisitEntity> findVisitByCriteria(VisitCriteria visitCrtiteria);

}

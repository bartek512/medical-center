package medical.center.service;

import medical.center.exceptions.BusinessException;
import medical.center.types.VisitTO;

public interface VisitService {

    void deleteById(Long visitId);

    VisitTO getById(Long visitId);

    VisitTO updateVisit(Long id,VisitTO visitTO) throws BusinessException;

    VisitTO saveVisit(VisitTO visitTO) throws BusinessException;

    void deleteAll();
}

package medical.center.service.impl;

import medical.center.domain.VisitEntity;
import medical.center.exceptions.BusinessException;
import medical.center.mappers.VisitMapper;
import medical.center.repo.VisitRepo;
import medical.center.service.VisitService;
import medical.center.types.VisitTO;
import medical.center.validators.VisitValidator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


@Service
@Transactional
public class VisitServiceImpl implements VisitService {


    @Autowired
    private VisitRepo visitRepo;

    @Autowired
    private VisitValidator visitValidator;

    @Override
    public void deleteById(Long visitId) {
        visitRepo.deleteById(visitId);
    }

    @Override
    public VisitTO getById(Long visitId) {
        return VisitMapper.toVisitTO(visitRepo.getById(visitId));
    }

    @Override
    public VisitTO updateVisit(Long id, VisitTO visitTO) throws BusinessException {

        VisitTO visit = VisitMapper.toVisitTO(visitRepo.getById(id));
        visitTO.setId(visit.getId());

        visitValidator.validateVisit(visitTO);

        VisitEntity savedVisit = visitRepo.save(VisitMapper.toVisitEntity(visitTO));
        return VisitMapper.toVisitTO(savedVisit);
    }

    @Override
    public VisitTO saveVisit(VisitTO visitTO) throws BusinessException {
        visitValidator.validateVisit(visitTO);
        VisitEntity savedVisit = visitRepo.save(VisitMapper.toVisitEntity(visitTO));
        return VisitMapper.toVisitTO(savedVisit);
    }

    @Override
    public void deleteAll() {
        visitRepo.deleteAll();
    }
}

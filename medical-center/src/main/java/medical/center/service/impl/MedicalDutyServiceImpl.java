package medical.center.service.impl;


import medical.center.domain.MedicalDutyEntity;
import medical.center.exceptions.BusinessException;
import medical.center.mappers.MedicalDutyMapper;
import medical.center.repo.MedicalDutyRepo;
import medical.center.service.MedicalDutyService;
import medical.center.types.MedicalDutyTO;
import medical.center.validators.MedicalDutyValidator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;

@Service
@Transactional
public class MedicalDutyServiceImpl implements MedicalDutyService {


    @Autowired
    private MedicalDutyRepo medicalDutyRepo;

    @Autowired
    private MedicalDutyValidator medicalDutyValidator;

    @Override
    public MedicalDutyTO saveMedcalDuty(MedicalDutyTO medicalDutyTo) throws BusinessException {
        medicalDutyValidator.validateMedicalDuty(medicalDutyTo);
        MedicalDutyEntity savedMedicalDuty = medicalDutyRepo.save(MedicalDutyMapper.toMedicalDutyEntity(medicalDutyTo));
        return MedicalDutyMapper.toMedicalDutyTO(savedMedicalDuty);
    }

    @Override
    public MedicalDutyTO updateMedicalDuty(Long id, MedicalDutyTO medicalDutyTO) throws BusinessException {

        MedicalDutyTO duty = MedicalDutyMapper.toMedicalDutyTO(medicalDutyRepo.getById(id));
        medicalDutyTO.setId(duty.getId());

        medicalDutyValidator.validateMedicalDuty(medicalDutyTO);

        MedicalDutyEntity savedMedicalDuty = medicalDutyRepo.save(MedicalDutyMapper.toMedicalDutyEntity(medicalDutyTO));
        return MedicalDutyMapper.toMedicalDutyTO(savedMedicalDuty);

    }

    @Override
    public MedicalDutyTO getById(Long id) {
        return MedicalDutyMapper.toMedicalDutyTO(medicalDutyRepo.getById(id));
    }

    @Override
    public EntityManager getEm() {
        return medicalDutyRepo.getEm();
    }
}

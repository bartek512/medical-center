package medical.center.service;

import medical.center.exceptions.BusinessException;
import medical.center.types.MedicalDutyTO;

import javax.persistence.EntityManager;

public interface MedicalDutyService {

    MedicalDutyTO saveMedcalDuty(MedicalDutyTO medivalDutyTo) throws BusinessException;

    MedicalDutyTO updateMedicalDuty(Long id, MedicalDutyTO medicalDutyTO) throws BusinessException;

    MedicalDutyTO getById(Long id);

    EntityManager getEm();
}

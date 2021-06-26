package medical.center.validators;

import medical.center.domain.MedicalDutyEntity;
import medical.center.exceptions.BusinessException;
import medical.center.types.DoctorTO;
import medical.center.types.MedicalDutyTO;
import org.springframework.stereotype.Component;

import java.time.LocalDate;
import java.util.Set;

@Component
public class MedicalDutyValidator {

    public boolean validateMedicalDuty(MedicalDutyTO medicalDutyTO) throws BusinessException {

        DoctorTO doctor = medicalDutyTO.getDoctor();
        Set<MedicalDutyEntity> medicalDuties = doctor.getMedicalDutyTOS();
        LocalDate dutyDate = medicalDutyTO.getDate();

        if (medicalDuties.stream().anyMatch(d -> d.getDate().equals(dutyDate))) {
            throw new BusinessException("Doctos has a duty this day");
        }

        return true;

    }
}

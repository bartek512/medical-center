package medical.center.validators;

import medical.center.domain.enums.Sex;
import medical.center.domain.enums.Specialization;
import medical.center.exceptions.BusinessException;
import medical.center.types.VisitTO;
import org.springframework.stereotype.Component;

import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.Period;

@Component
public class VisitValidator {

    public boolean validateVisit(VisitTO visit) throws BusinessException {

        if (visit.getStartTime().getDayOfWeek().equals(DayOfWeek.SATURDAY) || visit.getStartTime().getDayOfWeek().equals(DayOfWeek.SUNDAY)) {
            throw new BusinessException("You cant book visit on the weekend");
        }

        if (visit.getStartTime().getMinute() % 15 != 0 && visit.getStartTime().getMinute() != 0) {
            throw new BusinessException("You can book visit only at full hour, quarter past, quarter to and half past");
        }

        if (visit.getStartTime().getHour() < 8) {
            throw new BusinessException("You can book visit only between 8 and 17:45");
        }
        boolean hourBeforeEndWorkingHours = visit.getStartTime().getHour() > 17;
        boolean minue = visit.getStartTime().getMinute() > 45;
        boolean hourAfterWorkingHours = visit.getStartTime().getHour() >= 18;

        if (hourAfterWorkingHours || (hourBeforeEndWorkingHours && minue)) {
            throw new BusinessException("You can book visit only between 8 and 17:45");

        }
        if (visit.getPatient().getSex().equals(Sex.MALE)
                && visit.getDoctor().getSpecializations().stream().anyMatch(s -> s.getName().equals(Specialization.GYNECOLOGIST))) {
            throw new BusinessException("Male cannot visit gynecologist :)");
        }

        if (Period.between(visit.getPatient().getDateOfBrth(), LocalDate.now()).getYears() >= 18
                && visit.getDoctor().getSpecializations().stream().anyMatch(s -> s.getName().equals(Specialization.PEDIATRICIAN))) {
            throw new BusinessException("An adult cannot visit pediatrician");
        }

        return true;
    }
}


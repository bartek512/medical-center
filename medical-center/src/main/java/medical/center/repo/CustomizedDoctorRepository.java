package medical.center.repo;

import medical.center.domain.DoctorEntity;

import java.time.LocalDateTime;
import java.util.List;

public interface CustomizedDoctorRepository{

    List<DoctorEntity> getDoctorWithLowestCountOfVisits(LocalDateTime startDate, LocalDateTime endDate);

    List<DoctorEntity> getDoctorsAssignedToOnlyOneMedicalCenter(Long medicalCenterId);

    List<Long> getCountOfVisitsTwoMostVisitedDoctors();

    List<DoctorEntity> getTwoMostVisitedDoctors();

    List<DoctorEntity> getDoctorWithMostCancelledVisits();

}

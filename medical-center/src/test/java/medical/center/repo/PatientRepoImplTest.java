package medical.center.repo;

import medical.center.domain.PatientEntity;
import medical.center.domain.enums.VisitStatus;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.time.LocalDateTime;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

@SpringBootTest
public class PatientRepoImplTest {


    @Autowired
    private PatientRepo patientRepo;


    @Test
    void shouldReturnPatientWithMostCancelledVisitsWithoutDates() {

        //when
        List<PatientEntity> list = patientRepo.getMostCancelledVisitPatient(null, null);

        //then
        assertEquals(1, list.size());
        assertTrue(list.get(0).getVisit().stream().anyMatch(v -> v.getVisitStatus().equals(VisitStatus.CANCELLED_PATIENT)));
    }

    @Test
    void shouldReturnPatientWithMostCancelledVisitsUsingOnlyEndDate() {

        //given
        LocalDateTime endDate = LocalDateTime.of(2021, 7, 1, 00, 00);

        //when
        List<PatientEntity> list = patientRepo.getMostCancelledVisitPatient(null, endDate);

        //then
        assertEquals(1, list.size());
        assertTrue(list.get(0).getVisit().stream().anyMatch(v -> v.getVisitStatus().equals(VisitStatus.CANCELLED_PATIENT)));
        assertTrue(list.get(0).getVisit().stream().anyMatch(v -> v.getStartTime().isBefore(endDate)));
    }

    @Test
    void shouldReturnPatientWithMostCancelledVisitsUsingOnlyStartDate() {

        //given
        LocalDateTime startDate = LocalDateTime.of(2017, 7, 1, 00, 00);

        //when
        List<PatientEntity> list = patientRepo.getMostCancelledVisitPatient(startDate, null);

        //then
        assertEquals(1, list.size());
        assertTrue(list.get(0).getVisit().stream().anyMatch(v -> v.getVisitStatus().equals(VisitStatus.CANCELLED_PATIENT)));
        assertTrue(list.get(0).getVisit().stream().anyMatch(v -> v.getStartTime().isAfter(startDate)));
    }

    @Test
    void shouldReturnAllPatientsAssignedToMedicalCenter(){

        //when
        List<PatientEntity> resultList = patientRepo.findPatientEntitiesByMedicalCenterId(1L);

        //then
        assertEquals(7, resultList.size());
        assertTrue(resultList.stream().allMatch(p -> p.getMedicalCenter().getId() == 1));
    }


}

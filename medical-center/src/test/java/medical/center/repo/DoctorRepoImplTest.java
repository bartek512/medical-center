package medical.center.repo;

import medical.center.domain.DoctorEntity;
import medical.center.domain.enums.VisitStatus;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.time.LocalDateTime;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

@SpringBootTest
public class DoctorRepoImplTest {

    @Autowired
    private DoctorRepo doctorRepo;


    @Test
    void shouldReturnDoctorWithLowestCountOfVisitsWithoutDates() {

        //when
        List<DoctorEntity> resultList = doctorRepo.getDoctorWithLowestCountOfVisits(null, null);

        //then
        assertEquals(2, resultList.size());

        assertEquals(1, resultList.get(0).getVisit().size());
        assertEquals(1, resultList.get(1).getVisit().size());

    }

    @Test
    void shouldReturnDoctorWithLowestCountOfVisitsWithBothDates() {

        //when
        List<DoctorEntity> resultList = doctorRepo.getDoctorWithLowestCountOfVisits(LocalDateTime.of(2022, 6, 1, 00, 00),
                LocalDateTime.of(2022, 6, 15, 00, 00));

        //then
        assertEquals(2, resultList.size());
        assertTrue(resultList.get(0).getVisit().stream().anyMatch(v -> v.getStartTime().isAfter(LocalDateTime.of(2022, 6, 1, 00, 00))));
        assertTrue(resultList.get(1).getVisit().stream().anyMatch(v -> v.getStartTime().isAfter(LocalDateTime.of(2022, 6, 1, 00, 00))));
        assertTrue(resultList.get(0).getVisit().stream().anyMatch(v -> v.getStartTime().isBefore(LocalDateTime.of(2022, 6, 15, 00, 00))));
        assertTrue(resultList.get(1).getVisit().stream().anyMatch(v -> v.getStartTime().isBefore(LocalDateTime.of(2022, 6, 15, 00, 00))));

    }

    @Test
    void shouldReturnDoctorWithLowestCountOfVisitsWithOnlyStartDate() {

        //when
        List<DoctorEntity> resultList = doctorRepo.getDoctorWithLowestCountOfVisits(LocalDateTime.of(2021, 6, 1, 00, 00),
                null);

        //then
        assertEquals(3, resultList.size());
        assertTrue(resultList.get(0).getVisit().stream().anyMatch(v -> v.getStartTime().isAfter(LocalDateTime.of(2021, 6, 1, 00, 00))));
        assertTrue(resultList.get(1).getVisit().stream().anyMatch(v -> v.getStartTime().isAfter(LocalDateTime.of(2021, 6, 1, 00, 00))));
        assertTrue(resultList.get(2).getVisit().stream().anyMatch(v -> v.getStartTime().isAfter(LocalDateTime.of(2021, 6, 1, 00, 00))));

    }

    @Test
    void shouldReturnDoctorWithLowestCountOfVisitsWithOnlyStartDateWithHour() {

        //when
        List<DoctorEntity> resultList = doctorRepo.getDoctorWithLowestCountOfVisits(LocalDateTime.of(2022, 6, 14, 15, 00),
                null);

        //then
        assertEquals(2, resultList.size());
        assertTrue(resultList.get(0).getVisit().stream().anyMatch(v -> v.getStartTime().isAfter(LocalDateTime.of(2022, 6, 14, 14, 59))));
        assertTrue(resultList.get(1).getVisit().stream().anyMatch(v -> v.getStartTime().isAfter(LocalDateTime.of(2022, 6, 14, 14, 59))));

    }


    @Test
    void shouldReturnDoctorWithLowestCountOfVisitsWithOnlyEndDate() {

        //when
        List<DoctorEntity> resultList = doctorRepo.getDoctorWithLowestCountOfVisits(null, LocalDateTime.of(2021, 6, 16, 00, 00));

        //then
        assertEquals(1, resultList.size());
        assertTrue(resultList.get(0).getVisit().stream().anyMatch(v -> v.getStartTime().isBefore(LocalDateTime.of(2021, 6, 16, 00, 00))));

    }

    @Test
    void shouldReturnDoctorWithLowestCountOfVisitsWithOnlyEndDateWithHour() {

        //when
        List<DoctorEntity> resultList = doctorRepo.getDoctorWithLowestCountOfVisits(null, LocalDateTime.of(2021, 6, 16, 15, 00));

        //then
        assertEquals(1, resultList.size());
        assertTrue(resultList.get(0).getVisit().stream().anyMatch(v -> v.getStartTime().isBefore(LocalDateTime.of(2021, 6, 16, 15, 01))));

    }

    @Test
    void shouldReturnDoctorsAssignedOnlyToOneMedicalCenter() {

        //when
        List<DoctorEntity> resultList = doctorRepo.getDoctorsAssignedToOnlyOneMedicalCenter(1L);

        //then
        assertEquals(3, resultList.size());
        assertTrue(resultList.stream().allMatch(v -> v.getMedicalCenters().size() == 1));
        assertTrue(resultList.stream().allMatch(v -> v.getMedicalCenters().stream().allMatch(m -> m.getId() == 1)));

    }

    @Test
    void shouldReturnDoctorsAssignedOnlyToOneAnotherMedicalCenter() {

        //when
        List<DoctorEntity> resultList = doctorRepo.getDoctorsAssignedToOnlyOneMedicalCenter(2L);

        //then
        assertEquals(1, resultList.size());
        assertTrue(resultList.stream().allMatch(v -> v.getMedicalCenters().size() == 1));
        assertTrue(resultList.stream().allMatch(v -> v.getMedicalCenters().stream().allMatch(m -> m.getId() == 2)));

    }

    @Test
    void shouldReturnEmptyList() {

        //when
        List<DoctorEntity> resultList = doctorRepo.getDoctorsAssignedToOnlyOneMedicalCenter(3L);

        //then
        assertTrue(resultList.isEmpty());

    }

    @Test
    void shouldReturnDoctorWithBiggestCountOfCancelledVisits() {

        //when
        List<DoctorEntity> resultList = doctorRepo.getDoctorWithMostCancelledVisits();

        //then
        assertEquals(2, resultList.size());
        assertTrue(resultList.get(0).getVisit().stream().anyMatch(v -> v.getVisitStatus().equals(VisitStatus.CANCELLED_PATIENT)));
        assertTrue(resultList.get(1).getVisit().stream().anyMatch(v -> v.getVisitStatus().equals(VisitStatus.CANCELLED_PATIENT)));
        assertTrue(resultList.get(0).getVisit().stream().anyMatch(v -> v.getVisitStatus().equals(VisitStatus.CANCELLED)));
        assertTrue(resultList.get(1).getVisit().stream().anyMatch(v -> v.getVisitStatus().equals(VisitStatus.CANCELLED)));

    }

    @Test
    void shouldReturnTwoMostVisitedDoctors() {

        //when
        List<DoctorEntity> resultList = doctorRepo.getTwoMostVisitedDoctors();

        //then
        assertEquals(2, resultList.size());
        assertTrue(resultList.get(0).getVisit().size() >= resultList.get(1).getVisit().size());
    }

    @Test
    void shouldReturnAllDoctorsFilteredByMedicalCenters() {

        //when
        List<DoctorEntity> resultList = doctorRepo.findDoctorEntityByMedicalCentersId(1L);

        //then
       assertEquals(5, resultList.size());
        assertTrue(resultList.stream().anyMatch(d -> d.getMedicalCenters().stream().anyMatch(m -> m.getId() == 1)));
    }

}

package medical.center.repo;


import medical.center.domain.VisitEntity;
import medical.center.domain.enums.Specialization;
import medical.center.domain.enums.VisitStatus;
import medical.center.types.VisitCriteria;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.time.LocalDateTime;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
public class VisitRepoImplTest {

    @Autowired
    private VisitRepo visitRepo;

    @Test
    void shouldReturnSumaricCostWithoutDates() {

        //when
        Double result = visitRepo.getSumaricCostOfVisit(1L, null, null);

        //then
        assertEquals(600, result);
    }

    @Test
    void shouldReturnSumaricCostWithBothDates() {

        //when
        Double result = visitRepo.getSumaricCostOfVisit(1L, LocalDateTime.of(2020, 10, 1, 00, 00),
                LocalDateTime.of(2020, 12, 15, 00, 00));

        //then
        assertEquals(300, result);
    }

    @Test
    void shouldReturnSumaricCostWithOnlyStartDate() {

        //when
        Double result = visitRepo.getSumaricCostOfVisit(1L, LocalDateTime.of(2020, 10, 1, 00, 00),
                null);

        //then
        assertEquals(450, result);
    }

    @Test
    void shouldReturnSumaricCostWithOnlyStartDateOnTheOfVisit() {

        //when
        Double result = visitRepo.getSumaricCostOfVisit(1L, LocalDateTime.of(2021, 6, 6, 00, 00),
                null);

        //then
        assertEquals(150, result);
    }

    @Test
    void shouldReturnSumaricCostWithOnlyEndDate() {

        //when
        Double result = visitRepo.getSumaricCostOfVisit(1L, null, LocalDateTime.of(2020, 9, 15, 00, 00));

        //then
        assertEquals(150, result);
    }

    @Test
    void shouldReturnSumaricCostWithOnlyEndDateOnDayOfVisit() {

        //when
        Double result = visitRepo.getSumaricCostOfVisit(1L, null, LocalDateTime.of(2020, 9, 12, 00, 00));

        //then
        assertEquals(150, result);
    }

    @Test
    void shouldReturnVisitByCriteriaSearchUsingOnlyVisitStatus() {

        //given
        VisitCriteria visitCriteria = VisitCriteria.builder().withVisitStatus(VisitStatus.CANCELLED_PATIENT).build();

        //when
        List<VisitEntity> resultList = visitRepo.findVisitByCriteria(visitCriteria);

        //then
        assertFalse(resultList.isEmpty());
        assertTrue(resultList.stream().allMatch(v -> v.getVisitStatus().equals(VisitStatus.CANCELLED_PATIENT)));

    }

    @Test
    void shouldReturnVisitByCriteriaSearchUsingOnlyPartDoctorFirstName() {

        //given
        VisitCriteria visitCriteria = VisitCriteria.builder()
                .withDoctorFirstName("Grz")
                .build();

        //when
        List<VisitEntity> resultList = visitRepo.findVisitByCriteria(visitCriteria);

        //then
        assertFalse(resultList.isEmpty());
        assertTrue(resultList.stream().allMatch(v -> v.getDoctor().getFirstName().contains("Grz")));

    }

    @Test
    void shouldReturnVisitByCriteriaSearchUsingOnlyDoctorFirstName() {

        //given
        VisitCriteria visitCriteria = VisitCriteria.builder()
                .withDoctorFirstName("Grzegorz")
                .build();

        //when
        List<VisitEntity> resultList = visitRepo.findVisitByCriteria(visitCriteria);

        //then
        assertFalse(resultList.isEmpty());
        assertTrue(resultList.stream().allMatch(v -> v.getDoctor().getFirstName().contains("Grzegorz")));

    }

    @Test
    void shouldReturnVisitByCriteriaSearchUsingOnlyPartDoctorLastName() {

        //given
        VisitCriteria visitCriteria = VisitCriteria.builder()
                .withDoctorLastName("Wan")
                .build();

        //when
        List<VisitEntity> resultList = visitRepo.findVisitByCriteria(visitCriteria);

        //then
        assertFalse(resultList.isEmpty());
        assertTrue(resultList.stream().allMatch(v -> v.getDoctor().getLastName().contains("Wan")));

    }

    @Test
    void shouldReturnVisitByCriteriaSearchUsingOnlyDoctorLastName() {

        //given
        VisitCriteria visitCriteria = VisitCriteria.builder()
                .withDoctorLastName("Wanna")
                .build();

        //when
        List<VisitEntity> resultList = visitRepo.findVisitByCriteria(visitCriteria);

        //then
        assertFalse(resultList.isEmpty());
        assertTrue(resultList.stream().allMatch(v -> v.getDoctor().getLastName().contains("Wanna")));

    }

    @Test
    void shouldReturnVisitByCriteriaSearchUsingOnlyPatientLastName() {

        //given

        VisitCriteria visitCriteria = VisitCriteria.builder().withPatientLastName("Krzysztof").build();

        //when
        List<VisitEntity> resultList = visitRepo.findVisitByCriteria(visitCriteria);

        //then
        assertFalse(resultList.isEmpty());
        assertTrue(resultList.stream().anyMatch(v -> v.getPatient().getLastName().equals("Krzysztof")));

    }

    @Test
    void shouldReturnVisitByCriteriaSearchUsingOnlyPatientFirstName() {

        //given

        VisitCriteria visitCriteria = VisitCriteria.builder().withPatientFirstName("Tomasz").build();

        //when
        List<VisitEntity> resultList = visitRepo.findVisitByCriteria(visitCriteria);

        //then
        assertFalse(resultList.isEmpty());
        assertTrue(resultList.stream().anyMatch(v -> v.getPatient().getFirstName().equals("Tomasz")));

    }

    @Test
    void shouldReturnVisitByCriteriaSearchUsingStartAndEndTime() {

        //given

        VisitCriteria visitCriteria = VisitCriteria.builder().withStartTime(LocalDateTime.of(2021, 6, 6, 14, 00))
                .withEndTime(LocalDateTime.of(2021, 6, 6, 16, 00))
                .build();

        //when
        List<VisitEntity> resultList = visitRepo.findVisitByCriteria(visitCriteria);

        //then
        assertFalse(resultList.isEmpty());
        assertTrue(resultList.stream().anyMatch(v -> v.getStartTime().isAfter(LocalDateTime.of(2021, 6, 6, 14, 00))));
        assertTrue(resultList.stream().anyMatch(v -> v.getStartTime().isBefore(LocalDateTime.of(2021, 6, 6, 16, 00))));

    }

    @Test
    void shouldReturnVisitByCriteriaSearchUsingStartTime() {

        //given

        VisitCriteria visitCriteria = VisitCriteria.builder().withStartTime(LocalDateTime.of(2021, 6, 16, 14, 00))

                .build();

        //when
        List<VisitEntity> resultList = visitRepo.findVisitByCriteria(visitCriteria);

        //then
        assertFalse(resultList.isEmpty());
        assertTrue(resultList.stream().anyMatch(v -> v.getStartTime().isAfter(LocalDateTime.of(2021, 6, 16, 14, 00))));

    }

    @Test
    void shouldReturnVisitByCriteriaSearchUsingEndTime() {

        //given

        VisitCriteria visitCriteria = VisitCriteria.builder().withEndTime(LocalDateTime.of(2021, 6, 16, 14, 00))
                .build();

        //when
        List<VisitEntity> resultList = visitRepo.findVisitByCriteria(visitCriteria);

        //then
        assertFalse(resultList.isEmpty());
        assertTrue(resultList.stream().anyMatch(v -> v.getStartTime().isBefore(LocalDateTime.of(2021, 6, 16, 14, 00))));

    }

    @Test
    void shouldReturnVisitByCriteriaSearchUsingAlmostAllCriterias() {

        //given
        Set<Specialization> specializations = new HashSet<>();
        specializations.add(Specialization.OCULIST);

        VisitCriteria visitCriteria = VisitCriteria.builder().withStartTime(LocalDateTime.of(2021, 6, 14, 14, 00))
                .withEndTime(LocalDateTime.of(2021, 6, 16, 16, 00))
                .withPatientFirstName("Tomasz")
                .withPatientLastName("Tomasz")
                .withVisitStatus(VisitStatus.WAITING)
                .build();

        //when
        List<VisitEntity> resultList = visitRepo.findVisitByCriteria(visitCriteria);

        //then
        assertFalse(resultList.isEmpty());
        assertTrue(resultList.stream().anyMatch(v -> v.getStartTime().isBefore(LocalDateTime.of(2021, 6, 16, 14, 00))));
        assertTrue(resultList.stream().anyMatch(v -> v.getStartTime().isAfter(LocalDateTime.of(2021, 6, 14, 14, 00))));
        assertTrue(resultList.stream().anyMatch(v -> v.getPatient().getFirstName().equals("Tomasz")));
        assertTrue(resultList.stream().anyMatch(v -> v.getPatient().getLastName().equals("Tomasz")));
        assertTrue(resultList.stream().anyMatch(v -> v.getDoctor().getSpecializations()
                .stream().anyMatch(s -> s.getName().name().equals(Specialization.OCULIST.name()))));
        assertTrue(resultList.stream().anyMatch(v -> v.getVisitStatus().equals(VisitStatus.WAITING)));

    }


    @Test
    void shouldReturnVisitByCriteriaSearchUsingAllCriterias() {

        //given
        VisitCriteria visitCriteria = VisitCriteria.builder().withStartTime(LocalDateTime.of(2022, 6, 12, 14, 00))
                .withEndTime(LocalDateTime.of(2022, 6, 16, 16, 00))
                .withPatientFirstName("Tomasz")
                .withPatientLastName("Kowalski")
                .withVisitStatus(VisitStatus.FINISHED)
                .withDoctorFirstName("Grze")
                .withDoctorLastName("Grz")
                .build();

        //when
        List<VisitEntity> resultList = visitRepo.findVisitByCriteria(visitCriteria);

        //then
        assertFalse(resultList.isEmpty());
        assertTrue(resultList.stream().anyMatch(v -> v.getStartTime().isBefore(LocalDateTime.of(2022, 6, 16, 14, 00))));
        assertTrue(resultList.stream().anyMatch(v -> v.getStartTime().isAfter(LocalDateTime.of(2022, 6, 12, 14, 00))));
        assertTrue(resultList.stream().anyMatch(v -> v.getPatient().getFirstName().equals("Tomasz")));
        assertTrue(resultList.stream().anyMatch(v -> v.getDoctor().getFirstName().contains("Grze")));
        assertTrue(resultList.stream().anyMatch(v -> v.getPatient().getLastName().equals("Kowalski")));
        assertTrue(resultList.stream().anyMatch(v -> v.getDoctor().getLastName().contains("Grz")));
        assertTrue(resultList.stream().anyMatch(v -> v.getVisitStatus().equals(VisitStatus.FINISHED)));

    }

    @Test
    void shouldReturnVisitByCriteriaSearchUsingNull() {

        //given
        Set<Specialization> specializations = new HashSet<>();
        specializations.add(Specialization.OCULIST);

        VisitCriteria visitCriteria = VisitCriteria.builder().withStartTime(null)
                .withEndTime(null)
                .withPatientFirstName(null)
                .withPatientLastName(null)
                .withVisitStatus(null)
                .withDoctorFirstName(null)
                .withDoctorLastName(null)
                .build();

        //when
        List<VisitEntity> resultList = visitRepo.findVisitByCriteria(visitCriteria);

        //then
        assertEquals(49, resultList.size());

    }

    @Test
    void shouldReturnAllVisitsOfPatient(){
        //when
        List<VisitEntity> resultList = visitRepo.findVisitEntityByPatientId(1L);

        //then
        assertEquals(4, resultList.size());
       assertTrue(resultList.stream().allMatch(v -> v.getPatient().getId() == 1));

    }

    @Test
    void shouldReturnAllVisitsOfDoctor(){
        //when
        List<VisitEntity> resultList = visitRepo.findVisitEntityByDoctorId(101L);

        //then
        assertEquals(17, resultList.size());
        assertTrue(resultList.stream().allMatch(v -> v.getDoctor().getId() == 101));
    }
}

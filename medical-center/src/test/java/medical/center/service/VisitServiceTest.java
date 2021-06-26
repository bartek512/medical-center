package medical.center.service;


import medical.center.domain.enums.VisitStatus;
import medical.center.exceptions.BusinessException;
import medical.center.types.DoctorTO;
import medical.center.types.PatientTO;
import medical.center.types.VisitTO;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import javax.transaction.Transactional;
import java.time.LocalDateTime;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
public class VisitServiceTest {

    @Autowired
    private VisitService visitService;

    @Autowired
    private DoctorService doctorService;

    @Autowired
    private PatientService patientService;


    @Test
    @Transactional
    void shouldThrowBusinessExceptionWhenTryToBookVisitOnTheWeekend() throws BusinessException {

        //given
        DoctorTO doctor = doctorService.getById(101L);
        PatientTO patient = patientService.findById(2L);

        VisitTO visitToSave = VisitTO.builder().withVisitStatus(VisitStatus.WAITING)
                .withDoctor(doctor)
                .withId(50L)
                .withPatient(patient)
                .withStartTime(LocalDateTime.of(2021, 06, 19, 15, 00))
                .withPrice(150d)
                .build();

        //when
        //then

        assertThrows(BusinessException.class, () -> {
            visitService.saveVisit(visitToSave);
        });
    }

    @Test
    @Transactional
    void shouldReturnSavedVisitWhenTryToBookVisitOnCommonDay() throws BusinessException {

        //given
        DoctorTO doctor = doctorService.getById(101L);
        PatientTO patient = patientService.findById(2L);

        VisitTO visitToSave = VisitTO.builder().withVisitStatus(VisitStatus.WAITING)
                .withDoctor(doctor)
                //  .withId(50L)
                .withPatient(patient)
                .withStartTime(LocalDateTime.of(2021, 06, 22, 15, 00))
                .withPrice(150d)
                .build();

        //when
        VisitTO savedVisit = visitService.saveVisit(visitToSave);


        //then
        assertNotNull(savedVisit);
        assertEquals(doctor.getFirstName(), savedVisit.getDoctor().getFirstName());
        assertEquals(doctor.getLastName(), savedVisit.getDoctor().getLastName());
        assertEquals(patient.getFirstName(), savedVisit.getPatient().getFirstName());
        assertEquals(patient.getLastName(), savedVisit.getPatient().getLastName());

    }

    @Test
    @Transactional
    void shouldDeleteVisit() throws BusinessException {

        //given
        VisitTO visitToDelete = visitService.getById(1L);

        //when
        visitService.deleteById(1L);


        //then
        assertNotNull(visitToDelete);
        assertNull(visitService.getById(1L));

    }

    @Test
    @Transactional
    void shouldReturnBusinessExceptionWhenTryToSaveVisitOnWrongHour() throws BusinessException {

        //given
        DoctorTO doctor = doctorService.getById(101L);
        PatientTO patient = patientService.findById(2L);

        VisitTO visitToSave = VisitTO.builder().withVisitStatus(VisitStatus.WAITING)
                .withDoctor(doctor)
                .withId(50L)
                .withPatient(patient)
                .withStartTime(LocalDateTime.of(2021, 06, 22, 15, 06))
                .withPrice(150d)
                .build();

        //when
        //then

        assertThrows(BusinessException.class, () -> {
            visitService.saveVisit(visitToSave);
        });

    }

    @Test
    @Transactional
    void shouldReturnBusinessExceptionWhenTryToSaveVisitBeforeWorkingHours() throws BusinessException {

        //given
        DoctorTO doctor = doctorService.getById(101L);
        PatientTO patient = patientService.findById(2L);

        VisitTO visitToSave = VisitTO.builder().withVisitStatus(VisitStatus.WAITING)
                .withDoctor(doctor)
                .withId(50L)
                .withPatient(patient)
                .withStartTime(LocalDateTime.of(2021, 06, 22, 7, 00))
                .withPrice(150d)
                .build();

        //when
        //then

        assertThrows(BusinessException.class, () -> {
            visitService.saveVisit(visitToSave);
        });

    }

    @Test
    @Transactional
    void shouldReturnBusinessExceptionWhenTryToSaveVisitAfterWorkingHours() throws BusinessException {

        //given
        DoctorTO doctor = doctorService.getById(101L);
        PatientTO patient = patientService.findById(2L);

        VisitTO visitToSave = VisitTO.builder().withVisitStatus(VisitStatus.WAITING)
                .withDoctor(doctor)
                .withId(50L)
                .withPatient(patient)
                .withStartTime(LocalDateTime.of(2021, 06, 22, 19, 15))
                .withPrice(150d)
                .build();

        //when
        //then

        assertThrows(BusinessException.class, () -> {
            visitService.saveVisit(visitToSave);
        });

    }


    @Test
    @Transactional
    void shouldReturnBusinessExceptionWhenTryToSaveVisitAfterTimeOfLastVisit() throws BusinessException {

        //given
        DoctorTO doctor = doctorService.getById(101L);
        PatientTO patient = patientService.findById(2L);

        VisitTO visitToSave = VisitTO.builder().withVisitStatus(VisitStatus.WAITING)
                .withDoctor(doctor)
                .withId(50L)
                .withPatient(patient)
                .withStartTime(LocalDateTime.of(2021, 06, 22, 17, 46))
                .withPrice(150d)
                .build();

        //when
        //then

        assertThrows(BusinessException.class, () -> {
            visitService.saveVisit(visitToSave);
        });

    }

    @Test
    @Transactional
    void shouldReturnBusinessExceptionWhenTryToSaveVisitWithMaleToGynecologist() throws BusinessException {

        //given
        DoctorTO doctor = doctorService.getById(103L);
        PatientTO patient = patientService.findById(2L);

        VisitTO visitToSave = VisitTO.builder().withVisitStatus(VisitStatus.WAITING)
                .withDoctor(doctor)
                .withId(50L)
                .withPatient(patient)
                .withStartTime(LocalDateTime.of(2021, 06, 22, 17, 00))
                .withPrice(150d)
                .build();

        //when
        //then

        assertThrows(BusinessException.class, () -> {
            visitService.saveVisit(visitToSave);
        });

    }

    @Test
    @Transactional
    void shouldReturnBusinessExceptionWhenTryToSaveVisitWithAdultToPediatrician() throws BusinessException {

        //given
        DoctorTO doctor = doctorService.getById(104L);
        PatientTO patient = patientService.findById(2L);

        VisitTO visitToSave = VisitTO.builder().withVisitStatus(VisitStatus.WAITING)
                .withDoctor(doctor)
                .withId(50L)
                .withPatient(patient)
                .withStartTime(LocalDateTime.of(2021, 06, 22, 17, 00))
                .withPrice(150d)
                .build();

        //when
        //then

        assertThrows(BusinessException.class, () -> {
            visitService.saveVisit(visitToSave);
        });

    }

    @Test
    @Transactional
    void shouldReturnBusinessExceptionWhenTryToSaveVisitWith18YearsOldToPediatrician() throws BusinessException {

        //given
        DoctorTO doctor = doctorService.getById(104L);
        PatientTO patient = patientService.findById(5L);

        VisitTO visitToSave = VisitTO.builder().withVisitStatus(VisitStatus.WAITING)
                .withDoctor(doctor)
                .withId(50L)
                .withPatient(patient)
                .withStartTime(LocalDateTime.of(2021, 06, 22, 17, 00))
                .withPrice(150d)
                .build();

        //when
        //then

        assertThrows(BusinessException.class, () -> {
            visitService.saveVisit(visitToSave);
        });

    }

    @Test
    @Transactional
    void shouldReturnUpdatedVisit() throws BusinessException {

        //given
        DoctorTO doctor = doctorService.getById(101L);
        PatientTO patient = patientService.findById(2L);
        VisitTO visit = visitService.getById(1L);

        VisitTO visitToSave = VisitTO.builder().withVisitStatus(VisitStatus.WAITING)
                .withDoctor(doctor)
                //   .withId(visit.getId())
                .withPatient(patient)
                .withStartTime(LocalDateTime.of(2021, 06, 22, 15, 00))
                .withPrice(150d)
                .build();

        //when
        VisitTO updatedVisit = visitService.updateVisit(visit.getId(), visitToSave);


        //then
        assertNotNull(updatedVisit);
        assertEquals(doctor.getFirstName(), updatedVisit.getDoctor().getFirstName());
        assertEquals(doctor.getLastName(), updatedVisit.getDoctor().getLastName());
        assertEquals(patient.getFirstName(), updatedVisit.getPatient().getFirstName());
        assertEquals(patient.getLastName(), updatedVisit.getPatient().getLastName());

    }

}

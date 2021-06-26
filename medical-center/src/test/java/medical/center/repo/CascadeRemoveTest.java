package medical.center.repo;

import com.capgemini.domain.*;
import medical.center.domain.*;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import javax.transaction.Transactional;

import static org.junit.jupiter.api.Assertions.*;


@SpringBootTest
public class CascadeRemoveTest {

    @Autowired
    private MedicalCenterRepo medicalCenterRepo;

    @Autowired
    private PatientRepo patientRepo;

    @Autowired
    private VisitRepo visitRepo;

    @Autowired
    private MedicalDutyRepo medicalDutyRepo;

    @Autowired
    private DoctorRepo doctorRepo;

    @Test
    @Transactional
    void shouldDeletePatientVisitAndDutyWhenDeleteMedicalCenter() {

        //given
        MedicalCenterEntity medicalCenter = medicalCenterRepo.getById(1L);
        PatientEntity patient = patientRepo.getById(1L);
        VisitEntity visit = visitRepo.getById(1L);
        MedicalDutyEntity medicalDuty = medicalDutyRepo.getById(1L);

        //when
        medicalCenterRepo.getEm().remove(medicalCenterRepo.getById(1L));

        //then
        assertNotNull(medicalCenter);
        assertNotNull(patient);
        assertNotNull(visit);
        assertNotNull(medicalDuty);

        assertNull(medicalCenterRepo.getById(1L));
        assertNull(patientRepo.getById(1L));
        assertNull(visitRepo.getById(1L));
        assertNull(medicalDutyRepo.getById(1L));

        assertTrue(patientRepo.findPatientEntitiesByMedicalCenterId(1L).isEmpty());
        assertTrue(visitRepo.findVisitEntityByPatientId(1L).isEmpty());
        assertTrue(medicalDutyRepo.findMedicalDutyEntityByMedicalCenterId(1L).isEmpty());

    }

    @Test
    @Transactional
    void shouldReturnPatientVisitAndDutyWhenDeleteMedicalCenter() {

        //given
        DoctorEntity doctor = doctorRepo.getById(101L);
        VisitEntity visit = visitRepo.getById(1L);
        MedicalDutyEntity medicalDuty = medicalDutyRepo.getById(1L);

        //when
        doctorRepo.deleteById(101L);

        //then
        assertNotNull(doctor);
        assertNotNull(visit);
        assertNotNull(medicalDuty);

        assertNull(doctorRepo.getById(101L));
        assertNull(visitRepo.getById(1L));
        assertNull(medicalDutyRepo.getById(1L));

        assertTrue(medicalDutyRepo.findMedicalDutyEntityByDoctorEntityId(101L).isEmpty());
        assertTrue(visitRepo.findVisitEntityByDoctorId(101L).isEmpty());

    }

}

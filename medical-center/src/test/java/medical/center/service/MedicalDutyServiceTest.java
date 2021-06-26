package medical.center.service;


import medical.center.exceptions.BusinessException;
import medical.center.types.DoctorTO;
import medical.center.types.MedicalCenterTO;
import medical.center.types.MedicalDutyTO;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import javax.transaction.Transactional;
import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertThrows;

@SpringBootTest
public class MedicalDutyServiceTest {

    @Autowired
    private MedicalDutyService medicalDutyService;

    @Autowired
    private DoctorService doctorService;

    @Autowired
    private MedicalCenterService medicalCenterService;


    @Test
    @Transactional
    void shouldReturnExceptionWhenTryToAddDutyForOneDoctorInTwoDifferentCetnersOneDay() {

        //given
        DoctorTO doctor = doctorService.getById(101L);
        MedicalCenterTO medicalCenterTO = medicalCenterService.getById(3L);

        MedicalDutyTO medicalDutyTO = MedicalDutyTO.build().withMedicalCenter(medicalCenterTO)
                .withDoctor(doctor)
                .withDate(LocalDate.of(2021, 06, 22))
                .build();


        //when then
        assertThrows(BusinessException.class, () -> {
            medicalDutyService.saveMedcalDuty(medicalDutyTO);
        });
    }

    @Test
    @Transactional
    void shouldReturnSavedMedicalDuty() throws BusinessException {

        //given
        DoctorTO doctor = doctorService.getById(101L);
        MedicalCenterTO medicalCenterTO = medicalCenterService.getById(3L);

        MedicalDutyTO medicalDutyTO = MedicalDutyTO.build().withMedicalCenter(medicalCenterTO)
                .withDoctor(doctor)

                .withDate(LocalDate.of(2021, 9, 25))
                .build();

        //when
        MedicalDutyTO savedDuty = medicalDutyService.saveMedcalDuty(medicalDutyTO);

        //then
        assertNotNull(savedDuty);
    }

    @Test
    @Transactional
    void shouldReturnUpdatedMedicalDuty() throws BusinessException {

        //given
        DoctorTO doctor = doctorService.getById(101L);
        MedicalCenterTO medicalCenterTO = medicalCenterService.getById(3L);
        MedicalDutyTO medicalDutyTO = medicalDutyService.getById(1L);

        MedicalDutyTO medicalDutyTOToUpdate = MedicalDutyTO.build().withMedicalCenter(medicalCenterTO)
                .withDoctor(doctor)
                .withId(medicalDutyTO.getId())
                .withDate(LocalDate.of(2021, 9, 25))
                .build();

        //when
        MedicalDutyTO savedDuty = medicalDutyService.updateMedicalDuty(medicalDutyTO.getId(), medicalDutyTOToUpdate);

        //then
        assertNotNull(savedDuty);
    }


    @Test
    @Transactional
    void shouldThrowExceptionWhenTryToUpdateSecondVisitOnOneDay() throws BusinessException {

        //given
        DoctorTO doctor = doctorService.getById(101L);
        MedicalCenterTO medicalCenterTO = medicalCenterService.getById(3L);
        MedicalDutyTO medicalDutyTO = medicalDutyService.getById(1L);

        MedicalDutyTO medicalDutyTOToUpdate = MedicalDutyTO.build().withMedicalCenter(medicalCenterTO)
                .withDoctor(doctor)
                .withId(medicalDutyTO.getId())
                .withDate(LocalDate.of(2021, 6, 22))
                .build();

        //then
        assertThrows(BusinessException.class, () -> {
            medicalDutyService.updateMedicalDuty(medicalDutyTO.getId(), medicalDutyTOToUpdate);
        });
    }
}

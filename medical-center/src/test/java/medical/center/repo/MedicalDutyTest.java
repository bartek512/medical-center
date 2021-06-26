package medical.center.repo;

import medical.center.domain.MedicalDutyEntity;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;


import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

@SpringBootTest
public class MedicalDutyTest {

    @Autowired
    private MedicalDutyRepo medicalDutyRepo;


    @Test
    void shouldReturnAllMedicalDutiesAssignedToMedicalCenter(){

        //when
        List<MedicalDutyEntity> resultList = medicalDutyRepo.findMedicalDutyEntityByMedicalCenterId(1L);

        //then
        assertEquals(1, resultList.size());
        assertTrue(resultList.get(0).getMedicalCenter().getId() == 1);
    }

    @Test
    void shouldReturnAllMedicalDutiesAssignedToDoctor(){

        //when
        List<MedicalDutyEntity> resultList = medicalDutyRepo.findMedicalDutyEntityByDoctorEntityId(101L);

        //then
        assertEquals(2, resultList.size());
        assertTrue(resultList.get(0).getDoctorEntity().getId() == 101);
        assertTrue(resultList.get(1).getDoctorEntity().getId() == 101);
    }
}

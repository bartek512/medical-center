package medical.center.service;

import medical.center.domain.Address;
import medical.center.domain.MedicalCenterEntity;
import medical.center.repo.MedicalCenterRepo;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.dao.OptimisticLockingFailureException;

import javax.transaction.Transactional;

import static org.junit.jupiter.api.Assertions.assertThrows;

@SpringBootTest
public class OptimisticLockingTest {

    @Autowired
    private MedicalCenterRepo medicalCenterRepo;

    @Test
    @Transactional
    void shouldReturnOptimisticLockingException() {

        //given
        MedicalCenterEntity medicalCenterEntity = medicalCenterRepo.findById(1l).orElseThrow();

        medicalCenterRepo.getEm().detach(medicalCenterEntity);

        MedicalCenterEntity medicalCenterEntity2 = medicalCenterRepo.findById(1L).orElseThrow();

        Address address = new Address();
        address.setCity("Wroclaw");
        address.setPostalCode("12=434");
        address.setStreet("Kosciuszki");

        Address address2 = new Address();
        address.setCity("Wroclaw");
        address.setPostalCode("12=434");
        address.setStreet("Reymonta");


        medicalCenterEntity2.setAddress(address);

        medicalCenterRepo.getEm().flush();

        medicalCenterEntity.setAddress(address2);

        //then
        assertThrows(OptimisticLockingFailureException.class, () -> {
            medicalCenterRepo.save(medicalCenterEntity);
        });


    }
}

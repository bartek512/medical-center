package medical.center.service.impl;

import medical.center.mappers.MedicalCenterMapper;
import medical.center.repo.MedicalCenterRepo;
import medical.center.service.MedicalCenterService;
import medical.center.types.MedicalCenterTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Service
@Transactional
public class MedicalCenterServiceImpl implements MedicalCenterService {

    @Autowired
    private MedicalCenterRepo medicalCenterRepo;

    @Override
    public MedicalCenterTO getById(Long id) {
        return MedicalCenterMapper.toMedicalCenterTO(medicalCenterRepo.findById(id).orElseThrow());
    }
}

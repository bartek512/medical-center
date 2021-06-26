package medical.center.service.impl;

import medical.center.mappers.PatientMapper;
import medical.center.repo.PatientRepo;
import medical.center.service.PatientService;
import medical.center.types.PatientTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Service
@Transactional
public class PatientServiceImpl implements PatientService {


    @Autowired
    private PatientRepo patientRepo;

    @Override
    public PatientTO findById(Long id) {
        return PatientMapper.toPatientTO(patientRepo.findById(id).orElseThrow());
    }
}

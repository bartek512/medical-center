package medical.center.service.impl;


import medical.center.domain.DoctorEntity;
import medical.center.mappers.DoctorMapper;
import medical.center.repo.DoctorRepo;
import medical.center.service.DoctorService;
import medical.center.types.DoctorTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class DoctorServiceImpl implements DoctorService {

    @Autowired
    private DoctorRepo doctorRepo;


    @Override
    public DoctorTO getById(Long id) {
        return DoctorMapper.toDoctorTO(doctorRepo.findById(id).orElseThrow());
    }


    @Override
    public DoctorTO save(DoctorTO doctorTO) {
        DoctorEntity savedDoctor = doctorRepo.save(DoctorMapper.toDoctorEntity(doctorTO));
        return DoctorMapper.toDoctorTO(savedDoctor);
    }

    @Override
    public void deleteById(Long id) {
        doctorRepo.deleteById(id);
    }
}

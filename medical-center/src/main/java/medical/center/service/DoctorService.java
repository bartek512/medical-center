package medical.center.service;

import medical.center.types.DoctorTO;

public interface DoctorService {

    DoctorTO getById(Long id);

    DoctorTO save(DoctorTO doctorTO);

    void deleteById(Long id);
}

package medical.center.service;

import medical.center.types.PatientTO;

public interface PatientService {

    PatientTO findById(Long id);
}

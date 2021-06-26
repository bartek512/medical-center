package medical.center.repo.impl;

import medical.center.domain.PatientEntity;
import medical.center.repo.CustomizedPatientRepository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.time.LocalDateTime;
import java.util.List;

public class PatientRepoImpl implements CustomizedPatientRepository {


    @PersistenceContext
    private EntityManager em;

    /**
     * Returns patient with biggest count of cancelled visits between dates
     */
    @Override
    public List<PatientEntity> getMostCancelledVisitPatient(LocalDateTime startDate, LocalDateTime endDate) {
        List<PatientEntity> resultList = em.createNamedQuery("Patient.GetPatientsWithMaxCancelledVisits", PatientEntity.class)
                .setParameter("startDate", startDate)
                .setParameter("endDate", endDate)
                .getResultList();
        return resultList;
    }

}

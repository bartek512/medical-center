package medical.center.repo.impl;

import medical.center.domain.DoctorEntity;
import medical.center.repo.CustomizedDoctorRepository;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

@Repository
public class DoctorRepoImpl implements CustomizedDoctorRepository {

    @PersistenceContext
    private EntityManager em;

    /**
     * Returns doctor with lowest count of visits between dates
     *
     * @param startDate start date
     * @param endDate   end date
     */
    @Override
    public List<DoctorEntity> getDoctorWithLowestCountOfVisits(LocalDateTime startDate, LocalDateTime endDate) {
        List<DoctorEntity> resultList = em.createNamedQuery("Doctor.GetDoctorWithLowestCountOfVisits", DoctorEntity.class)
                .setParameter("startDate", startDate)
                .setParameter("endDate", endDate)
                .getResultList();
        return resultList;
    }

    /**
     * Returns all doctors assigned only to this medical center
     *
     * @param medicalCenterId medical center id
     */
    @Override
    public List<DoctorEntity> getDoctorsAssignedToOnlyOneMedicalCenter(Long medicalCenterId) {
        List<DoctorEntity> resultList = em.createNamedQuery("Doctor.GetDoctorsAssignedToOneMedicalCenter", DoctorEntity.class)
                .setParameter("id", medicalCenterId)
                .getResultList();
        return resultList;
    }

    /**
     * Returns count of visits most visited doctors ever
     */
    @Override
    public List<Long> getCountOfVisitsTwoMostVisitedDoctors() {
        List<Long> resultList = em.createNamedQuery("Doctor.GetCountOfVisitsTwoMostVisitedDoctors", Long.class).setMaxResults(2).getResultList();
        return resultList;
    }

    /**
     * Returns two most visited doctors ever
     */
    @Override
    public List<DoctorEntity> getTwoMostVisitedDoctors() {
        List<Integer> countList = getCountOfVisitsTwoMostVisitedDoctors().stream().map(Long::intValue).collect(Collectors.toList());

        List<DoctorEntity> resultList = em.createNamedQuery("Doctor.GetTwoMostVisitedDoctors", DoctorEntity.class)
                .setParameter("counts", countList)
                .getResultList();
        return resultList;
    }

    /**
     * Returns doctors with most cancelled visits
     */
    @Override
    public List<DoctorEntity> getDoctorWithMostCancelledVisits() {
        List<DoctorEntity> resultList = em.createNamedQuery("Doctor.WithMostCancelledVisits", DoctorEntity.class).getResultList();
        return resultList;
    }


}

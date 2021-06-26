package medical.center.repo.impl;

import medical.center.domain.DoctorEntity;
import medical.center.domain.VisitEntity;
import medical.center.repo.CustomizedVisitRepository;
import medical.center.types.VisitCriteria;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.*;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class VisitRepoImpl implements CustomizedVisitRepository {

    @PersistenceContext
    private EntityManager em;

    /**
     * Returns sumaric costs of visist for patient between dates
     */
    @Override
    public Double getSumaricCostOfVisit(Long patientId, LocalDateTime startDate, LocalDateTime endDate) {
        Double result = em.createNamedQuery("Visit.GetSumCostOfVisit", Double.class)
                .setParameter("id", patientId).setParameter("startDate", startDate).setParameter("endDate", endDate).getSingleResult();
        return result;

    }

    /**
     * Searching visits by criteria
     *
     * @param visitCrtiteria object which contains criteria to search
     */
    @Override
    public List<VisitEntity> findVisitByCriteria(VisitCriteria visitCrtiteria) {

        CriteriaBuilder queryBuilder = em.getCriteriaBuilder();
        CriteriaQuery<VisitEntity> criteriaQuery = queryBuilder.createQuery(VisitEntity.class);
        Root<VisitEntity> rootQuery = criteriaQuery.from(VisitEntity.class);
        List<Predicate> predicateList = new ArrayList<>();

        Join<VisitEntity, DoctorEntity> visitDoctor = rootQuery.join("doctor");

        if (visitCrtiteria.getVisitStatus() != null) {
            Predicate visitPredicate = queryBuilder.equal(rootQuery.get("visitStatus"), visitCrtiteria.getVisitStatus());
            predicateList.add(visitPredicate);
        }

        if (visitCrtiteria.getDoctorFirstName() != null) {
            Predicate visitPredicate = queryBuilder.like(rootQuery.get("doctor").get("firstName"), "%" + visitCrtiteria.getDoctorFirstName() + "%");
            predicateList.add(visitPredicate);
        }

        if (visitCrtiteria.getDoctorLastName() != null) {
            Predicate visitPredicate = queryBuilder.like(rootQuery.get("doctor").get("lastName"), "%" + visitCrtiteria.getDoctorLastName() + "%");
            predicateList.add(visitPredicate);
        }

        if (visitCrtiteria.getPatientLastName() != null) {
            Predicate visitPredicate = queryBuilder.equal(rootQuery.get("patient").get("lastName"), visitCrtiteria.getPatientLastName());
            predicateList.add(visitPredicate);
        }

        if (visitCrtiteria.getPatientFirstName() != null) {
            Predicate visitPredicate = queryBuilder.equal(rootQuery.get("patient").get("firstName"), visitCrtiteria.getPatientFirstName());
            predicateList.add(visitPredicate);
        }

        if (visitCrtiteria.getStartTime() != null && visitCrtiteria.getEndTime() != null) {
            Predicate datePredicate = queryBuilder.between(rootQuery.get("startTime"), visitCrtiteria.getStartTime(), visitCrtiteria.getEndTime());
            predicateList.add(datePredicate);
        }
        if (visitCrtiteria.getStartTime() != null && visitCrtiteria.getEndTime() == null) {
            Predicate datePredicate = queryBuilder.greaterThanOrEqualTo(rootQuery.get("startTime"), visitCrtiteria.getStartTime());
            predicateList.add(datePredicate);
        }
        if (visitCrtiteria.getStartTime() == null && visitCrtiteria.getEndTime() != null) {
            Predicate datePredicate = queryBuilder.lessThanOrEqualTo(rootQuery.get("startTime"), visitCrtiteria.getEndTime());
            predicateList.add(datePredicate);
        }


        Predicate[] predicateArray = predicateList.toArray(Predicate[]::new);
        criteriaQuery.select(rootQuery).where(predicateArray).distinct(true);
        TypedQuery<VisitEntity> typedQuery = em.createQuery(criteriaQuery);

        return typedQuery.getResultList();

    }


}

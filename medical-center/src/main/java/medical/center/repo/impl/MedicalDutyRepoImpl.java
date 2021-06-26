package medical.center.repo.impl;

import medical.center.repo.CustomizedMedicalDutyRepo;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

public class MedicalDutyRepoImpl implements CustomizedMedicalDutyRepo {

    @PersistenceContext
    private EntityManager em;

    @Override
    public EntityManager getEm() {
        return em;
    }
}

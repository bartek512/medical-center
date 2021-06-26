package medical.center.repo.impl;


import medical.center.repo.CustomizedMedicalCenterRepository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;


public class MedicalCenterRepoImpl implements CustomizedMedicalCenterRepository {

    @PersistenceContext
    private EntityManager em;

    @Override
    public EntityManager getEm() {
        return em;
    }

}

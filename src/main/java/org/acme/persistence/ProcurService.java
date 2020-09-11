package org.acme.persistence;

import java.util.List;
import java.util.stream.Stream;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.transaction.Transactional;

import org.acme.persistence.entity.ProcurementEntity;

@ApplicationScoped
public class ProcurService {
    @Inject
    EntityManager em;

    public Stream<ProcurementEntity> getAllData() {
        return em.createQuery("select p from ProcurementEntity p",ProcurementEntity.class).getResultStream();
    }
}

package com.proyect.appgateway.repository.implementation;

import com.proyect.appgateway.models.AccessPermits;
import com.proyect.appgateway.models.AccessPermits_;
import com.proyect.appgateway.models.User;
import com.proyect.appgateway.models.User_;
import com.proyect.appgateway.repository.AccessPermitsCriteriaRepository;
import jakarta.persistence.EntityManager;
import jakarta.persistence.criteria.*;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class AccessPermitsCriteriaRepositoryImpl implements AccessPermitsCriteriaRepository {

    private EntityManager em;

    @Autowired
    public AccessPermitsCriteriaRepositoryImpl(EntityManager em) {
        this.em = em;
    }

    @Override
    public List<AccessPermits> getAccessPermitsByEmailUser(String email) {
        CriteriaBuilder cb = em.getCriteriaBuilder();
        CriteriaQuery<AccessPermits> cq = cb.createQuery(AccessPermits.class);

        List<Predicate> predicateList = new ArrayList<>();
        Root<AccessPermits> accessPermitsRoot = cq.from(AccessPermits.class);
        Join<User, AccessPermits> userAccessPermitsJoin = accessPermitsRoot.join(AccessPermits_.USER, JoinType.INNER);

        if (Objects.nonNull(email))
            predicateList.add(cb.equal(userAccessPermitsJoin.get(User_.EMAIL), email));

        if (!predicateList.isEmpty()) {
            cq.where(predicateList.toArray(new Predicate[0]));
            return em.createQuery(cq).getResultList();
        }
        return new ArrayList<>();
    }
}

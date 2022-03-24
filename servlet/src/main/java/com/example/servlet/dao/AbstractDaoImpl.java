package com.example.servlet.dao;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import javax.transaction.Transactional;
import java.util.List;

public abstract class AbstractDaoImpl<T, PK> implements AbstractDao<T,PK> {
    private final Class<T> cl;
    @PersistenceContext
    protected EntityManager entityManager;

    public AbstractDaoImpl(Class<T> cl) {
        this.cl = cl;
    }

    @Override
    public List<T> findAll() {
        CriteriaBuilder cb = entityManager.getCriteriaBuilder();
        CriteriaQuery<T> cq = cb.createQuery(cl);
        Root<T> root = cq.from(cl);
        CriteriaQuery<T> select = cq.select(root);
        return entityManager.createQuery(select).getResultList();
    }

    @Override
    @Transactional
    public <S extends T> void save(S entity) {
        entityManager.persist(entity);
    }

    @Override
    public T findById(PK pk) {
        return entityManager.find(cl, pk);
    }

    @Override
    public void delete(T entity) {
        entityManager.remove(entity);
    }

    @Override
    @Transactional
    public <S extends T> void saveAllAndFlush(Iterable<S> entities) {
        entities.forEach(s -> entityManager.persist(s));
        entityManager.flush();
    }

}

package com.example.consoleapp.service;


import com.example.consoleapp.dao.AbstractDao;

import java.util.List;

public abstract class AbstractServiceImpl<T, PK> implements AbstractService<T, PK>{
    protected final AbstractDao<T, PK> abstractDao;

    protected AbstractServiceImpl(AbstractDao<T, PK> abstractDao) {
        this.abstractDao = abstractDao;
    }
    @Override
    public void save(T t) {
        abstractDao.save(t);
    }

    @Override
    public T findById(PK id) {
        return abstractDao.findById(id);
    }

    @Override
    public List<T> findAll() {
        return abstractDao.findAll();
    }

    @Override
    public void update(T t) {
        abstractDao.save(t);
    }

    @Override
    public void delete(T t) {
        abstractDao.delete(t);
    }

    @Override
    public void saveAllAndFlush(Iterable<T> list) {
        abstractDao.saveAllAndFlush(list);
    }
}

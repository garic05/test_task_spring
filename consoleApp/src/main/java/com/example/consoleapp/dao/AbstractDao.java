package com.example.consoleapp.dao;

import java.util.List;

public interface AbstractDao<T, PK>  {
    List<T> findAll();

    <S extends T> void save(S entity);

    T findById(PK pk);

    void delete(T entity);

    <S extends T> void saveAllAndFlush(Iterable<S> entities);
}

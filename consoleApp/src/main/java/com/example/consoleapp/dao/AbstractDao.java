package com.example.consoleapp.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.NoRepositoryBean;

import java.util.List;
import java.util.Optional;

@NoRepositoryBean
public interface AbstractDao<T, PK> extends JpaRepository<T, PK> {
    @Override
    List<T> findAll();

    @Override
    <S extends T> S save(S entity);

    @Override
    Optional<T> findById(PK pk);

    @Override
    void delete(T entity);

    @Override
    <S extends T> List<S> saveAllAndFlush(Iterable<S> entities);
}

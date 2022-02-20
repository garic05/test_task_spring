package com.example.servlet.service;

import java.util.List;

public interface AbstractService<T, PK> {
    public void save(T t);
    public T findById(PK id);
    public List<T> findAll();
    public void update(T t);
    public void delete(T t);
    public void saveAllAndFlush(Iterable<T> list);
}

package me.puras.mo.common.service;

import me.puras.mo.common.pagination.ListBounds;
import me.puras.mo.common.pagination.ListSlice;

import java.util.List;

public interface CrudService<T> {
    List<T> findAll();
    ListSlice<T> findAll(ListBounds bounds);
    T findById(Long id);
    void create(T t);
    int update(T t);
    int delete(Long id);
    long countAll();
}

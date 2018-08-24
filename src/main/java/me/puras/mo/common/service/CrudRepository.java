package me.puras.mo.common.service;

import me.puras.mo.common.pagination.ListBounds;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface CrudRepository<T> {
    List<T> findAll();
    List<T> findAll(@Param(ListBounds.NAME) ListBounds bounds);
    List<Long> findAllIds(@Param(ListBounds.NAME) ListBounds bounds);
    T findById(Long id);
    void create(T t);
    int update(T t);
    int delete(Long id);
    long countAll();
}

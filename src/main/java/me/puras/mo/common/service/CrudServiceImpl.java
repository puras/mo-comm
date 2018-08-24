package me.puras.mo.common.service;

import me.puras.mo.common.domain.DomainModel;
import me.puras.mo.common.pagination.ListBounds;
import me.puras.mo.common.pagination.ListSlice;

import java.util.List;

public abstract class CrudServiceImpl<T> implements CrudService<T> {
    public abstract CrudRepository<T> getRepository();

    @Override
    public List<T> findAll() {
        return getRepository().findAll();
    }

    @Override
    public ListSlice<T> findAll(ListBounds bounds) {
        List<T> ts = getRepository().findAll(bounds);
        long total = getRepository().countAll();
        return new ListSlice(total, ts);
    }

    @Override
    public T findById(Long id) {
        return getRepository().findById(id);
    }

    @Override
    public void create(T t) {
        if (t instanceof DomainModel) {
            ((DomainModel) t).defaultValue();
            if (null == ((DomainModel) t).getCreatedAt()) {
                ((DomainModel) t).createDefaultValue();
            }
        }
        getRepository().create(t);
    }

    @Override
    public int update(T t) {
        if (t instanceof DomainModel && null == ((DomainModel) t).getUpdatedAt()) {
            ((DomainModel) t).updateDefaultValue();
        }
        return getRepository().update(t);
    }

    @Override
    public int delete(Long id) {
        return getRepository().delete(id);
    }

    @Override
    public long countAll() {
        return getRepository().countAll();
    }
}

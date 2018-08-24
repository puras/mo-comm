package me.puras.mo.common.controller;

import me.puras.mo.common.domain.DomainModel;
import me.puras.mo.common.error.ErrCode;
import me.puras.mo.common.json.Response;
import me.puras.mo.common.json.ResponseHelper;
import me.puras.mo.common.pagination.ClientListSlice;
import me.puras.mo.common.pagination.ListSlice;
import me.puras.mo.common.pagination.Pagination;
import me.puras.mo.common.service.CrudService;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

public abstract class CrudController<T> extends BaseController {
    public abstract CrudService<T> getService();

    protected boolean beforeCheck(T t) {
        return true;
    }

    protected void doCreateBefore(T t) {}
    protected void doUpdateBefore(T t) {}

    @GetMapping("")
    public Response<ClientListSlice<T>> list(Pagination pagination) {
        ListSlice<T> slice = getService().findAll(getBounds(pagination));
        return updateResultResponse(pagination, slice);
    }

    @GetMapping("{id}")
    public Response<T> detail(@PathVariable("id") Long id) {
        T t = getService().findById(id);

        notFoundIfNull(t);

        return ResponseHelper.createSuccessResponse(t);
    }

    @PostMapping("")
    public Response<T> create(@Valid @RequestBody T t, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            return ResponseHelper.createResponse(ErrCode.DATA_BIND_ERR.getCode(), ErrCode.DATA_BIND_ERR.getDesc());
        }
        if (!beforeCheck(t)) {
            return ResponseHelper.createResponse(ErrCode.DATA_ALREADY_EXIST.getCode(), ErrCode.DATA_ALREADY_EXIST.getDesc());
        }

        doCreateBefore(t);

        getService().create(t);

        return ResponseHelper.createSuccessResponse(t);
    }

    @PutMapping("{id}")
    public Response<T> update(@PathVariable("id") Long id, @RequestBody T t) {
        T oldT = getService().findById(id);
        notFoundIfNull(oldT);

        if (t instanceof DomainModel) {
            ((DomainModel)t).setId(id);
        }

        if (!beforeCheck(t)) {
            return ResponseHelper.createResponse(ErrCode.DATA_ALREADY_EXIST.getCode(), ErrCode.DATA_ALREADY_EXIST.getDesc());
        }

        doUpdateBefore(t);

        getService().update(t);

        return ResponseHelper.createSuccessResponse(t);
    }

    @DeleteMapping("{id}")
    public Response<Boolean> delete(@PathVariable("id") Long id) {
        T t = getService().findById(id);
        notFoundIfNull(t);

        int result = getService().delete(id);
        return ResponseHelper.createSuccessResponse(result > 0 ? true : false);
    }
}
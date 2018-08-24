package me.puras.mo.common.controller;

import me.puras.mo.common.error.NotFoundException;
import me.puras.mo.common.json.Response;
import me.puras.mo.common.json.ResponseHelper;
import me.puras.mo.common.pagination.ClientListSlice;
import me.puras.mo.common.pagination.ListBounds;
import me.puras.mo.common.pagination.ListSlice;
import me.puras.mo.common.pagination.Pagination;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;

import java.util.List;
import java.util.Locale;

public class BaseController {

    @Autowired
    public MessageSource messageSource;

    public static final Locale DEFAULT_LOCALE = Locale.SIMPLIFIED_CHINESE;

    protected ListBounds getBounds(Pagination pagination) {
        return new ListBounds(pagination.getStartIndex(), pagination.getPageSize());
    }

    protected ClientListSlice<?> getClientListSlice(Pagination pagination, ListSlice<?> slice) {
        if (null == slice) return null;
        pagination.setTotalCount(Long.valueOf(slice.getTotal()));
        return new ClientListSlice(slice, pagination.getCurrentPage(), pagination.getPageSize());
    }

    protected ClientListSlice<?> getClientListSlice(ListSlice<?> slice) {
        if (null == slice) return null;
        return new ClientListSlice(slice, 0L, slice.getTotal());
    }

    protected Response updateResultResponse(Response resp, Pagination pagination, ListSlice slice) {
        resp.setPayload(getClientListSlice(pagination, slice));
        return resp;
    }

    protected Response updateResultResponse(Pagination pagination, ListSlice slice) {
        Response resp = ResponseHelper.createSuccessResponse();
        return updateResultResponse(resp, pagination, slice);
    }

    protected Response updateResultResponse(List list) {
        Response resp = ResponseHelper.createSuccessResponse();
        resp.setPayload(list);
        return resp;
    }

    protected String getMessage(String key) {
        return messageSource.getMessage(key, null, DEFAULT_LOCALE);
    }

    public String getMessage(String key, Object[] objs) {
        return messageSource.getMessage(key, objs, DEFAULT_LOCALE);
    }

    protected static void notFoundIfNull(Object obj) {
        if (null == obj) {
            notFound();
        }
    }

    protected static void notFoundIfNull(Object obj, String message) {
        if (null == obj) {
            notFound(message);
        }
    }

    protected static void notFound() {
        notFound("您访问的数据不存在");
    }

    protected static void notFound(String message) {
        throw new NotFoundException(message);
//        throw new NotFoundException(ErrCode.DATA_NOT_FOUND_ERR.getDesc());
    }
}
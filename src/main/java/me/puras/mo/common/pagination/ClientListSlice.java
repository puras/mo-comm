package me.puras.mo.common.pagination;

import java.util.Collections;
import java.util.List;

/**
 * @author puras <he@puras.me>
 * @since 16/1/14  下午12:59
 */
public class ClientListSlice<T> {
    private final static ClientListSlice EMPTY_SLICE = new ClientListSlice(0, 0, 0, Collections.emptyList());
    private final static int DEFAULT_PAGESIZE = 20;
    private final long currentPage;
    private final long totalPages;
    private final long totalCount;

    private final List<T> list;

    public ClientListSlice() {
        this.currentPage = 0;
        this.totalPages = 0;
        this.totalCount = 0;
        this.list = null;
    }

    public ClientListSlice(ListSlice<T> source, long curPage, long pageSize) {
        assert pageSize > 0;
        if (null == source) source = ListSlice.emptySlice();
        if (pageSize < 1) pageSize = DEFAULT_PAGESIZE; // 这块。。。。需要处理
        long total = source.getTotal();
        this.currentPage = curPage;
        this.totalPages = total / pageSize + (total % pageSize > 0 ? 1 : 0);
        this.totalCount = source.getTotal();
        this.list = source.getList();
    }

    public ClientListSlice(long currentPage, long totalPages, long totalCount, List list) {
        this.currentPage = currentPage;
        this.totalPages = totalPages;
        this.totalCount = totalCount;
        this.list = list;
    }

    public long getCurrentPage() {
        return currentPage;
    }

    public long getTotalPages() {
        return totalPages;
    }

    public long getTotalCount() {
        return totalCount;
    }

    public List<T> getList() {
        return list;
    }

    @Override
    public String toString() {
        return "ClientListSlice{" +
                "currentPage=" + currentPage +
                ", totalPages=" + totalPages +
                ", totalCount=" + totalCount +
                ", list=" + list +
                '}';
    }

    public static <T> ClientListSlice<T> emptySlice() {
        return (ClientListSlice<T>) EMPTY_SLICE;
    }
}

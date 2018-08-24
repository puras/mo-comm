package me.puras.mo.common.pagination;

import java.util.Collections;
import java.util.List;

/**
 * @author puras <he@puras.me>
 * @since 16/1/14  下午12:49
 */
public class ListSlice<T> {

    private static final ListSlice EMPTY_SLICE = new ListSlice(0, Collections.emptyList());

    private final long total;
    private final List<T> list;

    public ListSlice(long total, List<T> list) {
        this.total = total;
        this.list = list;
    }

    public long getTotal() {
        return total;
    }

    public List<T> getList() {
        return list;
    }

    @Override
    public String toString() {
        return "ListSlice [getTotal()=" + getTotal() + ", getList()="
                + getList() + "]";
    }

    public static <T> ListSlice<T> emptySlice() {
        return (ListSlice<T>) EMPTY_SLICE;
    }
}

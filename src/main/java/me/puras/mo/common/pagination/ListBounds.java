package me.puras.mo.common.pagination;

/**
 * @author puras <he@puras.me>
 * @since 16/1/14  上午11:28
 */
public class ListBounds {
    public static final String NAME = "bounds";
    private final static int NO_ROW_OFFSET = 0;
    private final static int NO_ROW_LIMIT = Integer.MAX_VALUE;
    public final static ListBounds DEFAULT = new ListBounds();

    private final int offset;
    private final int limit;

    public ListBounds() {
        this.offset = NO_ROW_OFFSET;
        this.limit = NO_ROW_LIMIT;
    }

    public ListBounds(int offset, int limit) {
        this.offset = offset;
        this.limit = limit;
    }

    public int getOffset() {
        return offset;
    }

    public int getLimit() {
        return limit;
    }
}

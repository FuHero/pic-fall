package cn.server.lab.model;

/**
 * Created by Fu Zhong on 2015/8/14.
 */
public class Pagination {
    /** 起点 **/
    private Integer offset;
    /** 数量 **/
    private Integer limit;

    public Integer getOffset() {
        return offset;
    }

    public void setOffset(Integer offset) {
        this.offset = offset;
    }

    public Integer getLimit() {
        return limit;
    }

    public void setLimit(Integer limit) {
        this.limit = limit;
    }
}

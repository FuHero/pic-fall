package cn.server.lab.model;

import com.alibaba.fastjson.JSON;

import java.util.Collection;

/**
 * Created by Fu Zhong on 2015/8/14.
 */
public class Result {

    private boolean state;
    private String msg;
    private Integer total;
    private Collection<? extends Object> rows;
    private Object obj;

    public boolean isState() {
        return state;
    }

    public void setState(boolean state) {
        this.state = state;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public Integer getTotal() {
        return total;
    }

    public void setTotal(Integer total) {
        this.total = total;
    }

    public Collection<? extends Object> getRows() {
        return rows;
    }

    public void setRows(Collection<? extends Object> rows) {
        this.rows = rows;
    }

    public Object getObj() {
        return obj;
    }

    public void setObj(Object obj) {
        this.obj = obj;
    }

    public static String toJSONFailResult (String msg) {
        Result result = new Result();
        result.setState(false);
        result.setMsg(msg);
        return JSON.toJSONString(result);
    }

    public static String toJSONSuccessResult (Object obj) {
        Result result = new Result();
        result.setState(true);
        result.setObj(obj);
        return JSON.toJSONString(result);
    }

    public static String toJSONSuccessResult (int total, Collection<? extends Object> rows) {
        Result result = new Result();
        result.setState(true);
        result.setRows(rows);
        result.setTotal(total);
        return JSON.toJSONString(result);
    }
}

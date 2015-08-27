package cn.server.lab.model;

import java.util.List;

/**
 * Created by Fu Zhong on 2015/7/4.
 */
public interface BaseDAO<T> {
    void create (T t);
    void update (T t);
    void delete (String id);
    List<T> query (T t);
    int total (T t);
}

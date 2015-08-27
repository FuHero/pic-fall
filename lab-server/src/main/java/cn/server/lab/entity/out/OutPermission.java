package cn.server.lab.entity.out;

import cn.server.lab.entity.Permission;

import java.util.List;

/**
 * Created by Fu Zhong on 2015/8/16.
 */
public class OutPermission extends Permission {
    private List<Permission> children;

    public List<Permission> getChildren() {
        return children;
    }

    public void setChildren(List<Permission> children) {
        this.children = children;
    }
}

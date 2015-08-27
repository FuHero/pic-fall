/***********************************************************************
 * Module:  lab_permission.java
 * Author:  Fu Zhong
 * Purpose: Defines the Class lab_permission
 ***********************************************************************/
package cn.server.lab.entity;

import cn.server.lab.model.Pagination;

import java.io.Serializable;

public class Permission extends Pagination implements Serializable {
    private static final long serialVersionUID = 5906576393449532102L;
    //主键ID
    private String id;
    //功能名称
    private String name;
    //权限名称
    private String permissionName;
    //功能请求URL
    private String url;
    //功能顺序
    private String sequence;
    //功能的类型
    private String type;
    //功能是否有效
    private String visible;
    //父级的ID
    private String parentId;
    //添加时间
    private String addTime;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPermissionName() {
        return permissionName;
    }

    public void setPermissionName(String permissionName) {
        this.permissionName = permissionName;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getSequence() {
        return sequence;
    }

    public void setSequence(String sequence) {
        this.sequence = sequence;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getVisible() {
        return visible;
    }

    public void setVisible(String visible) {
        this.visible = visible;
    }

    public String getParentId() {
        return parentId;
    }

    public void setParentId(String parentId) {
        this.parentId = parentId;
    }

    public String getAddTime() {
        return addTime;
    }

    public void setAddTime(String addTime) {
        this.addTime = addTime;
    }
}
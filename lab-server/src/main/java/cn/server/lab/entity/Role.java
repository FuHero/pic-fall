/***********************************************************************
 * Module:  lab_role.java
 * Author:  Fu Zhong
 * Purpose: Defines the Class lab_role
 ***********************************************************************/
package cn.server.lab.entity;

import cn.server.lab.model.Pagination;

import java.io.Serializable;
import java.util.Date;

public class Role extends Pagination implements Serializable {
    private static final long serialVersionUID = -7711854228144671515L;
    //主键ID
    private String id;
    //角色名称
    private String name;
    //角色描述
    private String descr;
    //备注
    private String remark;
    //创建时间
    private String addTime;
    //角色具有的权限的ID数组
    private String arrayPermissionId;
    //添加用户的ID
    private String createUserId;

    public Role () {}

    public Role(String id, String name) {
        this.id = id;
        this.name = name;
    }

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

    public String getDescr() {
        return descr;
    }

    public void setDescr(String descr) {
        this.descr = descr;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

    public String getAddTime() {
        return addTime;
    }

    public void setAddTime(String addTime) {
        this.addTime = addTime;
    }

    public String getArrayPermissionId() {
        return arrayPermissionId;
    }

    public void setArrayPermissionId(String arrayPermissionId) {
        this.arrayPermissionId = arrayPermissionId;
    }

    public String getCreateUserId() {
        return createUserId;
    }

    public void setCreateUserId(String createUserId) {
        this.createUserId = createUserId;
    }
}
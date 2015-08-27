/***********************************************************************
 * Module:  lab_depot.java
 * Author:  Fu Zhong
 * Purpose: Defines the Class lab_depot
 ***********************************************************************/
package cn.server.lab.entity;

import cn.server.lab.model.Pagination;

import java.io.Serializable;
import java.util.Date;

public class Depot extends Pagination implements Serializable {
    private static final long serialVersionUID = -6023256688582503294L;
    //仓库主键ID
    private String id;
    //仓库名称
    private String name;
    //仓库地址
    private String address;
    //仓库描述
    private String descr;
    //备注
    private String remark;
    //仓库添加时间
    private Date addTime;

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

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
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

    public Date getAddTime() {
        return addTime;
    }

    public void setAddTime(Date addTime) {
        this.addTime = addTime;
    }
}
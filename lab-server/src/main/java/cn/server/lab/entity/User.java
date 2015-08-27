/***********************************************************************
 * Module:  lab_user.java
 * Author:  Fu Zhong
 * Purpose: Defines the Class lab_user
 ***********************************************************************/
package cn.server.lab.entity;

import cn.server.lab.model.Pagination;

import java.io.Serializable;
import java.util.Date;

public class User extends Pagination implements Serializable {
    private static final long serialVersionUID = -860887716992715408L;
    //主键
    public String id;
    //登录用户名
    private String username;
    //登录密码
    private String password;
    //用户姓名
    private String name;
    //用户出生日期
    private String birth;
    // 用户性别
    private String sex;
    //用户联系电话
    private String phone;
    //用户地址
    private String address;
    //备注
    private String remark;
    //用户具有的角色ID数组
    private String arrayRoleId;
    //添加时间
    private String addTime;
    // 锁定状态
    private Boolean isLock;
    // 删除状态
    private Boolean isDelete;

    public User () {}

    public User(String username) {
        this.username = username;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getBirth() {
        return birth;
    }

    public void setBirth(String birth) {
        this.birth = birth;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

    public String getArrayRoleId() {
        return arrayRoleId;
    }

    public void setArrayRoleId(String arrayRoleId) {
        this.arrayRoleId = arrayRoleId;
    }

    public String getAddTime() {
        return addTime;
    }

    public void setAddTime(String addTime) {
        this.addTime = addTime;
    }

    public Boolean getIsLock() {
        return isLock;
    }

    public void setIsLock(Boolean isLock) {
        this.isLock = isLock;
    }

    public Boolean getIsDelete() {
        return isDelete;
    }

    public void setIsDelete(Boolean isDelete) {
        this.isDelete = isDelete;
    }
}
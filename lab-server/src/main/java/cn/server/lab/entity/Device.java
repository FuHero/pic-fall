/***********************************************************************
 * Module:  lab_device.java
 * Author:  Fu Zhong
 * Purpose: Defines the Class lab_device
 ***********************************************************************/
package cn.server.lab.entity;

import cn.server.lab.model.Pagination;

import java.io.Serializable;
import java.util.Date;

public class Device extends Pagination implements Serializable {
    private static final long serialVersionUID = 5802874831505878452L;
    //设备主键ID
    private String id;
    //设备名称
    private String name;
    //设备编号
    private String code;
    //设备条形码
    private String barcode;
    //设备状态
    private String status;
    //设备仓库ID
    private String depotId;
    //设备仓库位置编号
    private String depotPositionCode;
    //客户单位
    private String customerCompany;
    //客户姓名
    private String customerName;
    //客户联系电话
    private String customerPhone;
    //客户地址
    private String customerAddress;
    //备注
    private String remark;
    //入库登记用户ID
    private String userId;
    //入库时间
    private Date addTime;
    //设备检定人员姓名
    private String censorName;
    //设备检定人员联系电话
    private String censorPhone;
    //设备检定结果
    private String censorResult;
    //设备检定结果备注
    private String censorRemark;
    //设备检定费用
    private Double censorCost;
    //设备检定时间
    private Date censorTime;
    //设备检定结果登记时间
    private Date censorResultTime;
    //设备检定结果登记用户ID
    private Long censorUserId;

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

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getBarcode() {
        return barcode;
    }

    public void setBarcode(String barcode) {
        this.barcode = barcode;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getDepotId() {
        return depotId;
    }

    public void setDepotId(String depotId) {
        this.depotId = depotId;
    }

    public String getDepotPositionCode() {
        return depotPositionCode;
    }

    public void setDepotPositionCode(String depotPositionCode) {
        this.depotPositionCode = depotPositionCode;
    }

    public String getCustomerCompany() {
        return customerCompany;
    }

    public void setCustomerCompany(String customerCompany) {
        this.customerCompany = customerCompany;
    }

    public String getCustomerName() {
        return customerName;
    }

    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }

    public String getCustomerPhone() {
        return customerPhone;
    }

    public void setCustomerPhone(String customerPhone) {
        this.customerPhone = customerPhone;
    }

    public String getCustomerAddress() {
        return customerAddress;
    }

    public void setCustomerAddress(String customerAddress) {
        this.customerAddress = customerAddress;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public Date getAddTime() {
        return addTime;
    }

    public void setAddTime(Date addTime) {
        this.addTime = addTime;
    }

    public String getCensorName() {
        return censorName;
    }

    public void setCensorName(String censorName) {
        this.censorName = censorName;
    }

    public String getCensorPhone() {
        return censorPhone;
    }

    public void setCensorPhone(String censorPhone) {
        this.censorPhone = censorPhone;
    }

    public String getCensorResult() {
        return censorResult;
    }

    public void setCensorResult(String censorResult) {
        this.censorResult = censorResult;
    }

    public String getCensorRemark() {
        return censorRemark;
    }

    public void setCensorRemark(String censorRemark) {
        this.censorRemark = censorRemark;
    }

    public Double getCensorCost() {
        return censorCost;
    }

    public void setCensorCost(Double censorCost) {
        this.censorCost = censorCost;
    }

    public Date getCensorTime() {
        return censorTime;
    }

    public void setCensorTime(Date censorTime) {
        this.censorTime = censorTime;
    }

    public Date getCensorResultTime() {
        return censorResultTime;
    }

    public void setCensorResultTime(Date censorResultTime) {
        this.censorResultTime = censorResultTime;
    }

    public Long getCensorUserId() {
        return censorUserId;
    }

    public void setCensorUserId(Long censorUserId) {
        this.censorUserId = censorUserId;
    }
}
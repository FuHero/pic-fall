/***********************************************************************
 * Module:  lab_bill_devices.java
 * Author:  Fu Zhong
 * Purpose: Defines the Class lab_bill_devices
 ***********************************************************************/
package cn.server.lab.entity;

import cn.server.lab.model.Pagination;

import java.io.Serializable;
import java.util.Date;

public class BillDevice extends Pagination implements Serializable {
    private static final long serialVersionUID = 7187565988973889365L;
    //关系主键ID
    private String id;
    //取样登记清单ID
    private String billId;
    //取样设备ID
    private String deviceId;

    public String getDeviceId() {
        return deviceId;
    }

    public void setDeviceId(String deviceId) {
        this.deviceId = deviceId;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getBillId() {
        return billId;
    }

    public void setBillId(String billId) {
        this.billId = billId;
    }
}
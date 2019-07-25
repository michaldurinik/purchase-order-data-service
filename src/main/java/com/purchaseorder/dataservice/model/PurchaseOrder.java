package com.purchaseorder.dataservice.model;

public class PurchaseOrder {
    private String poNumber;
    private String date;
    private String subDepartment;
    private String requestedBy;
    private String status;

    public PurchaseOrder(String poNumber, String date, String subDepartment, String requestedBy, String status) {
        this.poNumber = poNumber;
        this.date = date;
        this.subDepartment = subDepartment;
        this.requestedBy = requestedBy;
        this.status = status;
    }

    public String getPoNumber() {
        return poNumber;
    }

    public void setPoNumber(String poNumber) {
        this.poNumber = poNumber;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getSubDepartment() {
        return subDepartment;
    }

    public void setSubDepartment(String subDepartment) {
        this.subDepartment = subDepartment;
    }

    public String getRequestedBy() {
        return requestedBy;
    }

    public void setRequestedBy(String requestedBy) {
        this.requestedBy = requestedBy;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}

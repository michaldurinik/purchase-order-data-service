package com.purchaseorder.dataservice.model;

import javax.crypto.SecretKey;

public class PoData {
    String nnumber;
    SecretKey secret;
    PurchaseOrder purchaseOrder;

    public PoData(String nnumber, SecretKey secret, PurchaseOrder purchaseOrder) {
        this.nnumber = nnumber;
        this.secret = secret;
        this.purchaseOrder = purchaseOrder;
    }

    public String getNnumber() {
        return nnumber;
    }

    public SecretKey getSecret() {
        return secret;
    }

    public PurchaseOrder getPurchaseOrder() {
        return purchaseOrder;
    }
}

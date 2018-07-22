package com.cosmos.hack.model.document;


import com.cosmos.hack.model.AuditModel;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.UUID;

@Document
public class Pfi extends AuditModel {

    private String invoiceNumber;
    private Float price;
    private String supplierName;
    private String goodName;
    private String gmtRef;
    private String Quantity;
    private String lvat;


    public String getInvoiceNumber() {
        return invoiceNumber;
    }

    public void setInvoiceNumber(String invoiceNumber) {
        this.invoiceNumber = invoiceNumber;
    }

    public Float getPrice() {
        return price;
    }

    public void setPrice(Float price) {
        this.price = price;
    }

    public String getSupplierName() {
        return supplierName;
    }

    public void setSupplierName(String supplierName) {
        this.supplierName = supplierName;
    }

    public String getGoodName() {
        return goodName;
    }

    public void setGoodName(String goodName) {
        this.goodName = goodName;
    }

    public String getGmtRef() {
        return gmtRef;
    }

    public void setGmtRef(String gmtRef) {
        this.gmtRef = gmtRef;
    }

    public String getQuantity() {
        return Quantity;
    }

    public void setQuantity(String quantity) {
        Quantity = quantity;
    }

    public String getLvat() {
        return lvat;
    }

    public void setLvat(String lvat) {
        this.lvat = lvat;
    }
}

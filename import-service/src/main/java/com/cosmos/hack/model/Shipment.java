package com.cosmos.hack.model;

import com.cosmos.hack.model.document.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.UUID;

@Document
public class Shipment {
    public String id;
    public String edd;
    public String importProcessId;
    public ImportPermit importPermit;

    public Bol bol;
    public CommercialInvoice commercialInvoice;
    public Ccvo ccvo;
    public PackingList packingList;
    public ManufacturerCertificate manufacturerCertificate;
    public Cria cria;
    public boolean isDocumentComplete = false;
    public boolean isShipmentComplete = false;
    public Float demurrage;
    public User user;

    public Shipment() {
    }

    public void copy(Shipment other) {
        this.edd = other.edd;
        this.importPermit = other.importPermit;
        this.bol = other.bol;
        this.commercialInvoice = other.commercialInvoice;
        this.ccvo = other.ccvo;
        this.packingList = other.packingList;
        this.manufacturerCertificate = other.manufacturerCertificate;
        this.cria = other.cria;
        this.isDocumentComplete = other.isDocumentComplete;
        this.demurrage = other.demurrage;
        this.user = other.user;
    }

    public String getImportProcessId() {
        return importProcessId;
    }

    public void setImportProcessId(String importProcessId) {
        this.importProcessId = importProcessId;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getEdd() {
        return edd;
    }

    public void setEdd(String edd) {
        this.edd = edd;
    }

    public ImportPermit getImportPermit() {
        return importPermit;
    }

    public void setImportPermit(ImportPermit importPermit) {
        this.importPermit = importPermit;
    }

    public Bol getBol() {
        return bol;
    }

    public void setBol(Bol bol) {
        this.bol = bol;
    }

    public CommercialInvoice getCommercialInvoice() {
        return commercialInvoice;
    }

    public void setCommercialInvoice(CommercialInvoice commercialInvoice) {
        this.commercialInvoice = commercialInvoice;
    }

    public Ccvo getCcvo() {
        return ccvo;
    }

    public void setCcvo(Ccvo ccvo) {
        this.ccvo = ccvo;
    }

    public PackingList getPackingList() {
        return packingList;
    }

    public void setPackingList(PackingList packingList) {
        this.packingList = packingList;
    }

    public ManufacturerCertificate getManufacturerCertificate() {
        return manufacturerCertificate;
    }

    public void setManufacturerCertificate(ManufacturerCertificate manufacturerCertificate) {
        this.manufacturerCertificate = manufacturerCertificate;
    }

    public Cria getCria() {
        return cria;
    }

    public void setCria(Cria cria) {
        this.cria = cria;
    }

    public boolean isDocumentComplete() {
        return isDocumentComplete;
    }

    public void setDocumentComplete(boolean documentComplete) {
        isDocumentComplete = documentComplete;
    }

    public boolean isShipmentComplete() {
        return isShipmentComplete;
    }

    public void setShipmentComplete(boolean shipmentComplete) {
        isShipmentComplete = shipmentComplete;
    }

    public Float getDemurrage() {
        return demurrage;
    }

    public void setDemurrage(Float demurrage) {
        this.demurrage = demurrage;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
}

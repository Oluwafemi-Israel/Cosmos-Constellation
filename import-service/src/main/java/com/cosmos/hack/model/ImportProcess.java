package com.cosmos.hack.model;

import com.cosmos.hack.model.document.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.List;

@Document
public class ImportProcess extends AuditModel {
    @Id
    private String id;
    private Pfi pfi;
    private FormM formM;

    private Lc lc;

    private Insurance insurance;

    private Nafdac nafdac;

    private Son son;

    private Quarantine quarantine;

    private ImportPermit importPermit;

    private List<Shipment> shipment;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public Pfi getPfi() {
        return pfi;
    }

    public void setPfi(Pfi pfi) {
        this.pfi = pfi;
    }

    public FormM getFormM() {
        return formM;
    }

    public void setFormM(FormM formM) {
        this.formM = formM;
    }

    public Lc getLc() {
        return lc;
    }

    public void setLc(Lc lc) {
        this.lc = lc;
    }

    public Insurance getInsurance() {
        return insurance;
    }

    public void setInsurance(Insurance insurance) {
        this.insurance = insurance;
    }

    public Nafdac getNafdac() {
        return nafdac;
    }

    public void setNafdac(Nafdac nafdac) {
        this.nafdac = nafdac;
    }

    public Son getSon() {
        return son;
    }

    public void setSon(Son son) {
        this.son = son;
    }

    public Quarantine getQuarantine() {
        return quarantine;
    }

    public void setQuarantine(Quarantine quarantine) {
        this.quarantine = quarantine;
    }

    public ImportPermit getImportPermit() {
        return importPermit;
    }

    public void setImportPermit(ImportPermit importPermit) {
        this.importPermit = importPermit;
    }

    public List<Shipment> getShipment() {
        return shipment;
    }

    public void setShipment(List<Shipment> shipment) {
        this.shipment = shipment;
    }
}

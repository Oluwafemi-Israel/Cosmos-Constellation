package com.cosmos.hack.model.document;

import com.cosmos.hack.model.AuditModel;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.UUID;

@Document // This tells Hibernate to make a table out of this class
public class CommercialInvoice extends AuditModel {

}

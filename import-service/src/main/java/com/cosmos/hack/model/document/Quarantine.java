package com.cosmos.hack.model.document;


import com.cosmos.hack.model.AuditModel;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.UUID;

@Document
public class Quarantine extends AuditModel {

}

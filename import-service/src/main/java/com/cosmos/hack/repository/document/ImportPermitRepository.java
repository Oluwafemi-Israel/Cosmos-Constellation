package com.cosmos.hack.repository.document;

import com.cosmos.hack.model.document.ImportPermit;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface ImportPermitRepository extends MongoRepository<ImportPermit,String> {
}

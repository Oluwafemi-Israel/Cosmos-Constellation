package com.cosmos.hack.repository.document;

import com.cosmos.hack.model.document.Quarantine;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface QuarantineRepository extends MongoRepository<Quarantine,String> {
}

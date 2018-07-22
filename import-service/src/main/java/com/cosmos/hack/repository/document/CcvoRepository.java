package com.cosmos.hack.repository.document;

import com.cosmos.hack.model.document.Ccvo;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface CcvoRepository extends MongoRepository<Ccvo,String> {
}

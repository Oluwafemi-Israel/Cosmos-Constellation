package com.cosmos.hack.repository.document;

import com.cosmos.hack.model.document.Pfi;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface PfiRepository extends MongoRepository<Pfi,String> {
}

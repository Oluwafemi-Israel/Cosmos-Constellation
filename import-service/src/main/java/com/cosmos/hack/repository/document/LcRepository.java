package com.cosmos.hack.repository.document;

import com.cosmos.hack.model.document.Lc;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface LcRepository extends MongoRepository<Lc,String> {
}

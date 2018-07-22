package com.cosmos.hack.repository.document;

import com.cosmos.hack.model.document.Son;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface SonRepository extends MongoRepository<Son,String> {
}

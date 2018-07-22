package com.cosmos.hack.repository.document;

import com.cosmos.hack.model.document.Bol;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface BolRepository extends MongoRepository<Bol,String> {
}

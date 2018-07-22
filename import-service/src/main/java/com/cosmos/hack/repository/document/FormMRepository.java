package com.cosmos.hack.repository.document;

import com.cosmos.hack.model.document.FormM;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface FormMRepository extends MongoRepository<FormM,String> {
}

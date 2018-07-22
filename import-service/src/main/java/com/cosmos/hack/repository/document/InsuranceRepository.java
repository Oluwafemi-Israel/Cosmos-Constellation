package com.cosmos.hack.repository.document;

import com.cosmos.hack.model.document.Insurance;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface InsuranceRepository extends MongoRepository<Insurance,String> {
}

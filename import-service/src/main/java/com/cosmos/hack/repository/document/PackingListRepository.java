package com.cosmos.hack.repository.document;

import com.cosmos.hack.model.document.PackingList;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface PackingListRepository extends MongoRepository<PackingList,String> {
}

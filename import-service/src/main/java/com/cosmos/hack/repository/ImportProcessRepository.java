package com.cosmos.hack.repository;

import com.cosmos.hack.model.ImportProcess;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.NoRepositoryBean;
import org.springframework.stereotype.Repository;

@Repository
public interface ImportProcessRepository extends MongoRepository<ImportProcess, String> {

}

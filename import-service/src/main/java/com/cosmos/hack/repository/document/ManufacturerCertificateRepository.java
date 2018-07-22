package com.cosmos.hack.repository.document;

import com.cosmos.hack.model.document.ManufacturerCertificate;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface ManufacturerCertificateRepository extends MongoRepository<ManufacturerCertificate,String> {
}

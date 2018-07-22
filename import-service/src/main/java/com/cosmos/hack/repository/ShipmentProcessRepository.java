package com.cosmos.hack.repository;

import com.cosmos.hack.model.Shipment;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ShipmentProcessRepository extends MongoRepository<Shipment, String> {
}

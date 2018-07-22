package com.cosmos.hack.repository.document;

import com.cosmos.hack.model.document.CommercialInvoice;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface CommercialInvoiceRepository extends MongoRepository<CommercialInvoice,String> {
}

package com.cosmos.hack.controller.document;

import com.cosmos.hack.controller.AbstractController;
import com.cosmos.hack.model.document.CommercialInvoice;
import com.cosmos.hack.repository.document.CommercialInvoiceRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;

@org.springframework.web.bind.annotation.RestController
@RequestMapping("/document/commercialinvoice")
public class CommercialInvoiceController extends AbstractController<CommercialInvoice,String> {
    @Autowired
    public CommercialInvoiceController(CommercialInvoiceRepository repo) {
        super(repo);
    }
}

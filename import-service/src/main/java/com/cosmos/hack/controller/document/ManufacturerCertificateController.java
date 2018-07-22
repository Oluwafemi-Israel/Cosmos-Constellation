package com.cosmos.hack.controller.document;

import com.cosmos.hack.controller.AbstractController;
import com.cosmos.hack.model.document.ManufacturerCertificate;
import com.cosmos.hack.repository.document.ManufacturerCertificateRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;

@org.springframework.web.bind.annotation.RestController
@RequestMapping("/document/manufacturercertificate")
public class ManufacturerCertificateController extends AbstractController<ManufacturerCertificate,String> {
    @Autowired
    public ManufacturerCertificateController(ManufacturerCertificateRepository repo) {
        super(repo);
    }
}

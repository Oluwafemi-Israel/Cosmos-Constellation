package com.cosmos.hack.controller.document;

import com.cosmos.hack.controller.AbstractController;
import com.cosmos.hack.model.document.Quarantine;
import com.cosmos.hack.repository.document.QuarantineRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;

@org.springframework.web.bind.annotation.RestController
@RequestMapping("/document/quarantine")
public class QuarantineController extends AbstractController<Quarantine,String> {
    @Autowired
    public QuarantineController(QuarantineRepository repo) {
        super(repo);
    }
}


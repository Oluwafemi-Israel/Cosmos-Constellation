package com.cosmos.hack.controller.document;

import com.cosmos.hack.controller.AbstractController;
import com.cosmos.hack.model.document.Pfi;
import com.cosmos.hack.repository.document.PfiRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;

@org.springframework.web.bind.annotation.RestController
@RequestMapping("/document/pfi")
public class PfiController extends AbstractController<Pfi,String> {
    @Autowired
    public PfiController(PfiRepository repo) {
        super(repo);
    }
}

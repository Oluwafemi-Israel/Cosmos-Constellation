package com.cosmos.hack.controller.document;

import com.cosmos.hack.controller.AbstractController;
import com.cosmos.hack.model.document.Lc;
import com.cosmos.hack.repository.document.LcRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;

@org.springframework.web.bind.annotation.RestController
@RequestMapping("/document/lc")
public class LcController extends AbstractController<Lc,String> {
    @Autowired
    public LcController(LcRepository repo) {
        super(repo);
    }
}

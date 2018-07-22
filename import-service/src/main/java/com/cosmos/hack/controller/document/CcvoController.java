package com.cosmos.hack.controller.document;

import com.cosmos.hack.controller.AbstractController;
import com.cosmos.hack.model.document.Ccvo;
import com.cosmos.hack.repository.document.CcvoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;

@org.springframework.web.bind.annotation.RestController
@RequestMapping("/document/ccvo")
public class CcvoController extends AbstractController<Ccvo,String> {
    @Autowired
    public CcvoController(CcvoRepository repo) {
        super(repo);
    }
}

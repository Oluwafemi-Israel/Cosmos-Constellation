package com.cosmos.hack.controller.document;

import com.cosmos.hack.controller.AbstractController;
import com.cosmos.hack.model.document.Son;
import com.cosmos.hack.repository.document.SonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;

@org.springframework.web.bind.annotation.RestController
@RequestMapping("/document/son")
public class SonController extends AbstractController<Son,String> {
    @Autowired
    public SonController(SonRepository repo) {
        super(repo);
    }
}

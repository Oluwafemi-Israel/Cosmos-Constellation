package com.cosmos.hack.controller.document;

import com.cosmos.hack.controller.AbstractController;
import com.cosmos.hack.model.document.Nafdac;
import com.cosmos.hack.repository.document.NafdacRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;

@org.springframework.web.bind.annotation.RestController
@RequestMapping("/document/nafdac")
public class NafdacController extends AbstractController<Nafdac,String> {
    @Autowired
    public NafdacController(NafdacRepository repo) {
        super(repo);
    }
}

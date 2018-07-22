package com.cosmos.hack.controller.document;

import com.cosmos.hack.controller.AbstractController;
import com.cosmos.hack.model.document.Cria;
import com.cosmos.hack.repository.document.CcvoRepository;
import com.cosmos.hack.repository.document.CriaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;

@org.springframework.web.bind.annotation.RestController
@RequestMapping("/document/cria")
public class CriaController extends AbstractController<Cria,String> {
    @Autowired
    public CriaController(CriaRepository repo) {
        super(repo);
    }
}

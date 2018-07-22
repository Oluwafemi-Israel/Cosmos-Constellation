package com.cosmos.hack.controller.document;

import com.cosmos.hack.controller.AbstractController;
import com.cosmos.hack.model.document.Insurance;
import com.cosmos.hack.repository.document.InsuranceRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;

@org.springframework.web.bind.annotation.RestController
@RequestMapping("/document/insurance")
public class InsuranceController extends AbstractController<Insurance,String> {
    @Autowired
    public InsuranceController(InsuranceRepository repo) {
        super(repo);
    }
}

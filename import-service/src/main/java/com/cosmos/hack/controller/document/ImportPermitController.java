package com.cosmos.hack.controller.document;

import com.cosmos.hack.controller.AbstractController;
import com.cosmos.hack.model.document.ImportPermit;
import com.cosmos.hack.repository.document.ImportPermitRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;

@org.springframework.web.bind.annotation.RestController
@RequestMapping("/document/importpermit")
public class ImportPermitController extends AbstractController<ImportPermit,String> {
    @Autowired
    public ImportPermitController(ImportPermitRepository repo) {
        super(repo);
    }
}

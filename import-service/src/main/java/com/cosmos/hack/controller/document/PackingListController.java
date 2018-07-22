package com.cosmos.hack.controller.document;

import com.cosmos.hack.controller.AbstractController;
import com.cosmos.hack.model.document.PackingList;
import com.cosmos.hack.repository.document.PackingListRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;

@org.springframework.web.bind.annotation.RestController
@RequestMapping("/document/packinglist")
public class PackingListController extends AbstractController<PackingList,String> {
    @Autowired
    public PackingListController(PackingListRepository repo) {
        super(repo);
    }
}

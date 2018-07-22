package com.cosmos.hack.controller;

import com.cosmos.hack.model.Shipment;
import com.cosmos.hack.repository.ImportProcessRepository;
import org.jsoup.Connection;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.nodes.FormElement;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/schedule")
public class SchedulerController {
    @Autowired
    ImportProcessRepository importProcessRepository;

    @GetMapping()
    public List<Shipment> getAll() {
        return importProcessRepository.findAll().stream()
                .filter(elt -> elt.getShipment() != null)
                .flatMap(elt -> elt.getShipment().stream().filter(elt2 -> elt2.isDocumentComplete() == false))
                .collect(Collectors.toList());
    }

    public static void checkElement(String name, Element elem) {
        if (elem == null) {
            throw new RuntimeException("Unable to find " + name);
        }
    }

}

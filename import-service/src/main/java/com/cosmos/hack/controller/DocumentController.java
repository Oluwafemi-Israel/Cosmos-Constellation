package com.cosmos.hack.controller;

import com.cosmos.hack.exception.ResourceNotFoundException;
import com.cosmos.hack.model.AuditModel;
import com.cosmos.hack.model.ImportProcess;
import com.cosmos.hack.model.document.*;
import com.cosmos.hack.repository.ImportProcessRepository;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.lang.reflect.Field;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/document")
public class DocumentController<T> {
    @Autowired
    ImportProcessRepository importProcessRepository;


    @GetMapping("/{processid}/{doctype}")
    public T getDoc(@PathVariable String processid, @PathVariable String doctype) {
        Optional<ImportProcess> importProcess = importProcessRepository.findById(processid);
        T result = null;
        if(importProcess.isPresent()){
            ImportProcess ip = importProcess.get();
            switch(doctype){
                case "pfi":
                    result = (T) ip.getPfi();
                    break;
                case "formm":
                    result = (T) ip.getFormM();
                    break;
                case "lc":
                    result = (T) ip.getLc();
                    break;
                case "insurance":
                    result = (T) ip.getInsurance();
                    break;
                case "nafdac":
                    result = (T) ip.getNafdac();
                    break;
                case "son":
                    result = (T) ip.getSon();
                    break;
                case "quarantine":
                    result = (T) ip.getQuarantine();
                    break;
                case "importPermit":
                    result = (T) ip.getImportPermit();
                    break;
            }
        }else {
            throw new ResourceNotFoundException("process id not found");
        }
        return result;
    }

    @GetMapping("/{doctype}")
    public List<T> getAll(@PathVariable String doctype) {

        switch(doctype){
            case "pfi":
                return importProcessRepository.findAll().stream()
                        .filter(elt -> elt.getPfi() != null)
                        .map(elt -> (T)elt.getPfi())
                        .collect(Collectors.toList());

            case "formm":
                return importProcessRepository.findAll().stream()
                        .filter(elt -> elt.getFormM() != null)
                        .map(elt -> (T)elt.getFormM())
                        .collect(Collectors.toList());

            case "lc":
                return importProcessRepository.findAll().stream()
                        .filter(elt -> elt.getLc() != null)
                        .map(elt -> (T)elt.getLc())
                        .collect(Collectors.toList());

            case "insurance":
                return importProcessRepository.findAll().stream()
                        .filter(elt -> elt.getInsurance() != null)
                        .map(elt -> (T)elt.getInsurance())
                        .collect(Collectors.toList());

            case "nafdac":
                return importProcessRepository.findAll().stream()
                        .filter(elt -> elt.getNafdac() != null)
                        .map(elt -> (T)elt.getNafdac())
                        .collect(Collectors.toList());

            case "son":
                return importProcessRepository.findAll().stream()
                        .filter(elt -> elt.getSon() != null)
                        .map(elt -> (T)elt.getSon())
                        .collect(Collectors.toList());

            case "quarantine":
                return importProcessRepository.findAll().stream()
                        .filter(elt -> elt.getQuarantine() != null)
                        .map(elt -> (T)elt.getQuarantine())
                        .collect(Collectors.toList());

            case "importPermit":
                return importProcessRepository.findAll().stream()
                        .filter(elt -> elt.getImportPermit() != null)
                        .map(elt -> (T)elt.getImportPermit())
                        .collect(Collectors.toList());

        }
        throw new ResourceNotFoundException("document type not found");
    }

    @PostMapping("/{processid}/{doctype}")
    public void createDoc(@PathVariable String processid, @PathVariable String doctype, @RequestBody T document) {
        Optional<ImportProcess> importProcess = importProcessRepository.findById(processid);
        final ObjectMapper mapper = new ObjectMapper(); // jackson's objectmapper
        if(importProcess.isPresent()){
            ImportProcess ip = importProcess.get();
            switch(doctype){
                case "pfi":
                    ip.setPfi(mapper.convertValue(document, Pfi.class));
                    break;
                case "formm":
                    ip.setFormM(mapper.convertValue(document, FormM.class));
                    break;
                case "lc":
                    ip.setLc(mapper.convertValue(document, Lc.class));
                    break;
                case "insurance":
                    ip.setInsurance(mapper.convertValue(document, Insurance.class));
                    break;
                case "nafdac":
                    ip.setNafdac(mapper.convertValue(document, Nafdac.class));
                    break;
                case "son":
                    ip.setSon(mapper.convertValue(document, Son.class));
                    break;
                case "quarantine":
                    ip.setQuarantine(mapper.convertValue(document, Quarantine.class));
                    break;
                case "importPermit":
                    ip.setImportPermit(mapper.convertValue(document, ImportPermit.class));
                    break;
            }
            importProcessRepository.save(ip);
        }else {
            throw new ResourceNotFoundException("process id not found");
        }
    }
}

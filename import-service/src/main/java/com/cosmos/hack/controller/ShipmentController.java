package com.cosmos.hack.controller;

import com.cosmos.hack.exception.ResourceNotFoundException;
import com.cosmos.hack.model.ImportProcess;
import com.cosmos.hack.model.Shipment;
import com.cosmos.hack.model.binding.CompleteShipment;
import com.cosmos.hack.model.document.ImportPermit;
import com.cosmos.hack.repository.ImportProcessRepository;
import com.cosmos.hack.repository.ShipmentProcessRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.lang.reflect.Field;
import java.util.*;
import java.util.stream.Collectors;


@RestController
@RequestMapping("/shipment")
public class ShipmentController  {

    @Autowired
    ImportProcessRepository importProcessRepository;

    @GetMapping()
    public List<Shipment> getAll() {
        return importProcessRepository.findAll().stream()
                .filter(elt -> elt.getShipment() != null)
                .flatMap(elt -> elt.getShipment().stream())
                .collect(Collectors.toList());
    }

    @RequestMapping(value="/{processid}", method=RequestMethod.POST)
    public void createShipment(@PathVariable String processid, @RequestBody Shipment shipment) throws IllegalAccessException {
        Optional<ImportProcess> importProcess = importProcessRepository.findById(processid);
        if(importProcess.isPresent()){
            List<Shipment> shipment1 = importProcess.get().getShipment();
            if(shipment1!=null){
                if(!isNull(shipment)){
                    shipment.setDocumentComplete(true);
                }
                /*boolean found = false;
                for(Shipment s: shipment1){
                    if(s.getId().equalsIgnoreCase())
                }*/
                shipment.setId(UUID.randomUUID().toString().replaceAll("-",""));
                shipment.setImportProcessId(processid);
                shipment1.add(shipment);
                ImportProcess importProcess1 = importProcess.get();
                importProcess1.setShipment(shipment1);
                importProcessRepository.save(importProcess1);
            }else{
                if(!isNull(shipment)){
                    shipment.setDocumentComplete(true);
                }
                ImportProcess importProcess1 = importProcess.get();
                List<Shipment> a = new ArrayList<>();
                shipment.setId(UUID.randomUUID().toString().replaceAll("-",""));
                shipment.setImportProcessId(processid);
                a.add(shipment);
                importProcess1.setShipment(a);
                importProcessRepository.save(importProcess1);
            }



        }else {
            throw new ResourceNotFoundException("process id not found");
        }
    }



    @RequestMapping(value="/{processid}/{shipmentid}", method=RequestMethod.POST)
    public void updateShipment(@PathVariable String processid, @PathVariable String shipmentid, @RequestBody Shipment shipment) throws IllegalAccessException {
        Optional<ImportProcess> importProcess = importProcessRepository.findById(processid);
        if(importProcess.isPresent()){
            List<Shipment> shipment1 = importProcess.get().getShipment();
            if(shipment1!=null){
                if(!isNull(shipment)){
                    shipment.setDocumentComplete(true);
                }
                boolean found = false;
                for(Shipment s: shipment1){
                    if(s.getId().equalsIgnoreCase(shipmentid)){
                        found = true;
                        s.copy(shipment);
                        s.setImportProcessId(processid);
                    }
                }

                ImportProcess importProcess1 = importProcess.get();
                importProcess1.setShipment(shipment1);
                importProcessRepository.save(importProcess1);
            }else{
                throw new ResourceNotFoundException("process id and shipment id not found");
            }



        }else {
            throw new ResourceNotFoundException("process id not found");
        }
    }

    @RequestMapping(value="/complete/{processid}/{shipmentid}", method=RequestMethod.POST)
    public void completeShipment(@PathVariable String processid, @PathVariable String shipmentid, @RequestBody CompleteShipment completeShipment){
        Optional<ImportProcess> importProcess = importProcessRepository.findById(processid);
        if(importProcess.isPresent()) {
            ImportProcess importProcess1 = importProcess.get();
            if(importProcess1.getShipment()!=null){
                boolean found=false;
                for(Shipment s : importProcess1.getShipment()){
                    if(s.getId().equalsIgnoreCase(shipmentid)){
                        List<Shipment> shipments = importProcess1.getShipment();
                        shipments.remove(s);
                        s.setShipmentComplete(true);
                        s.setDemurrage(completeShipment.getDemurrage());
                        shipments.add(s);
                        importProcess1.setShipment(shipments);
                        found=true;
                    }
                }
                importProcessRepository.save(importProcess1);
                if(!found){
                    throw new ResourceNotFoundException("shipment id not found");
                }
            }else {
                throw new ResourceNotFoundException("shipment id not found");
            }
        }else {
            throw new ResourceNotFoundException("shipment id not found");
        }
    }

    public boolean isNull(Shipment shipment) throws IllegalAccessException {
        if(shipment.getBol()==null){
            return true;
        }
        if(shipment.getCcvo()==null){
            return true;
        }
        if(shipment.getCommercialInvoice()==null){
            return true;
        }
        if(shipment.getCria()==null){
            return true;
        }
        if(shipment.getImportPermit()==null){
            return true;
        }
        if(shipment.getManufacturerCertificate()==null){
            return true;
        }
        if(shipment.getPackingList()==null){
            return true;
        }
        return false;
    }
}

package com.cosmos.hack.controller;

import com.cosmos.hack.model.ImportProcess;
import com.cosmos.hack.model.Shipment;
import com.cosmos.hack.repository.ImportProcessRepository;
import com.google.common.base.Throwables;
import com.google.common.collect.Lists;
import com.google.common.collect.Maps;
import org.apache.commons.beanutils.BeanUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.UUID;

@RestController
@RequestMapping("/importprocess")
public class ImportProcessController  {

    private Logger logger = LoggerFactory.getLogger(AbstractController.class);

    @Autowired
    private ImportProcessRepository repo;

    @RequestMapping
    public @ResponseBody
    List<ImportProcess> listAll() {
        Iterable<ImportProcess> all = this.repo.findAll();
        return Lists.newArrayList(all);
    }

    @RequestMapping(method=RequestMethod.POST, consumes={MediaType.APPLICATION_JSON_VALUE})
    public @ResponseBody
    Map<String, Object> create(@RequestBody ImportProcess json) {
        logger.debug("create() with body {} of type {}", json, json.getClass());
        if(json.getShipment()!=null){
            for(Shipment s : json.getShipment()){
                s.setId(UUID.randomUUID().toString().replaceAll("-",""));
                json.setId(UUID.randomUUID().toString().replaceAll("-",""));
                s.setImportProcessId(json.getId());
            }
        }
        ImportProcess created = this.repo.save(json);

        Map<String, Object> m = Maps.newHashMap();
        m.put("success", true);
        m.put("created", created);
        return m;
    }

    @RequestMapping(value="/{id}", method=RequestMethod.GET)
    public @ResponseBody Optional<ImportProcess> get(@PathVariable String id) {
        return (Optional<ImportProcess>) this.repo.findById(id);
    }

    @RequestMapping(value="/{id}", method=RequestMethod.POST, consumes={MediaType.APPLICATION_JSON_VALUE})
    public @ResponseBody Map<String, Object> update(@PathVariable String id, @RequestBody ImportProcess json) {
        logger.debug("update() of id#{} with body {}", id, json);
        logger.debug("T json is of type {}", json.getClass());

        Optional<ImportProcess> entity =  this.repo.findById(id);
        try {
            BeanUtils.copyProperties(entity.get(), json);
        }
        catch (Exception e) {
            logger.warn("while copying properties", e);
            throw Throwables.propagate(e);
        }

        logger.debug("merged entity: {}", entity.get());

        ImportProcess updated = this.repo.save(entity.get());
        logger.debug("updated enitity: {}", updated);

        Map<String, Object> m = Maps.newHashMap();
        m.put("success", true);
        m.put("id", id);
        m.put("updated", updated);
        return m;
    }

    @RequestMapping(value="/{id}", method=RequestMethod.DELETE)
    public @ResponseBody Map<String, Object> delete(@PathVariable String id) {
        this.repo.deleteById(id);
        Map<String, Object> m = Maps.newHashMap();
        m.put("success", true);
        return m;
    }
}
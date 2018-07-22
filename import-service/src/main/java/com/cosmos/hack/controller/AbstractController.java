package com.cosmos.hack.controller;

import com.cosmos.hack.model.AuditModel;
import com.google.common.base.Throwables;
import com.google.common.collect.Lists;
import com.google.common.collect.Maps;
import org.apache.commons.beanutils.BeanUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.io.Serializable;
import java.util.List;
import java.util.Map;
import java.util.Optional;


public abstract class AbstractController<T, ID extends Serializable> {

    private Logger logger = LoggerFactory.getLogger(AbstractController.class);

    private MongoRepository<T, ID> repo;


    public AbstractController(MongoRepository repo) {
        this.repo = repo;
    }

    @RequestMapping
    public @ResponseBody List<T> listAll() {
        Iterable<T> all = this.repo.findAll();
        return Lists.newArrayList(all);
    }

    @RequestMapping(method=RequestMethod.POST, consumes={MediaType.APPLICATION_JSON_VALUE})
    public @ResponseBody Map<String, Object> create(@RequestBody T json) {
        logger.debug("create() with body {} of type {}", json, json.getClass());
        T created = this.repo.save(json);

        Map<String, Object> m = Maps.newHashMap();
        m.put("success", true);
        m.put("created", created);
        return m;
    }

    @RequestMapping(value="/{id}", method=RequestMethod.GET)
    public @ResponseBody Optional<T> get(@PathVariable ID id) {
        return (Optional<T>) this.repo.findById(id);
    }

    @RequestMapping(value="/{id}", method=RequestMethod.POST, consumes={MediaType.APPLICATION_JSON_VALUE})
    public @ResponseBody Map<String, Object> update(@PathVariable ID id, @RequestBody T json) {
        logger.debug("update() of id#{} with body {}", id, json);
        logger.debug("T json is of type {}", json.getClass());

        Optional<T> entity =  this.repo.findById(id);
        try {
            BeanUtils.copyProperties(entity.get(), json);
        }
        catch (Exception e) {
            logger.warn("while copying properties", e);
            throw Throwables.propagate(e);
        }

        logger.debug("merged entity: {}", entity.get());

        T updated = this.repo.save(entity.get());
        logger.debug("updated enitity: {}", updated);

        Map<String, Object> m = Maps.newHashMap();
        m.put("success", true);
        m.put("id", id);
        m.put("updated", updated);
        return m;
    }

    @RequestMapping(value="/{id}", method=RequestMethod.DELETE)
    public @ResponseBody Map<String, Object> delete(@PathVariable ID id) {
        this.repo.deleteById(id);
        Map<String, Object> m = Maps.newHashMap();
        m.put("success", true);
        return m;
    }
}
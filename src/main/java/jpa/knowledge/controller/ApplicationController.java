package jpa.knowledge.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

public interface ApplicationController<T> {

    @PostMapping(path = "/create", consumes = "application/json")
    void create(@RequestBody T entity);

    @GetMapping(path = "/get/{ID}", produces = "application/json")
    T get(@PathVariable("ID") Integer id);
}

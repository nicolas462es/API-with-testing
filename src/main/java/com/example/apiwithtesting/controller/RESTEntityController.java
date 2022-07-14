package com.example.apiwithtesting.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

public interface RESTEntityController<ID, DTO> {
    @GetMapping("")
    ResponseEntity<List<DTO>> findAll();

    @GetMapping("/{id}")
    ResponseEntity<DTO> findById(@PathVariable("id") ID id);

    @DeleteMapping("/{id}")
    void deleteById(@PathVariable("id") ID id);

    @PutMapping("")
    ResponseEntity<DTO> update(@RequestBody DTO entity);

    @PostMapping("")
    ResponseEntity<DTO> add(@RequestBody DTO newEntity);
}

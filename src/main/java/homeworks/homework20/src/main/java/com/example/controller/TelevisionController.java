package com.example.controller;

import com.example.entity.Television;
import com.example.service.TelevisionService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/televisions")
@RequiredArgsConstructor
public class TelevisionController {
    private final TelevisionService service;

    @GetMapping
    public List<Television> getAll() {
        return service.findAll();
    }

    @GetMapping("/{id}")
    public Television getById(@PathVariable Long id) {
        return service.findById(id);
    }

    @PostMapping
    public Television create(@RequestBody Television television) {
        return service.save(television);
    }

    @PutMapping("/{id}")
    public Television update(@PathVariable Long id, @RequestBody Television television) {
        television.setId(id);
        return service.save(television);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        service.deleteById(id);
    }
}
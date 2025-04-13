package com.example.service;

import com.example.entity.Television;
import com.example.repository.TelevisionRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class TelevisionService {
    private final TelevisionRepository repository;

    public List<Television> findAll() {
        return repository.findAll();
    }

    public Television findById(Long id) {
        return repository.findById(id).orElse(null);
    }

    public Television save(Television television) {
        return repository.save(television);
    }

    public void deleteById(Long id) {
        repository.deleteById(id);
    }
}
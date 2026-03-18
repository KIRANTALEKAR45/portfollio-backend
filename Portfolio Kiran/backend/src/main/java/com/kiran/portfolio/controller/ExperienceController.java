package com.kiran.portfolio.controller;

import com.kiran.portfolio.model.Experience;
import com.kiran.portfolio.repository.ExperienceRepository;

import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin
@RequestMapping("/api/experience")
public class ExperienceController {

    private final ExperienceRepository repo;

    public ExperienceController(ExperienceRepository repo) {
        this.repo = repo;
    }

    @GetMapping
    public List<Experience> getAll() {
        return repo.findAll();
    }

    @PostMapping
    public Experience add(@RequestBody Experience e) {
        return repo.save(e);
    }

    @PutMapping("/{id}")
    public Experience update(@PathVariable Long id, @RequestBody Experience e) {
        e.setId(id);
        return repo.save(e);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        repo.deleteById(id);
    }
}
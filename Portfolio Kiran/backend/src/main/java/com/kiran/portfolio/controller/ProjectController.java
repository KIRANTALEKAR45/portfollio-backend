package com.kiran.portfolio.controller;
import com.kiran.portfolio.model.Project;
import com.kiran.portfolio.repository.ProjectRepository;

import org.springframework.web.bind.annotation.*;

import java.util.List;
@RestController
@RequestMapping("/api/projects")
@CrossOrigin
public class ProjectController {

    private final ProjectRepository repo;

    public ProjectController(ProjectRepository repo) {
        this.repo = repo;
    }

    @GetMapping
    public List<Project> getAll() {
        return repo.findAll();
    }

    @PostMapping
    public Project add(@RequestBody Project p) {
        return repo.save(p);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        repo.deleteById(id);
    }

    @PutMapping("/{id}")
    public Project update(@PathVariable Long id, @RequestBody Project p) {
        p.setId(id);
        return repo.save(p);
    }
}
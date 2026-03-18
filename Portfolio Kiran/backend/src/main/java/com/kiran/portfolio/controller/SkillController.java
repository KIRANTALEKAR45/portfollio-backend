package com.kiran.portfolio.controller;

import com.kiran.portfolio.model.Skill;
import com.kiran.portfolio.repository.SkillRepository;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin
@RequestMapping("/api/skills")
public class SkillController {

    private final SkillRepository repo;

    public SkillController(SkillRepository repo) {
        this.repo = repo;
    }

    // GET all
    @GetMapping
    public List<Skill> getAll() {
        return repo.findAll();
    }

    // ADD
    @PostMapping
    public Skill addSkill(@RequestBody Skill skill) {
        return repo.save(skill);
    }

    // UPDATE
    @PutMapping("/{id}")
    public Skill update(@PathVariable Long id, @RequestBody Skill skill) {

        Skill existing = repo.findById(id)
                .orElseThrow(() -> new RuntimeException("Skill not found"));

        existing.setName(skill.getName());
        existing.setLevel(skill.getLevel());

        return repo.save(existing);
    }

    // DELETE
    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        repo.deleteById(id);
    }
}
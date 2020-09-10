package com.zackyrza.employeesbackend.controller;

import com.zackyrza.employeesbackend.model.Division;
import com.zackyrza.employeesbackend.model.Position;
import com.zackyrza.employeesbackend.service.PositionService;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;
import java.util.Optional;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/position")
@CrossOrigin()
public class PositionController {
    private PositionService repository;

    public PositionController(PositionService repository) {
        this.repository = repository;
    }

    @GetMapping("")
    public Collection<Position> getAll() {
        return repository.findAll().stream()
                .collect(Collectors.toList());
    }

    @GetMapping("/{id}")
    public Optional<Position> getById(@PathVariable Long id) {
        return repository.findById(id).stream().findFirst();
    }

    @DeleteMapping("/{id}")
    public Optional<Position> deleteById(@PathVariable Long id) {
        return repository.deleteById(id);
    }

    @PostMapping("")
    public Position insertEmployees(@RequestBody Position position) {
        return repository.save(position);
    }
}

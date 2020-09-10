package com.zackyrza.employeesbackend.controller;

import com.zackyrza.employeesbackend.model.Employees;
import com.zackyrza.employeesbackend.repository.EmployeesRepositories;
import com.zackyrza.employeesbackend.service.EmployeeService;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;
import java.util.Optional;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/employees")
@CrossOrigin()
public class EmployeesController {
    private EmployeeService repository;

    public EmployeesController(EmployeeService repository) {
        this.repository = repository;
    }

    @GetMapping("")
    public Collection<Employees> getAll() {
        return repository.findAll().stream()
                .collect(Collectors.toList());
    }

    @GetMapping("/{id}")
    public Optional<Employees> getById(@PathVariable Long id) {
        return repository.findById(id).stream().findFirst();
    }

    @DeleteMapping("/{id}")
    public Optional<Employees> deleteById(@PathVariable Long id) {
        return repository.deleteById(id);
    }

    @PostMapping("")
    public Employees insertEmployees(@RequestBody Employees employees) {
        return repository.save(employees);
    }
}

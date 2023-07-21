package com.example.employeeapi.rest;

import com.example.employeeapi.entity.Employee;
import com.example.employeeapi.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@GetMapping("/api")
public class EmployeeRestController {
    private EmployeeRepository repository;

    @Autowired
    public EmployeeRestController(EmployeeRepository theEmployeeRpository) { repository = theEmployeeRpository}

    @GetMapping("/emp")
    List<Employee> all() {return repository.findAll(); }

    @PostMapping("/emp")
    Employee newEmp(@RequestParam Employee newEmp) { return repository.save(newEmp); }

    //single item
    @GetMapping("/emp/{id}")
    Employee one(@PathVariable Integer id) {
        return repository.findById(id);
    }
}

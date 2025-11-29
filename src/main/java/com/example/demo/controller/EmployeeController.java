package com.example.demo.controller;
import com.example.demo.entity.Employee;
import com.example.demo.repository.EmployeeRepository;
import org.springframework.web.bind.annotation.*; import java.util.List;
@RestController @RequestMapping("/employees")
public class EmployeeController {
    private final EmployeeRepository repo;
    public EmployeeController(EmployeeRepository repo){ this.repo = repo; }
    @PostMapping public Employee create(@RequestBody Employee e){ return repo.save(e); }
    @GetMapping public List<Employee> findAll(){ return repo.findAll(); }
}

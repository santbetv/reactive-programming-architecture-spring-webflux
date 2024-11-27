package com.sbvdeveloper.employeereact.controller;

import com.sbvdeveloper.employeereact.domain.Employee;
import com.sbvdeveloper.employeereact.service.EmployeeService;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RestController
public class EmployeeController {


    private final EmployeeService employeeService;

    public EmployeeController(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }

    @GetMapping("/employees")
    public Flux<Employee> getAllEmployees(){
        return employeeService.getAllEmployees();
    }

    @PostMapping("/employees")
    public Mono<Employee> saveEmployee(@RequestBody Employee employee){
        return employeeService.saveEmployee(employee);
    }

    @GetMapping("/employees/{id}")
    public Mono<Employee> getEmployeeById(@RequestParam Long id){
        return employeeService.getEmployeeById(id);
    }

    @DeleteMapping("/employees/{id}")
    public Mono<Employee> deleteEmployee(@RequestParam Long id){
        return employeeService.deleteEmployee(id);
    }

    @PutMapping("/employees/{id}")
    public Mono<Employee> updateEmployee(@RequestParam Long id, @RequestBody Employee employee){
        return employeeService.updateEmployee(id, employee);
    }
}

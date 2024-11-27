package com.sbvdeveloper.employeereact.service;

import com.sbvdeveloper.employeereact.domain.Employee;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

@Service
public class EmployeeServiceImpl implements EmployeeService{


    public EmployeeServiceImpl() {
        crearBDMemoria();
    }

    private List<Employee> crearBDMemoria(){
        // Lista para almacenar empleados
        List<Employee> employees = new ArrayList<>();

        // Nombres y roles predefinidos para los datos aleatorios
        String[] names = {"Alice", "Bob", "Charlie", "Diana", "Eve", "Frank", "Grace", "Hank"};
        String[] roles = {"Developer", "Tester", "Manager", "Analyst", "Designer", "Support", "Lead", "Engineer"};

        Random random = new Random();

        // Generar 8 empleados aleatorios
        for (int i = 0; i < 8; i++) {
            Employee employee = new Employee((long) (i + 1), names[random.nextInt(names.length)], roles[random.nextInt(roles.length)]);
            employees.add(employee);
        }

        // Mostrar la lista de empleados
        employees.forEach(System.out::println);

        return employees;
    }

    @Override
    public Flux<Employee> getAllEmployees() {
       return Flux.fromIterable(crearBDMemoria());
    }

    @Override
    public Mono<Employee> getEmployeeById(Long id) {
        return this.getAllEmployees().filter(employee -> employee.getId().equals(id))
                .next();
    }

    @Override
    public Mono<Employee> saveEmployee(Employee employee) {
        return this.getEmployeeById(employee.getId())
                .switchIfEmpty(Mono.just(employee).map(p -> {
                    crearBDMemoria().add(employee);
                    return p;
                }))
                .then(Mono.just(employee));

    }

    @Override
    public Mono<Employee> updateEmployee(Long id, Employee employee) {
        return this.getEmployeeById(id)
                .map(p -> {
                    p.setName(employee.getName());
                    p.setRole(employee.getRole());
                    return p;
                }).switchIfEmpty(Mono.error(new Exception("El empleado NO existe")));
    }

    @Override
    public Mono<Employee> deleteEmployee(Long id) {
        return this.getEmployeeById(id)
                .map(employee -> {
                    crearBDMemoria().removeIf(e -> e.getId().equals(id));
                    return employee;
                })
                .switchIfEmpty(Mono.error(new Exception("El empleado NO existe")));
    }
}

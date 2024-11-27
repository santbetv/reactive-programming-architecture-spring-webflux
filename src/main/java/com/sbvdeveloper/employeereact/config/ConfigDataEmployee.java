package com.sbvdeveloper.employeereact.config;

import com.sbvdeveloper.employeereact.domain.Employee;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class ConfigDataEmployee {

//    @Bean
//    public static List<Employee> crearBDMemoria(){
//        // Lista para almacenar empleados
//        List<Employee> employees = new ArrayList<>();
//
//        // Nombres y roles predefinidos para los datos aleatorios
//        String[] names = {"Alice", "Bob", "Charlie", "Diana", "Eve", "Frank", "Grace", "Hank"};
//        String[] roles = {"Developer", "Tester", "Manager", "Analyst", "Designer", "Support", "Lead", "Engineer"};
//
//        Random random = new Random();
//
//        // Generar 8 empleados aleatorios
//        for (int i = 0; i < 8; i++) {
////            Employee employee = Employee.builder()
////                    .id((long) (i + 1))  // IDs consecutivos
////                    .name(names[random.nextInt(names.length)])  // Nombres aleatorios
////                    .role(roles[random.nextInt(roles.length)])  // Roles aleatorios
////                    .build();
//            Employee employee = new Employee((long) (i + 1), names[random.nextInt(names.length)], roles[random.nextInt(roles.length)]);
//            employees.add(employee);
//        }
//
//        // Mostrar la lista de empleados
//        employees.forEach(System.out::println);
//
//        return employees;
//    }

}

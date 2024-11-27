package com.sbvdeveloper.employeereact.domain;

import lombok.*;

/**
 *
 * @author santiago betancur
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Employee {

    private Long id;
    private String name;
    private String role;

    @Override
    public String toString() {
        return "Employee{" + "id=" + id + ", name=" + name + ", role=" + role + '}';
    }
}

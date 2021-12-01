package com.example.demo.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "tbl_employee")
public class Employee {

    @Id
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "employee_sequence")
    @SequenceGenerator(
            name = "employee_sequence",
            sequenceName = "employee_id_seq",
            allocationSize = 1
    )
    private Long employeeId;

    String fullName;

    public Employee(String fullName) {
        this.fullName = fullName;
    }
}

package com.example.expenses.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@AllArgsConstructor
@NoArgsConstructor
@Entity
@Data //handles getters and setters for all
@Table(name = "employee")
public class Employee {

    @Id
    private Long id;

    private String name;

    private String email;


}

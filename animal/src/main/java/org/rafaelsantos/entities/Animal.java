package org.rafaelsantos.entities;

import jakarta.persistence.*;

@Entity
@Table(name = "tb_animals")
public class Animal {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;

    private String gender;
    private Integer age;

}

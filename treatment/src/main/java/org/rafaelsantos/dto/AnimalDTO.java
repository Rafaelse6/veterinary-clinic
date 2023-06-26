package org.rafaelsantos.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.extern.jackson.Jacksonized;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Jacksonized
public class AnimalDTO {

    private String name;
    private String gender;
    private Integer age;
}

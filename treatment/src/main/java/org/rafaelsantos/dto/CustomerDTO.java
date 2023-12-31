package org.rafaelsantos.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.extern.jackson.Jacksonized;


@Data
@NoArgsConstructor
@AllArgsConstructor
@Jacksonized
public class CustomerDTO {

    private Long id;
    private String name;
    private String phone;
    private String email;
    private String address;
}

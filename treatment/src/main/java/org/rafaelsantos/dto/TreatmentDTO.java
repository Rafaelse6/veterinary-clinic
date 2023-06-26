package org.rafaelsantos.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.extern.jackson.Jacksonized;

import java.math.BigDecimal;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Jacksonized
public class TreatmentDTO {

    private Long customerId;
    private Long customerName;
    private Long animalId;
    private BigDecimal treatmentValue;
}

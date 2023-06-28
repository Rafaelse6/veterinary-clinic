package org.rafaelsantos.services;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import jakarta.ws.rs.NotFoundException;
import org.eclipse.microprofile.rest.client.inject.RegisterRestClient;
import org.eclipse.microprofile.rest.client.inject.RestClient;
import org.rafaelsantos.clients.AnimalClient;
import org.rafaelsantos.clients.CustomerClient;
import org.rafaelsantos.dto.CustomerDTO;
import org.rafaelsantos.dto.TreatmentDTO;
import org.rafaelsantos.entities.Treatment;
import org.rafaelsantos.repositories.TreatmentRepository;

import java.util.ArrayList;
import java.util.List;

@ApplicationScoped
public class TreatmentService {

    @Inject
    private TreatmentRepository treatmentRepository;

    @Inject
    @RestClient
    private CustomerClient customerClient;

    @Inject
    @RestClient
    private AnimalClient animalClient;

    public List<TreatmentDTO> getAllTreatments() {
        List<TreatmentDTO> treatments = new ArrayList<>();

        treatmentRepository.findAll().stream().forEach(item -> {
            treatments.add(mapEntityToDTO(item));
        });

        return treatments;
    }

    public void saveNewTreatment(TreatmentDTO treatmentDTO){
        CustomerDTO customerDTO = customerClient.getCustomerById(treatmentDTO.getCustomerId());

        if(customerDTO.getName().equals(treatmentDTO.getCustomerName())
                && animalClient.getAnimalById(treatmentDTO.getAnimalId()) != null){
           treatmentRepository.persist(mapDtoToEntity(treatmentDTO));
        } else {
            throw new NotFoundException();
        }

    }

    private TreatmentDTO mapEntityToDTO(Treatment item) {

        TreatmentDTO treatmentDTO = new TreatmentDTO();

        treatmentDTO.setCustomerId(item.getCustomerId());
        treatmentDTO.setCustomerName(item.getCustomerName());
        treatmentDTO.setAnimalId(item.getAnimalId());
        treatmentDTO.setTreatmentValue(item.getTreatmentValue());

        return treatmentDTO;
    }

    private Treatment mapDtoToEntity(TreatmentDTO item){
        Treatment treatment = new Treatment();

       treatment.setCustomerId(item.getCustomerId());
       treatment.setCustomerName(item.getCustomerName());
       treatment.setAnimalId(item.getAnimalId());
       treatment.setTreatmentValue(item.getTreatmentValue());

        return treatment;
    }
}
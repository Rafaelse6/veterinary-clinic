package org.rafaelsantos.services;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import org.rafaelsantos.dto.AnimalDTO;
import org.rafaelsantos.entities.Animal;
import org.rafaelsantos.repositories.AnimalRepository;

import java.util.ArrayList;
import java.util.List;

@ApplicationScoped
public class AnimalService {

    @Inject
    private AnimalRepository animalRepository;

    public List<AnimalDTO> findAllAnimals(){
        List<AnimalDTO> animals = new ArrayList<>();

        animalRepository.findAll().stream().forEach(item ->{
            animals.add(mapAnimalEntityToDTO(item));
        });

        return animals;
    }

    public AnimalDTO findAnimalById(Long id){
        return mapAnimalEntityToDTO(animalRepository.findById(id));
    }

    public void createNewAnimal(AnimalDTO animalDTO){
        animalRepository.persist(mapAnimalDtoToEntity(animalDTO));
    }

    public void updateAnimal(Long id, AnimalDTO animalDTO){
        Animal animal = animalRepository.findById(id);

        animal.setName(animalDTO.getName());
        animal.setAge(animalDTO.getAge());
        animal.setGender(animalDTO.getGender());

        animalRepository.persist(animal);
    }

    public void deleteAnimal(Long id){
        animalRepository.deleteById(id);
    }

    private AnimalDTO mapAnimalEntityToDTO(Animal animal){
        AnimalDTO animalDTO = new AnimalDTO();

        animalDTO.setAge(animal.getAge());
        animalDTO.setName(animal.getName());
        animalDTO.setGender(animal.getGender());

        return animalDTO;
    }

    private Animal mapAnimalDtoToEntity(AnimalDTO animal){
        Animal animalEntity = new Animal();

        animalEntity.setAge(animal.getAge());
        animalEntity.setName(animal.getName());
        animalEntity.setGender(animal.getGender());

        return animalEntity;
    }
}

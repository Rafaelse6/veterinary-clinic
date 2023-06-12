package org.rafaelsantos.services;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import org.rafaelsantos.dto.AnimalDTO;
import org.rafaelsantos.entities.Animal;
import org.rafaelsantos.repositories.AnimalRepository;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@ApplicationScoped
public class AnimalService {

    @Inject
    private AnimalRepository animalRepository;

    public List<AnimalDTO> findAllAnimals(){
      List<AnimalDTO> animals = new ArrayList<>();

      animalRepository.findAll().stream().forEach(x -> {
          animals.add(mapAnimalToDTO(x));
      });

      return animals;
    }

    public void findAnimalById(Long id){
        animalRepository.findById(id);
    }

    public void createNewAnimal(AnimalDTO animalDTO){
        animalRepository.persist(mapAnimalDtoToEntity(animalDTO));
    }

    public void changeAnimal(Long id, AnimalDTO animalDTO){
        Animal animal = animalRepository.findById(id);

        animal.setId(animalDTO.getId());
        animal.setName(animalDTO.getName());
        animal.setAge(animalDTO.getAge());
        animal.setGender(animalDTO.getGender());

        animalRepository.persist(animal);
    }

    public void deleteAnimal(Long id){
        animalRepository.deleteById(id);
    }

    private AnimalDTO mapAnimalToDTO(Animal animal) {
        AnimalDTO animalDTO = new AnimalDTO();

        animalDTO.setId(animal.getId());
        animalDTO.setName(animal.getName());
        animalDTO.setAge(animal.getAge());
        animalDTO.setGender(animalDTO.getGender());

        return animalDTO;
    }

    private Animal mapAnimalDtoToEntity(AnimalDTO animalEntity){
        Animal animal = new Animal();

        animal.setId(animal.getId());
        animal.setName(animal.getName());
        animal.setAge(animal.getAge());
        animal.setGender(animal.getGender());

        return animal;
    }

}

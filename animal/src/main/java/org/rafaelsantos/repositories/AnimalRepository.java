package org.rafaelsantos.repositories;

import io.quarkus.hibernate.orm.panache.PanacheRepository;
import jakarta.enterprise.context.ApplicationScoped;
import org.rafaelsantos.entities.Animal;

@ApplicationScoped
public class AnimalRepository implements PanacheRepository<Animal> {
}

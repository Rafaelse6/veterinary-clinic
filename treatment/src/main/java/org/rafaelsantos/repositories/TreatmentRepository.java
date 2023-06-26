package org.rafaelsantos.repositories;

import io.quarkus.hibernate.orm.panache.PanacheRepository;
import jakarta.enterprise.context.ApplicationScoped;
import org.rafaelsantos.entities.Treatment;

@ApplicationScoped
public class TreatmentRepository implements PanacheRepository<Treatment> {
}

package org.rafaelsantos.repositories;

import io.quarkus.hibernate.orm.panache.PanacheRepository;
import jakarta.enterprise.context.ApplicationScoped;
import org.rafaelsantos.entities.Customer;

@ApplicationScoped
public class CustomerRepository implements PanacheRepository<Customer> {
}

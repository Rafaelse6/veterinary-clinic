package org.rafaelsantos.services;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import org.rafaelsantos.dto.CustomerDTO;
import org.rafaelsantos.entities.Customer;
import org.rafaelsantos.repositories.CustomerRepository;

import java.util.ArrayList;
import java.util.List;

@ApplicationScoped
public class CustomerService {

    @Inject
    private CustomerRepository customerRepository;

    public List<CustomerDTO> findAllCustomers(){
        List<CustomerDTO> customers = new ArrayList<>();

        customerRepository.findAll().stream().forEach(item -> {
            customers.add(mapCustomerEntityToDTO(item));
        });

        return customers;
    }

    public CustomerDTO findCustomerById(Long id){
        return mapCustomerEntityToDTO(customerRepository.findById(id));
    }

    public void createNewCustomer(CustomerDTO customerDTO){
        customerRepository.persist(mapCustomerDtoToEntity(customerDTO));
    }

    public void updateCustomer(Long id, CustomerDTO customerDTO){
        Customer customer = customerRepository.findById(id);

        customer.setName(customerDTO.getName());
        customer.setAddress(customerDTO.getAddress());
        customer.setPhone(customerDTO.getPhone());
        customer.setEmail(customerDTO.getEmail());

        customerRepository.persist(customer);
    }

    public void deleteCustomer(Long id){
        customerRepository.deleteById(id);
    }

    private CustomerDTO mapCustomerEntityToDTO(Customer customer){
        CustomerDTO customerDTO = new CustomerDTO();

        customerDTO.setAddress(customer.getAddress());
        customerDTO.setEmail(customer.getEmail());
        customerDTO.setName(customer.getName());
        customerDTO.setPhone(customer.getPhone());

        return customerDTO;
    }

    private Customer mapCustomerDtoToEntity(CustomerDTO customer){
        Customer customerEntity = new Customer();

        customerEntity.setAddress(customer.getAddress());
        customerEntity.setEmail(customer.getEmail());
        customerEntity.setName(customer.getName());
        customerEntity.setPhone(customer.getPhone());

        return customerEntity;
    }
}

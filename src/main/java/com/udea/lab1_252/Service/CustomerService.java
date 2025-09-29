package com.udea.lab1_252.Service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.udea.lab1_252.DTO.CustomerDTO;
import com.udea.lab1_252.Entity.Customer;
import com.udea.lab1_252.Mapper.CustomerMapper;
import com.udea.lab1_252.Repository.CustomerRepository;

@Service
public class CustomerService {
    private final CustomerRepository customerRepository;
    private final CustomerMapper customerMapper;

    public CustomerService(CustomerRepository customerRepository, CustomerMapper customerMapper){
        this.customerRepository = customerRepository;
        this.customerMapper = customerMapper;
    }

    // Obtener información de todos los clientes

    public List<CustomerDTO> getAllCustomers() {
        return customerRepository.findAll().stream().map(customerMapper::toDTO).toList();
    }

    // Obtener el dato de un cliente por un Id

    public CustomerDTO getCustomerByID(Long Id){
        return customerRepository.findById(Id).map(customerMapper::toDTO).orElseThrow(()-> new RuntimeException("Cliente no Encontrado"));
    }

    // Crear un cliente nuevo

    public CustomerDTO createCustomer(CustomerDTO customerDTO) {
        Customer customer = customerMapper.toEntity(customerDTO);
        return customerMapper.toDTO(customerRepository.save(customer));
    }
}

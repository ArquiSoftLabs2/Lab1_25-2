package com.udea.lab1_252.Controller;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.udea.lab1_252.DTO.CustomerDTO;
import com.udea.lab1_252.Service.CustomerService;

@RestController
@RequestMapping("/api/customers")
public class CustomarController {
    private final CustomerService customerService;

    public CustomarController (CustomerService customerService) {
        this.customerService = customerService;
    }

    // Obtener todos los clientes
    // Recursos HTTP --> URL
    // Metodos HTTP --> GET, POST, PUT, DELETE
    // Representación del recurso JSON / XML / Texto plano

    @GetMapping
    public ResponseEntity<List<CustomerDTO>> getAllCustomers(){
        return ResponseEntity.ok(customerService.getAllCustomers());
    }

    // Obtener un cliente por un Id

    @GetMapping("/{id}")
    public ResponseEntity<CustomerDTO> getCustomerById(@PathVariable Long id) {
        return ResponseEntity.ok(customerService.getCustomerByID(id));
    }

    // Crear un nuevo cliente
    @PostMapping
    public ResponseEntity<CustomerDTO> createCustomer(@RequestBody CustomerDTO customerDTO){
        if(customerDTO.getBalance()==null){
            throw new IllegalArgumentException("El saldo no puede ser nulo");
        }
        return ResponseEntity.ok(customerService.createCustomer(customerDTO));
    }

}

package com.udea.lab1_252.Repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.udea.lab1_252.Entity.Customer;

@Repository
public interface CustomerRepository extends JpaRepository<Customer, Long>{

    Optional<Customer> findByAccountNumber(String accountNumber);
} 

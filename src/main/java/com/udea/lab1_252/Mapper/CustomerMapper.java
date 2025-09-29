package com.udea.lab1_252.Mapper;

import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import com.udea.lab1_252.DTO.CustomerDTO;
import com.udea.lab1_252.Entity.Customer;

@Mapper(componentModel = "spring")
public interface CustomerMapper {

    CustomerMapper INSTANCE = Mappers.getMapper(CustomerMapper.class);
    CustomerDTO toDTO(Customer customer);
    Customer toEntity(CustomerDTO customerDTO);
    
} 
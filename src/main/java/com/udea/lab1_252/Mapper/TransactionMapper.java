package com.udea.lab1_252.Mapper;

import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import com.udea.lab1_252.Entity.Transaction;
import com.udea.lab1_252.DTO.TransactionDTO;


@Mapper
public interface TransactionMapper {

    TransactionMapper INSTANCE = Mappers.getMapper(TransactionMapper.class);
    TransactionDTO toDTO(Transaction Transaction);
}

package com.safari.exam.service;


import com.safari.exam.dto.BankDto;
import com.safari.exam.model.Bank;
import com.safari.exam.repository.BankRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class BankService {

    @Autowired
    private BankRepository bankRepository;
    public List<BankDto> getBanks() {
       List<Bank> banks = bankRepository.findAll();
       List<BankDto> bankDtos = new ArrayList<>();
       for (Bank b: banks){
           BankDto bankDto = new BankDto();
           bankDto.setId(b.getId());
           bankDto.setBankName(b.getValue());
           bankDtos.add(bankDto);
       }
       return bankDtos;

    }

    public Bank findBankById(long id) {
        return bankRepository.findById(id).get();
    }
}

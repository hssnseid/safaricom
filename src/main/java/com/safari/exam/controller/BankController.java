package com.safari.exam.controller;


import com.safari.exam.dto.BankDto;
import com.safari.exam.service.BankService;
import com.safari.exam.util.GenericResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/bank")
public class BankController {


    @Autowired
    private BankService bankService;

    @GetMapping()
    public ResponseEntity<?> getBanks() {

        List<BankDto> response = bankService.getBanks();
        return ResponseEntity.status(HttpStatus.OK).body(new GenericResponse("success", "data fetched successfully.", response.size(), response));
    }
}

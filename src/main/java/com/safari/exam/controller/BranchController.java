package com.safari.exam.controller;

import com.safari.exam.dto.BankDto;
import com.safari.exam.dto.BranchDto;
import com.safari.exam.model.Bank;
import com.safari.exam.service.BankService;
import com.safari.exam.service.BranchService;
import com.safari.exam.util.GenericResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/branch")
public class BranchController {

    @Autowired
    private BranchService branchService;

    @Autowired
    private BankService bankService;

    @GetMapping()
    public ResponseEntity<?> getBanks(@RequestParam("bank_id") long id) {
        Bank bank = bankService.findBankById(id);
        if (bank != null) {
            List<BranchDto> response = branchService.getBranchByBank(bank);
            return ResponseEntity.status(HttpStatus.OK).body(new GenericResponse("success", "data fetched successfully.", response.size(),response));
         } else {
            return ResponseEntity.status(HttpStatus.OK).body(new GenericResponse("Failed","No bank with Id:"+  id));
        }
    }
}

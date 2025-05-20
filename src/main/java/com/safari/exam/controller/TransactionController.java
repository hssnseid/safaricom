package com.safari.exam.controller;


import com.safari.exam.dto.ReversalDto;
import com.safari.exam.dto.TransactionDto;
import com.safari.exam.service.TransactionService;
import com.safari.exam.util.GenericResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/")
public class TransactionController {
    @Autowired
    private TransactionService transactionService;

    @PostMapping("transaction")
    public ResponseEntity<?> saveTransaction(@RequestBody TransactionDto transactionDto) {
        try {
            TransactionDto response = transactionService.saveTransaction(transactionDto);
            if (response != null)
                return ResponseEntity.status(HttpStatus.OK).body(new GenericResponse("success", "Transaction Saved successfully.", response));
            else
                return ResponseEntity.status(HttpStatus.OK).body(new GenericResponse("FAILED", "Account does NOT exist", transactionDto.getAccountNumber()));

        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(new GenericResponse("Failed", e.getMessage(), transactionDto));
        }

    }

    @PostMapping("reverse")
    public ResponseEntity<?> reverseTransaction(@RequestBody ReversalDto reversalDto) {
        try {
            ReversalDto response = transactionService.reverseTransaction(reversalDto);
            if (response != null)
                return ResponseEntity.status(HttpStatus.OK).body(new GenericResponse("success", "Reversal successfully.", response));
            else
                return ResponseEntity.status(HttpStatus.OK).body(new GenericResponse("FAILED", "Txn does NOT exist", reversalDto.getTransactionId()));

        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(new GenericResponse("Failed", e.getMessage(), reversalDto));
        }
    }
}

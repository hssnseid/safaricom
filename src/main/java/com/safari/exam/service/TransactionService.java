package com.safari.exam.service;

import com.fasterxml.jackson.annotation.ObjectIdGenerators;
import com.safari.exam.ApplicationStatus;
import com.safari.exam.dto.ReversalDto;
import com.safari.exam.dto.TransactionDto;
import com.safari.exam.model.Application;
import com.safari.exam.model.Transaction;
import com.safari.exam.repository.TransactionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.UUID;

@Service
public class TransactionService {

    @Autowired
    private ApplicationService applicationService;

    @Autowired
    private TransactionRepository transactionRepository;

    public TransactionDto saveTransaction(TransactionDto transactionDto) {
        Application application = applicationService.findApplicationByAccountNo(transactionDto.getAccountNumber());
        if (application != null) {
            Transaction t = new Transaction();
            t.setTransactionId(UUID.randomUUID().toString());
            t.setAccountNo(transactionDto.getAccountNumber());
            t.setCreatedAt(new Date());
            t.setNarration(transactionDto.getNarration());
            t.setValue(transactionDto.getAmount().toString());
            t.setStatus("SUCCESS");
            transactionRepository.save(t);
            return transactionDto;
        } else {
            return new TransactionDto();
        }
    }

    public ReversalDto reverseTransaction(ReversalDto reversalDto) {
        Transaction transaction = transactionRepository.findTransactionByTransactionId(reversalDto.getTransactionId());
        if (transaction != null && transaction.getStatus().equals("SUCCESS")) {
            transaction.setStatus("REVERSED");
            transaction.setUpdateAt(new Date());
            transactionRepository.save(transaction);
            reversalDto.setStatus("REVERSED");
            return reversalDto;
        }
        return new ReversalDto();


    }
}

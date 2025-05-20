package com.safari.exam.repository;

import com.safari.exam.model.Transaction;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface TransactionRepository extends JpaRepository<Transaction,Long> {

    Transaction findTransactionByTransactionId(String transactionId);
}

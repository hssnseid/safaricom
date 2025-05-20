package com.safari.exam.repository;

import com.safari.exam.model.Bank;
import com.safari.exam.model.Branch;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public interface BranchRepository extends JpaRepository<Branch,Long> {

    List<Branch> findBranchesByBank(Bank bank);
}

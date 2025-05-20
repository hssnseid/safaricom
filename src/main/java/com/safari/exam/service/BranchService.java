package com.safari.exam.service;

import com.safari.exam.dto.BranchDto;
import com.safari.exam.model.Bank;
import com.safari.exam.model.Branch;
import com.safari.exam.repository.BankRepository;
import com.safari.exam.repository.BranchRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class BranchService {

    @Autowired
    BranchRepository branchRepository;

    @Autowired
    BankRepository bankRepository;

    public List<BranchDto> getBranchByBank(Bank bank) {

        List<Branch> branches = branchRepository.findBranchesByBank(bank);
        List<BranchDto> branchList = new ArrayList<>();
        for (Branch b : branches) {
            BranchDto branchDto = new BranchDto();
            branchDto.setId(b.getId());
            branchDto.setBranchName(b.getValue());
            branchList.add(branchDto);
        }
        return branchList;

    }
}

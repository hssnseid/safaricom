package com.safari.exam.service;

import com.safari.exam.ApplicationStatus;
import com.safari.exam.dto.ApplicationDto;
import com.safari.exam.model.Application;
import com.safari.exam.repository.ApplicationRepository;
import com.safari.exam.repository.BankRepository;
import com.safari.exam.repository.BranchRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;

@Service
public class ApplicationService {

    @Autowired
    private ApplicationRepository applicationRepository;

    @Autowired
    private BankRepository bankRepository;

    @Autowired
    private BranchRepository branchRepository;
    public Application findApplicationByAccountNo(String accountNumber) {
        return applicationRepository.findApplicationByAccountNumberEquals(accountNumber);
    }

    public ApplicationDto saveApplication(ApplicationDto applicationDto) {
        Application application = new Application();
        application.setAccountName(applicationDto.getAccountName());
        application.setStatus(ApplicationStatus.Submitted);
        application.setAccountNumber(applicationDto.getAccountNumber());
        application.setBankName(bankRepository.findById(applicationDto.getBankId()).get().getValue());
        application.setBranchName(branchRepository.findById(applicationDto.getBranchId()).get().getValue());
        application.setCreatedAt(new Date());
        applicationRepository.save(application);
        return applicationDto;
    }
}

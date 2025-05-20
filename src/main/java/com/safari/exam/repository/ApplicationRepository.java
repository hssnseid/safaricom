package com.safari.exam.repository;

import com.safari.exam.model.Application;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ApplicationRepository extends JpaRepository<Application,Long> {

       Application findApplicationByAccountNumberEquals(String accNo);
}

package com.safari.exam.model;

import jakarta.persistence.*;

import java.util.Date;

@Table(name = "tbl_application")
public class Application {
       @Id
       @GeneratedValue(strategy = GenerationType.AUTO)
       private Long id;
       private String bankName;
       private String branchName;
       private String accountName;
       @Column(unique = true)
       private String accountNumber;
       private Enum status;
       private Date createdAt;
       private Date updatedAt;

       public Long getId() {
              return id;
       }

       public void setId(Long id) {
              this.id = id;
       }

       public String getBankName() {
              return bankName;
       }

       public void setBankName(String bankName) {
              this.bankName = bankName;
       }

       public String getBranchName() {
              return branchName;
       }

       public void setBranchName(String branchName) {
              this.branchName = branchName;
       }

       public String getAccountName() {
              return accountName;
       }

       public void setAccountName(String accountName) {
              this.accountName = accountName;
       }

       public String getAccountNumber() {
              return accountNumber;
       }

       public void setAccountNumber(String accountNumber) {
              this.accountNumber = accountNumber;
       }

       public Enum getStatus() {
              return status;
       }

       public void setStatus(Enum status) {
              this.status = status;
       }

       public Date getCreatedAt() {
              return createdAt;
       }

       public void setCreatedAt(Date createdAt) {
              this.createdAt = createdAt;
       }

       public Date getUpdatedAt() {
              return updatedAt;
       }

       public void setUpdatedAt(Date updatedAt) {
              this.updatedAt = updatedAt;
       }
}

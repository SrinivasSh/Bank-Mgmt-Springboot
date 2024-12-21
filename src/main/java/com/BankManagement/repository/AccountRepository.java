package com.BankManagement.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.BankManagement.entity.Account;

public interface AccountRepository extends JpaRepository<Account, Long>{

}

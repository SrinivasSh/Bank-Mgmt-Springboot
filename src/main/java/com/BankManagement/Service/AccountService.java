package com.BankManagement.Service;

import java.util.List;

import com.BankManagement.entity.Account;

public interface AccountService {
	
	public Account createAccount(Account account);
	public Account getAccountDetailsByAccountNumber(Long accountNumber);
	public List<Account> getAccountDetails();
	public Account depositAmount(Long accountNumber, Double amount);
	public Account withDrawAmount(Long accountNumber, Double amount);
	public void closeAccount(Long accountNumber);
	

}

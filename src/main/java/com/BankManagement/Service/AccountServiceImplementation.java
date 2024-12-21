package com.BankManagement.Service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.BankManagement.entity.Account;
import com.BankManagement.repository.AccountRepository;
@Service
public class AccountServiceImplementation implements AccountService{
	
	@Autowired
	AccountRepository repo;

	@Override
	public Account createAccount(Account account) {
		Account account_saved=repo.save(account);
		return account_saved;
	}

	@Override
	public Account getAccountDetailsByAccountNumber(Long accountNumber) {
		Optional<Account> account=repo.findById(accountNumber);
		if(account.isEmpty()) {
			throw new RuntimeException("Account doesn't exit");
		}
	return account.get();
		
	}

	@Override
	public List<Account> getAccountDetails() {
		List<Account> getAllAccounts=repo.findAll();
		return getAllAccounts;
	}

	@Override
	public Account depositAmount(Long accountNumber, Double amount) {
		Optional<Account> account=repo.findById(accountNumber);
		if(account.isEmpty()) {
			throw new RuntimeException("Account doesn't exit");
		}
		Account accountPresent=account.get();
		Double totalBalance=accountPresent.getAccount_balance()+amount;
		accountPresent.setAccount_balance(totalBalance);
		repo.save(accountPresent);
		return accountPresent;
	}

	@Override
	public Account withDrawAmount(Long accountNumber, Double amount) {
		Optional<Account> account=repo.findById(accountNumber);
		if(account.isEmpty()) {
			throw new RuntimeException("Account doesn't exit");
		}
		Account accountPresent=account.get();
		Double totalBalance=accountPresent.getAccount_balance()-amount;
		accountPresent.setAccount_balance(totalBalance);
		repo.save(accountPresent);
		return accountPresent;
	
	}

	@Override
	public void closeAccount(Long accountNumber) {
	getAccountDetailsByAccountNumber(accountNumber);
	repo.deleteById(accountNumber);
		
	}

}

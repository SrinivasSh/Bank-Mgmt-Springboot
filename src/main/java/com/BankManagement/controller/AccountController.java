package com.BankManagement.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.BankManagement.Service.AccountService;
import com.BankManagement.entity.Account;

@RestController
@RequestMapping("/accounts")
public class AccountController {
	
	
	@Autowired
	AccountService service;
	
	//Create an account by using Post Mapping
	@PostMapping("/create")
	public ResponseEntity<Account> createAccount(@RequestBody Account account){
		Account createAccount=service.createAccount(account);
		return ResponseEntity.status(HttpStatus.CREATED).body(createAccount);
	}
	
	@GetMapping("/{accountNumber}")
	public Account getAccountByAccountNumber(@PathVariable Long accountNumber) {
	Account account=service.getAccountDetailsByAccountNumber(accountNumber);
		return account;
		}

	@GetMapping("getAllAccounts")
	public List<Account> getAllAccounts() {
	List<Account> allAccounts=service.getAccountDetails();
		return allAccounts;
	}
    
	@PutMapping("/deposit/{accountNumber}/{amount}")
	public Account depositAmmount(@PathVariable Long accountNumber, @PathVariable Double amount) {
		Account account=service.depositAmount(accountNumber, amount);
		return account;
		
	}
	
	@PutMapping("/withdraw/{accountNumber}/{amount}")
	public Account withDrawAmount(@PathVariable Long accountNumber, @PathVariable Double amount) {
		Account account=service.withDrawAmount(accountNumber, amount);
		return account;
	}
	
	@DeleteMapping("/delete/{accountNumber}")
	public ResponseEntity<String>closeAccount(@PathVariable Long accountNumber){
		service.closeAccount(accountNumber);
		return ResponseEntity.status(HttpStatus.ACCEPTED).body("Account closed");
		
	}
}

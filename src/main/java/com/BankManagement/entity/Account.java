package com.BankManagement.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table
public class Account {
	
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long accountNumber;
	@Column
	private String account_holder_name;
	@Column
	private Double account_balance;
	
	public Account() {    ///Default Constructor
	}

	public Long getAccountNumber() {
		return accountNumber;
	}

	public void setAccountNumber(Long accountNumber) {
		this.accountNumber = accountNumber;
	}

	public String getAccount_holder_name() {
		return account_holder_name;
	}

	public void setAccount_holder_name(String account_holder_name) {
		this.account_holder_name = account_holder_name;
	}

	public Double getAccount_balance() {
		return account_balance;
	}

	public void setAccount_balance(Double account_balance) {
		this.account_balance = account_balance;
	}

	@Override
	public String toString() {
		return "Account [accountNumber=" + accountNumber + ", account_holder_name=" + account_holder_name
				+ ", account_balance=" + account_balance + "]";
	}

	public Account(String account_holder_name, Double account_balance) {
		super();
		this.account_holder_name = account_holder_name;
		this.account_balance = account_balance;
	}
	
	
	

}

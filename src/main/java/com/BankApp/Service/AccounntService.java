package com.BankApp.Service;

import java.util.List;

import com.BankApp.entity.Account;

public interface AccounntService {
	
	public Account createAccounnt(Account account);
	public Account getAccountDetailsByAccountNumber(Long accountNumber);
	public List<Account> getAllAccounntDetails();
	public Account depositAmount(Long accountNumber,Double amount);
	public Account withdrawAmount(Long accounntNumber,Double amount);
	public void closeAccount(Long accountNumber);

}

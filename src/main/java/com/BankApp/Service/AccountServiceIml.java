package com.BankApp.Service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.BankApp.entity.Account;
import com.BankApp.repository.AccountRepository;
@Service

public class AccountServiceIml implements AccounntService{
	@Autowired
	AccountRepository repo;
	@Override
	public Account createAccounnt(Account account) {
		Account account_save=repo.save(account);
		return account_save;
	}

	@Override
	public Account getAccountDetailsByAccountNumber(Long accountNumber) {
		Optional<Account> account=repo.findById(accountNumber);
		if(account.isEmpty()) {
			throw new RuntimeException("Account is not present");
		}
		Account account_found=account.get();
		
		return account_found;
	}

	@Override
	public List<Account> getAllAccounntDetails() {
		List<Account> ListOfaccount=repo.findAll();
		return ListOfaccount;
	}

	@Override
	public Account depositAmount(Long accountNumber, Double amount) {
		Optional<Account> account=repo.findById(accountNumber);
		if(account.isEmpty()) {
			throw new RuntimeException("Account is not present");
		}
		Account accountPresent=account.get();
		Double totalBalance=accountPresent.getAccount_balance()+amount;
		accountPresent.setAccount_balance(totalBalance);
		repo.save(accountPresent);
		return accountPresent;
	}

	@Override
	public Account withdrawAmount(Long accountNumber, Double amount) {
		Optional<Account> account=repo.findById(accountNumber);
		if(account.isEmpty()) {
			throw new RuntimeException("Account is not present");
		}
		Account accountPresent=account.get();
		
		Double acountBalance=accountPresent.getAccount_balance()-amount;
		accountPresent.setAccount_balance(acountBalance);
		repo.save(accountPresent);
		return accountPresent;
	}

	@Override
	public void closeAccount(Long accountNumber) {
		getAccountDetailsByAccountNumber(accountNumber);
		repo.deleteById(accountNumber);
	}

}

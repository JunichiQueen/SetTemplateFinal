package com.qa.business;

import javax.inject.Inject;

import com.qa.persistence.repository.AccountRepository;

public class AccountServiceImpl implements AccountService{
	
	@Inject
	AccountRepository acc1;

	@Override
	public String addAccount(String account) {
		if (account.contains("9999")) {
			return "{“message”: “This account is blocked”}";
		}
		return acc1.createAccount(account);
	}

	@Override
	public String getAllAccounts() {
		return acc1.getAllAccounts();
	}

	@Override
	public String deleteAccount(int accountNumber) {
		return acc1.deleteAccount(accountNumber);
	}

	@Override
	public String updateAccount() {
		// TODO Auto-generated method stub
		return null;
	}
	

}

package com.qa.business;

public interface AccountService {
	
	String getAllAccounts();
	String addAccount(String account);
	String deleteAccount(int accountNumber);
	String updateAccount();

}

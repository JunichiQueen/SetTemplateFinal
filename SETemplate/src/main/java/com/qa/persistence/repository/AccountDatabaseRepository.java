package com.qa.persistence.repository;

import java.util.List;

import javax.enterprise.inject.Default;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.persistence.TypedQuery;
import javax.transaction.Transactional;
import javax.transaction.Transactional.TxType;

import com.qa.persistence.domain.Account;
import com.qa.util.JSONUtil;

@Default
@Transactional(TxType.SUPPORTS)
public class AccountDatabaseRepository implements AccountRepository{
	
	@PersistenceContext(unitName = "primary")
	private EntityManager em;
	
	@Inject
	JSONUtil util;

	@Override
	@Transactional(TxType.REQUIRED)
	public String getAllAccounts() {
		Query query = em.createQuery("SELECT a FROM Account a");
		return this.util.getJSONForObject(query.getResultList());
	}
	
	public Account findAccount(int id) {
	  return em.find(Account.class, id);
	}

	@Override
	public String createAccount(String account) {
		Account acc = util.getObjectForJSON(account, Account.class);
		em.persist(acc);
		return null;
	}

	@Override
	public String deleteAccount(int accountNumber) {
		em.remove(em.find(Account.class, accountNumber));
		return null;
	}

	@Override
	public String updateAccount(int accountNumber, String account) {
		Account acc = util.getObjectForJSON(account, Account.class);
		return null;
	}
	


}

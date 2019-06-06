package com.qa.MapTests;

import static org.junit.Assert.assertEquals;

import org.junit.After;
import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;

import com.qa.persistence.domain.Account;
import com.qa.persistence.repository.AccountMapRepository;
import com.qa.util.JSONUtil;

public class AccountServiceTest {

	private AccountMapRepository amr;
	private Account acc1 = new Account(1, "D0001", "Matt", "Hunt");
	private Account acc2 = new Account(2, "D0002", "Bert", "Smith");
	private Account acc3 = new Account(3, "D0003", "Matt", "Hunt");
	private JSONUtil jsonUtil = new JSONUtil();

	@Before
	public void setup() {
		amr = new AccountMapRepository();
	}
	
	@After
	public void tearDown() {
		this.amr = null;
	}

	@Test @Ignore
	public void getAllAccountsTest() {

		assertEquals("{}", amr.getAllAccounts());
	}

	@Test @Ignore
	public void getAllAccountsTest2() {

		amr.getAccountMap().put(1, acc1);
		assertEquals("{\"1\":{\"id\":1,\"accountNumber\":\"D0001\",\"firstName\":\"Matt\",\"lastName\":\"Hunt\"}}",
				amr.getAllAccounts());
	}

	@Test @Ignore
	public void updateAccountTest() {

		amr.getAccountMap().put(1, acc1);
		amr.updateAccount(1, "{\"id\":1,\"accountNumber\":\"D0001\",\"firstName\":\"Matt\",\"lastName\":\"Wright\"}");
		assertEquals("Wright", amr.getAccountMap().get(1).getLastName());
	}

	@Test @Ignore
	public void addAccountTest() {
		String accToCreate = jsonUtil.getJSONForObject(acc1);
		System.out.println(accToCreate);
		assertEquals(amr.createAccount(accToCreate), "Account successfuly created");
		assertEquals(amr.getAccountMap().size(), 1);

	}

	@Test @Ignore
	public void add2AccountsTest() {
		assertEquals(amr.createAccount(jsonUtil.getJSONForObject(acc1)), "Account successfuly created");
		assertEquals(amr.createAccount(jsonUtil.getJSONForObject(acc2)), "Account successfuly created");
		assertEquals(amr.getAccountMap().size(), 2);
	}

	@Test @Ignore
	public void removeAccountTest() {

		amr.getAccountMap().put(1, acc1);

		amr.deleteAccount(1);
		assertEquals(false, amr.getAccountMap().containsKey(1));

	}

	@Test @Ignore
	public void remove2AccountsTest() {
		amr.getAccountMap().put(1, acc1);
		amr.getAccountMap().put(2, acc2);

		amr.deleteAccount(1);
		assertEquals(false, amr.getAccountMap().containsKey((Integer) 1));

		amr.deleteAccount(2);
		assertEquals(false, amr.getAccountMap().containsKey((Integer) 2));

	}

	@Test @Ignore
	public void remove2AccountTestAnd1ThatDoesntExist() {
		amr.getAccountMap().put(1, acc1);
		amr.getAccountMap().put(2, acc2);

		amr.deleteAccount(1);
		assertEquals(false, amr.getAccountMap().containsKey((Integer) 1));

		amr.deleteAccount(3);
		assertEquals(false, amr.getAccountMap().containsKey((Integer) 3));

	}

	@Test @Ignore
	public void jsonStringToAccountConversionTest() {
		String stringToTest = "{\"id\":1,\"accountNumber\":\"D0001\",\"firstName\":\"Matt\",\"lastName\":\"Hunt\"}";
		Account testAccount = jsonUtil.getObjectForJSON(stringToTest, Account.class);
		assertEquals(acc1.getAccountNumber(), testAccount.getAccountNumber());
	}

	@Test @Ignore
	public void accountConversionToJSONTest() {
		String jsonAccount = "{\"id\":1,\"accountNumber\":\"D0001\",\"firstName\":\"Matt\",\"lastName\":\"Hunt\"}";
		String stringToTest = jsonUtil.getJSONForObject(acc1);
		assertEquals(jsonAccount, stringToTest);

	}
}
// @Test @Ignore
// public void firstNameFinder() {
// String name = "John";
//
// amr.createAccount(jsonUtil.getJSONForObject(acc1));
// amr.createAccount(jsonUtil.getJSONForObject(acc2));
// amr.updateAccount(1,
// "{\"id\":1,\"accountNumber\":\"D0001\",\"firstName\":\"John\",\"lastName\":\"Harris\"}");
// amr.updateAccount(2,
// "{\"id\":1,\"accountNumber\":\"D0001\",\"firstName\":\"John\",\"lastName\":\"Smith\"}");
// int counter = amr.findName(name);
//
// assertTrue(counter > 0);
//
// }
//
// @Test @Ignore
//
// public void getCountForFirstNamesInAccountWhenZeroOccurances() {
// String name = "Phillis";
//
// amr.createAccount(jsonUtil.getJSONForObject(acc1));
// amr.createAccount(jsonUtil.getJSONForObject(acc2));
// amr.updateAccount(1,
// "{\"id\":1,\"accountNumber\":\"D0001\",\"firstName\":\"John\",\"lastName\":\"Harris\"}");
// amr.updateAccount(2,
// "{\"id\":1,\"accountNumber\":\"D0001\",\"firstName\":\"John\",\"lastName\":\"Smith\"}");
// int counter = amr.findName(name);
//
// assertEquals(0, counter);
// }
//
// @Test @Ignore
// public void getCountForFirstNamesInAccountWhenOne() {
// String name = "John";
//
// amr.createAccount(jsonUtil.getJSONForObject(acc1));
// amr.createAccount(jsonUtil.getJSONForObject(acc2));
// amr.updateAccount(1,
// "{\"id\":1,\"accountNumber\":\"D0001\",\"firstName\":\"John\",\"lastName\":\"Harris\"}");
// amr.updateAccount(2,
// "{\"id\":1,\"accountNumber\":\"D0001\",\"firstName\":\"Dohn\",\"lastName\":\"Smith\"}");
// int counter = amr.findName(name);
//
// assertEquals(1, counter);
// }
//
// @Test @Ignore
// public void getCountForFirstNamesInAccountWhenTwo() {
//
// String name = "John";
//
// amr.createAccount(jsonUtil.getJSONForObject(acc1));
// amr.createAccount(jsonUtil.getJSONForObject(acc2));
// amr.updateAccount(1,
// "{\"id\":1,\"accountNumber\":\"D0001\",\"firstName\":\"John\",\"lastName\":\"Harris\"}");
// amr.updateAccount(2,
// "{\"id\":1,\"accountNumber\":\"D0001\",\"firstName\":\"John\",\"lastName\":\"Smith\"}");
// int counter = amr.findName(name);
//
// assertEquals(2, counter);
// }
// }

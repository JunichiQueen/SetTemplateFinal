package com.qa.rest;

import javax.inject.Inject;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import com.qa.business.AccountService;

@Path("/account")
public class AccountEndPoint {
	
	@Inject
	AccountService acse;
	
	@Path("/getAllAccounts")
	@GET
	@Produces( "application/json" )
	public String getAllAccounts() {
		return acse.getAllAccounts();
	}
	
	@Path("/addAccount")
	@POST
	@Produces({ "application/json" })
	public String addAccount(String account) {
		return acse.addAccount(account);
	}
	
	@Path("/deleteAccount/{accountNumber}")
	@DELETE
	@Produces({ "application/json" })
	public String deleteAccount(@PathParam("accountNumber") int accountNumber) {
		return acse.deleteAccount(accountNumber);
	}
	
	
	
	

}

package org.archfirst.mmm.adapter.rest;

import java.util.List;

import org.archfirst.mmm.adapter.rest.dto.AccountData;
import org.archfirst.mmm.application.AccountService;
import org.archfirst.mmm.domain.Account;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AccountController {
	
	@Autowired
	private AccountService accountService;
	
	@RequestMapping(value="/accounts", method=RequestMethod.POST)
	public Account createAccount(@RequestBody AccountData accountData) {
		return accountService.createAccount(accountData.getName());
	}
	
	// The path variable id is not used
	@RequestMapping(value="/accounts/{id}", method=RequestMethod.PUT)
	public Account updateAccount(@RequestBody AccountData accountData) {
		return accountService.updateAccount(accountData.getId(), accountData.getName());
	}
	
	@RequestMapping("/accounts/{id}")
	public Account getAccount(@PathVariable int id) {
		return accountService.getAccount(id);
	}
	
	@RequestMapping("/accounts")
	public List<Account> getAccounts() {
		return accountService.getAccounts();
	}

	@RequestMapping(value="/accounts/{id}", method=RequestMethod.DELETE)
	public void deleteAccount(@PathVariable int id) {
		accountService.deleteAccount(id);
	}
}

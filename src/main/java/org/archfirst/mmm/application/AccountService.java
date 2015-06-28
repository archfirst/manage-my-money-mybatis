package org.archfirst.mmm.application;

import java.util.List;

import org.archfirst.mmm.domain.Account;
import org.archfirst.mmm.persistence.AccountMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AccountService {
	
	@Autowired
	private AccountMapper accountMapper;
	
	public Account createAccount(String name) {

		Account account = new Account();
		account.setName(name);

		accountMapper.createAccount(account);
		
		return account;
	}

	public Account updateAccount(int id, String name) {

		Account account = new Account();
		account.setId(id);
		account.setName(name);
		
		accountMapper.updateAccount(account);
		
		return account;
	}

	public Account getAccount(int id) {
		return accountMapper.getAccount(id);
	}

	public List<Account> getAccounts() {
		return accountMapper.getAccounts();
	}

	public void deleteAccount(int id) {
		accountMapper.deleteAccount(id);
	}
}

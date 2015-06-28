package org.archfirst.mmm.persistence;

import java.util.List;

import org.archfirst.mmm.domain.Account;

public interface AccountMapper {
	public void createAccount(Account account);
	public void updateAccount(Account account);
	public Account getAccount(int id);
	public List<Account> getAccounts();
	public void deleteAccount(int id);
}

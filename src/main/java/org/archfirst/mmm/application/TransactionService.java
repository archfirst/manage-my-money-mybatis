package org.archfirst.mmm.application;

import java.util.Date;
import java.util.List;

import org.archfirst.mmm.domain.Account;
import org.archfirst.mmm.domain.Category;
import org.archfirst.mmm.domain.Transaction;
import org.archfirst.mmm.domain.TransactionSummaryForCategory;
import org.archfirst.mmm.persistence.TransactionMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TransactionService {

    @Autowired
    private TransactionMapper transactionMapper;

	public Transaction createTransaction(Date txn_date, String payee, String memo, float amount, int account_id, int category_id) {

		Account account = new Account();
		account.setId(account_id);
		Category category = new Category();
		category.setId(category_id);
		
		Transaction transaction = new Transaction();
		transaction.setTxn_date(txn_date);
		transaction.setPayee(payee);
		transaction.setMemo(memo);
		transaction.setAmount(amount);
		transaction.setAccount(account);
		transaction.setCategory(category);

		transactionMapper.createTransaction(transaction);
		
		return this.getTransaction(transaction.getId());
	}

	public Transaction updateTransaction(int id, Date txn_date, String payee, String memo, float amount, int account_id, int category_id) {

		Account account = new Account();
		account.setId(account_id);
		Category category = new Category();
		category.setId(category_id);
		
		Transaction transaction = new Transaction();
		transaction.setId(id);
		transaction.setTxn_date(txn_date);
		transaction.setPayee(payee);
		transaction.setMemo(memo);
		transaction.setAmount(amount);
		transaction.setAccount(account);
		transaction.setCategory(category);

		transactionMapper.updateTransaction(transaction);
		
		return this.getTransaction(transaction.getId());
	}

    public Transaction getTransaction(int id) {
        return transactionMapper.getTransaction(id);
    }

    public List<Transaction> getTransactions(int accountId) {
        return transactionMapper.getTransactions(accountId);
    }

    public List<TransactionSummaryForCategory> getTransactionsByCategory(Date startDate, Date endDate) {
        return transactionMapper.getTransactionsByCategory(startDate, endDate);
    }

	public void deleteTransaction(int id) {
		transactionMapper.deleteTransaction(id);
	}
}

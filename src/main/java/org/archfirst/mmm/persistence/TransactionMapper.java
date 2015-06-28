package org.archfirst.mmm.persistence;

import java.util.Date;
import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.archfirst.mmm.domain.Transaction;
import org.archfirst.mmm.domain.TransactionSummaryForCategory;

public interface TransactionMapper {
	public void createTransaction(Transaction transaction);
	public void updateTransaction(Transaction transaction);
    public Transaction getTransaction(int id);
    public List<Transaction> getTransactions(int accountId);
    public List<TransactionSummaryForCategory> getTransactionsByCategory(
    		@Param("startDate") Date startDate,
    		@Param("endDate") Date endDate);
	public void deleteTransaction(int id);
}

package org.archfirst.mmm.adapter.rest;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.List;

import org.archfirst.mmm.adapter.rest.dto.TransactionData;
import org.archfirst.mmm.application.TransactionService;
import org.archfirst.mmm.domain.Transaction;
import org.archfirst.mmm.domain.TransactionSummaryForCategory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TransactionController {

    @Autowired
    private TransactionService transactionService;
    
	@RequestMapping(value="/transactions", method=RequestMethod.POST)
	public Transaction createTransaction(@RequestBody TransactionData transactionData) {
		return transactionService.createTransaction(
				transactionData.getTxn_date(),
				transactionData.getPayee(),
				transactionData.getMemo(),
				transactionData.getAmount(),
				transactionData.getAccount_id(),
				transactionData.getCategory_id());
	}

	// The path variable id is not used
	@RequestMapping(value="/transactions/{id}", method=RequestMethod.PUT)
	public Transaction updateTransaction(@RequestBody TransactionData transactionData) {
		return transactionService.updateTransaction(
				transactionData.getId(),
				transactionData.getTxn_date(),
				transactionData.getPayee(),
				transactionData.getMemo(),
				transactionData.getAmount(),
				transactionData.getAccount_id(),
				transactionData.getCategory_id());
	}
	
    @RequestMapping("/transactions/{id}")
    public Transaction getTransaction(@PathVariable int id) {
        return transactionService.getTransaction(id);
    }

	@RequestMapping(value="/transactions", params="account")
    public List<Transaction> getTransactions(@RequestParam("account") Integer accountId) {
        return transactionService.getTransactions(accountId);    		
    }

	@RequestMapping(value="/transactions", params="groupByCategory")
    public List<TransactionSummaryForCategory> getTransactionsByCategory(
    		@RequestParam(value="startDate", defaultValue="1900-01-01") String startDate,
    		@RequestParam(value="endDate", defaultValue="2099-12-31") String endDate
    		) throws ParseException {
    	
		DateFormat format = new SimpleDateFormat("yyyy-MM-dd");
		return transactionService.getTransactionsByCategory(format.parse(startDate), format.parse(endDate));
    }

	@RequestMapping(value="/transactions/{id}", method=RequestMethod.DELETE)
	public void deleteTransaction(@PathVariable int id) {
		transactionService.deleteTransaction(id);
	}
}

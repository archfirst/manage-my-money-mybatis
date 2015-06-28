package org.archfirst.mmm.adapter.rest.dto;

import java.util.Date;

public class TransactionData {
    private Integer id;
    private Date txn_date;
    private String payee;
    private String memo;
    private float amount;
    private int account_id;
    private int category_id;
    
	public Integer getId() {
		return id;
	}

	public Date getTxn_date() {
		return txn_date;
	}

	public String getPayee() {
		return payee;
	}

	public String getMemo() {
		return memo;
	}

	public float getAmount() {
		return amount;
	}

	public int getAccount_id() {
		return account_id;
	}

	public int getCategory_id() {
		return category_id;
	}
}

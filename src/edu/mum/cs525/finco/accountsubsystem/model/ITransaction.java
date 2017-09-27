package edu.mum.cs525.finco.accountsubsystem.model;

import java.util.Date;

public interface ITransaction {
	 public double getTransactionAmount();

	    public TransactionType getTransactionType() ;

	    public Date getTransactionDate() ;
}

package edu.mum.cs525.finco.accountsubsystem.model;

import java.util.Date;

public class Transaction implements ITransaction {
    private double transactionAmount;
    private TransactionType transactionType;
    private Date transactionDate;

    public Transaction(double transactionAmount,
                       TransactionType transactionType, Date transactionDate) {
        super();
        this.transactionAmount = transactionAmount;
        this.transactionType = transactionType;
        this.transactionDate = transactionDate;
    }

    public Transaction(double transactionAmount,
                       TransactionType transactionType) {
        super();
        this.transactionAmount = transactionAmount;
        this.transactionType = transactionType;
        this.transactionDate = new Date();
    }

    public double getTransactionAmount() {
        return transactionAmount;
    }

    public TransactionType getTransactionType() {
        return transactionType;
    }

    public Date getTransactionDate() {
        return transactionDate;
    }
}

package edu.mum.cs525.finco.accountsubsystem.model;

import edu.mum.cs525.finco.accountsubsystem.controller.EvaluateFunctor;
import edu.mum.cs525.finco.customersubsystem.model.Customer;
import edu.mum.cs525.finco.customersubsystem.model.ICustomer;

import java.util.ArrayList;
import java.util.List;

public class Account implements IAccount{

    private ICustomer accountOwner;
    
    private String accountNumber;
    
    private double accountBalance;
    
    private double accountInterestRate;
    
    private String accountType;
    
	private List<ITransaction> transactions;
	private EvaluateFunctor func;
	
    public Account(ICustomer accountOwner, String accountNumber,double accountInterestRate, EvaluateFunctor evaluateFunctor) {
		super();
		this.accountOwner = accountOwner;
		this.accountNumber = accountNumber;
		this.transactions = new ArrayList<>();
		this.accountInterestRate=0.25;
		this.accountBalance=0;
		this.func = evaluateFunctor;
	}

    public Account(ICustomer accountOwner, String accountNumber, EvaluateFunctor evaluateFunctor) {
		super();
		this.accountOwner = accountOwner;
		this.accountNumber = accountNumber;
		this.transactions = new ArrayList<>();
		this.accountInterestRate=0.0;
		this.accountBalance=0.0;
		this.func = evaluateFunctor;
	}

	public Account(){
    	accountOwner=new Customer();
    	accountNumber="";
    	this.transactions = new ArrayList<>();
    }

	@Override
	public void deposite(ITransaction transaction) {
		evaluateTransaction(transaction);
		this.accountBalance+=transaction.getTransactionAmount();
		transactions.add(transaction);
	}

	@Override
	public void withdraw(ITransaction transaction) {
		evaluateTransaction(transaction);
		this.accountBalance-=transaction.getTransactionAmount();
		transactions.add(transaction);		
	}

	@Override
	public void addInterest() {
		double addAmount=this.accountBalance*(this.accountInterestRate);
		Transaction t=new Transaction(addAmount, TransactionType.INTEREST);
		evaluateTransaction(t);
		this.accountBalance+=addAmount;
		transactions.add(t);				
	}

	@Override
	public String generateReport() {
		StringBuilder report=new StringBuilder();
		report.append("Account No.:"+this.accountNumber );
		report.append("Account Owner Name:"+this.accountOwner.getName());
		report.append("Account Balance:"+this.getAccountBalance() );
		for (int i = 0; i < this.getTransactions().size(); i++) {
			report.append("Account Transaction"+(i+1)+" :"+this.getAccountBalance() );
		}
		return report.toString();
	}
	
	@Override
	public void evaluateTransaction(ITransaction transaction) {
		func.evaluateTemplate(transaction, this);
	}

	public ICustomer getAccountOwner() {
		return accountOwner;
	}

	public void setAccountOwner(Customer accountOwner) {
		this.accountOwner = accountOwner;
	}

	public String getAccountNumber() {
		return accountNumber;
	}

	public void setAccountNumber(String accountNumber) {
		this.accountNumber = accountNumber;
	}

	public double getAccountBalance() {
		return accountBalance;
	}

	public void setAccountBalance(double accountBalance) {
		this.accountBalance = accountBalance;
	}

	public List<ITransaction> getTransactions() {
		return transactions;
	}

	public void setTransactions(List<ITransaction> transactions) {
		this.transactions = transactions;
	}

	public void addAccountTransactions(ITransaction transaction) {
		transactions.add(transaction);
	}

	public EvaluateFunctor getFunc() {
		return func;
	}

	public void setFunc(EvaluateFunctor func) {
		this.func = func;
	}

	@Override
	public String toString() {
		return accountNumber;
	}
	


	public double getAccountInterestRate() {
		return accountInterestRate;
	}

	@Override
	public String getAccountType() {
		return accountType;
	}

	@Override
	public void setAccountType(String accountType) {
		this.accountType = accountType;
	}
}

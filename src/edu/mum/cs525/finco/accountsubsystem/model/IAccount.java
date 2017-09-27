package edu.mum.cs525.finco.accountsubsystem.model;

import edu.mum.cs525.finco.customersubsystem.model.ICustomer;

public interface IAccount {
    void deposite(ITransaction transaction);
    void withdraw(ITransaction transaction);
    void addInterest();
    void evaluateTransaction(ITransaction transaction);
    String generateReport();
    public ICustomer getAccountOwner();
    public double getAccountBalance() ;
    public String getAccountNumber();
    public String getAccountType();
    public void setAccountType(String accountType);   
}

package edu.mum.cs525.finco.accountsubsystem.controller;

import edu.mum.cs525.finco.accountsubsystem.model.Account;
import edu.mum.cs525.finco.accountsubsystem.model.IAccount;
import edu.mum.cs525.finco.customersubsystem.model.ICompany;
import edu.mum.cs525.finco.customersubsystem.model.IPerson;

public class AccountVisitor implements IAccountVisitor {
    @Override
    public IAccount createAccount(IPerson person,String accountNumber) {
    	return new Account( person,accountNumber, new PersonEvaluatorFunctor());
    }

    @Override
    public IAccount createAccount(ICompany company,String accountNumber) {
    	return new Account(company,accountNumber, new CompanyEvaluatorFunctor());

    }
}

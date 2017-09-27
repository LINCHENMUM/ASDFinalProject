package edu.mum.cs525.finco.accountsubsystem.controller;

import edu.mum.cs525.finco.accountsubsystem.model.IAccount;
import edu.mum.cs525.finco.customersubsystem.model.ICompany;
import edu.mum.cs525.finco.customersubsystem.model.IPerson;

public interface IAccountVisitor {
    IAccount createAccount(IPerson person,String accountNumber);
    IAccount createAccount(ICompany company,String accountNumber);
}

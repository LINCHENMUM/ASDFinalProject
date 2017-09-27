package edu.mum.cs525.ccard.accountsubsystem.controller;

import edu.mum.cs525.ccard.accountsubsystem.model.BronzeCCardAccount;
import edu.mum.cs525.finco.accountsubsystem.controller.AccountVisitor;
import edu.mum.cs525.finco.accountsubsystem.controller.CompanyEvaluatorFunctor;
import edu.mum.cs525.finco.accountsubsystem.controller.PersonEvaluatorFunctor;
import edu.mum.cs525.finco.accountsubsystem.model.IAccount;
import edu.mum.cs525.finco.customersubsystem.model.ICompany;
import edu.mum.cs525.finco.customersubsystem.model.IPerson;

public class BronzeCCardAccountVisitor extends AccountVisitor{
    @Override
    public IAccount createAccount(IPerson person, String accountNumber) {
        return new BronzeCCardAccount( person,accountNumber, new PersonEvaluatorFunctor());
    }

    @Override
    public IAccount createAccount(ICompany company, String accountNumber) {
        return new BronzeCCardAccount(company,accountNumber, new CompanyEvaluatorFunctor());
    }
}

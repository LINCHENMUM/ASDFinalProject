package edu.mum.cs525.ccard.accountsubsystem.model;

import edu.mum.cs525.finco.accountsubsystem.controller.EvaluateFunctor;
import edu.mum.cs525.finco.customersubsystem.model.ICustomer;

public class BronzeCCardAccount extends CCardAccount {
    public BronzeCCardAccount(ICustomer accountOwner, String accountNumber, double accountInterestRate, EvaluateFunctor evaluateFunctor) {
        super(accountOwner, accountNumber, accountInterestRate, evaluateFunctor);
    }

    public BronzeCCardAccount(ICustomer accountOwner, String accountNumber, EvaluateFunctor evaluateFunctor) {

        super(accountOwner, accountNumber, 0.1, evaluateFunctor);
    }

    public BronzeCCardAccount() {
    }
}

package edu.mum.cs525.ccard.accountsubsystem.model;

import edu.mum.cs525.finco.accountsubsystem.controller.EvaluateFunctor;
import edu.mum.cs525.finco.customersubsystem.model.ICustomer;

public class GoldCCardAccount extends CCardAccount {

    public GoldCCardAccount(ICustomer accountOwner, String accountNumber, double accountInterestRate, EvaluateFunctor evaluateFunctor) {
        super(accountOwner, accountNumber, accountInterestRate, evaluateFunctor);
    }

    public GoldCCardAccount(ICustomer accountOwner, String accountNumber, EvaluateFunctor evaluateFunctor) {

        super(accountOwner, accountNumber,0.06, evaluateFunctor);
    }

    public GoldCCardAccount() {
    }

}

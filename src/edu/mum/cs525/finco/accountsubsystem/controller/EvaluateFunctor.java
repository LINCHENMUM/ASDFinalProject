package edu.mum.cs525.finco.accountsubsystem.controller;

import edu.mum.cs525.finco.accountsubsystem.model.IAccount;
import edu.mum.cs525.finco.accountsubsystem.model.ITransaction;
public abstract class EvaluateFunctor {

    public abstract boolean evaluateTransactionTemplate(ITransaction transaction, IAccount account) ;

    public final void evaluateTemplate(ITransaction transaction, IAccount account){

        if (evaluateTransactionTemplate(transaction, account))
            sendEmail(account);
    }

    private void sendEmail(IAccount count){
        System.out.println("sending email");

    }

}

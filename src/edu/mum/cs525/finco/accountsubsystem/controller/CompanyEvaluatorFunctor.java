package edu.mum.cs525.finco.accountsubsystem.controller;

import edu.mum.cs525.finco.accountsubsystem.model.IAccount;
import edu.mum.cs525.finco.accountsubsystem.model.ITransaction;

public class CompanyEvaluatorFunctor extends EvaluateFunctor {

    @Override
    public boolean evaluateTransactionTemplate(ITransaction transaction, IAccount account) {
        return true;
    }
}

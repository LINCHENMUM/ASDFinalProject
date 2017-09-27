package edu.mum.cs525.ccard.accountsubsystem.model;

import edu.mum.cs525.finco.accountsubsystem.controller.EvaluateFunctor;
import edu.mum.cs525.finco.accountsubsystem.model.Account;
import edu.mum.cs525.finco.accountsubsystem.model.ITransaction;
import edu.mum.cs525.finco.accountsubsystem.model.TransactionType;
import edu.mum.cs525.finco.customersubsystem.model.ICustomer;

import java.time.LocalDate;
import java.time.ZoneId;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

public abstract class CCardAccount extends Account implements ICCardAccount {
    private double minimumPayment;
    private double previousBalance=0.0;
    private Date expireDate;


    public CCardAccount(ICustomer accountOwner, String accountNumber, double accountInterestRate, EvaluateFunctor evaluateFunctor) {
        super(accountOwner, accountNumber, accountInterestRate, evaluateFunctor);
    }
    public CCardAccount(ICustomer accountOwner, String accountNumber, EvaluateFunctor evaluateFunctor) {

        super(accountOwner, accountNumber,0.0, evaluateFunctor);
    }

    public CCardAccount() {
    }

    public double getMinimumPayment() {
        return minimumPayment;
    }

    public void setMinimumPayment(double minimumPayment) {
        this.minimumPayment = minimumPayment;
    }



    @Override
    public String generateReport() {

        double totalCharges=0,totalCredit=0,newBalnce=0,totalDue=0;
        List<ITransaction> currentTransactions=this.getTransactions().stream().filter((x)->{
            Date date = new Date();
            LocalDate localDate = date.toInstant().atZone(ZoneId.systemDefault()).toLocalDate();
            int currentMonth = localDate.getMonthValue();
            return x.getTransactionDate().toInstant().atZone(ZoneId.systemDefault()).toLocalDate().getMonthValue()==currentMonth;}).collect(Collectors.toList());
        for (ITransaction transaction :currentTransactions) {
            if (transaction.getTransactionType()== TransactionType.DEPOSIT){
                totalCharges+=transaction.getTransactionAmount();
            }else
            {
                totalCredit+=transaction.getTransactionAmount();
            }
        }
        newBalnce=this.previousBalance-totalCredit+totalCharges+(this.getAccountInterestRate()*(previousBalance-totalCredit));
        totalDue=this.getMinimumPayment()*newBalnce;


        StringBuilder report=new StringBuilder();
        report.append("Previous balance: "+previousBalance);
        report.append("Total charges: "+ totalCharges);
        report.append("Total credits: "+totalCredit);
        report.append("New balance: "+newBalnce);
        report.append("Total due: "+totalDue);

        return report.toString();
    }
	public Date getExpireDate() {
		return expireDate;
	}
	public void setExpireDate(Date expireDate) {
		this.expireDate = expireDate;
	}
    
}


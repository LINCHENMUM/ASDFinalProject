package edu.mum.cs525.ccard;

import edu.mum.cs525.ccard.accountsubsystem.model.ICCardAccount;
import edu.mum.cs525.ccard.presentation.CCardMainFrame;
import edu.mum.cs525.finco.FinCo;
import edu.mum.cs525.finco.accountsubsystem.controller.AccountController;
import edu.mum.cs525.finco.accountsubsystem.controller.EvaluateFunctor;
import edu.mum.cs525.finco.accountsubsystem.controller.IAccountController;
import edu.mum.cs525.finco.accountsubsystem.controller.IAccountVisitor;
import edu.mum.cs525.finco.accountsubsystem.model.IAccount;
import edu.mum.cs525.finco.accountsubsystem.model.ITransaction;
import edu.mum.cs525.finco.customersubsystem.controller.CustomerController;
import edu.mum.cs525.finco.customersubsystem.controller.ICustomerController;
import edu.mum.cs525.finco.customersubsystem.model.IAddress;
import edu.mum.cs525.finco.customersubsystem.model.ICompany;
import edu.mum.cs525.finco.customersubsystem.model.ICustomer;
import edu.mum.cs525.finco.customersubsystem.model.IPerson;
import edu.mum.cs525.finco.dataaccesssubsystem.DataAccessSubSystem;
import edu.mum.cs525.finco.presentation.FinCoMainFrame;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.util.List;

public class CCard extends FinCo {

    protected DefaultTableModel defaultTableModel;
    EvaluateFunctor evaluateFuctor;
    String amountColumnLabel = "Amount";
    

    @Override
    public String generateReport(IAccount account) {
    	return account.generateReport();
    }


    public static void main(String[] args) {
        CCard card = new CCard();
        String[] dataTableCols = {"ccNumber", "Name", "expDate", "type", "Amount"};
        card.initializeFincoApp(dataTableCols, new CCardMainFrame(card),"CCard system");

    }


    public DefaultTableModel getDefaultTableModel() {
        return defaultTableModel;
    }

    public void setDefaultTableModel(DefaultTableModel defaultTableModel) {
        this.defaultTableModel = defaultTableModel;
    }

    public void addRow(IAccount account) {
		ICustomer customer = account.getAccountOwner();
		Object rowdata[] = new Object[defaultTableModel.getColumnCount()];
		rowdata[0] = account;
		rowdata[1] = customer.getName();
		rowdata[2] = account.getAccountNumber();
		rowdata[3] = ((ICCardAccount)account).getExpireDate();
		rowdata[4] = account.getAccountBalance();
		defaultTableModel.addRow(rowdata);
    }
    
	public EvaluateFunctor getEvaluateFuctor() {
		return evaluateFuctor;
	}

	public void setEvaluateFuctor(EvaluateFunctor evaluateFuctor) {
		this.evaluateFuctor = evaluateFuctor;
	}

}




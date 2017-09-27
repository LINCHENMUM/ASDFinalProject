package edu.mum.cs525.bank;

import edu.mum.cs525.bank.presentation.BankMainFrame;
import edu.mum.cs525.finco.FinCo;
import edu.mum.cs525.finco.accountsubsystem.model.IAccount;
import edu.mum.cs525.finco.customersubsystem.model.IAddress;
import edu.mum.cs525.finco.customersubsystem.model.ICustomer;
import javax.swing.table.DefaultTableModel;

public class Bank extends FinCo {

	String amountColumnLabel = "Amount";

	public static void main(String[] args) {
		Bank bank = new Bank();
		String[] dataTableCols = { "AccountNo", "Name", "city", "P/C", "Type", "Amount" };
		bank.initializeFincoApp(dataTableCols, new BankMainFrame(bank), "Bank system");

	}

	public DefaultTableModel getDefaultTableModel() {
		return defaultTableModel;
	}

	public void setDefaultTableModel(DefaultTableModel defaultTableModel) {
		this.defaultTableModel = defaultTableModel;
	}

	public void addRow(IAccount account) {
		ICustomer customer = account.getAccountOwner();
		IAddress address = customer.getAddress();
		Object rowdata[] = new Object[defaultTableModel.getColumnCount()];
		rowdata[0] = account;
		rowdata[1] = customer.getName();
		rowdata[2] = address.getCity();
		rowdata[3] = customer.getType();
		rowdata[4] = account.getAccountType();
		rowdata[5] = account.getAccountBalance();
		defaultTableModel.addRow(rowdata);
	}

}
package edu.mum.cs525.finco.dataaccesssubsystem;

import edu.mum.cs525.finco.accountsubsystem.model.IAccount;
import edu.mum.cs525.finco.accountsubsystem.model.ITransaction;
import edu.mum.cs525.finco.customersubsystem.model.ICustomer;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by asme on 2/6/17.
 */
public class DataAccessSubSystem implements IDataAccessSubSystem {
    static List<IAccount> accountList=new ArrayList<>();
    static List<ICustomer>customers = new ArrayList<>();
    static List<ITransaction>transactions = new ArrayList<>();

    public  List<IAccount> getAccounts() {
        return null;
    }
    
    public  void addAccounts(IAccount account) {
        accountList.add(account);
    }
    
    public  void addAllAccounts(List<IAccount> accounts) {
        accountList.addAll(accounts);
    }

	public  List<IAccount> getAccountList() {
		return accountList;
	}

	public  void setAccountList(List<IAccount> accountList) {
		DataAccessSubSystem.accountList = accountList;
	}

	public  List<ICustomer> getCustomers() {
		return customers;
	}

	public  void setCustomers(List<ICustomer> customers) {
		DataAccessSubSystem.customers = customers;
	}

	public  List<ITransaction> getTransactions() {
		return transactions;
	}

	public  void setTransactions(List<ITransaction> transactions) {
		DataAccessSubSystem.transactions = transactions;
	}
    
}

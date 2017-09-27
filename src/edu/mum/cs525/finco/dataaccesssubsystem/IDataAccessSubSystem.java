package edu.mum.cs525.finco.dataaccesssubsystem;

import java.util.List;

import edu.mum.cs525.finco.accountsubsystem.model.IAccount;
import edu.mum.cs525.finco.accountsubsystem.model.ITransaction;
import edu.mum.cs525.finco.customersubsystem.model.ICustomer;

public interface IDataAccessSubSystem {
	public   List<ITransaction> getTransactions();
	public   List<ICustomer> getCustomers();
	public  List<IAccount> getAccountList();
	public  void addAccounts(IAccount account);
}

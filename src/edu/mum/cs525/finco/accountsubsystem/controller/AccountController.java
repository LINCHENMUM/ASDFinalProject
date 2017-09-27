package edu.mum.cs525.finco.accountsubsystem.controller;

import edu.mum.cs525.finco.accountsubsystem.model.AccountLogger;
import edu.mum.cs525.finco.accountsubsystem.model.IAccount;
import edu.mum.cs525.finco.accountsubsystem.model.ITransaction;
import edu.mum.cs525.finco.accountsubsystem.model.Transaction;
import edu.mum.cs525.finco.customersubsystem.model.ICompany;
import edu.mum.cs525.finco.customersubsystem.model.IPerson;
import edu.mum.cs525.finco.dataaccesssubsystem.DataAccessSubSystem;
import edu.mum.cs525.finco.dataaccesssubsystem.IDataAccessSubSystem;

import java.util.Iterator;
import java.util.List;

public class AccountController implements IAccountController {
	IDataAccessSubSystem dbStore;
	
	public AccountController() {
		super();
		dbStore = new DataAccessSubSystem();
	}

	@Override
	public void createCompanyAccount(IAccountVisitor accountVisitor,ICompany company,String accountNumber) {
		dbStore.addAccounts(accountVisitor.createAccount(company,accountNumber));
	}

	@Override
	public void createPersonAccount(IAccountVisitor accountVisitor,	IPerson person,String accountNumber) {
		dbStore.addAccounts(accountVisitor.createAccount(person,accountNumber));
		
	}

	@Override
    public void addInterest() {
        List<IAccount> accountList= dbStore.getAccountList();
        Iterator<IAccount> accountIterator=accountList.iterator();
        while(accountIterator.hasNext()){
			AccountLogger accountLogger=new AccountLogger(accountIterator.next());
            accountLogger.addInterest();
        }
    }

    @Override
    public String generateReport(IAccount account) {
    	return account.generateReport();
    }

	@Override
	public void depositeMoney(ITransaction transaction, IAccount account) {
		AccountLogger accountLogger=new AccountLogger(account);
		accountLogger.deposite((Transaction) transaction);
	}

	@Override
	public void withdrawMoney(ITransaction transaction, IAccount account) {
		AccountLogger accountLogger=new AccountLogger(account);
		accountLogger.withdraw((Transaction) transaction);
	}

	public IDataAccessSubSystem getDbStore() {
		return dbStore;
	}

	public void setDbStore(IDataAccessSubSystem dbStore) {
		this.dbStore = dbStore;
	}

	@Override
	public List<IAccount> getAccounts() {
		return dbStore.getAccountList();
	}

	@Override
	public IAccount getAccount(String accountNumber) {
		Iterator<IAccount>iter = dbStore.getAccountList().iterator();
		IAccount account = null;
		while(iter.hasNext()){
			account = iter.next();
			if(accountNumber.equals(account.getAccountNumber())){
				break;
			}
		}
		return account;
	}
}

package edu.mum.cs525.finco.customersubsystem.model;

import java.util.List;

import edu.mum.cs525.finco.accountsubsystem.model.IAccount;

public interface ICustomer {
	public IAddress getAddress();
	public String getName();
	public String getType();
	public List<IAccount>getAccountList();
	public void setAddress(IAddress address);
}

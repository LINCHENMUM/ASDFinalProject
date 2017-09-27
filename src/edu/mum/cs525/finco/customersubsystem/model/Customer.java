package edu.mum.cs525.finco.customersubsystem.model;

import java.util.List;

import edu.mum.cs525.finco.accountsubsystem.model.IAccount;

public class Customer implements ICustomer {
	private IAddress address;
    private String name;
    private String email;
    private List<IAccount>accountList;

    public Customer(String state, String city, String street, String zip, String name, String email) {
		super();
		this.address = new Address(state,city,street,zip);
		this.name = name;
		this.email = email;
	}

	public Customer(Address address, String name, String email) {
		super();
		this.address = address;
		this.name = name;
		this.email = email;
	}

	public Customer(){
		this.address = new Address("","","","");
		this.name = "";
		this.email = "";
    }

	public IAddress getAddress() {
		return address;
	}

	public void setAddress(IAddress address) {
		this.address = address;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
}

	@Override
	public String getType() {
		return null;
	}

	@Override
	public List<IAccount> getAccountList() {
		return accountList;
	}

	public void setAccountList(List<IAccount> accountList) {
		this.accountList = accountList;
	}
	
	}


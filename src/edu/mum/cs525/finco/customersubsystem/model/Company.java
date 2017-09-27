package edu.mum.cs525.finco.customersubsystem.model;


public class Company extends Customer implements ICompany {
	private IAddress address;
    private String name;
    private int noOfEmployees;
    private String email;
    
    public Company(String state, String city, String street, String zip, String name, int noOfEmployees, String email) {
		super();
		this.address = new Address(state,city,street,zip);
		this.name = name;
		this.noOfEmployees = noOfEmployees;
		this.email = email;
	}

	public Company(IAddress address, String name, int noOfEmployees, String email) {
		super();
		this.address = address;
		this.name = name;
		this.noOfEmployees = noOfEmployees;
		this.email = email;
	}

	public Company(){
		this.address = new Address("","","","");
		this.name = "";
		this.noOfEmployees = 0;
		this.email = "";
    }

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getNoOfEmployees() {
		return noOfEmployees;
	}

	public void setBirthDate(int noOfEmployees) {
		this.noOfEmployees = noOfEmployees;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public IAddress getAddress() {
		return address;
	}

	public void setAddress(IAddress address) {
		this.address = address;
	}

	@Override
	public String getType() {
		return "C";
	}

}

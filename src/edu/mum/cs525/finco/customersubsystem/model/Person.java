package edu.mum.cs525.finco.customersubsystem.model;

import java.util.Date;

public class Person extends Customer implements IPerson{
    private IAddress address;
    private String name;
    private Date birthDate;
    private String email;

    public Person(String state, String city, String street, String zip, String name, Date birthDate, String email) {
		super();
		this.address = new Address(state,city,street,zip);
		this.name = name;
		this.birthDate = birthDate;
		this.email = email;
	}

	public Person(IAddress address, String name, Date birthDate, String email) {
		super();
		this.address = address;
		this.name = name;
		this.birthDate = birthDate;
		this.email = email;
	}

	public Person(){
		this.address = new Address("","","","");
		this.name = "";
		this.birthDate = new Date();
		this.email = "";
    }

	public IAddress getAddress() {
		return address;
	}

	public void setAddress(Address address) {
		this.address = address;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Date getBirthDate() {
		return birthDate;
	}

	public void setBirthDate(Date birthDate) {
		this.birthDate = birthDate;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	@Override
	public String getType() {
		return "P";
	}
	
}

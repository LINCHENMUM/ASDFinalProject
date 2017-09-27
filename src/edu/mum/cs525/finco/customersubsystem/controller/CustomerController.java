package edu.mum.cs525.finco.customersubsystem.controller;

import java.util.Date;

import edu.mum.cs525.finco.customersubsystem.model.Address;
import edu.mum.cs525.finco.customersubsystem.model.Company;
import edu.mum.cs525.finco.customersubsystem.model.Person;

public class CustomerController implements ICustomerController {

	@Override
	public Person createPerson(String state, String city, String street,
			String zip, String name, Date birthDate, String email) {
		return new Person(state, city, street,
				 zip,  name,  birthDate,  email);
	}

	@Override
	public Person createPerson() {
		return new Person();
	}

	@Override
	public Person createPerson(Address address, String name, Date birthDate,
			String email) {
		return new Person(address,  name,  birthDate,  email);
	}

	@Override
	public Company createCompany(String state, String city, String street,
			String zip, String name, int noOfEmployees, String email) {
		return new Company(state,  city,  street,
				 zip,  name,  noOfEmployees,  email);
	}

	@Override
	public Company createCompany(Address address, String name,
			int noOfEmployees, String email) {
		return new Company(address,  name,  noOfEmployees,  email);
	}

	@Override
	public Company createCompany() {
		return new Company();
	}
}

package edu.mum.cs525.finco.customersubsystem.controller;

import java.util.Date;

import edu.mum.cs525.finco.customersubsystem.model.Address;
import edu.mum.cs525.finco.customersubsystem.model.Company;
import edu.mum.cs525.finco.customersubsystem.model.Person;

public interface ICustomerController {
    Person createPerson(String state, String city, String street, String zip, String name, Date birthDate, String email);
    Person createPerson();
    Person createPerson(Address address, String name, Date birthDate, String email);    
  
    Company createCompany(String state, String city, String street, String zip, String name, int noOfEmployees, String email);
    Company createCompany(Address address, String name, int noOfEmployees, String email);
    Company createCompany();
}

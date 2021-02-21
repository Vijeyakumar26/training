package com.htc.spring.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;

import com.htc.spring.beans.Address;
import com.htc.spring.beans.Customer;

@Configuration
public class BeansConfig
{
	@Bean(name="customer")
	public Customer getCustomer() {
		Customer customer = new Customer();
		customer.setCustname("Company-1");
		customer.setContactno("95959595");
		customer.setAddress(getAddress());
		return customer;
	}
	
	@Bean(name="customer2")
	public Customer getCustomer2() {
		Customer customer = new Customer();
		customer.setCustname("Company-23");
		customer.setContactno("345345");
		customer.setAddress(getAddress());
		return customer;
	}
	
	@Bean(name="address")
	@Scope(scopeName="prototype")
	public Address getAddress() {
		
		Address address = new Address();
		address.setDoorno("43-43-34");
		address.setStreet("Street1");
		address.setCity("chennai");
		address.setPincode("600043");
		return address;
	}
}

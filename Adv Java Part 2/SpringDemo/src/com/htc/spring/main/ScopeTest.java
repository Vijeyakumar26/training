package com.htc.spring.main;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.htc.spring.beans.Customer;

public class ScopeTest 
{
	public static void main(String[] arg) {

		ApplicationContext context = new ClassPathXmlApplicationContext("ApplicationContext.xml");

		Customer customer1 = (Customer) context.getBean("customer");
		System.out.println(customer1);
		customer1.getAddress().setCity("Bangalore");
		System.out.println(customer1.getAddress());


		Customer customer2 = (Customer) context.getBean("customer1");
		System.out.println(customer2);
		System.out.println(customer2.getAddress());
	}
}

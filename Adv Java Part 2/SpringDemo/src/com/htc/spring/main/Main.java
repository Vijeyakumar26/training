package com.htc.spring.main;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.htc.spring.beans.Customer;

public class Main 
{
	public static void main(String[] args) 
	{
		ApplicationContext context = new ClassPathXmlApplicationContext("ApplicationContext.xml");
		//	ApplicationContext context1 = new FileSystemXmlApplicationContext("c:/f/fs/f//fssd/")

		Customer customer = (Customer) context.getBean("customer");

		System.out.println(customer);
		System.out.println(customer.getAddress());

		Customer customer1 = (Customer) context.getBean("customer1");
		System.out.println(customer1);
		System.out.println(customer1.getAddress());
	}
}

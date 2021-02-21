package com.htc.spring.main;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.htc.spring.beans.Customer;
import com.htc.spring.config.BeansConfig;

public class AnnotationTest 
{
	public static void main(String[] arg) {

		ApplicationContext context = new AnnotationConfigApplicationContext(BeansConfig.class);

		Customer customer = (Customer) context.getBean("customer");

		System.out.println(customer);
		System.out.println(customer.getAddress());
		
		Customer customer2 = (Customer) context.getBean("customer2");

		System.out.println(customer2);
		System.out.println(customer2.getAddress());
	}
}

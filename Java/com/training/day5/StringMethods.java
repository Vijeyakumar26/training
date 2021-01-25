package com.training.day5;
/*
 * 
General methods like  length(), charAt(), replace(),  trim(),   toUpperCase(), toLowerCase () , concat(), getChars()
Search methods like indexOf(), lastIndexOf()
Extractive methods like substring(), split()
Comparison methods like  equals(), equalsIgnoreCase(), compareTo(), regionMatches(), startsWith(), endsWith()
Data Conversion Using valueOf( ) 
 */
public class StringMethods 
{
	public static void main(String[] args) 
	{
		String str = "Hello World!";
		char[] ch = {'e','w','g'};
		System.out.println(str.length());
		System.out.println(str.charAt(8));
		System.out.println(str.replace('d', 'w'));
		System.out.println(str.trim());
		System.out.println(str.toUpperCase());
		System.out.println(str.toLowerCase());
		System.out.println(str.concat(str));
		System.out.println(str.indexOf('d'));
		System.out.println(str.lastIndexOf('l'));
	}
}

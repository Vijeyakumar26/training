package com.htc.xmlParsers;

import java.io.File;
import java.io.IOException;

import javax.xml.XMLConstants;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

import org.w3c.dom.Document;
import org.xml.sax.SAXException;

public class MyDOMParser 
{
	static final String JAXP_SCHEMA_LANGUAGE = "http://java.sun.com/xml/jaxp/properties/schemaLanguage";

	public static void main(String[] args) 
	{
		DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();

		factory.setAttribute(JAXP_SCHEMA_LANGUAGE, XMLConstants.W3C_XML_SCHEMA_NS_URI);
		factory.setNamespaceAware(true);
		factory.setValidating(true);

		DocumentBuilder builder;
		try 
		{
			builder = factory.newDocumentBuilder();

			Document document = builder.parse(new File("customers.xml"));
			
			System.out.println("Document Parsed.");
		}
		catch (SAXException | IOException |ParserConfigurationException e ) 
		{
			e.printStackTrace();
		}
	}
}

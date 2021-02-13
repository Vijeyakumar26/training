package com.htc.xmlParsers;

import java.io.File;
import java.io.IOException;

import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;

import org.xml.sax.SAXException;

public class MySAXParser 
{

	static final String JAXP_SCHEMA_LANGUAGE =
		      "http://java.sun.com/xml/jaxp/properties/schemaLanguage";
		
		static final String JAXP_SCHEMA_SOURCE =
		      "http://java.sun.com/xml/jaxp/properties/schemaSource";
		
		static final String W3C_XML_SCHEMA =
		      "http://www.w3.org/2001/XMLSchema";

		public static SAXParser  getParser(String xsdFile) {
			SAXParser parser = null;
			try {
				SAXParserFactory factory =SAXParserFactory.newInstance();
				factory.setValidating(true);
				factory.setNamespaceAware(true);
				
				parser = factory.newSAXParser(); 
				parser.setProperty(JAXP_SCHEMA_LANGUAGE, W3C_XML_SCHEMA);
				parser.setProperty(JAXP_SCHEMA_SOURCE,xsdFile);  
			}
			catch(Exception e) 
			{
				System.out.println(e);
			}
			return parser;
		} 
		
		public static void main(String[] args) 
		{
			SAXParser p = MySAXParser.getParser("hospital.xsd");
			try
			{
				p.parse(new File("hospital.xml"), new MyErrorHandler());
			} 
			catch (SAXException | IOException e)
			{
				e.printStackTrace();
			}
			
			System.out.println("Parsed");
		}
}

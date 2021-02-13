package com.htc.xmlParsers;

import org.xml.sax.SAXException;
import org.xml.sax.SAXParseException;
import org.xml.sax.helpers.DefaultHandler;

public class MyErrorHandler extends DefaultHandler
{
	@Override
	public void error(SAXParseException e) throws SAXException
	{
		System.out.println(e.getMessage() + "," + e.getColumnNumber() + "," + e.getLineNumber());
	}

	@Override
	public void fatalError(SAXParseException e) throws SAXException
	{
		System.out.println(e.getMessage() + "," + e.getColumnNumber() + "," + e.getLineNumber());
	}

	@Override
	public void warning(SAXParseException e) throws SAXException 
	{
		System.out.println(e.getMessage() + "," + e.getColumnNumber() + "," + e.getLineNumber());
	}

}

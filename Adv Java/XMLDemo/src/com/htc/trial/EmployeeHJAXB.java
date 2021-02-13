package com.htc.trial;

import java.io.File;
import java.util.List;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBElement;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;

import com.htc.jaxb.empHelper.EmployeeTy;
import com.htc.jaxb.empHelper.EmployeesTy;
import com.htc.jaxb.empHelper.ObjectFactory;

public class EmployeeHJAXB 
{
	public static void main(String[] args) 
	{
		try
		{
			JAXBContext jaxbContext = JAXBContext.newInstance("com.htc.jaxb.empHelper");
			Unmarshaller um = jaxbContext.createUnmarshaller();
			JAXBElement<EmployeesTy> root = (JAXBElement<EmployeesTy>)um.unmarshal(new File("employee.xml"));
			EmployeesTy emp = root.getValue();

			List<EmployeeTy> doctors = emp.getEmployee();

			EmployeesTy hty = new ObjectFactory().createEmployeesTy();

			for(EmployeeTy emp1: doctors)
			{
				if(emp1.getTitle().equals("Engineer")) 
				{
					hty.getEmployee().add(emp1);
				}
			}

			Marshaller m = jaxbContext.createMarshaller();
			m.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, Boolean.TRUE);


			m.marshal(new ObjectFactory().createEmployees(hty), new File("engineers.xml"));
			System.out.println("Completed.");

		}
		catch (JAXBException e)
		{
			e.printStackTrace();
		} 

	}

}

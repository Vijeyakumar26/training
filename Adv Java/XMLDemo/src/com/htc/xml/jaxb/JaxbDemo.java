package com.htc.xml.jaxb;

import java.io.File;
import java.util.List;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBElement;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;

import com.htc.jaxb.helpers.DoctorTy;
import com.htc.jaxb.helpers.HospitalTy;
import com.htc.jaxb.helpers.ObjectFactory;

public class JaxbDemo 
{
	public static void main(String[] args)
	{
		try
		{
			JAXBContext jaxbContext = JAXBContext.newInstance("com.htc.jaxb.helpers");
			Unmarshaller um=jaxbContext.createUnmarshaller();
			JAXBElement<HospitalTy> root=(JAXBElement<HospitalTy>)um.unmarshal(new File("hospital.xml"));
			HospitalTy hospital=root.getValue();

			List<DoctorTy> doctors = hospital.getDoctor();

			HospitalTy hty = new ObjectFactory().createHospitalTy();

			for(DoctorTy doctor: doctors)
			{
				if(doctor.getSpeciality().equals("Heart")) 
				{
					hty.getDoctor().add(doctor);
				}
			}

			Marshaller m = jaxbContext.createMarshaller();
			m.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, Boolean.TRUE);


			m.marshal(new ObjectFactory().createHospital(hty), new File("heartdoctors.xml"));
			System.out.println("Completed.");

		}
		catch (JAXBException e)
		{
			e.printStackTrace();
		} 
	}
}

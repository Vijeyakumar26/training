package com.htc.load.dto;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Iterator;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import com.htc.connection.DBConnection;
import com.htc.entity.Customer;

/*
 * (customerId INT PRIMARY KEY,customerName VARCHAR(20), accountno INT, accountType VARCHAR(10), 
 balance Numeric(7,2), mailId VARCHAR(20),contactNo INT);
 */
public class CustomerLoadDTOImpl implements CustomerLoadDTO
{

	@Override
	public void readFile() throws IOException, SQLException, ClassNotFoundException 
	{
		File file = new File("CustomerDetails.xlsx");	

		FileInputStream fis = new FileInputStream(file);
		XSSFWorkbook wb = new XSSFWorkbook(fis);
		XSSFSheet sheet = wb.getSheetAt(0); // creating a Sheet object to retrieve object
		
		Iterator<Row> itr = sheet.iterator(); // iterating over excel file

		Row row = itr.next();
		
		while (itr.hasNext())
		{
			row = itr.next();
			Iterator<Cell> cellIterator = row.cellIterator(); // iterating over each column

			// cell.getStringCellValue()
			// cell.getNumericCellValue()
			
			while (cellIterator.hasNext())
			{

				Cell cell = cellIterator.next();
				int customerId = (int) cell.getNumericCellValue();

				cell = cellIterator.next();
				String customerName = cell.getStringCellValue();
				
				cell = cellIterator.next();
				int accountNo = (int) cell.getNumericCellValue();
				
				cell = cellIterator.next();
				String accountType = cell.getStringCellValue();

				cell = cellIterator.next();
				double availableBalance = cell.getNumericCellValue();
				
				cell = cellIterator.next();
				String mailId = cell.getStringCellValue();
				
				cell = cellIterator.next();
				int contactNo = (int) cell.getNumericCellValue();


				Customer obj = new Customer(customerId,customerName,accountNo,accountType,availableBalance,mailId,contactNo);

				insertToDb(obj);
			}
			// System.out.println("");
		}
		
	}

	@Override
	public boolean insertToDb(Customer obj) throws IOException, SQLException, ClassNotFoundException
	{
		boolean status = false;
		
		DBConnection db = new DBConnection();
		
		Connection con = db.getConnection();
	
		PreparedStatement ps = con.prepareStatement(
		"INSERT INTO Customers(customerId,customerName,accountno,accountType,balance,mailId,contactNo) VALUES(?,?,?,?,?,?,?)");

		ps.setInt(1, obj.getCustomerId());
		ps.setString(2, obj.getCustomerName());
		ps.setInt(3, obj.getAccountNo());
		ps.setString(4, obj.getAccountType());
		ps.setDouble(5, obj.getAccountBalance());
		ps.setString(6, obj.getMailId());
		ps.setInt(7, obj.getContactNo());
		
		
		status = !ps.execute(); // true if the first result is a ResultSet object
								// false if the first result is an update count or there is no result

		return status;
	}

}

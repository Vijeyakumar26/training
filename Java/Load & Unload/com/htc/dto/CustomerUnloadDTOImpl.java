package com.htc.dto;

import java.io.FileOutputStream;
import java.io.IOException;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import com.htc.connection.DBConnection;
import com.htc.entity.Customer;

public class CustomerUnloadDTOImpl implements CustomerUnloadDTO 
{
	DBConnection dbconnect = new DBConnection();
	Connection con;
	List<Customer> emplist=new ArrayList<Customer>();


	public CustomerUnloadDTOImpl(DBConnection dbconnect) throws ClassNotFoundException, IOException, SQLException
	{
		super();
		this.dbconnect = dbconnect;
		this.con = dbconnect.getConnection();
	}

	@Override
	public List<Customer> getAllCustomers() throws SQLException
	{
		Statement stmt = con.createStatement();
		ResultSet rs = stmt.executeQuery("SELECT customerId,customerName,accountno,accountType,balance,mailId,contactNo FROM CUSTOMERS;");
		
		while(rs.next())
		{
			emplist.add(new Customer(rs.getInt(1),rs.getString(2),rs.getInt(3),rs.getString(4),rs.getInt(5),rs.getString(6),rs.getInt(7)));
		}
		return emplist;
	}

	@Override
	public boolean unloadCustomerDetail(List<Customer> cus) throws IOException 
	{
		XSSFWorkbook wb = new XSSFWorkbook();

		XSSFSheet spreedsheet = wb.createSheet("CustomerDetails");
		FileOutputStream fos = new FileOutputStream("CustomerDetails.xlsx");

		XSSFRow row;
		int rowno = 0;
		int cellno = 0;

		row = spreedsheet.createRow(rowno);
		Cell cell = row.createCell(cellno);

		cell = row.createCell(cellno);
		cell.setCellValue("CustomerId");
		cellno++;

		cell = row.createCell(cellno);
		cell.setCellValue("CustomerName");
		cellno++;

		cell = row.createCell(cellno);
		cell.setCellValue("AccountNo");
		cellno++;

		cell = row.createCell(cellno);
		cell.setCellValue("AccountType");
		cellno++;

		cell = row.createCell(cellno);
		cell.setCellValue("AccountBalance");
		cellno++;
		
		cell = row.createCell(cellno);
		cell.setCellValue("MailId");
		cellno++;
		
		cell = row.createCell(cellno);
		cell.setCellValue("ContactNo");
		cellno++;

		rowno++;
		for(Customer cus1:emplist)
		{
			row = spreedsheet.createRow(rowno);


			cellno = 0;
			cell = row.createCell(cellno);
			cell.setCellValue(cus1.getCustomerId());
			cellno++;

			cell = row.createCell(cellno);
			cell.setCellValue(cus1.getCustomerName());
			cellno++;

			cell = row.createCell(cellno);
			cell.setCellValue(cus1.getAccountNo());
			cellno++;

			cell = row.createCell(cellno);
			cell.setCellValue(cus1.getAccountType());
			cellno++;

			cell = row.createCell(cellno);
			cell.setCellValue(cus1.getAccountBalance());
			cellno++;
			
			cell = row.createCell(cellno);
			cell.setCellValue(cus1.getMailId());
			cellno++;
			
			cell = row.createCell(cellno);
			cell.setCellValue(cus1.getContactNo());
			cellno++;
			rowno++;

		}
		wb.write(fos);
		fos.close();
		return true;
	}
}

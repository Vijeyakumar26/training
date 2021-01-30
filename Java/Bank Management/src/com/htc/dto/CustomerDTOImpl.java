package com.htc.dto;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import com.htc.connection.DBConnection;
import com.htc.entity.Customer;
import com.htc.entity.Transaction;

public class CustomerDTOImpl implements CustomerDTO
{
	List<Customer> cuslist = new ArrayList<>();
	List<Transaction> tranlist = new ArrayList<>();

	@Override
	public void readFileCustomers() throws IOException, SQLException, ClassNotFoundException 
	{
		File file = new File("CustomerDetails.xlsx");	

		FileInputStream fis = new FileInputStream(file);
		XSSFWorkbook wb = new XSSFWorkbook(fis);
		XSSFSheet sheet = wb.getSheetAt(0);

		Iterator<Row> itr = sheet.iterator(); 

		Row row = itr.next();

		while (itr.hasNext())
		{
			row = itr.next();
			Iterator<Cell> cellItr = row.cellIterator(); 

			while (cellItr.hasNext())
			{

				Cell cell = cellItr.next();
				int customerId = (int) cell.getNumericCellValue();

				cell = cellItr.next();
				String customerName = cell.getStringCellValue();

				cell = cellItr.next();
				String accountType = cell.getStringCellValue();

				cell = cellItr.next();
				int availableBalance = (int) cell.getNumericCellValue();


				//				Customer obj = new Customer(customerId,customerName,accountType,availableBalance);

				cuslist.add(new Customer(customerId, customerName, accountType, availableBalance));

				//				insertToDb(obj); //inserting to database method call
			}	
		}
	}

//	@Override
//	public boolean insertToDb(Customer obj) throws IOException, SQLException, ClassNotFoundException
//	{
//		boolean status = false;
//
//		DBConnection db = new DBConnection();
//
//		Connection con = db.getConnection();
//
//		PreparedStatement ps = con.prepareStatement(
//				"INSERT INTO Customerrs(customerId,customerName,accountType,accountbalance) VALUES(?,?,?,?)");
//
//		ps.setInt(1, obj.getCustomerId());
//		ps.setString(2, obj.getCustomeName());;
//		ps.setString(3, obj.getAccountType());
//		ps.setDouble(4, obj.getAvailableBalance());
//
//		status = !ps.execute();
//
//		return status;
//	}

	@Override
	public boolean addtransaction(Transaction t) 
	{
		tranlist.add(t);
		return true;
	}

	@Override
	public void unloadTrans() throws IOException 
	{
		XSSFWorkbook wb = new XSSFWorkbook();
		XSSFSheet spreadsheet = wb.createSheet("TransactionDetails");
		XSSFSheet failtrans = wb.createSheet("FailTransaction");

		FileOutputStream fos =  new FileOutputStream("Transaction.xlsx");

		String status = "";
		double rem_amount=0;

		XSSFRow row;			
		int rowno = 0;
		int cellno = 0;

		//		Transaction

		row = spreadsheet.createRow(rowno);
		Cell cell = row.createCell(cellno);

		cell = row.createCell(cellno);
		cell.setCellValue("TransactionId");
		cellno++;

		cell = row.createCell(cellno);
		cell.setCellValue("CustomerId");
		cellno++;

		cell = row.createCell(cellno);
		cell.setCellValue("Amount");
		cellno++;

		cell = row.createCell(cellno);
		cell.setCellValue("Status");
		cellno++;

		rowno++;

		for(Customer c: cuslist)
		{
			for(Transaction t : tranlist)
			{
				if(c.getCustomerId()== t.getCustomer_id())
				{

					if(c.getAvailableBalance()>t.getAmount())
					{						
						rem_amount = c.getAvailableBalance() - t.getAmount();
						status = "Balance Updated";

						row = spreadsheet.createRow(rowno);

						cellno = 0;

						cell = row.createCell(cellno);
						cell.setCellValue(t.getTransactionId());
						cellno++;			

						cell =  row.createCell(cellno);
						cell.setCellValue(t.getCustomer_id());
						cellno++;

						cell =  row.createCell(cellno);
						cell.setCellValue(rem_amount);
						cellno++;

						cell =  row.createCell(cellno);
						cell.setCellValue(status);
						cellno++;

						rowno++;
					}
					else
					{
						status = "Insufficient Amount";
						row = spreadsheet.createRow(rowno);

						cellno = 0;
						cell = row.createCell(cellno);cell.setCellValue(t.getTransactionId());
						cellno++;			

						cell =  row.createCell(cellno);cell.setCellValue(t.getCustomer_id());
						cellno++;

						cell =  row.createCell(cellno);cell.setCellValue(c.getAvailableBalance());
						cellno++;

						cell =  row.createCell(cellno);cell.setCellValue(status);
						cellno++;

						rowno++;
					}
				}
			}
		}		
		wb.write(fos);
		fos.close();
	}
}

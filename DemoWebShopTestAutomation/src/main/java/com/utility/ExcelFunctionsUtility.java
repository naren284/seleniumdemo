package com.utility;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelFunctionsUtility {
	static public Object[][] UserLogin()
	{
		File file=new File("./src/test/resources/UserLoginDetails.xlsx");
		Object[][] obj=null;
		try {
			InputStream is=new FileInputStream(file);
			XSSFWorkbook workbook=new XSSFWorkbook(is);
			XSSFSheet sheet1=workbook.getSheet("Sheet1");
			obj=new Object[sheet1.getLastRowNum()][];
			for(int i=1;i<=sheet1.getLastRowNum();i++)
			{
				obj[i-1]=new Object[sheet1.getRow(i).getPhysicalNumberOfCells()];
				for(int j=0;j<sheet1.getRow(i).getPhysicalNumberOfCells();j++)
				{
				System.out.print(sheet1.getRow(i).getCell(j).getStringCellValue()+"\t");
				obj[i-1][j]=sheet1.getRow(i).getCell(j).getStringCellValue();
				}
				System.out.println();
			}
			workbook.close();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return obj;
	}
	public static Object[][] readDataFromExcelforRegistration()
	{
		File file=new File("./src/test/resources/UsersRegistrationData.xlsx");
		Object[][] obj=null;
		try {
			InputStream is=new FileInputStream(file);
			XSSFWorkbook workbook=new XSSFWorkbook(is);
			XSSFSheet sheet1=workbook.getSheet("RegistrationDetails");
			obj=new Object[sheet1.getLastRowNum()][];
			for(int i=1;i<sheet1.getLastRowNum();i++)
			{
				obj[i]=new Object[sheet1.getRow(i).getPhysicalNumberOfCells()];
				for(int j=0;j<sheet1.getRow(i).getPhysicalNumberOfCells();j++)
				{
				//System.out.print(sheet1.getRow(i).getCell(j).getStringCellValue()+"\t");
				obj[i][j]=sheet1.getRow(i).getCell(j).getStringCellValue();
				System.out.println(obj[i][j]);
				}
				
			}
			
			workbook.close();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return obj;
	}
	public static void writeExcel(String texttowrite,String secondpassword) {
		File file=new File("./src/test/resources/UserLoginDetails.xlsx");
		Object[][] obj=null;
		try {
			InputStream is=new FileInputStream(file);
			@SuppressWarnings("resource")
			XSSFWorkbook workbook=new XSSFWorkbook(is);
			XSSFSheet sheet=workbook.getSheet("Sheet1");
			int rowCount=sheet.getLastRowNum();
			/*for(i=0;i<sheet.getLastRowNum();i++)
			{*/
				 Row row = sheet.getRow(rowCount);

				    //Create a new row and append it at last of sheet

				    Row newRow = sheet.createRow(rowCount+1);

				    //Create a loop over the cell of newly created Row

				    //for( int j = 0; j < 2; j++){

				        //Fill data in row

				        Cell cell = newRow.createCell(0);

				        cell.setCellValue(texttowrite);
				        System.out.println(texttowrite);
				        cell = newRow.createCell(1);
				        
				        cell.setCellValue(secondpassword);
				        System.out.println(secondpassword);
				    //}

				    //Close input stream

				    is.close();

				    //Create an object of FileOutputStream class to create write data in excel file

				    FileOutputStream outputStream = new FileOutputStream(file);

				    //write data in the excel file

				    workbook.write(outputStream);

				    //close output stream

				    outputStream.close();
			//}
			}
		catch(Exception e) {
			e.printStackTrace();
		}
}
}

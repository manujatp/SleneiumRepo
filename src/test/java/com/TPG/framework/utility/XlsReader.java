package com.TPG.framework.utility;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class XlsReader {

	static File file;
	static XSSFWorkbook wb;
	static XSSFSheet sheet;
	String filePath = "";
	String fileName = "";
	static int colnum = 0;

	//Constructor : creating file object
	public XlsReader(String filePath,String fileName){//file path + file name
		this.filePath = filePath;
		file = new File(filePath+"/"+fileName);
	}

	//Reading data from Excel file and storing into Object[][]
	public Object[][] readXls(String sheetName) throws IOException{

		Object[][] obj = null;

		if(file.exists()==true){//1
			InputStream fis = new FileInputStream(file);
			wb = new XSSFWorkbook(fis);
			fis.close();
			if(wb.getNumberOfSheets()!=0)
				for(int i=0; i<wb.getNumberOfSheets();i++)			
					if(wb.getSheetName(i).equals(sheetName)){
						sheet = wb.getSheet(sheetName);
						wb.close();
						XSSFRow row;
						XSSFCell cell;
						int lastrownum = sheet.getLastRowNum();
						int lastcolnum = sheet.getRow(0).getLastCellNum();
						obj = new Object[lastrownum][lastcolnum];

						if(sheet!=null)
							for (i=0; i<= lastrownum; i++){
								row = sheet.getRow(i+1);
								for (int j=0; j<=lastcolnum; j++){
									if(row!=null){
										cell = row.getCell(j);
										if(cell!=null)
											obj[i][j] = cell.toString();
									}
								}

							}			
					}
		}
		return obj;

	}

	//Creating new sheet
	public void addSheet(String sheetName)throws IOException{

		if(file.exists()==true){

			InputStream fis = new FileInputStream(file);
			wb = new XSSFWorkbook(fis);
			fis.close();
			if(wb.getNumberOfSheets()!=0){
				for(int i=0; i<wb.getNumberOfSheets();i++)
					if(wb.getSheetName(i).equals(sheetName)){
						sheet = wb.getSheet(sheetName);
						break;
					}
				if((wb.getSheet(sheetName))==null)
					sheet = wb.createSheet(sheetName);
			}
			else
				sheet = wb.createSheet(sheetName);

			OutputStream ous = new FileOutputStream(file);
			wb.write(ous);
			wb.close();
			ous.close();
		}

	}


	//Creating new column 
	public void addColumn(String sheetName,String colName) throws Exception{

		if(file.exists()==true){
			InputStream fis = new FileInputStream(file);
			wb = new XSSFWorkbook(fis);
			fis.close();
			sheet = wb.getSheet(sheetName);
			int rownum = sheet.getLastRowNum();
			if((sheet.getRow(rownum))==null)
				sheet.createRow(rownum);

			XSSFRow row = sheet.getRow(rownum);

			if(sheet.getRow(rownum).getCell(colnum)==null)
				row.createCell(colnum++).setCellValue(colName);
			else{
				row.createCell(++colnum).setCellValue(colName);
				++colnum;
			}
		}

		OutputStream ous = new FileOutputStream(file);
		wb.write(ous);
		wb.close();
		ous.close();
	}

	//Adding values to column	
	public void setCellData(String sheetName,int rownum,int index,String colValue) throws Exception{
		if(file.exists()==true){
			InputStream fis = new FileInputStream(file);
			wb = new XSSFWorkbook(fis);
			fis.close();
			sheet = wb.getSheet(sheetName);
			if(sheet.getRow(rownum)==null)
				sheet.createRow(rownum);
			XSSFRow row = sheet.getRow(rownum);
			row.createCell(index).setCellValue(colValue);
		}
		OutputStream ous = new FileOutputStream(file);
		wb.write(ous);
		wb.close();
		ous.close();
	}
}





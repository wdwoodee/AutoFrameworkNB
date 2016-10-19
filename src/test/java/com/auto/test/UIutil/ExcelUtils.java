package com.auto.test.UIutil;


import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;

//ï¿½ï¿½ï¿½ï¿½Excelï¿½ï¿½ï¿½ï¿½ï¿½ï¿½
public class ExcelUtils {
		
		public static HSSFSheet ExcelSheet;
		public static HSSFWorkbook	ExcelBook;
		public static HSSFRow Row;
		public static HSSFCell	Cell;
		
		/**
		 * ï¿½ï¿½ï¿½ï¿½Excel
		 * @param Path
		 * ï¿½Ä¼ï¿½Â·ï¿½ï¿½
		 */
		public static void setExcelFile(String Path) {
			FileInputStream ExcelFile;
			try {
				ExcelFile = new FileInputStream(Path);
				ExcelBook=new HSSFWorkbook(ExcelFile);
			} catch (FileNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}					
		}
		
		/**
		 * Öµï¿½ï¿½Ð´ï¿½ï¿½
		 * @param Result
		 * @param RowNum
		 * @param ColNum
		 * @param Path
		 * @param SheetName
		 */
		public static void setCellData(String Result,  int RowNum, int ColNum,String Path,String SheetName) {
			try {
				ExcelSheet=ExcelBook.getSheet(SheetName);
				Row  = ExcelSheet.getRow(RowNum);
				Cell = Row.getCell(ColNum, Row.RETURN_BLANK_AS_NULL);
				if (Cell == null) {
					Cell = Row.createCell(ColNum);
					Cell.setCellValue(Result);
					} else {
						Cell.setCellValue(Result);
					}
				FileOutputStream fileOut = new FileOutputStream(Path);
				ExcelBook.write(fileOut);
				fileOut.flush();
				fileOut.close();
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
		/**
		 * ï¿½ï¿½È¡Excelï¿½Ð¶ï¿½Ó¦ï¿½ï¿½Ôªï¿½ï¿½ï¿½Öµ
		 * @param RowNum
		 * @param CloNum
		 * @param SheetName
		 * @return
		 */
		public static String getCellDate(int RowNum,int CloNum,String SheetName){
			ExcelSheet=ExcelBook.getSheet(SheetName);
			Cell=ExcelSheet.getRow(RowNum).getCell(CloNum);
			String cellData=Cell.getStringCellValue();
			return cellData;
	
		}
		
		/**
		 * ï¿½ï¿½È¡ï¿½ï¿½sheetÒ³ï¿½ï¿½ï¿½Ò»ï¿½ï¿½
		 * @param SheetName
		 * @return
		 * @throws Exception 
		 * 
		 */
		public static int getLastRowNums(String SheetName) throws Exception {
		    try {
		    	ExcelSheet=ExcelBook.getSheet(SheetName);
			    int rowCount = ExcelSheet.getLastRowNum();
		        return rowCount;
		    }catch (Exception e){
		        throw(e);
			    }
		    }				
}

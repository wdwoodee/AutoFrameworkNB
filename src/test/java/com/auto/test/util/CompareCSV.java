package com.auto.test.util;

import java.nio.charset.Charset;
import java.util.ArrayList;

import com.csvreader.CsvReader;
import com.csvreader.CsvWriter;

/**
 * @author luozt
 *
 * 2016年9月12日下午8:35:09
 */
public class CompareCSV {
	
	
	/**
	 * 
	 * 读取csv
	 */
	public static final String ENCODE="UTF-8";
	
	ArrayList<String[]> csvList=new ArrayList<String[]>();
	
    public ArrayList<String[]> readCsv(String csvPath){
    	
    	try{
    		
    		String csvpath="";
    		CsvReader reader=new CsvReader(csvpath,',',Charset.forName(ENCODE));
    		reader.readHeaders();//跳过表头，如果需要表头的话，不要写这句
    		
    		while(reader.readRecord()){//逐行读入除表头的数据
    			
    			csvList.add(reader.getValues());
    			
    		}
    		reader.close();
    		
    		
    	}catch(Exception e){
    		e.printStackTrace();
    	}
    	
    	return csvList;
    	
    }
    
    
    
    /**
     * 
     * 写入文件
     * 
     */
    
    public static void WriteCsv(String csvPath,String []contents){
    	
    	try{
    		
    		CsvWriter wr=new CsvWriter(csvPath,',',Charset.forName(ENCODE));
    		wr.writeRecord(contents);;
    		wr.close();
    		
    	}catch(Exception e){e.printStackTrace();}
    	
    	
    }
}

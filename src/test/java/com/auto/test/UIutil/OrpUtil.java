package com.auto.test.UIutil;

import java.io.BufferedInputStream;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

//ï¿½ï¿½ï¿½ï¿½ï¿½ï¿½ï¿½ï¿½ï¿½ÄµÄ¹ï¿½ï¿½ï¿½ï¿½ï¿½
public class OrpUtil {
	
	/**
	 * @param a(ï¿½ï¿½Ó¦ï¿½Äµï¿½KeyÖµ)
	 * @return(ï¿½ï¿½ï¿½Ø¶ï¿½Ó¦ï¿½ï¿½values)
	 */
	public static String  readValue(String a){
		Properties pro=new Properties();
		String popath=Contants.ObjectReUrl;
		String value=null;
		try {
			InputStream in =new BufferedInputStream(new FileInputStream(popath));
//			InputStream in=getClass().getResourceAsStream("/info.properties");
			pro.load(in);
			value=pro.getProperty(a);
			

		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return value;
	}
}

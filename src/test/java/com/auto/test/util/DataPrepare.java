package com.auto.test.util;

import java.util.Random;

/**
 * @author gaohuan
 *
 * 2016年9月19日下午7:23:45
 */
public class DataPrepare {
	public static String getStringRandom(int length){
		String val = "";
		Random random = new Random(); 
		for(int i = 0; i < length; i++) {  
			String charOrNum = random.nextInt(2) % 2 == 0 ? "char" : "num"; 			
			 if( "char".equalsIgnoreCase(charOrNum) ) {  
				 val += (char)(random.nextInt(26) + 'a');
	          } else if( "num".equalsIgnoreCase(charOrNum) ) {  
	                val += String.valueOf(random.nextInt(10));  
	           }  
	     }  
	     return val;  
	}
	
	public static void  main(String[] args) {  
        System.out.println(getStringRandom(8));  
    }
	
}

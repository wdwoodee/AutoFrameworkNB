package com.auto.test.util;


import java.util.Random;

/**  
 * 类说明   
 *  安装我们自己产品的的id生成格式
 * @author luozt  
 * @date 2016年9月30日  新建  
 */
public class createRandomId {

	public static String getRandomId(){
		
		 String base = "abcdefghijklmnopqrstuvwxyz0123456789";
		 Random random=new Random();
		 StringBuffer sb=new StringBuffer();
		 for(int i=0;i<32;i++){
			 
			 int number=random.nextInt(base.length());
			 
			 
			 sb.append(base.charAt(number));
             if((i==7)||(i==11)||(i==15)||(i==19)){
				 
				 sb.append("-");
				 
			 }
		 }
		
		return sb.toString();
	}
	
	public static void main(String[] args){
		
		createRandomId cr=new createRandomId();
		System.out.print(cr.getRandomId());
	}
	
	
}

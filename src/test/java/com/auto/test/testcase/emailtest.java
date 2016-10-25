package com.auto.test.testcase;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;

import com.auto.test.util.MailSenderInfo;
import com.auto.test.util.SendMail;

/**  
 * 类说明   
 *  
 * @author luozt  
 * @date 2016年9月29日  新建  
 */
public class emailtest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//这个类主要是设置邮件  
	      MailSenderInfo mailInfo = new MailSenderInfo();   
	      mailInfo.setMailServerHost("10.10.10.8");   
	      mailInfo.setMailServerPort("587");   
	      mailInfo.setValidate(true);   
	      mailInfo.setUserName("luozhitao@netbrain.com");   
	      mailInfo.setPassword("luozhitao");//您的邮箱密码   
	      mailInfo.setFromAddress("luozhitao@netbrain.com");   
	      mailInfo.setToAddress("luozhitao@netbrain.com");   
	      mailInfo.setSubject("test_1");  
	      StringBuffer sbstr=new StringBuffer();
	      try {
	    	  
	    	  InputStreamReader read = new InputStreamReader(new FileInputStream(new File("C:/Users/luozhitao/Desktop/aa/power-emailable-report.html")));
	    	  BufferedReader ins=new BufferedReader(read) ;
	    	  String dataline="";
	    	  try {
				while(null!=(dataline=ins.readLine())){
					sbstr.append(dataline);
				//	sbstr.append("/r/n");
					
					
				}
				
				ins.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			mailInfo.setContent(sbstr.toString());
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}   
	  //这个类主要来发送邮件  
	      SendMail sms = new SendMail();  
	//   sms.sendTextMail(mailInfo);//发送文体格式   
	   sms.sendHtmlMail(mailInfo);//发送html格式  
	}

}

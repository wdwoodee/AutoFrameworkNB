package com.auto.test.testcase;

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
	      mailInfo.setToAddress("Gaohuan@netbrain.com");   
	      mailInfo.setSubject("test_1");   
	      mailInfo.setContent("test_hello");   
	  //这个类主要来发送邮件  
	      SendMail sms = new SendMail();  
	   sms.sendTextMail(mailInfo);//发送文体格式   
	   sms.sendHtmlMail(mailInfo);//发送html格式  
	}

}

package com.netbrain.test.testcase;

import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.netbrain.test.commons.CommonsHeader;
import com.netbrain.test.commons.CommonsParam;





/**
 * @author gaohuan
 *
 * 2016年9月14日下午7:25:24
 */
public class LoginTest {
	public static final Logger logger=LoggerFactory.getLogger(LoginTest.class);
	Map<String, String> Header=CommonsHeader.getloginHeader();
	Map<String, Object> Param=CommonsParam.getloginParm();
	@BeforeClass
	public void beforeClass() {
		
	}
	@BeforeMethod
	public void beforeMethod() {
	}
	
	
	@Test
	public void loginTest(){
		logger.info("[TESTCASE]-" +Thread.currentThread().getStackTrace()[1].getMethodName());
	}
	
	
	
	
	
	 @AfterMethod
		public void afterMethod() {
		}
		
	@AfterClass
		public void afterClass() {

			logger.info("#######################关闭数据库连接######################");
		}
}

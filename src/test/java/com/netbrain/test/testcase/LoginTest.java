package com.netbrain.test.testcase;

import java.io.IOException;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.netbrain.test.commons.CommonsHeader;
import com.netbrain.test.commons.CommonsParam;
import com.netbrain.test.util.HttpRequest;
import com.netbrian.test.basedata.TestBase;


/**
 * @author gaohuan
 *
 * 2016年9月14日下午7:25:24
 */
public class LoginTest extends TestBase{
	
	@BeforeClass
	public void beforeClass() {
		
	}
	@BeforeMethod
	public void beforeMethod() {
	}
	
	
	@Test
	public void loginTest(){
		logger.info("[TESTCASE]-" +Thread.currentThread().getStackTrace()[1].getMethodName());
		String login_result=HttpRequest.doPostFormWithHeader(url, CommonsParam.getloginParm(), CommonsHeader.getloginHeader(), "utf-8");
		JsonNode node;
    	try{
    		node=objectMapper.readTree(login_result);
    		access_token=node.get("access_token").asText();
    		token_type=node.get("token_type").asText();
    		Assert.assertEquals("Bearer",token_type);
    	}catch (JsonProcessingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	
	
	
	
	 @AfterMethod
		public void afterMethod() {
		}
		
	@AfterClass
		public void afterClass() {

			logger.info("#######################关闭数据库连接######################");
		}
}

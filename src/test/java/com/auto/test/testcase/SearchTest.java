package com.auto.test.testcase;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.AfterTest;

import com.auto.test.basedata.TestBase;
import com.auto.test.commons.CommonsHeader;
import com.auto.test.commons.CommonsParam;
import com.auto.test.util.HttpRequest;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonNode;

public class SearchTest extends TestBase{
  @Test
  public void search() {
	  
	  logger_search.info("[TESTCASE]-" +Thread.currentThread().getStackTrace()[1].getMethodName());
	  String login_result=HttpRequest.doPostFormWithHeader(url_Search, CommonsParam.getsearchParm(), CommonsHeader.getcommonHeader(), "utf-8");
		JsonNode node;
    	try{
    		node=objectMapper.readTree(login_result);
    		//access_token=node.get("access_token").asText();
    		//token_type=node.get("token_type").asText();
    		System.out.println(node.get("operationResult").get("ResultCode").toString());
    		
    		
    	//	Assert.assertEquals("Bearer",token_type);
    	}catch (JsonProcessingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	  
	  
	  
	  
  }
  @BeforeMethod
  public void beforeMethod() {
  }

  @AfterMethod
  public void afterMethod() {
  }

  @BeforeClass
  public void beforeClass() {
  }

  @AfterClass
  public void afterClass() {
  }

  @BeforeTest
  public void beforeTest() {
  }

  @AfterTest
  public void afterTest() {
  }

}

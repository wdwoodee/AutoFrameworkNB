package com.auto.test.util;

import java.io.IOException;



import com.auto.test.basedata.TestBase;
import com.auto.test.commons.CommonsHeader;
import com.auto.test.commons.CommonsParam;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonNode;

/**  
 * 类说明   
 *  
 * @author luozt  
 * @date 2016年9月26日  新建  
 */
public class GetAccessToken extends TestBase{

	String Access_token;
	
	public GetAccessToken(){

		//主要是参照gaohuan的logintest的方法，所以修改配置时修改config文件即可
		String login_result=HttpRequest.doPostFormWithHeader(url, CommonsParam.getloginParm(), CommonsHeader.getloginHeader(), "utf-8");
		
		JsonNode node;
    	try{
    		node=objectMapper.readTree(login_result);
    		Access_token=node.get("access_token").asText();
    		
    		
    	}catch (JsonProcessingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	
		
		
		
	}
	
	public  String getToken(){
		
	   return Access_token;
		
	}
}

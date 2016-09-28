package com.auto.test.util;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;


/**
 * @author gaohuan
 *
 * 2016年9月12日下午8:38:19
 */
public class ParamTool {
	public static Map<String,Object>login_param(){
		Map<String,Object>mapparms=new HashMap<String,Object>();
		mapparms.put("grant_type", "password");
		mapparms.put("username", "admin");
		mapparms.put("password", "admin");
		mapparms.put("client_id", "ngAuthApp");
		mapparms.put("scope", "system");
		return mapparms;
	}
	
	/*
	 * 
	 */
	public static Map<String,Object>createTanent_param(String tenantGuid,String tenantName){
		Map<String,Object>mapprams=new HashMap<String,Object>();
		Map<String, Object> mapparms = new HashMap<String, Object>();
		Map<String, Object> mapparms1 = new HashMap<String, Object>();
		mapparms1.put("ID", tenantGuid);
		mapparms1.put("name", tenantName);
		mapparms1.put("description", "This is the default automation tenant");
		mapparms1.put("dbName", tenantName);		
		mapparms1.put("nodeSize", "1000");
		mapparms1.put("maxSeat", "100");
		mapparms1.put("reserveSeat", "0");
		Map<String, Object> mapparms2 = new HashMap<String, Object>();
		
		
		return mapparms;
		
		
	}
	
	
	/**
	 * 
	 */
	public static Map<String,Object> createSearch_param(){
		
		Map<String,Object> mapprams=new LinkedHashMap<String,Object>();
		mapprams.put("prefix", "sea");
		mapprams.put("count", 10);
		int [] aa=new int[]{0,1,2,3,4,5,6,7,8,9};
		mapprams.put("types",aa);
		return mapprams;
		
		
	}
}

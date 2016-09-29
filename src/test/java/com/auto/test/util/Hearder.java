package com.auto.test.util;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * @author gaohuan
 *
 * 2016年9月12日下午8:37:02
 * 
 * edit by luozt
 */
public class Hearder {
	
	private final static Logger logger=LoggerFactory.getLogger(Hearder.class);
	public static Map<String, String> getLoginheader() {
		Map<String, String> mapparmsAll = new HashMap<String, String>();
		mapparmsAll.put("Content-type", "application/json;charset=UTF-8");
		return mapparmsAll;
	}
	public static Map<String, String> getheader() {
		Map<String, String> mapparmsAll = new HashMap<String, String>();
		String stoken=new GetAccessToken().getToken();
		ArrayList<String> dot=new Get_domain_tenantId().get_dt();
		if(dot.size()!=2){
			logger.info("domain or tenant id is null,please check it!");
		}
		mapparmsAll.put("TenantGuid", dot.get(0));
		mapparmsAll.put("DomainGuid", dot.get(1));
		mapparmsAll.put("Content-type", "application/json;charset=UTF-8");		
		if (stoken!=null&&!stoken.equals("")) {
			StringBuffer sb=new StringBuffer("Bearer ");
			sb.append(stoken);
			mapparmsAll.put("Authorization", sb.toString());
		}
		else{
			
			logger.info("token is null");	
		}
		return mapparmsAll;
	}
}

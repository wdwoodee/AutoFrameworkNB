package com.auto.test.util;

import java.util.HashMap;
import java.util.Map;

/**
 * @author gaohuan
 *
 * 2016年9月12日下午8:37:02
 */
public class Hearder {
	public static Map<String, String> getLoginheader() {
		Map<String, String> mapparmsAll = new HashMap<String, String>();
		mapparmsAll.put("Content-type", "application/json;charset=UTF-8");
		return mapparmsAll;
	}
	public static Map<String, String> getheader(String stoken) {
		Map<String, String> mapparmsAll = new HashMap<String, String>();
		mapparmsAll.put("Content-type", "application/json;charset=UTF-8");		
		if (stoken!=null&&!stoken.equals("")) {
			mapparmsAll.put("Authorization", "Bearer "+ stoken);
		}
		
		return mapparmsAll;
	}
}

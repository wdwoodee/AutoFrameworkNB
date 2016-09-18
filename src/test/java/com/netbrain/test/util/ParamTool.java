package com.netbrain.test.util;

import java.util.HashMap;
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
}

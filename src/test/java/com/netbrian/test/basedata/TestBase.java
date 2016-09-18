package com.netbrian.test.basedata;

import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.netbrain.test.commons.CommonsHeader;
import com.netbrain.test.commons.CommonsParam;
import com.netbrain.test.testcase.LoginTest;

/**
 * @author gaohuan
 *
 * 2016年9月12日下午8:44:47
 */
public class TestBase {
	public final static String url=Config.ipUrl+Config.baseUrl+Config.login;
	public final static ObjectMapper objectMapper=new ObjectMapper();
	public String access_token;
	public String token_type;
	public static final Logger logger=LoggerFactory.getLogger(LoginTest.class);
	Map<String, String> Header=CommonsHeader.getloginHeader();
	Map<String, Object> Param=CommonsParam.getloginParm();
}

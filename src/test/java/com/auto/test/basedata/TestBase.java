package com.auto.test.basedata;

import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.auto.test.commons.CommonsHeader;
import com.auto.test.commons.CommonsParam;
import com.auto.test.testcase.LoginTest;
import com.auto.test.testcase.SearchTest;
import com.fasterxml.jackson.databind.ObjectMapper;

/**
 * @author gaohuan
 *
 * 2016年9月12日下午8:44:47
 */
public class TestBase {
	public final static String url=Config.ipUrl+Config.baseUrl+Config.login;
	public final static String url_Search=Config.ipUrl+Config.baseUrl+Config.GetSearchPrefix;
	public final static ObjectMapper objectMapper=new ObjectMapper();
	public String access_token;
	public String token_type;
	public static final Logger logger=LoggerFactory.getLogger(LoginTest.class);
	public static final Logger logger_search=LoggerFactory.getLogger(SearchTest.class);
	Map<String, String> Header=CommonsHeader.getloginHeader();
	Map<String, Object> Param=CommonsParam.getloginParm();
}

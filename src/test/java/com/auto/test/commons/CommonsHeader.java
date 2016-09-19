package com.auto.test.commons;

import java.util.Map;

import com.auto.test.util.Hearder;

/**
 * @author gaohuan
 *
 * 2016年9月14日下午7:34:01
 */
public class CommonsHeader {
	public static Map<String, String> getloginHeader(){
		return Hearder.getLoginheader();
	}
	
}

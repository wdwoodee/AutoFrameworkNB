package com.netbrain.test.commons;

import java.util.Map;
import com.netbrain.test.util.ParamTool;

/**
 * @author gaohuan
 *
 * 2016年9月14日下午8:22:56
 */
public class CommonsParam {
	public static Map<String,Object>getloginParm(){		
		return ParamTool.login_param();
	}
}

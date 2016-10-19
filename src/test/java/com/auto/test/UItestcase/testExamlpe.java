package com.auto.test.UItestcase;

import org.testng.annotations.Test;

import com.auto.test.UIutil.LoginKeyWords;
import com.auto.test.UIutil.StartEngine_Excel;





public class testExamlpe {
	
	public static Object actionKeyWords;
	
	@Test(groups = {"p0"})
	public static void Login() throws Exception{
		actionKeyWords=new LoginKeyWords();
		StartEngine_Excel.StartEngine(actionKeyWords);
		
	}
}

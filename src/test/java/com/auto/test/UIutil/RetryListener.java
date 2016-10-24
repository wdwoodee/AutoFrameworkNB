package com.auto.test.UIutil;
/**  
 * 类说明   
 *  
 * @author luozt  
 * @date 2016年10月24日  新建  
 */
import java.lang.reflect.Constructor;
import java.lang.reflect.Method;

import org.testng.IAnnotationTransformer;
import org.testng.IRetryAnalyzer;
import org.testng.annotations.ITestAnnotation;
public class RetryListener implements IAnnotationTransformer {
	


	
	public void transform(ITestAnnotation annotation, Class testClass, Constructor testConstructor, Method testMethod) {
		IRetryAnalyzer retry = annotation.getRetryAnalyzer();
        if (retry == null) {
            annotation.setRetryAnalyzer(TestngRetry.class);
        }		
	}


	
}
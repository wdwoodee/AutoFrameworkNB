package com.auto.test.basedata;
/**  
 * 类说明   
 *  
 * @author luozt  
 * @date 2016年10月12日  新建  
 */
public class Contants {
	
//	定义访问地址
	public static  String url="http://www.oschina.net/";
//	定义基本路径
	public static String baseUrl="D:/workspace/SeleniumKeywordDrive/";
//	定义驱动路径
	public static String driverUrl=baseUrl+"server/chromedriver.exe";
//	Excel的路径和名称
	public static String excelFile=baseUrl+"src/dataEngine/";
	public static String excelName="dataEngine.xls";
//	用例sheet页
	public static String caseSheet="Test Steps";
//	用例场景的sheet页
	public static String suitSheet="Suite";
//	Suite页的设置
	public static int suitTestSuiteId=0;
	public static int suitRunmode=2;
	public static int suitResult=3;
//	用例步骤页的设置
	public static int stepTestSuiteId=0;
	public static int excelPOCloNum=4;
	public static int excelKWCloNum=5;
	public static int caseResult=6;
//	成功和失败
	public static  String fail="FAIL";
	public static  String pass="PASS";
//	对象仓库文件路径
	public static String ObjectReUrl=baseUrl+"/src/dataEngine/ObjectRepository";
//	登陆的用户明和密码
	public static String userName="xxxxxxxxa";
	public static String userPassword="XXXXXXb";

}

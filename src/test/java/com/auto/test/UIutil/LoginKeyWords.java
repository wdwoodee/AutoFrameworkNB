package com.auto.test.UIutil;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.events.EventFiringWebDriver;



public class LoginKeyWords {
	
	// DesiredCapabilities capability = null;
	static EventFiringWebDriver driver;
	
//	ï¿½ï¿½ï¿½ï¿½ï¿½ï¿½ï¿½ï¿½ï¿½ï¿½ï¿½ï¿½ï¿½ï¿½
	public static void OpenBrowser (String OR){
		
		
		try {
	//		System.setProperty("webdriver.chrome.driver", Contants.driverUrl);
	//		System.setProperty("webdriver.firefox.bin", "D:/firfox/firefox.exe");
	//		driver= new FirefoxDriver();
	//		driver.manage().window().maximize();
			 WebDriver webdriver=new FirefoxDriver();
			 driver=new EventFiringWebDriver(webdriver);
			MyEventListener handle=new MyEventListener();
			driver.register(handle);
			 
	
		
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			StartEngine_Excel.bResult=false;
			
		}
		
		
	}

//	ï¿½ò¿ª¿ï¿½Ô´ï¿½Ð¹ï¿½ï¿½ï¿½Ö·
	public static void Navigate (String OR){
		
		driver.get(Contants.url);
		
		
//		driver.get(Contants.url);
//		WebElement username=driver.findElement(By.cssSelector("input[placeholder='User Name']"));
//		
//		username.clear();
//		username.sendKeys("admin");
//		
//		WebElement passwd=driver.findElement(By.xpath("/html/body/div/div/form/div[2]/div[2]/input"));
//		passwd.clear();
//		passwd.sendKeys("admin");
	}
	
//	ï¿½ï¿½ï¿½ï¿½ï¿½Â¼
	
	
	public static void Login_Click (String OR){
		try {
			driver.findElement(By.xpath(OrpUtil.readValue(OR))).click();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			StartEngine_Excel.bResult=false;
		}
	}
	
//	ï¿½ï¿½ï¿½ï¿½ï¿½Ã»ï¿½ï¿½ï¿½
	public static void Input_Name (String OR){
		try {
			driver.findElement(By.cssSelector(OrpUtil.readValue(OR))).clear();
			driver.findElement(By.cssSelector(OrpUtil.readValue(OR))).sendKeys(Contants.userName);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			StartEngine_Excel.bResult=false;
		}
	}
	
//	ï¿½ï¿½ï¿½ï¿½ï¿½ï¿½ï¿½ï¿½
	public static void Input_Password (String OR){
		try {
			driver.findElement(By.cssSelector(OrpUtil.readValue(OR))).click();
			driver.findElement(By.cssSelector(OrpUtil.readValue(OR))).sendKeys(Contants.userPassword);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			StartEngine_Excel.bResult=false;
		}
	}
	
//	ï¿½ï¿½ï¿½ï¿½ï¿½Â¼ï¿½ï¿½Å¥
	public static void Login_Button (String OR){
		try {
			driver.findElement(By.cssSelector(OrpUtil.readValue(OR))).click();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			StartEngine_Excel.bResult=false;
		}
	}

	//	ï¿½ï¿½ï¿½ï¿½Ë³ï¿½ï¿½ï¿½Å¥
	public static void Logout_Click (String OR){
		try {
			Thread.sleep(1000);
			driver.findElement(By.cssSelector(OrpUtil.readValue(OR))).click();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			StartEngine_Excel.bResult=false;
		}
		
	}

//	ï¿½Ø±ï¿½ï¿½ï¿½ï¿½ï¿½ï¿½
	public static void CloseBrowser (String OR){
		
		try {
			Thread.sleep(600);
			driver.findElement(By.xpath(OrpUtil.readValue(OR))).click();
			driver.quit();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			StartEngine_Excel.bResult=false;
		}
		
	}

}

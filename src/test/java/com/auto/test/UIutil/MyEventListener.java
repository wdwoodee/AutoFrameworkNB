package com.auto.test.UIutil;
/**  
 * 类说明   
 *  
 * @author luozt  
 * @date 2016年10月21日  新建  
 */
import java.awt.AWTException;
import java.awt.Rectangle;
import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Calendar;











import javax.imageio.ImageIO;

import org.apache.commons.codec.binary.Base64;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.ScreenshotException;
import org.openqa.selenium.support.events.WebDriverEventListener;

public class MyEventListener implements WebDriverEventListener{

	public void afterChangeValueOf(WebElement arg0, WebDriver arg1) {
		// TODO Auto-generated method stub
		
	}

	public void afterClickOn(WebElement arg0, WebDriver arg1) {
		// TODO Auto-generated method stub
		
	}

	public void afterFindBy(By arg0, WebElement arg1, WebDriver arg2) {
		// TODO Auto-generated method stub
		
	}

	public void afterNavigateBack(WebDriver arg0) {
		// TODO Auto-generated method stub
		
	}

	public void afterNavigateForward(WebDriver arg0) {
		// TODO Auto-generated method stub
		
	}

	public void afterNavigateTo(String arg0, WebDriver arg1) {
		// TODO Auto-generated method stub
		
	}

	public void afterScript(String arg0, WebDriver arg1) {
		// TODO Auto-generated method stub
		
	}

	public void beforeChangeValueOf(WebElement arg0, WebDriver arg1) {
		// TODO Auto-generated method stub
		
	}

	public void beforeClickOn(WebElement arg0, WebDriver arg1) {
		// TODO Auto-generated method stub
		
	}

	public void beforeFindBy(By arg0, WebElement arg1, WebDriver arg2) {
		// TODO Auto-generated method stub
		
	}

	public void beforeNavigateBack(WebDriver arg0) {
		// TODO Auto-generated method stub
		
	}

	public void beforeNavigateForward(WebDriver arg0) {
		// TODO Auto-generated method stub
		
	}

	public void beforeNavigateTo(String arg0, WebDriver arg1) {
		// TODO Auto-generated method stub
		
	}

	public void beforeScript(String arg0, WebDriver arg1) {
		// TODO Auto-generated method stub
		
	}

	public void onException(Throwable ex, WebDriver arg1) {
		// TODO Auto-generated method stub
//		String filename = generateRandomFilename(ex);
//        try {
//            byte[] btDataFile = Base64.decodeBase64(extractScreenShot(ex).getBytes());
//            File of = new File(filename);
//            FileOutputStream osf = new FileOutputStream(of);
//            osf.write(btDataFile);
//            osf.flush();
//            osf.close();
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
        
		 String filename = generateRandomFilename(ex);
	        createScreenCaptureJPEG(filename);
		
		
		
	}

	
	 private String generateRandomFilename(Throwable ex) {
	       
		  	 
		    Calendar c = Calendar.getInstance();
	        String filename = ex.getCause().toString();
	        int i = filename.indexOf(":");
	        filename = filename.substring(0, i).replaceAll("\\s", "_")
	                    .replaceAll(":", "")
	                    + ".png";
	                    filename = "" + c.get(Calendar.YEAR) + "-" + c.get(Calendar.MONTH)
	                    + "-" + c.get(Calendar.DAY_OF_MONTH) + "-"
	                    + c.get(Calendar.HOUR_OF_DAY) + "-" + c.get(Calendar.MINUTE)
	                    + "-" + c.get(Calendar.SECOND) + "-" + filename;
	                    
	        return filename;
	    }
	 
//	 private String extractScreenShot(Throwable ex) {
//	        Throwable cause = ex.getCause();
//	        if (cause instanceof ScreenshotException) {
//	            return ((ScreenshotException) cause).getBase64EncodedScreenshot();
//	        }
//	        
//	        return null;
//	    }
	 
	 private void createScreenCaptureJPEG(String filename) {
		  try {
		   BufferedImage img = getScreenAsBufferedImage();
		   File output = new File("test-output/"+filename);
		   
		   ImageIO.write(img, "jpg", output);
		  } catch (IOException e) {
		   e.printStackTrace();
		  }
		 }
		 
	 
	 private BufferedImage getScreenAsBufferedImage() {
		  BufferedImage img = null;
		  try {
		   Robot r;
		   r = new Robot();
		   Toolkit t = Toolkit.getDefaultToolkit();
		   Rectangle rect = new Rectangle(t.getScreenSize());
		   img = r.createScreenCapture(rect);
		  } catch (AWTException e) {
		   e.printStackTrace();
		  }
		  return img;
		 }
}

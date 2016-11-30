package parameters;

import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import common.LogRegister;
import rules.ScreenCaptureRule;

public class Exec {


	WebDriver driver = ConfigWebDriver.selectWebDriver(1);	
	
	@Rule
	public ScreenCaptureRule screenCapture = new ScreenCaptureRule();
	
	@Before
	public void start(){
		
		ConfigWebDriver.acessApplication(driver);
		
	}
	
	@Test
	public void teste() throws Exception{
		
		try{
			LogRegister.startTestCase();
			WebElement inputTextGoogle = driver.findElement(By.name("q"));
	        inputTextGoogle.sendKeys("Camilo Lopes");
	        LogRegister.endTestCase();			
		}

		catch(Exception e){
			LogRegister.error("Eror:" + e.getStackTrace());
			throw(e);
		}
	}
	
}

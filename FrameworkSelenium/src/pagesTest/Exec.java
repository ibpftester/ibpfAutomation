package pagesTest;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.Test;

import common.LogRegister;
import pages.AccountantLogin;
import pages.NotAccountantLogin;
import parameters.ConfigWebDriver;
import parameters.Parameters;

public class Exec {
	
	WebDriver driver = ConfigWebDriver.selectWebDriver(2);
	
	@Test(priority=1)
	public void teste() throws Exception{
		try{
			NotAccountantLogin.InformCpfNumber();
			NotAccountantLogin.InformPassword();	
		}

		catch(Exception e){
			LogRegister.error("Eror:" + e.getStackTrace());
			throw(e);
		}
	}
	
	@Test(priority=2)
	public void teste2() throws Exception{
		try{			
			AccountantLogin.InformAccount();
			AccountantLogin.InformPassword();	
		}

		catch(Exception e){
			LogRegister.error("Eror:" + e.getStackTrace());
			throw(e);
		}
		Parameters.controllerEnd = true;
	}
	
	@AfterTest
	public void Close(){	    
	    driver.quit();
	    ConfigWebDriver.endApplication();
	}

}


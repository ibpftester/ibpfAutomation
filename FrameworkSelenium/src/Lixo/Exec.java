package Lixo;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.Test;

import common.LogRegister;
import pages.AccLogin;
import pages.NotAccLogin;
import parameters.ConfigWebDriver;
import parameters.Parameters;

public class Exec {
	
	WebDriver driver = ConfigWebDriver.selectWebDriver(2);
	
	@Test(priority=1)
	public void TestNotAccountantLogin() throws Exception{
		try{
			NotAccLogin.InformCpfNumber();
			NotAccLogin.InformPassword();	
		}

		catch(Exception e){
			LogRegister.error("Eror:" + e.getStackTrace());
			throw(e);
		}
	}
	
	@Test(priority=2)
	public void TestAccountantLogin() throws Exception{
		try{			
			AccLogin.InformAccount();
			AccLogin.InformPassword();	
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


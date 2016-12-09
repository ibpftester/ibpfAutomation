package pagesTest;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.Test;

import common.LogRegister;
import pages.AccountantLogin;
import parameters.ConfigWebDriver;
import parameters.Parameters;

public class TestAccountantLogin {

	WebDriver driver = ConfigWebDriver.selectWebDriver(2);

	@Test
	public void RunTestAccountantLogin() throws Exception{
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
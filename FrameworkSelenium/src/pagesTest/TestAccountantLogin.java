package pagesTest;

import org.junit.After;
import org.junit.Test;
import org.openqa.selenium.WebDriver;

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

	@After
	public void Close(){
	    driver.quit();
	    ConfigWebDriver.endApplication();
	}
}
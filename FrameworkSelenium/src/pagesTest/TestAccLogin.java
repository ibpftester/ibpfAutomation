package pagesTest;

import org.junit.After;
import org.junit.Test;
import org.openqa.selenium.WebDriver;

import common.LogRegister;
import pages.AccLogin;
import parameters.ConfigWebDriver;
import parameters.Parameters;

public class TestAccLogin {

	WebDriver driver = ConfigWebDriver.selectWebDriver(2);

	@Test
	public void RunTestAccountantLogin() throws Exception{
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

	@After
	public void Close(){
	    driver.quit();
	    ConfigWebDriver.endApplication();
	}
}
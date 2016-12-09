package pagesTest;

import org.junit.After;
import org.junit.Test;
import org.openqa.selenium.WebDriver;

import common.LogRegister;
import pages.NotAccountantLogin;
import parameters.ConfigWebDriver;
import parameters.Parameters;

public class TestNotAccountantLogin {

	WebDriver driver = ConfigWebDriver.selectWebDriver(2);

	@Test
	public void RunTestNotAccountantLogin() throws Exception{
		try{
			NotAccountantLogin.InformCpfNumber();
			NotAccountantLogin.InformPassword();
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

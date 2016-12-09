package pagesTest;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.Test;

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

	@AfterTest
	public void Close(){
	    driver.quit();
	    ConfigWebDriver.endApplication();
	}
}

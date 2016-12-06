package pagesTest;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;

import common.LogRegister;
import pages.AccountantLogin;
import pages.NotAccountantLogin;
import parameters.ConfigWebDriver;

public class Exec {
	
	WebDriver driver = ConfigWebDriver.selectWebDriver(2);
	
	@Before
	public void Start(){
		ConfigWebDriver.acessApplication(driver, 1);
	}	
	
	@Test
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
	
	@Test
	public void teste2() throws Exception{
		try{			
			AccountantLogin.InformAccount();
			AccountantLogin.InformPassword();	
		}

		catch(Exception e){
			LogRegister.error("Eror:" + e.getStackTrace());
			throw(e);
		}
	}
	
	@After
	public void Close(){	    
	    driver.quit();
	    ConfigWebDriver.endApplication();
	}

}


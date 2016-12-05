package parameters;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;

import common.LogRegister;
import pages.AccountantLogin;
import pages.NotAccountantLogin;

public class Exec {
	
	//static WebDriver driver = Parameters.driver;
	


	@Test
	public void teste() throws Exception{
		WebDriver driver = ConfigWebDriver.selectWebDriver(2);
		
		ConfigWebDriver.acessApplication(driver, 1);
		try{
			NotAccountantLogin.InformCpfNumber();
			NotAccountantLogin.InformPassword();	
		}

		catch(Exception e){
			LogRegister.error("Eror:" + e.getStackTrace());
			throw(e);
		}driver.close();
	}
	
	@Test
	public void teste2() throws Exception{
		WebDriver driver = ConfigWebDriver.selectWebDriver(1);
		
		ConfigWebDriver.acessApplication(driver, 0);
		
		try{			
			AccountantLogin.InformAccount();
			AccountantLogin.InformPassword();	
		}

		catch(Exception e){
			LogRegister.error("Eror:" + e.getStackTrace());
			throw(e);
		}
		driver.close();
	}
	
//	@After
//	public void End(){
//		driver.close();
//		
//	}
}

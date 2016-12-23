package pagesTest;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.Test;

import common.LogRegister;
import pages.AccLimitsAvailableForBuyAndSake;
import pages.AccLogin;
import pages.AccMenuCards;
import parameters.ConfigWebDriver;
import parameters.Parameters;

public class TestAccLimitsAvailableForBuyAndSake {

	WebDriver driver = ConfigWebDriver.selectWebDriver(2);

	@Test
	public void RunTestAccLimitsAvailableForBuyAndSake() throws Exception{
		try{
			AccLogin.InformAccount();
			AccLogin.InformPassword();
			AccMenuCards.SelectTabMyCreditCards();
			AccLimitsAvailableForBuyAndSake.SelectLimitsAvailableForBuyAndSake();
			AccLimitsAvailableForBuyAndSake.ValidateBreadWay();
			AccLimitsAvailableForBuyAndSake.ValidateText();
		}
		catch(Exception e){
			LogRegister.error("Eror:" + e.getMessage());
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

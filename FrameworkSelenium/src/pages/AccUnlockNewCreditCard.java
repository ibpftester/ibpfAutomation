package pages;

import org.junit.Rule;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import common.LogRegister;
import common.ScreenCapture;
import parameters.ConfigWebDriver;
import parameters.Parameters;
import rules.ScreenCaptureRule;

public class AccUnlockNewCreditCard {

	static WebDriver driver = Parameters.driver;
	static WebDriverWait wait = new WebDriverWait(driver, 90);

	@Rule
	public ScreenCaptureRule screenCapture = new ScreenCaptureRule();

	@Test
	public static void InformAccount() throws Exception{

		ConfigWebDriver.acessApplication(driver, 0);

		if(driver.findElements(By.name("AGN")).size() == 0){
			ScreenCapture.takePrintScreen();
			LogRegister.info("Atenção: O servidor de aplicação está indisponível.");
			Parameters.controllerFailure = false;
		}
	}	
}

package parameters;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;

import common.LogRegister;

public class ConfigWebDriver {

	public static WebDriver selectWebDriver(int option){

		WebDriver driver = null;

		switch (option) {
		case 0:
			driver = new FirefoxDriver();
			break;
		case 1:
			System.setProperty("webdriver.chrome.driver", Parameters.ieWebDriverPath);
			driver = new ChromeDriver();
			break;
		case 2:
			System.setProperty("webdriver.ie.driver", Parameters.chromeWebDriverPath);
			driver = new InternetExplorerDriver();
			break;
		default:
			System.out.println("Error: 'ConfigWebDriver.selectWebDriver()'\nBrowser unknown! Enter 0 (Firefox), 1 (Chrome) or 2 (Internet Explorer)");
			break;
		}
		return driver;
	}

	public static void acessApplication(WebDriver driver, int idUrlList){
		driver.get(Parameters.urlApplication[idUrlList]);
		driver.manage().window().maximize();
	}

	public static void endApplication(){
	    if(Parameters.controllerEnd == true){
			try {
				Runtime.getRuntime().exec("taskkill /F /IM iexplore.exe");
			} catch (IOException e) {
				LogRegister.error("Eror:" + e.getStackTrace());
			}
	    }
	    Parameters.controllerEnd = false;
	}
}
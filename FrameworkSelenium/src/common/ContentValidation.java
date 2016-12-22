package common;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class ContentValidation {

	public static void ValidateText(WebDriver driver, String xpathWebElement, String text) throws Exception{

		try{
			if (driver.findElement(By.xpath(xpathWebElement)).getText().contains(text)){
				LogRegister.info("Valida o texto '" + text + "'.");
			}

			else{
				LogRegister.info("Aten��o: O texto '" + text + "' n�o est� correto.");
			}
			ScreenCapture.takePrintScreen();
		}

		catch(Exception e){
			LogRegister.error("Eror:" + e.getMessage());
			throw(e);
		}
	}
}
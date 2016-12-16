package common;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class PageContentValidation {

	public static void ValidateTitle(WebDriver driver, String xpathWebElement, String textTitle) throws Exception{

		try{
			if (driver.findElement(By.xpath(xpathWebElement)).getText().equals(textTitle)){
				LogRegister.info("Valida o t�tulo da p�gina: '" + textTitle + "'.");
			}

			else{
				LogRegister.info("Aten��o: O t�tulo '" + textTitle + "' n�o est� correto.");
			}
			ScreenCapture.takePrintScreen();
		}

		catch(Exception e){
			LogRegister.error("Eror:" + e.getMessage());
			throw(e);
		}
	}
	
	public static void ValidateContent(WebDriver driver, String xpathWebElement, String textContent) throws Exception{

		try{
			if (driver.findElement(By.xpath(xpathWebElement)).getText().equals(textContent)){
				LogRegister.info("Valida o conte�do da p�gina: " + textContent + ".");
			}

			else{
				LogRegister.info("Aten��o: O texto '" + textContent + "' n�o est� correto.");
			}
			ScreenCapture.takePrintScreen();
		}

		catch(Exception e){
			LogRegister.error("Eror:" + e.getMessage());
			throw(e);
		}
	}
}
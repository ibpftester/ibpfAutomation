package common;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class PageContentValidation {

	public static void ValidateTitle(WebDriver driver, String xpathWebElement, String textTitle) throws Exception{

		try{
			if (driver.findElement(By.xpath(xpathWebElement)).getText().equals(textTitle)){
				LogRegister.info("Valida o título da página: '" + textTitle + "'.");
			}

			else{
				LogRegister.info("Atenção: O título '" + textTitle + "' não está correto.");
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
				LogRegister.info("Valida o conteúdo da página: " + textContent + ".");
			}

			else{
				LogRegister.info("Atenção: O texto '" + textContent + "' não está correto.");
			}
			ScreenCapture.takePrintScreen();
		}

		catch(Exception e){
			LogRegister.error("Eror:" + e.getMessage());
			throw(e);
		}
	}
}
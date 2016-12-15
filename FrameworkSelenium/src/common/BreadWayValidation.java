package common;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import parameters.Parameters;

public class BreadWayValidation {

	public static void ValidateBreadWayText(WebDriver driver, String xpathWebElement, String textBreadWay) throws Exception{

		try{
			if (driver.findElement(By.xpath(xpathWebElement)).getText().equals(textBreadWay)){
				LogRegister.info("Valida o texto '" + textBreadWay + "' do caminho de pão.");
			}

			else{
				LogRegister.info("Atenção: O texto '" + textBreadWay + "' do caminho de pão não está correto.");
			}
			ScreenCapture.takePrintScreen();
		}

		catch(Exception e){
			LogRegister.error("Eror:" + e.getMessage());
			throw(e);
		}
	}

	public static void ValidateBreadWayAction(WebDriver driver, String xpathWebElementSelected, String xpathWebElementDirected) throws Exception{

		WebDriverWait wait = new WebDriverWait(driver, 300);

		try{
			WebElement breadWay = driver.findElement(By.partialLinkText(xpathWebElementSelected));

			LogRegister.info("Seleciona o caminho de pão '" + breadWay.getText() + "'.");
			breadWay.click();

			wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(xpathWebElementDirected)));
			ScreenCapture.takePrintScreen();

			if(driver.findElements(By.xpath(xpathWebElementDirected)).size() == 0){
				ScreenCapture.takePrintScreen();
				LogRegister.info("Atenção: O serviço que direciona o caminho de pão '" + breadWay.getText() + "' está incorreto.");
				Parameters.controllerFailure = false;
			}
		}

		catch(Exception e){
			LogRegister.error("Eror:" + e.getMessage());
			throw(e);
		}
	}
}
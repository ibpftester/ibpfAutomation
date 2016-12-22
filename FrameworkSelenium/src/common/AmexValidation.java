package common;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import parameters.Parameters;

public class AmexValidation {

	public static void ValidateText(WebDriver driver, String xpathWebElement) throws Exception {

		String amexText = "As informa��es e servi�os referentes aos Cart�es American Express Membership Cards, encontram-se dispon�veis no site:";

		try {
			if (driver.findElement(By.xpath(xpathWebElement)).getText().equals(amexText)) {
				LogRegister.info("Valida o texto '" + amexText + "'.");
			}

			else {
				LogRegister.info("Aten��o: O texto '" + amexText + "' n�o est� correto.");
			}
			ScreenCapture.takePrintScreen();
		}

		catch (Exception e) {
			LogRegister.error("Eror:" + e.getMessage());
			throw (e);
		}
	}

	public static void ValidateAmexAction(WebDriver driver, String xpathWebElementSelected) throws Exception {

		try {
			WebElement amexLink = driver.findElement(By.xpath(xpathWebElementSelected));

			LogRegister.info("Seleciona o link '" + amexLink.getText() + "'.");
			amexLink.click();

			if (driver.getPageSource().contains("American Express")
					&& (!driver.getPageSource().contains("erro") || !driver.getPageSource().contains("error"))) {
				ScreenCapture.takePrintScreen();
				LogRegister.info("Link '" + amexLink.getText() + "' verificado.");
			}

			else {
				ScreenCapture.takePrintScreen();
				LogRegister.info("Aten��o: O link '" + amexLink.getText()
						+ "' est� com o direcionamento incorreto ou o site se encontra indispon�vel.");
				Parameters.controllerFailure = false;
			}

//			String originalWindowHandle = driver.getWindowHandle();
			java.util.Set<java.lang.String> windowHandles = driver.getWindowHandles();
//			for (String window : windowHandles) {
//				System.out.print("Aqui: " + window);
//				driver.switchTo().window(originalWindowHandle);
//				if (!window.equals(originalWindowHandle)) {
//					driver.switchTo().window(window).close();
//				}
//				driver.switchTo().window(originalWindowHandle);
//			}
			
			
			String originalWindowHandle = driver.getWindowHandle();

//			for (String window : driver.getWindowHandles()) {
//				driver.switchTo().window(window);
//			}
//			driver.close();
			driver.switchTo().window(originalWindowHandle);
			
			driver.switchTo().defaultContent();
			 driver.switchTo().window(windowHandles.iterator().next());
		}

		catch (Exception e) {
			LogRegister.error("Eror:" + e.getMessage());
			throw (e);
		}
	}
}
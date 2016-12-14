package pages;

import org.junit.Rule;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import common.BreadWay;
import common.LogRegister;
import common.ScreenCapture;
import parameters.Parameters;
import rules.ScreenCaptureRule;

public class AccLimitsAvailableForBuyAndSake {

	static WebDriver driver = Parameters.driver;
	static WebDriverWait wait = new WebDriverWait(driver, 300);

	@Rule
	public ScreenCaptureRule screenCapture = new ScreenCaptureRule();

	@Test
	public static void SelectLimitsAvailableForBuyAndSake() throws Exception{

		try{
			if (Parameters.controllerFailure == true){
				if(driver.findElements(By.xpath("//a[@title='Limites Dispon�veis para Compra e Saque']")).size() == 0){
					LogRegister.info("Aten��o: A funcionalidade 'Limites Dispon�veis para Compra e Saque' n�o est� dispon�vel.");
					Parameters.controllerFailure = false;
				}

				else{
					WebElement linkLimitsAvailableForBuyAndSake = driver.findElement(By.partialLinkText("Limites Dispon�veis para Compra e Saque"));

					LogRegister.startTestCase();
					LogRegister.info("Seleciona a funcionalidade 'Limites Dispon�veis para Compra e Saque'.");
					linkLimitsAvailableForBuyAndSake.click();
					wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id='conteudo']/div[2]/div[1]/h2")));
				}
				ScreenCapture.takePrintScreen();
			}
		}

		catch(Exception e){
			LogRegister.error("Eror:" + e.getMessage());
			throw(e);
		}
	}

	@Test
	public static void ValidateBreadWay() throws Exception{

		try{
			if (Parameters.controllerFailure == true){
				BreadWay.ValidateBreadWayText(driver, "//*[@id='_id60_0:_id64']", "P�gina Inicial");
				BreadWay.ValidateBreadWayText(driver, "//*[@id='_id60_1:_id71']", "Cart�es");
				BreadWay.ValidateBreadWayText(driver, "//*[@id='_id60_2:_id89']", "Consultas : Limites Dispon�veis para Compra e Saque");

				BreadWay.ValidateBreadWayAction(driver, "Cart�es", "//*[@id='conteudo']/div[2]/div[1]/h2");
				SelectLimitsAvailableForBuyAndSake();
			}
		}

		catch(Exception e){
			LogRegister.error("Eror:" + e.getMessage());
			throw(e);
		}
	}
}
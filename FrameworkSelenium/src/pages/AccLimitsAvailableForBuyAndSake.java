package pages;

import org.junit.Rule;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import common.AmexValidation;
import common.BreadWayValidation;
import common.ContentValidation;
import common.LogRegister;
import common.ScreenCapture;
import parameters.Parameters;
import rules.ScreenCaptureRule;

public class AccLimitsAvailableForBuyAndSake {

	static WebDriver driver = Parameters.driver;
	static WebDriverWait wait = new WebDriverWait(driver, 300);
	//public static String valueUrl = "";

	@Rule
	public ScreenCaptureRule screenCapture = new ScreenCaptureRule();

	@Test
	public static void SelectLimitsAvailableForBuyAndSake() throws Exception{

		try{
			if (Parameters.controllerFailure == true){
				if(driver.findElements(By.xpath("//a[@title='Limites Disponíveis para Compra e Saque']")).size() == 0){
					LogRegister.info("Atenção: A funcionalidade 'Limites Disponíveis para Compra e Saque' não está disponível.");
					Parameters.controllerFailure = false;
				}

				else{
					WebElement linkLimitsAvailableForBuyAndSake = driver.findElement(By.partialLinkText("Limites Disponíveis para Compra e Saque"));

					LogRegister.startTestCase();
					LogRegister.info("Seleciona a funcionalidade 'Limites Disponíveis para Compra e Saque'.");
					linkLimitsAvailableForBuyAndSake.click();
					wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id='conteudo']/div[2]/div[1]/h2")));
				}
				ScreenCapture.takePrintScreen();
				//valueUrl = ((JavascriptExecutor) driver).executeScript("return window.location.href;").toString();
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
				BreadWayValidation.ValidateBreadWayText(driver, "//*[@id='_id60_0:_id64']", "Página Inicial");
				BreadWayValidation.ValidateBreadWayText(driver, "//*[@id='_id60_1:_id71']", "Cartões");
				BreadWayValidation.ValidateBreadWayText(driver, "//*[@id='_id60_2:_id89']", "Consultas : Limites Disponíveis para Compra e Saque");

				BreadWayValidation.ValidateBreadWayAction(driver, "Cartões", "//*[@id='conteudo']/div[2]/div[1]/h2");
				SelectLimitsAvailableForBuyAndSake();
			}
		}

		catch(Exception e){
			LogRegister.error("Eror:" + e.getMessage());
			throw(e);
		}
	}
	
	@Test
	public static void ValidateText() throws Exception{

		try{
			if (Parameters.controllerFailure == true){
				ContentValidation.ValidateText(driver, "//*[@id='conteudo']/div[2]/div[1]/h2", "Limites Disponíveis para Compra e Saque");
				ContentValidation.ValidateText(driver, "//*[@id='conteudo']/div[2]/div[1]/p", "Os dados abaixo correspondem ao limite atual disponível do seu Cartão de Crédito. Os limites estão sujeitos a alteração.");
				ContentValidation.ValidateText(driver, "//*[@id='conteudo']/div[2]/div[2]/div/div/div/span", "Sabia que você tem um limite emergencial para suas compras no cartão de crédito? Conheça as Condições Gerais da Avaliação Emergencial de Crédito");
				ContentValidation.ValidateText(driver, "//*[@id='_id245']/div", "Limite por Cartão");
				ContentValidation.ValidateText(driver, "//*[@id='_id245']", "Consulte o limite individual de cada cartão.");
				AmexValidation.ValidateText(driver, "//*[@id='conteudo']/div[2]/div[3]/p/span[1]");
				//AmexValidation.ValidateAmexAction(driver, "//*[@id='link_ext']/a");
			}
		}

		catch(Exception e){
			LogRegister.error("Eror:" + e.getMessage());
			throw(e);
		}
	}
}
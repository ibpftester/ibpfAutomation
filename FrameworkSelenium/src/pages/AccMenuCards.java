package pages;

import org.junit.Rule;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;

import common.LogRegister;
import common.ScreenCapture;
import parameters.Parameters;
import rules.ScreenCaptureRule;

public class AccMenuCards {
	
	static WebDriver driver = Parameters.driver;
	static WebDriverWait wait = new WebDriverWait(driver, 300);

	@Rule
	public ScreenCaptureRule screenCapture = new ScreenCaptureRule();

	@Test
	public static void SelectMenuCards() throws Exception{

		if(driver.findElements(By.className("botaoentretela")).size() != 0){		
			WebElement messageIB = driver.findElement(By.xpath("//*[@id='entretela']/div[1]/div[2]/a/img"));
			LogRegister.info("Clica na op��o afirmando que n�o tem interesse na mensagem/produto apresentado.");
			JavascriptExecutor executor = (JavascriptExecutor)driver;
			executor.executeScript("arguments[0].click();", messageIB);
		}

		WebElement menuCards = driver.findElement(By.xpath("//a[@title='Cart�es']"));

		LogRegister.startTestCase();
		LogRegister.info("Seleciona o menu 'Cart�es'.");
		JavascriptExecutor executor = (JavascriptExecutor)driver;
		executor.executeScript("arguments[0].click();", menuCards);
		Thread.sleep(30000);
		//driver.switchTo().frame(1);
		//wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id='conteudo']/div[2]/div[1]/h2")));
		ScreenCapture.takePrintScreen();
		
		if(driver.findElement(By.tagName("body")).getText().contains("indispon�vel")){
			ScreenCapture.takePrintScreen();
			LogRegister.info("Aten��o: O servi�o do menu 'Cart�es' est� indispon�vel.");
			Parameters.controllerFailure = false;
		}
	}

	@Test
	public static void SelectTabMyCreditCards() throws Exception{

		if (Parameters.controllerFailure == true){
			try{
				SelectMenuCards();

				if (Parameters.controllerFailure == true){
					WebElement tabMyCreditCards = driver.findElement(By.xpath("//a[@class='UITabs UItabs-header-tab tabindex pag98']"));

					LogRegister.info("Seleciona a aba 'Meus Cart�es de Cr�dito'.");
					tabMyCreditCards.click();
					Thread.sleep(3000);
					ScreenCapture.takePrintScreen();
			        LogRegister.endTestCase();
				}
			}

			catch(Exception e){
				LogRegister.error("Eror:" + e.getMessage());
				throw(e);
			}
		}
	}

	@Test
	public static void SelectTabMyDebitCard() throws Exception{

		if (Parameters.controllerFailure == true){
			try{
				SelectMenuCards();

				if (Parameters.controllerFailure == true){
					WebElement tabMyDebitCard = driver.findElement(By.xpath("//a[@class='UITabs UItabs-header-tab tabindex pag100']"));

					LogRegister.info("Seleciona a aba 'Meus Cart�o de D�bito'.");
					tabMyDebitCard.click();
					Thread.sleep(3000);
					ScreenCapture.takePrintScreen();
			        LogRegister.endTestCase();
				}
			}

			catch(Exception e){
				LogRegister.error("Eror:" + e.getMessage());
				throw(e);
			}
		}
	}

	@Test
	public static void SelectTabBradescardCards() throws Exception{

		if (Parameters.controllerFailure == true){
			try{
				SelectMenuCards();

				if (Parameters.controllerFailure == true){
					WebElement tabBradescardCards = driver.findElement(By.xpath("//a[@class='UITabs UItabs-header-tab tabindex pag101']"));

					LogRegister.info("Seleciona a aba 'Cart�es Bradescard'.");
					tabBradescardCards.click();
					Thread.sleep(3000);
					ScreenCapture.takePrintScreen();
			        LogRegister.endTestCase();
				}
			}

			catch(Exception e){
				LogRegister.error("Eror:" + e.getMessage());
				throw(e);
			}
		}
	}

	@Test
	public static void SelectTabPreCompensa() throws Exception{

		if (Parameters.controllerFailure == true){
			try{
				SelectMenuCards();
	
				if (Parameters.controllerFailure == true){
					WebElement tabPreCompensa = driver.findElement(By.xpath("//a[@class='UITabs UItabs-header-tab tabindex pag99']"));
	
					LogRegister.info("Seleciona a aba 'Pr� Compensa'.");
					tabPreCompensa.click();
					Thread.sleep(3000);
					ScreenCapture.takePrintScreen();
			        LogRegister.endTestCase();
				}
			}
	
			catch(Exception e){
				LogRegister.error("Eror:" + e.getMessage());
				throw(e);
			}
		}
	}
}
package pages;

import org.junit.Rule;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
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

		WebElement menuCards = driver.findElement(By.xpath("//a[@title='Cartões']"));

		LogRegister.startTestCase();
		LogRegister.info("Seleciona o menu 'Cartões'.");
		menuCards.click();
		driver.switchTo().frame(1);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id='conteudo']/div[2]/div[1]/h2")));
		ScreenCapture.takePrintScreen();
		
		if(driver.findElement(By.tagName("body")).getText().contains("indisponível")){
			ScreenCapture.takePrintScreen();
			LogRegister.info("Atenção: O serviço do menu 'Cartões' está indisponível.");
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

					LogRegister.info("Seleciona a aba 'Meus Cartões de Crédito'.");
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

					LogRegister.info("Seleciona a aba 'Meus Cartão de Débito'.");
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

					LogRegister.info("Seleciona a aba 'Cartões Bradescard'.");
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
	
					LogRegister.info("Seleciona a aba 'Pré Compensa'.");
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
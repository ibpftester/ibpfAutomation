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
import parameters.ConfigWebDriver;
import parameters.Parameters;
import rules.ScreenCaptureRule;

public class NotAccLogin {

	static WebDriver driver = Parameters.driver;
	static WebDriverWait wait = new WebDriverWait(driver, 90);

	@Rule
	public ScreenCaptureRule screenCapture = new ScreenCaptureRule();

	@Test
	public static void InformCpfNumber() throws Exception{

		ConfigWebDriver.acessApplication(driver, 1);

		if(driver.findElements(By.name("IDENT")).size() == 0){
			ScreenCapture.takePrintScreen();
			LogRegister.info("Aten��o: O servidor de aplica��o est� indispon�vel.");
			Parameters.controllerFailure = false;
		}

		else {
			WebElement cpfNumber = driver.findElement(By.name("IDENT"));
			WebElement submitButton = driver.findElement(By.xpath("//input[@type='submit'][@value='Entra']"));

			try{
				LogRegister.startTestCase();
				ScreenCapture.takePrintScreen();
				LogRegister.info("Informa o n�mero do CPF.");
				cpfNumber.sendKeys(Parameters.cpfNumber);
				LogRegister.info("Clica no bot�o 'Entra'.");
				ScreenCapture.takePrintScreen();
				submitButton.click();
		        LogRegister.endTestCase();
		        Thread.sleep(3000);
		        ScreenCapture.takePrintScreen();
				if(driver.findElement(By.tagName("body")).getText().contains("erro")){
					ScreenCapture.takePrintScreen();
					LogRegister.info("Aten��o: O servidor de aplica��o est� indispon�vel.");
					Parameters.controllerFailure = false;
				}
			}
			catch(Exception e){
				LogRegister.error("Eror:" + e.getStackTrace());
				throw(e);
			}
		}
	}

	@Test
	public static void InformPassword() throws Exception{

		if (Parameters.controllerFailure == true){

			if(driver.findElement(By.tagName("body")).getText().contains("O CPF informado n�o � v�lido")){
				ScreenCapture.takePrintScreen();
				LogRegister.info("Aten��o: A informa��o 'CPF' n�o corresponde a um n�o correntista v�lido.");
			}

			else if(driver.findElement(By.tagName("body")).getText().contains("indispon�vel")){
				ScreenCapture.takePrintScreen();
				LogRegister.info("Aten��o: O servi�o de login est� indispon�vel.");
			}

			else{
				driver.switchTo().frame(0);	

		        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@title='Tecla " + Parameters.passwordNDigit1 + "']")));

				WebElement digit1PasswordButton = driver.findElement(By.xpath("//div[@title='Tecla " + Parameters.passwordNDigit1 + "']"));
				WebElement digit2PasswordButton = driver.findElement(By.xpath("//div[@title='Tecla " + Parameters.passwordNDigit2 + "']"));
				WebElement digit3PasswordButton = driver.findElement(By.xpath("//div[@title='Tecla " + Parameters.passwordNDigit3 + "']"));
				WebElement digit4PasswordButton = driver.findElement(By.xpath("//div[@title='Tecla " + Parameters.passwordNDigit4 + "']"));		
				WebElement advanceButton = driver.findElement(By.id("frmTecladoVirtual:botaoAvancar"));

				try{
					LogRegister.startTestCase();
					LogRegister.info("Informa o d�gito 1 da senha.");
					digit1PasswordButton.click();
					LogRegister.info("Informa o d�gito 2 da senha.");
					digit2PasswordButton.click();
					LogRegister.info("Informa o d�gito 3 da senha.");
					digit3PasswordButton.click();
					LogRegister.info("Informa o d�gito 4 da senha.");
					digit4PasswordButton.click();
					Thread.sleep(4000);
					ScreenCapture.takePrintScreen();
					wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("frmTecladoVirtual:botaoAvancar")));
					LogRegister.info("Clica no bot�o 'Avan�ar'.");
					ScreenCapture.takePrintScreen();
					advanceButton.click();
					Thread.sleep(10000);

					if(driver.findElement(By.tagName("body")).getText().contains("Acesso Bloqueado")){
						ScreenCapture.takePrintScreen();
						LogRegister.info("Aten��o: A senha de 4 d�gitos est� bloqueada.");
					}

					else if(driver.findElement(By.tagName("body")).getText().contains("A Senha de 4 D�gitos n�o est� correta")){
						ScreenCapture.takePrintScreen();
						LogRegister.info("Aten��o: A senha de 4 d�gitos est� incorreta.");
					}

					else if(driver.findElement(By.tagName("body")).getText().contains("indispon�vel")){
						ScreenCapture.takePrintScreen();
						LogRegister.info("Aten��o: O servi�o de login est� indispon�vel.");
					}

					else if(driver.findElement(By.tagName("body")).getText().contains("CPF n�o cadastrado")){
						ScreenCapture.takePrintScreen();
						LogRegister.info("Aten��o: O CPF informado n�o est� cadastrado como um n�o correntista.");
					}

					else{
						wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("logo")));
				        ScreenCapture.takePrintScreen();

						if(driver.findElement(By.tagName("body")).getText().contains("indispon�vel")){
							ScreenCapture.takePrintScreen();
							LogRegister.info("Aten��o: O servi�o de login est� indispon�vel.");
						}
					}
					LogRegister.endTestCase();
				}
				catch(Exception e){
					LogRegister.error("Eror:" + e.getStackTrace());
					throw(e);
				}
			}
		}
	}
}
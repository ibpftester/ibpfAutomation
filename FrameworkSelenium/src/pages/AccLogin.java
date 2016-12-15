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
import common.SpellChecker;
import parameters.ConfigWebDriver;
import parameters.Parameters;
import rules.ScreenCaptureRule;

public class AccLogin {

	static WebDriver driver = Parameters.driver;
	static WebDriverWait wait = new WebDriverWait(driver, 90);

	@Rule
	public ScreenCaptureRule screenCapture = new ScreenCaptureRule();

	@Test
	public static void InformAccount() throws Exception{

		ConfigWebDriver.acessApplication(driver, 0);

		if(driver.findElements(By.name("AGN")).size() == 0){
			ScreenCapture.takePrintScreen();
			LogRegister.info("Aten��o: O servidor de aplica��o est� indispon�vel.");
			Parameters.controllerFailure = false;
		}

		else {
			WebElement agencyField = driver.findElement(By.name("AGN"));
			WebElement accountField = driver.findElement(By.name("CTA"));
			WebElement digitAccountField = driver.findElement(By.name("DIGCTA"));
			WebElement submitButton = driver.findElement(By.xpath("//input[@type='submit'][@value='Entra']"));

			try{
				LogRegister.startTestCase();
				ScreenCapture.takePrintScreen();
				LogRegister.info("Informa ag�ncia.");
				agencyField.sendKeys(Parameters.agency);
				LogRegister.info("Informa n�mero da conta.");
				accountField.sendKeys(Parameters.account);
				LogRegister.info("Informa d�gito da conta.");
				digitAccountField.sendKeys(Parameters.digitAccount);
				ScreenCapture.takePrintScreen();
				LogRegister.info("Clica no bot�o 'Entra'.");
				submitButton.click();
		        LogRegister.endTestCase();
		        Thread.sleep(3000);
		        ScreenCapture.takePrintScreen();
				if(driver.findElement(By.tagName("body")).getText().contains("erro") || driver.findElement(By.tagName("body")).getText().contains("Erro")){					
					ScreenCapture.takePrintScreen();
					LogRegister.info("Aten��o: O servidor de aplica��o est� indispon�vel.");
					Parameters.controllerFailure = false;
				}
			}
			catch(Exception e){
				LogRegister.error("Eror:" + e.getMessage());
				throw(e);
			}
		}
	}

	@Test
	public static void InformPassword() throws Exception{

		if (Parameters.controllerFailure == true){
			SpellChecker.teste(driver.findElement(By.tagName("body")).getText());
			if(driver.findElement(By.tagName("body")).getText().contains("Sua senha de 4 d�gitos")){
				ScreenCapture.takePrintScreen();
				LogRegister.info("Aten��o: A senha de 4 d�gitos est� cancelada.");
				Parameters.controllerFailure = false;
			}

			else if(driver.findElement(By.tagName("body")).getText().contains("Cliente inexistente")){
				ScreenCapture.takePrintScreen();
				LogRegister.info("Aten��o: As informa��es 'Ag�ncia', 'Conta' e 'D�gito' n�o correspondem a um correntista v�lido.");
				Parameters.controllerFailure = false;
			}

			else if(driver.findElement(By.tagName("body")).getText().contains("indispon�vel")){
				ScreenCapture.takePrintScreen();
				LogRegister.info("Aten��o: O servi�o de login est� indispon�vel.");
				Parameters.controllerFailure = false;
			}

			else{
				wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//a[@title='" + Parameters.passwordCDigit1 + "']")));

				WebElement digit1PasswordButton = driver.findElement(By.xpath("//a[@title='" + Parameters.passwordCDigit1 + "']"));
				WebElement digit2PasswordButton = driver.findElement(By.xpath("//a[@title='" + Parameters.passwordCDigit2 + "']"));
				WebElement digit3PasswordButton = driver.findElement(By.xpath("//a[@title='" + Parameters.passwordCDigit3 + "']"));
				WebElement digit4PasswordButton = driver.findElement(By.xpath("//a[@title='" + Parameters.passwordCDigit4 + "']"));		
				WebElement advanceButton = driver.findElement(By.id("loginbotoes:botaoAvancar"));

				try{
					LogRegister.startTestCase();
					wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//a[@title='" + Parameters.passwordCDigit1 + "']")));
					LogRegister.info("Informa o d�gito 1 da senha.");
					digit1PasswordButton.click();
					LogRegister.info("Informa o d�gito 2 da senha.");
					digit2PasswordButton.click();
					LogRegister.info("Informa o d�gito 3 da senha.");
					digit3PasswordButton.click();
					LogRegister.info("Informa o d�gito 4 da senha.");
					digit4PasswordButton.click();
					Thread.sleep(4000);

					if(driver.findElement(By.tagName("body")).getText().contains("A Senha de 4 D�gitos n�o est� correta")){
						ScreenCapture.takePrintScreen();
						LogRegister.info("Aten��o: A senha de 4 d�gitos est� incorreta.");
						Parameters.controllerFailure = false;
					}

					else if(driver.findElement(By.tagName("body")).getText().contains("Todas as chaves do seu cart�o foram utilizadas")){
						ScreenCapture.takePrintScreen();
						LogRegister.info("Aten��o: Todas as chaves (token) do cart�o j� foram utilizadas.");
						Parameters.controllerFailure = false;
					}

					else if(driver.findElement(By.tagName("body")).getText().contains("indispon�vel")){
						ScreenCapture.takePrintScreen();
						LogRegister.info("Aten��o: O servi�o de login est� indispon�vel.");
						Parameters.controllerFailure = false;
					}

					else{
						ScreenCapture.takePrintScreen();
						if(driver.findElements(By.id("botao-nao-recebi")).size() != 0){
							WebElement notReceiveCardButton = driver.findElement(By.id("botao-nao-recebi"));
							LogRegister.info("Clica na op��o afirmando que n�o recebeu o cart�o.");
							notReceiveCardButton.click();
						}
						wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//label[@for='txtCartaoSeg']")));
						ScreenCapture.takePrintScreen();
						LogRegister.info("Obt�m a chave de seguran�a.");
						String labelSecurityKeyField = (driver.findElement(By.xpath("//label[@for='txtCartaoSeg']")).getText());
						String[] securityKey = labelSecurityKeyField.split(" ");
						WebElement securityKeyField = driver.findElement(By.id("form_j_tancode:txtCartaoSeg"));
						LogRegister.info("Informa a chave de seguran�a.");
						securityKeyField.sendKeys(securityKey[1]);
						ScreenCapture.takePrintScreen();
						LogRegister.info("Clica no bot�o 'Avan�ar'.");
						advanceButton.click();
				        LogRegister.endTestCase();
				        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("logo")));
				        ScreenCapture.takePrintScreen();

						if(driver.findElement(By.tagName("body")).getText().contains("indispon�vel")){
							ScreenCapture.takePrintScreen();
							LogRegister.info("Aten��o: O servi�o de login est� indispon�vel.");
							Parameters.controllerFailure = false;
						}
					}
				}
				catch(Exception e){
					LogRegister.error("Eror:" + e.getMessage());
					throw(e);
				}
			}
		}
	}
}
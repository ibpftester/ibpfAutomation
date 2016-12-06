package parameters;

import org.openqa.selenium.WebDriver;

public class Parameters {
	
	public static boolean controllerFailure = true;
	public static boolean controllerEnd = false;
	
	public static String ieWebDriverPath = "D:\\chromedriver.exe";
	public static String chromeWebDriverPath = "D:\\IEDriverServer.exe";
	
	public static String pathScreenshots = "D:\\Log\\";
	public static String pathErrorScreenshots = "D:\\Log\\Erros\\";

	public static String[] urlApplication = {"https://www.ib.bradesco.des.scopus.com.br/ibpflogin/login.htm.", 
		"https://www.ib.bradesco.des.scopus.com.br/ibpfnaocorrentistalogin/login.htm.", 
		"https://www.ib.bradesco.des.scopus.com.br/cartoesbradesco/loginCartao.jsf"};

	public static WebDriver driver = ConfigWebDriver.selectWebDriver(2);
	
	/* Dados de login de Correntista */
	public static String agency = "3982";
	public static String account = "1115";
	public static String digitAccount = "0";
	public static String passwordCDigit1 = "1";
	public static String passwordCDigit2 = "2";
	public static String passwordCDigit3 = "1";
	public static String passwordCDigit4 = "2";;
	
	/* Dados de login de Não Correntista */
	public static String cpfNumber = "18781088914";
	public static String passwordNDigit1 = "1";
	public static String passwordNDigit2 = "2";
	public static String passwordNDigit3 = "1";
	public static String passwordNDigit4 = "2";
	
	public static int numberOfDatabase = 2;
	
	public static String[] vSgbd = {"0", "0"}; //(0 - Sql Server; 1 - MySql; 2 - Oracle)
	public static String[] vServerName = {"localhost", "localhost2"};
	public static String[] vPortNumber = {"1521", "1522"};
	public static String[] vDataBaseName = {"db_test", "db_test2"};
	public static String[] vUserName = {"root", "root2"};
	public static String[] vPassword = {"123456", "123457"};
}
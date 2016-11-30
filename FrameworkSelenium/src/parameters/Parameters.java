package parameters;

public class Parameters {

	public static String ieWebDriverPath = "D:\\ProjetosEclipse\\chromedriver.exe";
	public static String chromeWebDriverPath = "D:\\ProjetosEclipse\\IEDriverServer.exe";
	
	public static String pathScreenshots = "D:\\Log\\";
	public static String pathErrorScreenshots = "D:\\Log\\Erros\\";
	
	public static String urlApplication = "http://www.google.com";	
	
	public static int numberOfDatabase = 2;
	
	public static String[] vSgbd = {"0", "0"}; //(0 - Sql Server; 1 - MySql; 2 - Oracle)
	public static String[] vServerName = {"localhost", "localhost2"};
	public static String[] vPortNumber = {"1521", "1522"};
	public static String[] vDataBaseName = {"db_test", "db_test2"};
	public static String[] vUserName = {"root", "root2"};
	public static String[] vPassword = {"123456", "123457"};
		
}
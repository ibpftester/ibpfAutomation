package parameters;

import org.junit.Test;

import common.LogRegister;
import pages.AccountantLogin;

public class Exec {


	@Test
	public void teste() throws Exception{
		
		try{
			AccountantLogin.Start();
			AccountantLogin.Login();
			AccountantLogin.InformPassword();
			AccountantLogin.End();		
		}

		catch(Exception e){
			LogRegister.error("Eror:" + e.getStackTrace());
			throw(e);
		}
	}
	
}

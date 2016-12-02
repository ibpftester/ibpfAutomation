package parameters;

import org.junit.Test;

import common.LogRegister;
import pages.AccountantLogin;
import pages.NotAccountantLoginPassword;

public class Exec {

	@Test
	public void teste() throws Exception{
		
		try{
			NotAccountantLoginPassword.Start();
			NotAccountantLoginPassword.Login();
			NotAccountantLoginPassword.InformPassword();
			NotAccountantLoginPassword.End();		
		}

		catch(Exception e){
			LogRegister.error("Eror:" + e.getStackTrace());
			throw(e);
		}
	}
	
}

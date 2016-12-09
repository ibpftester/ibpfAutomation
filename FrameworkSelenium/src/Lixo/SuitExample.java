package Lixo;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;

import pagesTest.TestAccountantLogin;
import pagesTest.TestNotAccountantLogin;

@RunWith(Suite.class)
@SuiteClasses({ TestAccountantLogin.class, TestNotAccountantLogin.class })
public class SuitExample {

}

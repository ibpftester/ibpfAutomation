package Lixo;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;

import pagesTest.TestAccLogin;
import pagesTest.TestNotAccLogin;

@RunWith(Suite.class)
@SuiteClasses({ TestAccLogin.class, TestNotAccLogin.class })
public class SuitExample {

}

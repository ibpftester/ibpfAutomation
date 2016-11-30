package common;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class LogRegister {
   
	private static Logger log = LogManager.getLogger(LogRegister.class.getName());

	public static void startTestCase() {
		log.info("****************************************************************************************");
		log.info("$$$$$$$$$$$$$$$$$$$$$$           " + Thread.currentThread().getStackTrace()[2].getMethodName()
				+ "           $$$$$$$$$$$$$$$$$$$$$$");
		log.info("****************************************************************************************");
	}

	public static void endTestCase() {
		log.info("****************************************************************************************");
		log.info("XXXXXXXXXXXXXXXXXXXXX               " + "-E---N---D-"
				+ "               XXXXXXXXXXXXXXXXXXXXX");
		log.info("****************************************************************************************");
	}

	public static void info(String message) {
		log.info(message);
	}

	public static void warn(String message) {
		log.warn(message);
	}

	public static void error(String message) {
		log.error(message);
	}

	public static void fatal(String message) {
		log.fatal(message);
	}

	public static void debug(String message) {
		log.debug(message);
	}

}
package parameters;

import java.awt.AWTException;
import java.awt.HeadlessException;
import java.io.IOException;

import common.ScreenCapture;

public class Teste {

	public static void main(String[] args) throws HeadlessException, AWTException, IOException {
		
		ScreenCapture.takePrintScreen();
		
		//DBConnection.getConnection(0);

	}

}

package rules;

import java.awt.AWTException;
import java.awt.HeadlessException;
import java.io.IOException;

import org.junit.rules.TestWatcher;
import org.junit.runner.Description;

import common.LogRegister;
import common.ScreenCapture;

public class ScreenCaptureRule extends TestWatcher {

	@Override
	protected void failed(Throwable e, Description description) {
		try {
			ScreenCapture.takeErrorPrintScreen();
		} catch (HeadlessException | AWTException | IOException e1) {	
			LogRegister.fatal("Error: " + e1);
		}
	}
}

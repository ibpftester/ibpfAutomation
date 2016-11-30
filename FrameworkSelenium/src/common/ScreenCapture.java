package common;

import java.awt.AWTException;
import java.awt.HeadlessException;
import java.awt.Rectangle;
import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

import parameters.Parameters;

public class ScreenCapture {

	public static void takePrintScreen() throws HeadlessException, AWTException, IOException{

		String namePath = Thread.currentThread().getStackTrace()[2].getClassName().substring(Thread.currentThread().getStackTrace()[2].getClassName().lastIndexOf(".") + 1);
		String nameScreenshot = Thread.currentThread().getStackTrace()[2].getMethodName();
		
		if (!new File(Parameters.pathScreenshots + namePath).exists())
		{
			new File(Parameters.pathScreenshots + namePath).mkdir();
		}
		
		BufferedImage screencapture = new Robot().createScreenCapture(
		           new Rectangle(Toolkit.getDefaultToolkit().getScreenSize()) );
			
		ImageIO.write(screencapture, "jpg", new File(Parameters.pathScreenshots + namePath + "\\" + nameScreenshot + "_" + DateTimeFunctions.getTimeScreenShot() + ".jpg"));
	}
	
	public static void takeErrorPrintScreen() throws HeadlessException, AWTException, IOException{

		String namePath = Thread.currentThread().getStackTrace()[2].getClassName().substring(Thread.currentThread().getStackTrace()[2].getClassName().lastIndexOf(".") + 1);
		String nameScreenshot = Thread.currentThread().getStackTrace()[2].getMethodName();
		
		if (!new File(Parameters.pathErrorScreenshots + namePath).exists())
		{
			new File(Parameters.pathErrorScreenshots + namePath).mkdir();
		}
		
		BufferedImage screencapture = new Robot().createScreenCapture(
		           new Rectangle(Toolkit.getDefaultToolkit().getScreenSize()) );
			
		ImageIO.write(screencapture, "jpg", new File(Parameters.pathErrorScreenshots + namePath + "\\" + "Error_" + nameScreenshot + "_" + DateTimeFunctions.getTimeScreenShot() + ".jpg"));
	}
	
}

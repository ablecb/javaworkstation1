package ui;

import java.awt.AWTException;
import java.awt.GraphicsConfiguration;
import java.awt.GraphicsDevice;
import java.awt.GraphicsEnvironment;
import java.awt.MouseInfo;
import java.awt.Point;
import java.awt.Robot;
import java.awt.event.MouseEvent;
import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.Reader;

public class main {
		public static void main(String[] args) throws  Exception{
			Point point=MouseInfo.getPointerInfo().getLocation();
			System.out.println(point.getX()+"     "+point.getY());
			Process process=Runtime.getRuntime().exec("cmd /c  dir E:vm");
			GraphicsEnvironment d=GraphicsEnvironment.getLocalGraphicsEnvironment();
			GraphicsDevice[]  gd  =d.getScreenDevices();
			System.out.println(gd.length);
			Robot r=new Robot();
			
			r.mouseMove(46, 42);
			r.mousePress(MouseEvent.BUTTON1_MASK);
			r.mouseRelease(MouseEvent.BUTTON1_MASK);
			r.delay(10);
			r.mousePress(MouseEvent.BUTTON1_MASK);
		}
}

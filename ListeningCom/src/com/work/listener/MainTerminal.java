package com.work.listener;

import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.swing.JFrame;

import org.jfree.ui.RefineryUtilities;

import jssc.SerialPortException;



public class MainTerminal {

	public static void main(String[] args) {
		JFrame simpleFrame = new MainWindow();
		RefineryUtilities.centerFrameOnScreen(simpleFrame);
		simpleFrame.setVisible(true);
		simpleFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		/*simpleFrame.addWindowListener(new WindowAdapter() { 
			public void windowClosing(WindowEvent e) {		
				try {
					if(.isOpened()) {
						serialPort.closePort();
					}
				} catch (SerialPortException e1) {
					System.out.println(e1);
				}
				//super.windowClosing(e);
				e.getWindow().dispose();
			}		
		});*/

	}

}

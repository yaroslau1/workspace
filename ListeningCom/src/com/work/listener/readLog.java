package com.work.listener;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.Arrays;

import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;

import jssc.SerialPort;
import jssc.SerialPortEvent;
import jssc.SerialPortEventListener;
import jssc.SerialPortException;

public class readLog extends Frame{
	//public static String data;
	static Label myLabel = new Label("Data Terminal Com"); 
	static JTextArea textArea = new JTextArea("***Start working***");

	public readLog() {

		super("TerminalCom");
		setSize(400,400);
		Button getData = new Button("Get Data");
		Button disconnect = new Button("Disconnect");
		Button connect = new Button("Connect");
		Button send = new Button("Send");
		Label label1 = new Label("***Start working***");
		JTextField textField = new JTextField();
		//JTextArea textArea = new JTextArea("***Start working***");
		add(myLabel, BorderLayout.NORTH);	
		add(getData, BorderLayout.SOUTH);
		add(send, BorderLayout.NORTH);
		add(disconnect, BorderLayout.WEST);
		add(connect, BorderLayout.EAST);
		//add(label1, BorderLayout.CENTER);
		add(new JScrollPane(textArea), BorderLayout.CENTER);

		serialPort = new SerialPort("COM3");

		disconnect.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				try {
					if(serialPort.isOpened()) {
						serialPort.closePort();
					}
					textArea.append("\n***Disconnected***");
				} catch (SerialPortException e1) {
					System.out.println(e1);
				}

			} 

		});

		connect.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				try {
					if(serialPort.isOpened()) {
						textArea.append("\n***Port already opened***");
					} else {
						serialPort.openPort();
						textArea.append("\n***Connected***");
						serialPort.setParams(921600,8,1,0);
					}

					//label1.setAlignment(Label.CENTER);


				} catch (SerialPortException e1) {
					System.out.println(e1);
				}

			} 

		});

		send.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				//byte[] buffer = {82,1,2,5,1,9,(byte) 170};
				byte[] buffer = {85,1,1,2,4,(byte) 170};
				try {
					//serialPort.writeString("85 1 2 5 1 9 170");	
					serialPort.writeBytes(buffer);
				} catch (SerialPortException e1) {
					System.out.println(e1);
				}
				try {
					Thread.sleep(1000);
				} catch (InterruptedException e2) {
					e2.printStackTrace();
					// handle the exception...
					// For example consider calling Thread.currentThread().interrupt(); here.
				}
				byte[] buffer1 = {85,1,2,5,1,9,(byte) 170};
				try {
					serialPort.writeBytes(buffer1);
				} catch (SerialPortException e1) {
					System.out.println(e1);
				}

			} 

		});

		getData.addActionListener(new ActionListener() { 

			public void actionPerformed(ActionEvent e) {
				//serialPort = new SerialPort("COM9");

				//String str1 = "85 1 2 5 1 9 170"; // 55 01 02 05 01 09 AA - send 85, 1, 1, 2, 2, 6, 170
				String str1 = "85 1 1 2 2 6 170";
				byte[] buffer = {85,1,2,5,1,9,(byte) 170};  //85 8 0 0 170
				//byte[] buffer = {82,8,0,0,(byte) 170};
				try {
					//serialPort.writeString(str1);
					serialPort.writeBytes(buffer);
					//serialPort.writeByte((byte) 85);
					serialPort.isOpened();

				}
				catch (SerialPortException ex) {
					JOptionPane.showMessageDialog(readLog.this,
							ex,
							"Inane warning",
							JOptionPane.WARNING_MESSAGE);
				}
				try {
					Thread.sleep(1000);
				} catch (InterruptedException e2) {
					e2.printStackTrace();
					// handle the exception...
					// For example consider calling Thread.currentThread().interrupt(); here.
				}

				try {
					//serialPort.wait(10);
					//serialPort.setParams(921600,8,1,0);
					serialPort.setEventsMask(SerialPort.MASK_RXCHAR + SerialPort.MASK_CTS + SerialPort.MASK_DSR);
					serialPort.addEventListener(new EventListener());

					byte [] data = serialPort.readBytes();
					textArea.append("\n" + Arrays.toString(data));
					textArea.append("\n******");
				}
				catch (SerialPortException ex) {
					System.out.println(ex);
				}
			}
		});
	}
	private static SerialPort serialPort;

	public static void main(String[] args){
		readLog log = new readLog();
		log.setVisible(true);
		//Button myButton;

		log.addWindowListener(new WindowAdapter() { 
			public void windowClosing(WindowEvent e) {		
				try {
					if(serialPort.isOpened()) {
						serialPort.closePort();
					}
				} catch (SerialPortException e1) {
					System.out.println(e1);
				}
				//super.windowClosing(e);
				e.getWindow().dispose();
			}		
		});
	}

	private static class EventListener implements SerialPortEventListener  {
		public void serialEvent(SerialPortEvent event) {
			//textArea.append("\n***prelistner***");
			//if(event.isRXCHAR() && event.getEventValue() > 0){
			if(event.isRXCHAR()){
				//while(!event.isRXCHAR());
				//textArea.append("\n***in listner***");
				try {

					byte [] data = serialPort.readBytes();
					
				//	String stringRead = serialPort.readString(event.getEventValue());
					textArea.append("\n" + Arrays.toString(data));
					System.out.print(Arrays.toString(data));
//					textArea.append("\n" + stringRead);
//					System.out.print(stringRead);
					textArea.append("\n******");
					System.out.println("\n*****\n");


				}
				catch (SerialPortException ex) {
					System.out.println(ex);
				}
			}
			else if(event.isCTS()){
				if(event.getEventValue() == 1){
					System.out.println("CTS - ON");
				}
				else {
					System.out.println("CTS - OFF");
				}
			}
			else if(event.isDSR()){
				if(event.getEventValue() == 1){
					System.out.println("DSR - ON");
				}
				else {
					System.out.println("DSR - OFF");
				}
			}
		}
	}
}
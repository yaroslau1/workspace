package com.work.listener;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import jssc.SerialPortList;

public class RefreshActionListner implements ActionListener{

	@Override
	public void actionPerformed(ActionEvent e) {
		String[] portNames = SerialPortList.getPortNames();
	}

}

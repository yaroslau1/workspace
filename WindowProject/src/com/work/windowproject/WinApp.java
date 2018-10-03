package com.work.windowproject;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JRadioButton;
import java.awt.BorderLayout;


public class WinApp {

	private JFrame frame;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					WinApp window = new WinApp();
					window.frame.setVisible(true);
				} catch (Exception e) {
					System.out.println(e);
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public WinApp() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 450, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}

}

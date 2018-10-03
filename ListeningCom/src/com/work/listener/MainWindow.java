package com.work.listener;

import java.awt.BorderLayout;
import java.awt.Button;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.Arrays;

import javax.swing.BorderFactory;
import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JScrollPane;
import javax.swing.JSplitPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.border.Border;

import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.axis.ValueAxis;
import org.jfree.chart.plot.XYPlot;
import org.jfree.data.time.Millisecond;
import org.jfree.data.time.TimeSeries;
import org.jfree.data.time.TimeSeriesCollection;
import org.jfree.data.xy.XYDataset;
import org.jfree.ui.RefineryUtilities;

import jssc.SerialPort;
import jssc.SerialPortEvent;
import jssc.SerialPortEventListener;
import jssc.SerialPortException;
import jssc.SerialPortList;
import jssc.SerialPortTimeoutException;

public class MainWindow extends JFrame{

	private static SerialPort serialPort = new SerialPort("COM9");

	static JTextArea textArea = new JTextArea("***Start working***");

	public static SerialPort getSerialPort() {
		return serialPort;
	}

	private static TimeSeries series;	

	@SuppressWarnings("deprecation")
	public MainWindow () {
		super("TerminalCOM");

		String[] portNames = SerialPortList.getPortNames();

		JComboBox<String> jComboBox = new JComboBox<String>(portNames);
		jComboBox.setMaximumSize(jComboBox.getPreferredSize());

		MainWindow.series = new TimeSeries("Data From COM", Millisecond.class);
		final TimeSeriesCollection dataset = new TimeSeriesCollection(MainWindow.series);
		final JFreeChart chart = createChart(dataset);

		final ChartPanel chartPanel = new ChartPanel(chart);

		JTextField textToSend = new JTextField(20);
		textToSend.setMaximumSize(textToSend.getPreferredSize());

		textArea.setSize(textArea.getPreferredSize());

		JButton clear = new JButton("Clear");
		JButton disconnect = new JButton("Disconnect");
		JButton connect = new JButton("Connect");
		JButton send = new JButton("Send");
		JButton start = new JButton("Start");
		JButton refresh = new JButton("Refresh ports");
		JButton get = new JButton("Get data");
		JPanel main = new JPanel();
		JPanel top = new JPanel();
		JPanel center = new JPanel();		
		JPanel botom = new JPanel();
		JPanel east = new JPanel();
		JPanel west = new JPanel();
		JPanel speed = new JPanel();
		Border speedBorder = BorderFactory.createTitledBorder("Baud Rate");
		speed.setBorder(speedBorder);
		ButtonGroup speedGroup = new ButtonGroup();
		JRadioButton rb9600 = new JRadioButton("9600", false);
		speedGroup.add(rb9600);
		JRadioButton rb115200 = new JRadioButton("115200", false);
		speedGroup.add(rb115200);
		JRadioButton rb921600 = new JRadioButton("921600", true);
		speedGroup.add(rb921600);

		JSplitPane jSplitPane = new JSplitPane(
				JSplitPane.HORIZONTAL_SPLIT,
				top, 
				center);

		speed.setLayout(new BoxLayout(speed, BoxLayout.Y_AXIS));
		speed.add(rb9600);
		speed.add(rb115200);
		speed.add(rb921600);		

		main.setLayout(new BorderLayout());
		top.setLayout(new BoxLayout(top, BoxLayout.X_AXIS));
		botom.setLayout(new BoxLayout(botom, BoxLayout.X_AXIS));
		center.setLayout(new BoxLayout(center, BoxLayout.PAGE_AXIS));
		east.setLayout(new BoxLayout(east, BoxLayout.Y_AXIS));
		west.setLayout(new BoxLayout(west, BoxLayout.Y_AXIS));

		main.add(top, BorderLayout.NORTH);
		main.add(botom, BorderLayout.SOUTH);
		main.add(center, BorderLayout.CENTER);
		main.add(east, BorderLayout.EAST);
		main.add(west, BorderLayout.WEST);

		west.add(textArea);
		west.add(new JScrollPane(textArea));

		center.add(Box.createHorizontalGlue());
		center.add(Box.createVerticalGlue());
		center.add(chartPanel);

		top.add(Box.createHorizontalStrut(10));
		top.add(Box.createVerticalGlue());
		top.add(connect);
		top.add(Box.createHorizontalStrut(10));
		top.add(disconnect);

		botom.add(Box.createHorizontalStrut(10));
		botom.add(Box.createVerticalGlue());
		botom.add(textToSend);
		botom.add(Box.createHorizontalStrut(10));
		botom.add(send);

		east.add(clear);
		east.add(Box.createVerticalStrut(10));
		east.add(jComboBox);
		east.add(Box.createVerticalStrut(10));
		east.add(refresh);
		east.add(Box.createVerticalStrut(10));
		east.add(get);
		east.add(Box.createVerticalStrut(10));
		east.add(start);
		east.add(Box.createVerticalStrut(10));
		east.add(speed);

		this.add(main);
		this.pack();

		/*	ActionListener actionListenerCB = new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String s = (String) comboBox.getSelectedItem();
				serialPort = new SerialPort(s);
			}
		};
		comboBox.addActionListener(actionListener);*/

		jComboBox.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				try {
					if(jComboBox.getSelectedItem() != null) {
						String selectedItem = (String) jComboBox.getSelectedItem();
						serialPort = new SerialPort(selectedItem.toString());
					}
				}
				catch(NullPointerException ex) {
					JOptionPane.showMessageDialog(MainWindow.this,
							ex,
							"Inane warning",
							JOptionPane.WARNING_MESSAGE);
				}
			}
		});

		clear.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				textArea.setText(null);
			}
		});


		refresh.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				jComboBox.removeAllItems();
				String [] ports = SerialPortList.getPortNames();
				for(String i: ports) {
					jComboBox.addItem(i);
				}
			}
		});


		disconnect.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				try {
					if(serialPort.isOpened()) {
						serialPort.closePort();
					}
					textArea.append("\n***Disconnected***");
				} catch (SerialPortException e1) {
					JOptionPane.showMessageDialog(MainWindow.this,
							e1,
							"Inane warning",
							JOptionPane.WARNING_MESSAGE);
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
						serialPort.setParams(115200, 8, 1, 0); //921600
						serialPort.setEventsMask(SerialPort.MASK_RXCHAR + SerialPort.MASK_CTS + SerialPort.MASK_DSR);
						serialPort.addEventListener(new EventListener());
						//serialPort.setParams(921600,8,1,0);
					}
				} catch (SerialPortException e1) {
					JOptionPane.showMessageDialog(MainWindow.this,
							e1,
							"Inane warning",
							JOptionPane.WARNING_MESSAGE);
				}
			}
		});

		send.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				String getText = textToSend.getText();
				try {
					serialPort.writeString(getText);
					textArea.append("\n" + getText);
				} catch (SerialPortException e1) {
					JOptionPane.showMessageDialog(MainWindow.this,
							e1,
							"Inane warning",
							JOptionPane.WARNING_MESSAGE);
				}
				textToSend.setText("");
			} 
		});

		start.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {

				try {
					serialPort.writeString("a");
					textArea.append("\n" + "a");
				} catch (SerialPortException e1) {
					JOptionPane.showMessageDialog(MainWindow.this,
							e1,
							"Inane warning",
							JOptionPane.WARNING_MESSAGE);
				}
				textToSend.setText("");
			} 
		});

		get.addActionListener(new ActionListener() { 

			public void actionPerformed(ActionEvent e) {
				//serialPort = new SerialPort("COM9");

				//String str1 = "85 1 2 5 1 9 170"; // 55 01 02 05 01 09 AA - send 85, 1, 1, 2, 2, 6, 170
				String str1 = "85 1 1 2 2 6 170";
				byte[] buffer = {85,1,2,5,1,9,(byte) 170};  //85 8 0 0 170
				//byte[] buffer = {82,1,1,2,2,6,(byte) 170};
				try {
					//serialPort.writeString("$$$");
					serialPort.writeBytes(buffer);
					//serialPort.writeByte((byte) 85);
					//serialPort.isOpened();

				}
				catch (SerialPortException ex) {
					JOptionPane.showMessageDialog(MainWindow.this,
							ex,
							"Inane warning",
							JOptionPane.WARNING_MESSAGE);
				}	
			}
		});
	}  // ****END CONSTRUCTOR******

	private JFreeChart createChart(final XYDataset dataset) {
		final JFreeChart result = ChartFactory.createTimeSeriesChart(
				"Dynamic Data Draw", 
				"Time", 
				"Value",
				dataset, 
				true, 
				true, 
				false
				);
		final XYPlot plot = result.getXYPlot();
		ValueAxis axis = plot.getDomainAxis();
		axis.setAutoRange(true);
		axis.setFixedAutoRange(60000.0);  // 60 seconds
		axis = plot.getRangeAxis();
		axis.setRange(-200.0, 200.0); 
		return result;
	}


	private static String dataToBin(byte data) {
		String bs = null;
		if(data >= 0) {
			bs = Integer.toBinaryString(data);
			while (bs.length() < 8) {
				bs = "0" + bs;
			}
		}  else {
			bs = Integer.toBinaryString(data);
			bs = bs.substring(24, 32);
		}

		//System.out.println(bs);
		//System.out.println(Integer.parseInt(bs,2));
		return bs;

	}




	/*public static void main(String[] args){
		MainWindow log = new MainWindow();
		RefineryUtilities.centerFrameOnScreen(log);
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
	}*/
	static int z = 0;


	public class EventListener implements SerialPortEventListener  {
		public void serialEvent(SerialPortEvent event) {
			if(event.isRXCHAR() && event.getEventValue() > 0){
				//if(event.isRXCHAR()){
				//while(!event.isRXCHAR());
				//textArea.append("\n***in listner***");
				try {
					String stringRead = serialPort.readString();
					// ***** this code for chart and recieve data ****************
					//byte [] data = serialPort.readBytes();
					z++;/*
					int count = 0;
					for(int i = 0; i < data.length; i++) {
						if (data[i] == 92)
							count++;
					}
					//System.out.print("\n" + Arrays.toString(data));
					int[] temp = new int[count];
					//System.out.println(count);
					//count = 0;
					int j = 0;
					for(int i = 0; i < data.length; i++) {
						if(data[i] == 92) {
							if(i+5>data.length) {

							}else {
								temp[j] = Integer.parseInt(dataToBin(data[i+1]) + dataToBin(data[i+2]) + dataToBin(data[i+3]),2);
								j++;
								i += 3;
							}


						}
					}*/

					/*for(int i = 0; i < data.length;i++) {						
						final Millisecond now = new Millisecond();
						//						System.out.println("Now = " + now.toString());
						while(now.equals(new Millisecond())) {}
						//series.add(new Millisecond(), temp[i]);
						series.add(new Millisecond(), data[i]);
						//System.out.println(i);
					}*/

					//int stringRead = event.getEventValue();
					//textArea.append("\n" + Arrays.toString(data));
					//System.out.print("\n" + Arrays.toString(data));
					System.out.print(stringRead.toString());
					//textArea.append("\n" + data);
					//						System.out.print(stringRead);
					//textArea.append("\n******" + z);
					System.out.println("\n*****" + z);


				}
				catch (SerialPortException ex) {
					JOptionPane.showMessageDialog(MainWindow.this,
							ex,
							"Inane warning",
							JOptionPane.WARNING_MESSAGE);
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

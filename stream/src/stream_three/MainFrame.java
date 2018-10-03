package stream_three;

import java.awt.BorderLayout;
import java.awt.Button;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.File;
import java.util.Arrays;

import javax.swing.BorderFactory;
import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JScrollPane;
import javax.swing.JSplitPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.border.Border;

public class MainFrame extends JFrame{

	

	static JTextArea textArea = new JTextArea("***Start working***");
	
	 private String filePath;

	
	public MainFrame () {
		super("CheckFiles");

		

		JComboBox<String> jComboBox = new JComboBox<String>();
		jComboBox.setMaximumSize(jComboBox.getPreferredSize());


		JTextField textToSend = new JTextField(10);
		textToSend.setMaximumSize(textToSend.getPreferredSize());
		textToSend.setText("0");
		
		JTextField maxValue = new JTextField(10);
		maxValue.setMaximumSize(maxValue.getPreferredSize());
		maxValue.setText("255");
		
		JLabel min = new JLabel("Минимальное значение : ");
		JLabel max = new JLabel("Максимальное значение : ");

		textArea.setSize(300, 300);

		JButton clear = new JButton("Очистка");
		JButton check = new JButton("Выполнить проверку");
		JButton fileOpen = new JButton("Открыть файл");
		
		JPanel main = new JPanel();
		JPanel top = new JPanel();
		JPanel center = new JPanel();		
		JPanel botom = new JPanel();
		JPanel east = new JPanel();
		JPanel west = new JPanel();			

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

		//west.add(textArea);
		//west.add(new JScrollPane(textArea));

		center.add(textArea);
		center.add(new JScrollPane(textArea));

		top.add(Box.createHorizontalStrut(10));
		top.add(Box.createVerticalGlue());
		top.add(fileOpen);
		top.add(Box.createHorizontalStrut(10));
		top.add(check);
		top.add(Box.createHorizontalStrut(10));
		top.add(clear);

		botom.add(Box.createHorizontalStrut(10));
		botom.add(Box.createVerticalGlue());
		botom.add(Box.createHorizontalStrut(10));
		botom.add(min);
		botom.add(textToSend);
		botom.add(Box.createHorizontalStrut(10));
		botom.add(max);
		botom.add(Box.createHorizontalStrut(10));
		botom.add(maxValue);

		this.add(main);
		this.setSize(500, 500);


		clear.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				textArea.setText(null);
			}
		});


		check.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				CheckData checkData = new CheckData(filePath);
				int minVal = Integer.parseInt(textToSend.getText());
				int maxVal = Integer.parseInt(maxValue.getText());				
				checkData.checkDataToError(minVal, maxVal);
				
				}
			
		});		

		fileOpen.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				JFileChooser fileopen = new JFileChooser();             
                int ret = fileopen.showDialog(null, "Открыть файл");                
                if (ret == JFileChooser.APPROVE_OPTION) {
                    File file = fileopen.getSelectedFile();
                    filePath = file.getAbsolutePath();
                    textArea.setText("\n" + file.getAbsolutePath());
                }
				
			}
		});
		
	}  // ****END CONSTRUCTOR******

	
	
}

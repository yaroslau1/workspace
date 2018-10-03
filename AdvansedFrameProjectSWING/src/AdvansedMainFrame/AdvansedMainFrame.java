package AdvansedMainFrame;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.InputEvent;
import java.awt.event.KeyEvent;

import javax.swing.AbstractAction;
import javax.swing.Action;
import javax.swing.ImageIcon;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.KeyStroke;

public class AdvansedMainFrame extends JFrame {
	private static final int WIDTH_FRAME = 500;
	private static final int HEIGHT_FRAME = 500;
	private JMenuItem addBallMenuItem;
	
	private BounceField field = new BounceField();
	
	@SuppressWarnings("serial")
	public AdvansedMainFrame() {
		super("Bounces");
		setSize(WIDTH_FRAME, HEIGHT_FRAME);
		
		JMenuBar jMenuBar = new JMenuBar();
		setJMenuBar(jMenuBar);
		
		JMenu menuBall = new JMenu("Balls");
		addBallMenuItem = new JMenuItem("Add Bounce");	
		addBallMenuItem.setIcon(new ImageIcon(getClass().getResource("addBounce.png")));
		addBallMenuItem.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_I, InputEvent.CTRL_MASK));
		
		addBallMenuItem.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                field.addBall();
            }
        });
		/*Action addBallAction = new AbstractAction("Добавить мяч") {
			public void actionPerformed(ActionEvent event) {
				field.addBall();
			}
		};
		addBallMenuItem=menuBall.add(addBallAction);*/
		
		
		menuBall.add(addBallMenuItem);
		
		jMenuBar.add(menuBall);
		getContentPane().add(field, BorderLayout.CENTER);

		
	}
	
	public static void main(String ...strings) {
		AdvansedMainFrame advansedMainFrame = new AdvansedMainFrame();
		advansedMainFrame.setDefaultCloseOperation(EXIT_ON_CLOSE);		
		advansedMainFrame.setLocationRelativeTo(null);
		advansedMainFrame.setVisible(true);
	}



}


package stream_three;

import java.awt.Image;
import java.awt.Toolkit;

import javax.swing.ImageIcon;
import javax.swing.JFrame;

import org.jfree.ui.RefineryUtilities;


public class MainStreamThree {

	public static void main(String[] args) {
			
		JFrame simpleFrame = new MainFrame();
		RefineryUtilities.centerFrameOnScreen(simpleFrame);
		simpleFrame.setVisible(true);
		simpleFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		

	}

}

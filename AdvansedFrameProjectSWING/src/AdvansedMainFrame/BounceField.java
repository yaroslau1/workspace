package AdvansedMainFrame;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JPanel;
import javax.swing.Timer;

@SuppressWarnings("serial")
public class BounceField extends JPanel{
	private ArrayList<BounceEntity> bounces = new ArrayList<>();
	
	public BounceField() {
		setBackground(Color.WHITE);
		timer.start();
	}
	
	private Timer timer = new Timer(10, new ActionListener() {
		
		@Override
		public void actionPerformed(ActionEvent e) {
			repaint();
		}
	});
	
	public void addBall() {
		bounces.add(new BounceEntity(this));
	}
	
	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		Graphics2D canvas = (Graphics2D) g;
		
		for(BounceEntity bounce: bounces) {
			bounce.paint(canvas);
		}
		
	}

}

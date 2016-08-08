package io.github.trinnorica;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionAdapter;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JPanel;
import javax.swing.Timer;

import io.github.trinnorica.utils.Backgrounds;
import io.github.trinnorica.utils.Board;
import io.github.trinnorica.utils.Clickable;
import io.github.trinnorica.utils.Utils;
import res.ExternalFile;

public class Screen extends JPanel implements ActionListener {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	Timer timer;
//	java.util.Timer t;
	int DELAY = 15;
	boolean debug = false;
	int board = 0;
	int totalFrameCount = 0;


	public Screen() {
		init();
	}

	public void init() {
		
		timer = new Timer(DELAY, this);
		timer.start();

		addKeyListener(new TAdapter());
		addMouseMotionListener(new MMListener());
		addMouseListener(new MListener());
		
		setLayout(null);

		setFocusable(true);

		setPreferredSize(new Dimension(1920, 1080));
		
		Main.setScreen(this);
		Main.setBoard(Board.MAIN);
		
	}

	@Override
	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		drawMenu(g);
		Toolkit.getDefaultToolkit().sync();
	}

	public void drawMenu(Graphics g) {
		
		if(board == Board.MAIN){
			g.drawImage(Backgrounds.MAIN.getImage(), 0, 0, this.getWidth(), this.getHeight(), this);
			Image logo  = ExternalFile.loadTexture("logos/logo-title.png");
			g.drawImage(logo, this.getWidth()/2 - logo.getWidth(this)/2, this.getHeight()/2 - logo.getHeight(this)/2, this);
		}
		
		for(Clickable c : Main.getClickables()){
			c.drawPolygon(g);
		}
		
		//Debug overlay
		if(debug){
			g.setFont(new Font(Font.DIALOG_INPUT, Font.BOLD, 20));
			Utils.drawOutlineString(g, "Version: " + Utils.getVersion(), 0, 20, Color.WHITE, Color.BLACK, 1);
		}
		
		
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		repaint();
	}

	private class TAdapter extends KeyAdapter {
		
		

		@Override
		public void keyReleased(KeyEvent event) {
			
		}

		@Override
		public void keyPressed(KeyEvent event) {
			int key = event.getKeyCode();
			if(key == KeyEvent.VK_F3){
				if(debug) debug = false;
				else debug = true;
			}
			
		}
	}

	private class MMListener extends MouseMotionAdapter {

		public void mouseMoved(MouseEvent e) {
			
		}
		public void mouseDragged(MouseEvent e) {
			
		}
	}

	private class MListener extends MouseAdapter {
		
		public void mouseClicked(MouseEvent e){
			
		}

		public void mousePressed(MouseEvent e) {
			
		}

		public void mouseReleased(MouseEvent e) {
			
		}
	}

}

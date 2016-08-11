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
import java.util.ConcurrentModificationException;
import java.util.TimerTask;

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
	int menuvar = 0;
	int creditvar = 0;


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
		java.util.Timer t = new java.util.Timer();
		t.schedule(new TimerTask(){ public void run(){ Main.setBoard(Board.MAIN);}}, 500);
		
	}

	@Override
	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		drawMenu(g);
		Toolkit.getDefaultToolkit().sync();
	}

	public void drawMenu(Graphics g) {
		
		g.setFont(new Font("Helvetica", Font.PLAIN, getWidth()/50));
		
		if(board == Board.MAIN){
			Utils.drawOutlineString(g, "Loading...", getWidth()/2 - g.getFontMetrics().stringWidth("Loading...")/2, getHeight()/2, Color.RED, Color.BLACK, 1);
			menuvar = Utils.drawScrollingImage(g, Backgrounds.MAIN.getImage(), menuvar, 0, this.getWidth(), this.getHeight(), 2);
//			g.drawImage(Backgrounds.MAIN.getImage(), 0, 0, this.getWidth(), this.getHeight(), this);
			Image logo  = ExternalFile.loadTexture("logos/logo-title.png");
			g.drawImage(logo, this.getWidth()/2 - logo.getWidth(this)/2, this.getHeight()/2 - logo.getHeight(this)/2, this);
			g.drawImage(ExternalFile.loadTexture("entity/player/bobbing.gif"), getWidth()/4, getHeight()/2, 60, 60, this);
		}
		if(board == Board.CREDITS){
			g.drawImage(Backgrounds.CREDITS.getImage(), 0, 0, getWidth(), getHeight(), this);
			Utils.drawCredit(g, "Author & Developers", creditvar, 1, Color.BLACK, Color.WHITE, 1);
			Utils.drawCredit(g, "", creditvar, 2, Color.BLACK, Color.WHITE, 1);
			Utils.drawCredit(g, "Cameron Witcher (Author)", creditvar, 3, Color.BLACK, Color.WHITE, 1);
			
			Image logo = ExternalFile.loadTexture("logos/logo-title.png");
			
			Utils.drawCreditImage(g, logo, creditvar, 5);
			
			
			creditvar-=1;
			
			
		}
		
		
		for(Clickable c : Main.getClickables()){
			c.drawPolygon(g);
		}
		
		//Debug overlay
		if(debug){
			g.setFont(new Font(Font.DIALOG_INPUT, Font.BOLD, 20));
			Utils.drawOutlineString(g, "Version: " + Utils.getVersion(), 0, 20, Color.WHITE, Color.BLACK, 1);
			Utils.drawOutlineString(g, "Clickables: " + Main.getClickables().size(), 0, 40, Color.WHITE, Color.BLACK, 1);
			
				
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
			if(key == KeyEvent.VK_R){
				Main.setBoard(Board.MAIN);
			}
			
		}
	}

	private class MMListener extends MouseMotionAdapter {

		public void mouseMoved(MouseEvent e) {
			for(Clickable c : Main.getClickables()){
				if(c.getPolygon().contains(e.getPoint()))
					c.mouseEntered(e);
				else c.mouseExited(e);
			}
			
		}
		public void mouseDragged(MouseEvent e) {
			
		}
	}

	private class MListener extends MouseAdapter {
		
		public void mouseClicked(MouseEvent e){
			
		}

		public void mousePressed(MouseEvent e) {
			try{
				for(Clickable c : Main.getClickables())
					if(c.getPolygon().contains(e.getPoint()))
						c.mousePressed(e);
			} catch(ConcurrentModificationException ex){
				return;
			}
			
			
		}

		public void mouseReleased(MouseEvent e) {
			for(Clickable c : Main.getClickables())
				if(c.getPolygon().contains(e.getPoint()))
						c.mouseReleased(e);
			
		}
	}

}

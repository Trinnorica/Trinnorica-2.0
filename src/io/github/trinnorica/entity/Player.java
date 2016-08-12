package io.github.trinnorica.entity;

import java.awt.event.KeyEvent;

import io.github.trinnorica.utils.Keyable;
import io.github.trinnorica.utils.Moveable;
import res.ExternalFile;

public class Player extends Entity implements Moveable,Keyable {
	
	double dx=0;
	double dy=0;
	boolean falling = false;

	public Player(int x, int y) {
		super(x, y);
		initPlayer();
		// TODO Auto-generated constructor stub
	}
	
	private void initPlayer() {
		loadImage(ExternalFile.loadTexture("entity/player/peasant.gif"));
		setImageDimensions(60, 60);
	}

	@Override
	public void move() {
		if(falling) 
			dy=1;
		if(y+height+30 >= 540){
			y=540-height-30;
			falling = false;
		} else {
			falling = true;
		}
		y = (int) (y+dy);
		x = (int) (x+dx);
		
		dx = 0;
		dy=0;
	}

	@Override
	public void keyPressed(KeyEvent e) {
		int key = e.getKeyCode();
		
		if(key == KeyEvent.VK_D){
			dx = 1;
		}
		if(key == KeyEvent.VK_A){
			dx = -1;
		}
	}

	@Override
	public void keyReleased(KeyEvent e) {
		int key = e.getKeyCode();
		
		if(key == KeyEvent.VK_D){
			dx = 0;
		}
		if(key == KeyEvent.VK_A){
			dx = 0;
		}
	}
	
	

	

}

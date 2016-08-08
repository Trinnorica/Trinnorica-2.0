package io.github.trinnorica;

import java.util.ArrayList;
import java.util.List;

import io.github.trinnorica.utils.Board;
import io.github.trinnorica.utils.Button;
import io.github.trinnorica.utils.Clickable;
import io.github.trinnorica.utils.Utils;

public class Main {
	
	private static List<Clickable> clickables = new ArrayList<>();
	private static Screen screen;
	
	
	public static void main(String[] args){
		Utils.start();
		new Window();
		
	}
	
	public static void setScreen(Screen screen){
		Main.screen = screen;
	}
	public static Screen getScreen(){
		return screen;
	}
	
	public static void setBoard(int board){
		if(board == Board.MAIN){
			clickables.add(new Button(screen.getWidth()/2, screen.getHeight()/2, 50, 10, "test", new Runnable(){
				
				@Override
				public void run(){
					System.out.println("test");
				}
			}));
		}
	}
	
	public static List<Clickable> getClickables(){
		return clickables;
		
	}

}

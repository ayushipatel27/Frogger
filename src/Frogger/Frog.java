package Frogger;

import java.awt.Image;
import java.awt.Rectangle;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.ImageIcon;

public class Frog implements KeyListener {
	/**
	 * Constructs a frog.
	 * 
	 * @param x of the frog position
	 * @param y of the frog position
	 */
	public Frog(int x, int y) {
		this.x = x;
		this.y = y;
		this.frog = new ImageIcon("frog.png").getImage();
		  HEIGHT = FroggerComponent.HEIGHT;
	}
	
	/**
	 * @return x position
	 */
	   public int getX() {
		   return x;
	   }
   /**
    * @return y position
    */
	   public int getY() {
		   return y;
	   }
  /**
   * @return a frog image	   
   */
	   public Image getFrog() {
		   return frog;
	   }

	   public void setJumps(int x){
		   jumps = x;
	   }
  /**
   * @return the number of time the frog jumps
   */
	public int jumps() {
		return jumps;
	}	

	/** 
	 * moves the frog according to which key was pressed
	 */
	public void move() {
		if(pause >= delay){
		if(up) { 
			//y += -93;
			y += -20;
			jumps++;
			pause = 0;
		}
		if(down) { 
			//y += 93;
			y += 20;
			jumps--;
			pause = 0;
		}
		if(right){ 
			x += 16;
			pause = 0;
		}
		if(left){
			x += -16;
			pause = 0;
		}
		if(y >= HEIGHT-55){
			y = HEIGHT-55;
			jumps = 0;
		}
		}
	}
	
	public void incPause(){
		pause++;
	}
	
	public void incDelay(){
		delay = delay + 1;
	}
	
	public void resetFrog(){
		y = 545;
		x = 550;
	}
	
	/**
	 * @return a rectangle made by the bounds of the frog image
	 */
	public Rectangle getBounds() {
		return new Rectangle(x+3, y+3, 53, 53);
	}
	
	/**
	 * keeps track of when the key is released
	 */
	public void keyReleased(KeyEvent e) {
		if (e.getKeyCode() == KeyEvent.VK_LEFT) {
			left = false;
		}
		if (e.getKeyCode() == KeyEvent.VK_RIGHT) {
			right = false;
		}
		if (e.getKeyCode() == KeyEvent.VK_UP) {
			up = false;
		}
		if (e.getKeyCode() == KeyEvent.VK_DOWN) {
			down = false;
		}
	}
	/**
	 * keeps track of when the key is pressed
	 */
	public void keyPressed(KeyEvent e) {
		if (e.getKeyCode() == KeyEvent.VK_LEFT) {
			left = true;
		}
		if (e.getKeyCode() == KeyEvent.VK_RIGHT) {
			right = true;
		}
		if (e.getKeyCode() == KeyEvent.VK_UP) {
			up = true;
		}
		if (e.getKeyCode() == KeyEvent.VK_DOWN) {
			down = true;
		}
	}

	public void resetPause() {
	 pause = -30;	
	}
	
	public void keyTyped(KeyEvent arg0) {

	}

	/**
	 * data variables
	 */
	private int jumps;
	private boolean up;
	private boolean down;
	private boolean left;
	private boolean right;
	private int x;
	private int y;
	private Image frog;
	private int pause = 20;
	private int delay = 2;
	private int HEIGHT;
	

}

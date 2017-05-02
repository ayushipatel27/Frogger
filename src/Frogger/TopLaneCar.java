package Frogger;
import java.awt.Image;
import java.awt.Rectangle;

import javax.swing.ImageIcon;

public class TopLaneCar{

	public TopLaneCar(int x, int y, String image, int speed){
		this.x = x;
	    this.y = y;
		this.car = new ImageIcon(image).getImage();
	    dx = -speed;
	    ScreenW = FroggerComponent.WIDTH;
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
	    * @return a car image	   
	    */
	   public Image getCar() {
		   return car;
	   }

	   /** 
		 * moves the car according to the speed(1/4 of the width of the car)
		 * if the position of the car goes off of the screen width then, reverse the car
		 */
	   public void drive() {
		   
		   x += dx;
		   
		   if(x < -165) x = ScreenW;
		
		 }  
	   
		/**
		 * @return a rectangle made by the bounds of the car image
		 */
	   public Rectangle getBounds() {
			return new Rectangle(x+10, y+10, 145, 65);
		}
	   
	   /**
	    * data variables
	    */
	   private int ScreenW;
	   private int dx;
	   private int x;
	   private int y;
	   private Image car;
	   }

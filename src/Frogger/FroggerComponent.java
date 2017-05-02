package Frogger;

import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.Timer;

@SuppressWarnings("serial")
public class FroggerComponent extends JPanel implements ActionListener{
	
	// data variables 
	public Frog frog;
	private Car car; private Car car2; private Car car3;
	private TopLaneCar car4; private TopLaneCar silvercar; private TopLaneCar policecar; private TopLaneCar bluecar;
    private Image background;	
    private String silver = "silvercar.png"; private String red = "redcar.png"; private String yellowcar = "yellowcar.png"; private String yellowcartop = "yellowcartop.png"; private String silvertop = "silvercartop.png"; private String policetop = "policecartop.png"; private String redtop = "redcartop.png";
    private int lives = 3; 
    private int level = 1;
	static int WIDTH;
	static int HEIGHT;
	private Timer timer;
	private int interval = 100;
	
	public FroggerComponent(int width, int height){
		WIDTH = width;
		HEIGHT = height;
		this.setPreferredSize(new Dimension(WIDTH, HEIGHT)); // makes Panel fit according to Frame size
		
		frog = new Frog(550, 545); // creates a new frog and places it on the Panel
		car = new Car(300, 360, red, 9); // creates a new car and places it on the Panel
		car2 = new Car(950, 360, silver, 9);
		car3 = new Car(300, 450, yellowcar, 6);
		silvercar = new TopLaneCar(1100, 70, silvertop, 5); // creates a new car and places it on the Panel 
		policecar = new TopLaneCar(1000, 165, policetop, 12); // creates a new car and places it on the Panel 
		bluecar = new TopLaneCar(650, 70, redtop, 5); // creates a new car and places it on the Panel 
		car4 = new TopLaneCar(200, 70, yellowcartop, 5); // creates a new car and places it on the Panel 
		this.addKeyListener(frog);
		this.requestFocus();
		background = new ImageIcon("background.jpg").getImage(); // get the backrgound image 
		//creates a timer object and starts it 
		timer = new Timer(interval, this);
		timer.start();
	}

	@Override
	public void paint(Graphics g){	
		g.drawImage(background, 0, 0, getWidth(), getHeight(), null); // draws the background 
		g.drawImage(car.getCar(), car.getX(), car.getY() , 160, 80, null); // draws the car 
		g.drawImage(car2.getCar(), car2.getX(), car2.getY() , 160, 80, null); // draws the car 
		g.drawImage(car3.getCar(), car3.getX(), car3.getY() , 160, 80, null); // draws the car
		g.drawImage(silvercar.getCar(), silvercar.getX(), silvercar.getY() , 160, 80, null); // draws the police car
		g.drawImage(policecar.getCar(), policecar.getX(), policecar.getY() , 160, 80, null); // draws the police car
		g.drawImage(bluecar.getCar(), bluecar.getX(), bluecar.getY() , 160, 80, null); // draws the police car
		g.drawImage(car4.getCar(), car4.getX(), car4.getY() , 160, 80, null); // draws the police car
		g.drawImage(frog.getFrog(), frog.getX(), frog.getY(), 60, 60, null); // draws the frog
		g.drawString("Lives: " + lives, 25, 25);
		g.drawString("Level: " + level, 1135, 25);
		frog.incPause();
	}
	
	 public void actionPerformed(ActionEvent e) {
		    // Move Things
		 	won();
		 	lost();
	        car.drive();
	        car2.drive();
	        car3.drive();
	        silvercar.drive();
	        policecar.drive();
	        bluecar.drive();
	        car4.drive();
	        frog.move();
	        // Draw Things
	        repaint();
	 }   
	 
	 public int getLives(){
		 return lives;
	 }
	 
	 public void lost() {
		if(car.getBounds().intersects(frog.getBounds())){
			lives--; frog.resetFrog(); frog.resetPause();}
		if(silvercar.getBounds().intersects(frog.getBounds())){
			lives--; frog.resetFrog(); frog.resetPause();}
		if(policecar.getBounds().intersects(frog.getBounds())){
			lives--; frog.resetFrog(); frog.resetPause();}
		if(bluecar.getBounds().intersects(frog.getBounds())){
			lives--; frog.resetFrog(); frog.resetPause();}
		if(car2.getBounds().intersects(frog.getBounds())){
			lives--; frog.resetFrog(); frog.resetPause();}
		if(car3.getBounds().intersects(frog.getBounds())){
			lives--; frog.resetFrog(); frog.resetPause();}
		if(car4.getBounds().intersects(frog.getBounds())){
			lives--; frog.resetFrog(); frog.resetPause();}
		
		if(lives == 0){
			 JOptionPane.showMessageDialog(null,"Sorry, you lost. The game is over.");
			 System.exit(0);
		}
	 }
	public void won() {	
		if(frog.jumps() == 27) {
			level++;
			if(interval > 5){interval = interval - 1;}
			timer = new Timer(interval, this);
			timer.start();
			frog.setJumps(0);
			frog.resetFrog();
			frog.incDelay();
			frog.resetPause();
		 }
	}
		
 }
	

	 
	  



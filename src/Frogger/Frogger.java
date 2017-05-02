package Frogger;
import javax.swing.JFrame;

public class Frogger {

	public static void main(String[] args) {
		JFrame frame = new JFrame();

		FroggerComponent froggerApp = new FroggerComponent(1200, 600);

		frame.setTitle("Frogger");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.add(froggerApp);
		frame.addKeyListener(froggerApp.frog);
		frame.setVisible(true);
		frame.pack();
		
		
	
	}


}

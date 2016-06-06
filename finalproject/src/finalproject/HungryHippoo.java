package finalproject;

import javax.swing.JFrame;
import java.awt.Component;

public class HungryHippoo extends JFrame{
	
	private static final int WIDTH = 800;
	private static final int HEIGHT = 600;

	public HungryHippoo()
	{
		super("Hungry Hippo");
		setSize(WIDTH,HEIGHT);

		Wild theGame = new Wild();
		((Component)theGame).setFocusable(true);

		getContentPane().add(theGame);

		setVisible(true);
	}

	public static void main(String args[])
	{
		HungryHippoo run = new HungryHippoo(); 
	}
}

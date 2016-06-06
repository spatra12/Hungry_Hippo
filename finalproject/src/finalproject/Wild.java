package finalproject;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Canvas;
import java.awt.event.ActionEvent;
import java.awt.event.KeyListener;
import java.awt.event.KeyEvent;
import static java.lang.Character.*;
import java.awt.image.BufferedImage;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class Wild extends Canvas implements KeyListener, Runnable
{
	private Hippo hippo;
	private Melon melon; 

	
	private ArrayList<Melon> melons = new ArrayList<Melon>();

	private boolean[] keys;
	private BufferedImage back;

	public Wild()
	{
		setBackground(Color.black);

		keys = new boolean[5];

		//instantiate other stuff
		hippo = new Hippo(300, 300); 
		hippo.setSpeed(15);
		
		melon = new Melon(100, 100); 
		melon.setSpeed(1);
		
		
		for(int i= 0; i< 10; i++ )
		{
			int xpos = (int)Math.random()*800;
			int ypos = (int)Math.random()*600;
			melons.add(new Melon(xpos, ypos));
			melons.get(i).setSpeed(i+1);
			
		}
		

		this.addKeyListener(this);
		new Thread(this).start();

		setVisible(true);
	}

   public void update(Graphics window)
   {
	   if(melon != null)
	   {		   
		   
		   melon.move("DOWN");
	   }
	   
	  
	   paint(window);
   }

	public void paint( Graphics window )
	{
		//set up the double buffering to make the game animation nice and smooth
		Graphics2D twoDGraph = (Graphics2D)window;

		//take a snap shop of the current screen and same it as an image
		//that is the exact same width and height as the current screen
		if(back==null)
		   back = (BufferedImage)(createImage(getWidth(),getHeight()));

		//create a graphics reference to the back ground image
		//we will draw all changes on the background image
		Graphics graphToBack = back.createGraphics();

		graphToBack.setColor(Color.BLACK);
		graphToBack.fillRect(0,0,800,600);
		
		graphToBack.setColor(Color.BLUE);
		graphToBack.drawString("Hungry Hippo", 25, 50 );
		graphToBack.drawString("Harry the hippo is hangry. Try to catch as many watermelons"
				+ " by using the arrows to make Harry happy.", 25, 65);
		
		
		//draw hippo
		hippo.draw(graphToBack);
		
		//draw melon
		melon.draw(graphToBack);
			
		

		if(keys[0] == true)
		{
			if(hippo.getX() > -20)
			hippo.move("LEFT");
		}

		//add code to move stuff
		if(keys[1] == true)
		{
			if(hippo.getX() < getWidth()-60)
				hippo.move("RIGHT");
		}
		
		if(keys[2] == true)
		{
			if(hippo.getY() > 60)
				hippo.move("UP");
		}

		if(keys[3] == true)
		{
			if(hippo.getY() < 400)
				hippo.move("DOWN");
		}
		
		int counter = 0; 
		//add in collision detection

			if ((Math.abs(melon.getX()-hippo.getX())<20 && 
					Math.abs(melon.getY()-hippo.getY())<20  ))
			{
				//melon = melons.get((int)Math.random()*10);
				
				melon = null;
				
				counter++; 
			}
		
		graphToBack.drawString(counter +" watermelons fed", 600, 100);

		twoDGraph.drawImage(back, null, 0, 0);
	}


	public void keyPressed(KeyEvent e)
	{
		if (e.getKeyCode() == KeyEvent.VK_LEFT)
		{
			keys[0] = true;
		}
		if (e.getKeyCode() == KeyEvent.VK_RIGHT)
		{
			keys[1] = true;
		}
		if (e.getKeyCode() == KeyEvent.VK_UP)
		{
			keys[2] = true;
		}
		if (e.getKeyCode() == KeyEvent.VK_DOWN)
		{
			keys[3] = true;
		}
		if (e.getKeyCode() == KeyEvent.VK_SPACE)
		{
			keys[4] = true;
		}
		repaint();
	}

	public void keyReleased(KeyEvent e)
	{
		if (e.getKeyCode() == KeyEvent.VK_LEFT)
		{
			keys[0] = false;
		}
		if (e.getKeyCode() == KeyEvent.VK_RIGHT)
		{
			keys[1] = false;
		}
		if (e.getKeyCode() == KeyEvent.VK_UP)
		{
			keys[2] = false;
		}
		if (e.getKeyCode() == KeyEvent.VK_DOWN)
		{
			keys[3] = false;
		}
		if (e.getKeyCode() == KeyEvent.VK_SPACE)
		{
			keys[4] = false;
		}
		repaint();
	}

	public void keyTyped(KeyEvent e)
	{
		if (e.getKeyCode() == KeyEvent.VK_LEFT)
		{
			keys[0] = false;
		}
		if (e.getKeyCode() == KeyEvent.VK_RIGHT)
		{
			keys[1] = false;
		}
		if (e.getKeyCode() == KeyEvent.VK_UP)
		{
			keys[2] = false;
		}
		if (e.getKeyCode() == KeyEvent.VK_DOWN)
		{
			keys[3] = false;
		}
		if (e.getKeyCode() == KeyEvent.VK_SPACE)
		{
			keys[4] = false;
		}
		repaint();
	}

   public void run()
   {
   	try
   	{
   		while(true)
   		{
   		   Thread.currentThread().sleep(5);
            repaint();
         }
      }catch(Exception e)
      {
    	  System.out.println("Error! run not working");
      }
  	}
}


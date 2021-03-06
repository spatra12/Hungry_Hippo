package finalproject;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Image;
import java.io.File;
import javax.imageio.ImageIO;

public class Hippo extends MovingThing
{
	private int speed;
	private Image image;

	public Hippo()
	{
		this(0,0,0);
	}

	public Hippo(int x, int y)
	{
		this(x,y,0);
	}

	public Hippo(int x, int y, int s)
	{
		super(x, y);
		speed=s;
		try
		{
			image = ImageIO.read(new File("src/finalproject/Hippo_mouth_opening.jpg"));
		}
		catch(Exception e)
		{
			//feel free to do something here
			System.out.println("Error! Not downloading"); 
		}
	}


	public void setSpeed(int s)
	{
	   //add more code
		speed = s; 
	}

	public int getSpeed()
	{
	   return speed;
	}

	public void draw( Graphics window )
	{
   	window.drawImage(image,getX(),getY(),80,80,null);
	}

	public String toString()
	{
		return super.toString() + getSpeed();
	}
}


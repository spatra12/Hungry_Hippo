package finalproject;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Image;
import java.io.File;
import javax.imageio.ImageIO;

public class Melon extends MovingThing
{
	private int speed;

	public Melon()
	{
		this(0,0,0);
	}

	public Melon(int x, int y)
	{
		//add code
		this(x,y,0);
	}

	public Melon(int x, int y, int s)
	{
		//add code
		super(x,y);
		setSpeed(s);
	}

	public void setSpeed(int s)
	{
	   //add code
		speed = s; 
	}

	public int getSpeed()
	{
	   return speed;
	}

	public void draw( Graphics window )
	{
		//add code to draw the ammo
		window.setColor(Color.GREEN); 
		
		window.drawOval(super.getX(), super.getY(), 30, 30);
		window.fillOval(super.getX(), super.getY(), 30, 30);
	}

	public String toString()
	{
		return "";
	}
}


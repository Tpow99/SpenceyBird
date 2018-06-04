package ui;

import java.awt.Color;
import java.awt.Graphics;

public class UIRectangle extends UIObject
{
	private Color color;

	public UIRectangle(int x,int y, int width, int height, Color color)
	{
		super(x,y,width,height);
		this.color = color;
	}
	
	public void tick() {}

	public void render(Graphics g) {
		g.setColor(color);
		g.fillRect((int)x,(int) y, width, height);
	}

	@Override
	public void onClick()
	{
		// TODO Auto-generated method stub
		
	}

}

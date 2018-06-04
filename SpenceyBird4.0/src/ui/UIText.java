package ui;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;

public class UIText extends UIObject
{

	private Color color;
	private String text;
	private int textSize;

	public UIText(float x, float y, int textSize, Color color, String text)
	{
		super(x, y, textSize, textSize);
		this.textSize = textSize;
		this.color = color;
		this.text = text;
	}

	@Override
	public void tick()
	{
		// TODO Auto-generated method stub
		
	}

	@Override
	public void render(Graphics g)
	{
	g.setColor(color);
	g.setFont(new Font("Times New Roman",(int) textSize, textSize));
	g.drawString(text, (int)x,(int) y);
		
	}

	@Override
	public void onClick()
	{
		// TODO Auto-generated method stub
		
	}

}

package states;

import java.awt.Color;
import java.awt.Graphics;

import game.Handler;
import ui.UIManager;
import ui.UIRectangle;
import ui.UIText;

public class HelpState extends State
{
	private UIManager uiManager;

	public HelpState(Handler handler)
	{
		super(handler);
		uiManager = new UIManager(handler);
	}

	@Override
	public void tick()
	{
		uiManager.tick();	
	}

	@Override
	public void render(Graphics g)
	{
		uiManager.addObject(new UIRectangle(0,0,800,800,new Color(0,2,85)));
		uiManager.addObject(new UIText(230,50,40,Color.white,"Instructions"));
		uiManager.addObject(new UIText(70,80,20,Color.white,"In this game your objcetive is to explore the cities of the west."));
		uiManager.addObject(new UIText(40,100,20,Color.white,"In each city you will find gold nuggets that you can break to earn points."));
		uiManager.addObject(new UIText(50,120,20,Color.white,"When you accumulate 1000 points the next city will become available."));
		uiManager.addObject(new UIText(110,140,20,Color.white,"But you can always stick around for some bonus points!"));
		uiManager.addObject(new UIText(230,190,40,Color.white,"Controls"));
		uiManager.addObject(new UIText(230, 220,20,Color.white,"W - Up"));
		uiManager.addObject(new UIText(230, 240,20,Color.white,"A - Left"));
		uiManager.addObject(new UIText(230, 260,20,Color.white,"S - Down"));
		uiManager.addObject(new UIText(230, 280,20,Color.white,"D - Right"));
		uiManager.addObject(new UIText(230, 300,20,Color.white, "Space - Mine/Attack"));
		
		
		
		
		uiManager.render(g);
		
		
		
	}

}

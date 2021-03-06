package states;

import java.awt.Color;
import java.awt.Graphics;

import game.Handler;
import ui.UIManager;
import ui.UIObject;
import ui.UIRectangle;
import ui.UIText;
import worlds.World;

public class GameState extends State {
	
	private World world;
	
	
	
	private UIManager uiManager;
	
	public GameState(Handler handler){
		super(handler);
		uiManager = new UIManager(handler);
		world = new World(handler, "res/worlds/world1.txt");
		handler.setWorld(world);
		
		
	}
	
	
	
	@Override
	public void tick() {
		world.tick();
		uiManager.tick();
		
	}

	@Override
	public void render(Graphics g) {
		world.render(g);
		UIObject obj1 = checkScoreChange();
		uiManager.addObject(obj1);
		uiManager.render(g);
		uiManager.removeObject(obj1);
	}
	
	public UIObject checkScoreChange()
	{
		UIObject obj1;
		int startScore = handler.getWorld().getScore();
		
		uiManager.addObject(new UIRectangle(5,3,120,20,new Color(0,3,85)));
		
		if(handler.getWorld().getScore() == startScore)
		{
			obj1 = new UIText(10, 20, 20, Color.white,"Score: " + Integer.toString(handler.getWorld().getScore()));
		}
		else
		{
			obj1 =  new UIText(10, 20, 20, Color.white,"Score: " + Integer.toString(handler.getWorld().getScore()));
			startScore = handler.getWorld().getScore();
		}
		return obj1;
	}
	
	

}

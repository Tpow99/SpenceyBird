package staticEntity;

import java.awt.Graphics;

import game.Handler;
import gfx.Assets;
import tiles.Tile;

public class Door extends StaticEntity

{

	public Door(Handler handler, float x, float y)
	{
		super(handler, x, y, Tile.TILEWIDTH, Tile.TILEHEIGHT);
		
		this.setHealth(10);
		
	}
	
	
	public void tick()
	{
		
	}
	
	public void render(Graphics g)
	{
		g.drawImage(Assets.door,(int) (x - handler.getGameCamera().getxOffset()), (int) (y- handler.getGameCamera().getyOffset()), width, height, null);
	}


	@Override
	public void die() {
			active = false;
		
	}
	

}

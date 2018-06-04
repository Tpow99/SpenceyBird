package staticEntity;

import java.awt.Color;
import java.awt.Graphics;

import game.Handler;
import gfx.Assets;
import tiles.Tile;

public class GoldNugget extends StaticEntity
{
	
	public GoldNugget(Handler handler, float x, float y)
	{
		super(handler, x, y, Tile.TILEWIDTH, Tile.TILEHEIGHT);
		
		this.setHealth(2);
		
		bounds.x = 8;
		bounds.y = (int) (0);
		bounds.width =(int) (width / 4f);
		bounds.height = (int) (height/2f );
	}
	
	
	public void tick()
	{
		
	}
	
	public void render(Graphics g)
	{
		g.drawImage(Assets.goldNugg,(int) (x - handler.getGameCamera().getxOffset()), (int) (y- handler.getGameCamera().getyOffset()), width /2, height / 2, null);
	}


	@Override
	public void die() 
	{
		handler.getWorld().addScore(200);
	}
}

package staticEntity;

import java.awt.Graphics;

import game.Handler;
import gfx.Assets;
import tiles.Tile;

public class building3 extends StaticEntity
{

	public building3(Handler handler, float x, float y)
	{
		super(handler, x, y, Tile.TILEWIDTH, Tile.TILEHEIGHT);
		
		this.setHealth(1000000000);
		bounds.x = 10;
		bounds.y = (int) (height / 1.5f);
		bounds.width =(int) (width * 1.75f);
		bounds.height = (int) (height );
	}
	
	
	public void tick()
	{
		
	}
	
	public void render(Graphics g)
	{
		g.drawImage(Assets.building3,(int) (x - handler.getGameCamera().getxOffset()), (int) (y- handler.getGameCamera().getyOffset()), width * 2, height * 2, null);
	}


	@Override
	public void die() {
		// TODO Auto-generated method stub
		
	}

}

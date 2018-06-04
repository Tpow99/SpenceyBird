package staticEntity;

import java.awt.Graphics;
import java.awt.image.BufferedImage;

import game.Handler;
import gfx.Animation;
import gfx.Assets;
import tiles.Tile;

public class River extends StaticEntity
{
	private Animation riverFlow;
	
	
	public River(Handler handler, float x, float y)
	{
		super(handler, x, y, Tile.TILEWIDTH, Tile.TILEHEIGHT );
	
		this.setHealth(1000000000);
		riverFlow = new Animation(200, Assets.runningWater);
	}

	@Override
	public void tick()
	{
		riverFlow.tick();
		
	}
	
	private BufferedImage getCurrentAnimationFrame()
	{
		return riverFlow.getCurrentFrame();
		
	}

	@Override
	public void render(Graphics g)
	{
			g.drawImage(getCurrentAnimationFrame(), (int) (x - handler.getGameCamera().getxOffset()), (int)(y - handler.getGameCamera().getyOffset()), width, height, null);
		
	}

	@Override
	public void die() {
		// TODO Auto-generated method stub
		
	}
}

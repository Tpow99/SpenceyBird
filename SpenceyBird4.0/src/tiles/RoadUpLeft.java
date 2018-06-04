package tiles;

import java.awt.image.BufferedImage;

import gfx.Assets;

public class RoadUpLeft extends Tile {

	public RoadUpLeft(int id)
	{
		super(Assets.roadUpLeft, id);
	}
	
	@Override

	public boolean isSolid(){

		return false;

	}

}

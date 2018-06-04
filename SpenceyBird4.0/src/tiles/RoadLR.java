package tiles;

import gfx.Assets;

public class RoadLR extends Tile
{

	public RoadLR(int id) {

		super(Assets.roadSide,id);

	}

	

	@Override

	public boolean isSolid(){

		return false;

	}
}

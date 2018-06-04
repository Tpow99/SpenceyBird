package tiles;

import gfx.Assets;

public class RoadUD extends Tile
{
	public RoadUD(int id) {

		super(Assets.roadUp,id);

	}

	

	@Override

	public boolean isSolid(){

		return false;

	}
}

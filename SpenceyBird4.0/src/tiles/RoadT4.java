package tiles;

import gfx.Assets;

public class RoadT4 extends Tile
{

	public RoadT4(int id) {

		super(Assets.roadTurn4,id);

	}

	

	@Override

	public boolean isSolid(){

		return false;

	}
}

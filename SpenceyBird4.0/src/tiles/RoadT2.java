package tiles;

import gfx.Assets;

public class RoadT2 extends Tile
{

	public RoadT2(int id) {

		super(Assets.roadTurn2,id);

	}

	

	@Override

	public boolean isSolid(){

		return false;

	}
}

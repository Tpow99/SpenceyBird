package tiles;

import gfx.Assets;

public class RoadT3 extends Tile
{

	public RoadT3(int id) {

		super(Assets.roadTurn3,id);

	}

	

	@Override

	public boolean isSolid(){

		return false;

	}
}

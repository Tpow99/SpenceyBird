package tiles;

import gfx.Assets;

public class RoadT1 extends Tile
{

	public RoadT1(int id) {

		super(Assets.roadTurn1,id);

	}

	

	@Override

	public boolean isSolid(){

		return false;

	}
}

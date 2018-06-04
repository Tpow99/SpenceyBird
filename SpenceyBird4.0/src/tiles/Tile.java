package tiles;

import java.awt.Graphics;

import java.awt.image.BufferedImage;



public class Tile {

	

	//STATIC STUFF HERE

	

	public static Tile[] tiles = new Tile[256];

	public static Tile grassTile = new GrassTile(0);

	public static Tile dirtTile = new DirtTile(1);

	public static Tile rockTile = new RockTile(2);
	
	public static Tile bridgeTile = new BridgeTile(3);
	
	//river	
	public static Tile rivTileLeft = new RiverBankLeft(4);
	public static Tile rivTileRight = new RivBankR(5);
		
	//road pieces
	public static Tile roadHor = new RoadLR(6);
	public static Tile roadVert = new RoadUD(7);
	public static Tile roadTurn1 = new RoadT1(8);
	public static Tile roadTurn2 = new RoadT2(9);
	public static Tile roadTurn3 = new RoadT3(10);
	public static Tile roadTurn4 = new RoadT4(11);
	public static Tile roadUpLeft = new RoadUpLeft(12);
	
	//door pieces

	

	

	//CLASS

	

	public static final int TILEWIDTH = 64, TILEHEIGHT = 64;

	

	protected BufferedImage texture;

	protected final int id;

	

	public Tile(BufferedImage texture, int id){

		this.texture = texture;

		this.id = id;

		

		tiles[id] = this;

	}

	

	public void tick(){

		

	}

	

	public void render(Graphics g, int x, int y){

		g.drawImage(texture, x, y, TILEWIDTH, TILEHEIGHT, null);

	}

	

	public boolean isSolid(){

		return false;

	}

	

	public int getId(){

		return id;

	}

	

}
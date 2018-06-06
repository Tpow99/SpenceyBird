package worlds;

import java.awt.Graphics;
import java.util.ArrayList;

import creatures.Player;
import entities.Entity;
import entities.EntityManager;
import game.Handler;
import states.State;
import staticEntity.Door;
import staticEntity.GoldNugget;
import staticEntity.River;
import staticEntity.Saloon;
import staticEntity.Saloon2;
import staticEntity.Tree;
import staticEntity.bank;
import staticEntity.building;
import staticEntity.building2;
import staticEntity.building3;
import tiles.Tile;
import utils.Utils;

public class World {

	private Handler handler;
	private int width, height;
	private int spawnX, spawnY;
	private int[][] tiles;
	//Entities
	private EntityManager entityManager;
	public int score = 0;
	
	

	

	public World(Handler handler, String path){
		this.handler = handler;
		entityManager = new EntityManager(handler, new Player(handler, 100, 100));
		
		//removable entities
		
		if(handler.level ==0)
		{
		//add entities before loadWorld
		entityManager.addEntity(new Tree(handler,32 * 28,32 * 23));
		entityManager.addEntity(new Tree(handler,150,100));
		entityManager.addEntity(new Tree(handler,100,140));
		entityManager.addEntity(new Tree(handler,650,50));
		entityManager.addEntity(new Tree(handler,670,100));
		entityManager.addEntity(new Tree(handler,710,50));
		entityManager.addEntity(new Tree(handler,730,73));
		entityManager.addEntity(new Tree(handler,760,100));
		entityManager.addEntity(new Tree(handler, 760, 30));
		
		
		
		entityManager.addEntity(new GoldNugget(handler, 600,100));
		entityManager.addEntity(new GoldNugget(handler, 800,800));
		entityManager.addEntity(new GoldNugget(handler, 1000,1000));
		entityManager.addEntity(new GoldNugget(handler, 980,1150));
		entityManager.addEntity(new GoldNugget(handler, 220,890));
		entityManager.addEntity(new GoldNugget(handler, 180,890));
		entityManager.addEntity(new GoldNugget(handler, 200,890));
		
		
		for(int i = (27 *32) + 45 ; i < 34 *32 ; i += 90)
		{
			for(int w = (28* 32); w <= 38 *32; w += 70)
			{
			entityManager.addEntity(new Tree(handler,w,i));
			}
		}
		
		for(int i = 16 *32 ; i < 20 *32 ; i += 90)
		{
			for(int w = 28 * 32; w <= 38 *32; w += 70)
			{
			entityManager.addEntity(new Tree(handler,w,i));
			}
		}
		
		for(int i = 22 *32 ; i < 26 * 32 ; i += 90)
		{
			for(int w = 28* 32; w <= 38 *32; w += 70)
			{
			entityManager.addEntity(new Tree(handler,w,i));
			}
		}
		
		
		//river
		for(int i = 1; i < 19 ; i ++)
		{
			if(i !=7 ) 
			{
			int x = 64 * i;
			entityManager.addEntity(new River(handler, 32*26, x));
			}
			
		}
		
		
		
		entityManager.addEntity(new Saloon(handler, 1000, 70));
		
		//left side saloon forest
		entityManager.addEntity(new Tree(handler, 940,70));
		entityManager.addEntity(new Tree(handler, 920,40));
		entityManager.addEntity(new Tree(handler, 910,75));
		entityManager.addEntity(new Tree(handler, 920,40));
		entityManager.addEntity(new Tree(handler, 940,35));
		
		//right side saloon forest
		entityManager.addEntity(new Tree(handler, 1160,70));
		entityManager.addEntity(new Tree(handler, 1140,40));
		entityManager.addEntity(new Tree(handler, 1130,75));
		entityManager.addEntity(new Tree(handler, 1140,40));
		entityManager.addEntity(new Tree(handler, 1160,35));
		
		//city

		entityManager.addEntity(new bank(handler, 150,770));
		entityManager.addEntity(new building(handler, 350,770));
		entityManager.addEntity(new building2(handler, 550,770));
		entityManager.addEntity(new Saloon2(handler, 550,970));
		entityManager.addEntity(new  building3(handler, 350,970));
		entityManager.addEntity(new  building2(handler, 150,970));
		
		}		
		
		loadWorld(path);
		
		entityManager.getPlayer().setX(spawnX);
		entityManager.getPlayer().setY(spawnY);
		
	}
	
	public void tick(){
		entityManager.tick();
		
		if(handler.level == 1)
		{
			clearEntities(entityManager);
		}
	}
	
	public void render(Graphics g){
		int xStart = (int) Math.max(0, handler.getGameCamera().getxOffset() / Tile.TILEWIDTH);
		int xEnd = (int) Math.min(width, (handler.getGameCamera().getxOffset() + handler.getWidth()) / Tile.TILEWIDTH + 1);
		int yStart = (int) Math.max(0, handler.getGameCamera().getyOffset() / Tile.TILEHEIGHT);
		int yEnd = (int) Math.min(height, (handler.getGameCamera().getyOffset() + handler.getHeight()) / Tile.TILEHEIGHT + 1);
		
		for(int y = yStart;y < yEnd;y++){
			for(int x = xStart;x < xEnd;x++){
				getTile(x, y).render(g, (int) (x * Tile.TILEWIDTH - handler.getGameCamera().getxOffset()),
						(int) (y * Tile.TILEHEIGHT - handler.getGameCamera().getyOffset()));
				
				
				
				
			}
		}
		
		
		//new level
		entityManager.getPlayer().exitScreen();
		
		//door open
		Entity door = exitDoor(handler, 960,1216);
		entityManager.addEntity(door);
		door.active = false;
		
		//Entities
		entityManager.render(g);
	}
	
	public Tile getTile(int x, int y){
		if(x < 0 || y < 0 || x >= width || y >= height)
			return Tile.grassTile;
		
		Tile t = Tile.tiles[tiles[x][y]];
		if(t == null)
			return Tile.dirtTile;
		return t;
	}
	
	private void loadWorld(String path){
		String file = Utils.loadFileAsString(path);
		String[] tokens = file.split("\\s+");
		width = Utils.parseInt(tokens[0]);
		height = Utils.parseInt(tokens[1]);
		spawnX = Utils.parseInt(tokens[2]);
		spawnY = Utils.parseInt(tokens[3]);
		
		tiles = new int[width][height];
		for(int y = 0;y < height;y++){
			for(int x = 0;x < width;x++){
				tiles[x][y] = Utils.parseInt(tokens[(x + y * width) + 4]);
			}
		}
	}
	
	public int getWidth(){
		return width;
	}
	
	public int getHeight(){
		return height;
	}

	public EntityManager getEntityManager() {
		return entityManager;
	}
	
	public int getScore()
	{
		return score;
	}
	
	public void addScore(int s)
	{
		this.score += s;
	}
	
	public void checkExit(Door door)
	{
		if(this.getScore() >= 1000)
		{
			 door.setHealth(door.getHealth() - door.getHealth());
		}
		else
		{
			 door.setHealth(door.getHealth());
		}
	}
	
	
	public boolean checkExit()
	{
		if(this.getScore()>=1000)
		{
			return true;
		}
		else
		{
			return false;
		}
	}
	
	
	//entityManager.addEntity(new Door(handler,960,1216));
	Entity door = new Door(handler, 960, 1216);
			
	public Entity exitDoor(Handler handler, float x, float y)
	{
		if(checkExit())
		{
			Entity door = new Door(handler, 0, 0);
			return door;
		}
		else
		{
			Entity door = new Door(handler, x, y);
			return door;
		}
	}
	
	public ArrayList<Entity> clearEntities(EntityManager entityManager)
	{
		ArrayList<Entity> a = entityManager.getEntities();
		
		for(Entity e: a)
		{
			e.active = false;
		}
		
		return a;
	
		
	}
	
	
	
}









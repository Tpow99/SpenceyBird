package gfx;

import java.awt.image.BufferedImage;



public class Assets {

	

	private static final int width = 32, height = 32;

	

	public static BufferedImage  dirt, grass, stone, tree, standingWater, bridge, rivBankL, rivBankR, saloon, 
	saloon2, bank, building, building2, building3, roadSide, roadUp, roadTurn1, roadTurn2, roadTurn3, roadTurn4, 
	goldNugg,roadUpLeft, door, doorUp;
	
	public static BufferedImage[] btn_help,playerLeft, playerRight, PlayerDown, playerUp, player_down, player_up, player_right,player_left, player, runningWater, btn_start, att_up, att_down, att_left, att_right;

	public static void init(){

		SpriteSheet sheet = new SpriteSheet(ImageLoader.loadImage("/textures/spriteSheet.png"));
		SpriteSheet charMainSheet = new SpriteSheet(ImageLoader.loadImage("/textures/characterSheet.png"));
		SpriteSheet saloonS = new SpriteSheet(ImageLoader.loadImage("/textures/saloon.png"));
		SpriteSheet buildings = new SpriteSheet(ImageLoader.loadImage("/textures/buildings.png"));
		SpriteSheet attack = new SpriteSheet(ImageLoader.loadImage("/textures/attackSheet.png"));

		btn_start = new BufferedImage[2];
		btn_start[0] = sheet.crop(width, height * 2, width, height/2);
		btn_start[1] = sheet.crop(width, height * 2 + height/2, width, height/2);
		
		btn_help = new BufferedImage[2];
		btn_help[0] = sheet.crop(width * 3, height * 4, width, height/2);
		btn_help[1] = sheet.crop(width * 3, height * 4 + height/2, width, height/2);

		player_down = new BufferedImage[3];
		player_down[0] = charMainSheet.crop(0, 0, width, height);
		player_down[1] = charMainSheet.crop(width, 0, width, height);
		player_down[2] = charMainSheet.crop(width *2 , 0, width, height);
		
		player_up = new BufferedImage[3];
		player_up[0] = charMainSheet.crop(width, height * 2, width, height);
		player_up[1] = charMainSheet.crop(width * 2, height * 2, width, height);
		player_up[2] = charMainSheet.crop(width *3 , height * 2, width, height);
		
		player_right = new BufferedImage[3];
		player_right[0] = charMainSheet.crop(width * 2, height, width, height);
		player_right[1] = charMainSheet.crop(width * 3, height, width, height);
		player_right[2] = charMainSheet.crop(0 , height * 2, width, height);
		
		player_left = new BufferedImage[3];
		player_left[0] = charMainSheet.crop(width * 3, 0, width, height);
		player_left[1] = charMainSheet.crop(0, height, width, height);
		player_left[2] = charMainSheet.crop(width , height, width, height);
		
		player = new BufferedImage[2];
		player[0] = charMainSheet.crop(0, 0, width, height);
		player[1] = charMainSheet.crop(0, 0, width, height);
		
		playerLeft = new BufferedImage[2];
		playerLeft[0] = charMainSheet.crop(width * 3, 0, width, height);
		playerLeft[1] = charMainSheet.crop(width * 3, 0, width, height);
		
		playerRight = new BufferedImage[2];
		playerRight[0] = charMainSheet.crop(width * 2, height, width, height);
		playerRight[0] = charMainSheet.crop(width * 2, height, width, height);
		
		playerUp = new BufferedImage[2];
		playerUp[0] = charMainSheet.crop(width, height * 2, width, height);
		playerUp[0] = charMainSheet.crop(width, height * 2, width, height);
		
		
		runningWater = new BufferedImage[2];
		runningWater[0]= sheet.crop(width * 2, height , width, height);
		runningWater[1]= sheet.crop(width * 3, height , width, height);
		
		att_up = new BufferedImage[3];
		att_up[0] = attack.crop(width, height * 2, width, height);
		att_up[1] = attack.crop(width * 2, height * 2, width, height);
		att_up[2] = attack.crop(width * 3, height * 2, width, height);
		
		att_down = new BufferedImage[3];
		att_down[0] = attack.crop(width * 2, height, width, height);
		att_down[1] = attack.crop(width * 3, height, width, height);
		att_down[2] = attack.crop(0, height * 2, width, height);
		
		att_left = new BufferedImage[3];
		att_left[0] = attack.crop(width * 3, 0, width, height);
		att_left[1] = attack.crop(0, height, width, height);
		att_left[2] = attack.crop(width, height, width, height);
		
		att_right = new BufferedImage[3];
		att_right[0] = attack.crop(0, 0, width, height);
		att_right[1] = attack.crop(width, 0, width, height);
		att_right[2] = attack.crop(width * 2, 0, width, height);
		
		saloon2 = buildings.crop(0, 0, width * 6, height * 5);
		building = buildings.crop(width * 6, 0, width * 3, height * 2 - 2);
		building2 = buildings.crop(width * 6, height * 2, width * 3, height * 2);
		building3 = buildings.crop(width * 9, 0, width * 3, height * 2);
		bank = buildings.crop(0, height * 5, width * 6, height * 5);
		
		
		roadUpLeft = sheet.crop(0, height *5, width, height);
		roadSide = sheet.crop(0, height * 3, width, height);
		roadUp = sheet.crop(height * 2, height * 3, width, height);
		roadTurn1 = sheet.crop(height, height * 3, width, height);
		roadTurn2 = sheet.crop(height * 3, height * 3, width, height);
		roadTurn3 = sheet.crop(0, height * 4, width, height);
		roadTurn4 = sheet.crop(height, height * 4, width, height);
		
		goldNugg = sheet.crop(width * 2, height * 4, width, height);
		
		saloon = saloonS.crop(0, 0, width * 3, height* 3);
		
		rivBankL = sheet.crop(width *2,height *2, width, height);
		
		rivBankR = sheet.crop(width*3, height *2, width, height);
		
		bridge = sheet.crop(0, height * 2, width, height);

		dirt = sheet.crop(width, 0, width, height);

		grass = sheet.crop(width * 2, 0, width, height);

		stone = sheet.crop(width * 3, 0, width, height);

		tree = sheet.crop(0, 0, width, height * 2);
		
		door = sheet.crop(width, height * 5, width, height);
		
		doorUp = sheet.crop(width * 2, height * 5, width, height);
	}

	

}
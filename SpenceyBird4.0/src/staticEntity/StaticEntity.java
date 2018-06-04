package staticEntity;

import java.awt.Graphics;

import entities.Entity;
import game.Handler;

//this class is used for objects that DO NOT MOVE
public abstract class StaticEntity extends Entity {

	public StaticEntity(Handler handler,float x,float y,int width, int height)
	{
		super(handler, x,y,width,height);
	}

	
}

package creatures;

import java.awt.Graphics;
import java.awt.Rectangle;
import java.awt.image.BufferedImage;

import entities.Entity;
import game.Handler;
import gfx.Animation;
import gfx.Assets;
import states.State;

public class Player extends Creature {
	
	//Animations
	private Animation animStillUp, animStillLeft, animStillRight, animStillDown, animDown, animUp, animLeft, animRight, animStill, attackLeft, attackRight, attackUp, attackDown;
	//attack timer
	private long lastAttackTimer, attackCooldown = 250, attackTimer = attackCooldown;
	//still Animations
	private int lastAnim = 4, animCheck;
	
	//score 
	private float score;
	
	

	public Player(Handler handler, float x, float y) {
		super(handler, x, y, Creature.DEFAULT_CREATURE_WIDTH, Creature.DEFAULT_CREATURE_HEIGHT);
		
		bounds.x = 22;
		bounds.y = 44;
		bounds.width = 19;
		bounds.height = 19;
		
		//Animatons
		animDown = new Animation(500, Assets.player_down);
		animUp = new Animation(500, Assets.player_up);
		animLeft = new Animation(500, Assets.player_left);
		animRight = new Animation(500, Assets.player_right);
		
		animStillDown = new Animation(500, Assets.player);
		animStillUp = new Animation(500,Assets.player_up);
		animStillLeft = new Animation(500,Assets.playerLeft);
		animStillRight = new Animation(500,Assets.playerRight);
		
		attackLeft = new Animation(150, Assets.att_left);
		attackRight = new Animation(150, Assets.att_right);
		attackDown = new Animation(150, Assets.att_down);
		attackUp = new Animation(150, Assets.att_up);
		
	}

	@Override
	public void tick() {
		//Animations
		animDown.tick();
		animUp.tick();
		animRight.tick();
		animLeft.tick();
		attackUp.tick();
		attackDown.tick();
		attackLeft.tick();
		attackRight.tick();
		//Movement
		getInput();
		move();
		handler.getGameCamera().centerOnEntity(this);
		
		//attack
		checkAttacks();
	}
	
	private void getInput(){
		xMove = 0;
		yMove = 0;
		
		if(handler.getKeyManager().up)
			yMove = -speed;
		if(handler.getKeyManager().down)
			yMove = speed;
		if(handler.getKeyManager().left)
			xMove = -speed;
		if(handler.getKeyManager().right)
			xMove = speed;
	}

	@Override
	public void render(Graphics g) {
		g.drawImage(getCurrentAnimationFrame(), (int) (x - handler.getGameCamera().getxOffset()), (int) (y - handler.getGameCamera().getyOffset()), width, height, null);
		
		
	}
	
	private BufferedImage getCurrentAnimationFrame(){
		
		
		if(xMove < 0)
		{
			lastAnim = 1;
			if(handler.getKeyManager().attacc)
			{
				
				return attackLeft.getCurrentFrame();
			}
			else
			{
			return animLeft.getCurrentFrame();
			}
		}
		
		else if(xMove > 0)
		{
			lastAnim = 2;
			if(handler.getKeyManager().attacc)
			{
				return attackRight.getCurrentFrame();
			
			}
			else
			{
			return animRight.getCurrentFrame();
		
			}
		}
		else if(yMove < 0)
		{
			lastAnim = 3;
			if(handler.getKeyManager().attacc)
			{
				return attackUp.getCurrentFrame();
			}
			else
			{
			return animUp.getCurrentFrame();
			}
		}
		else if(yMove > 0)
		{
			lastAnim = 4;
			if(handler.getKeyManager().attacc)
			{
				return attackDown.getCurrentFrame();
			}
			else
			{
			return animDown.getCurrentFrame();
			}
		}
		else if(lastAnim == 1)
		{
			if(handler.getKeyManager().attacc)
			{
				
				return attackLeft.getCurrentFrame();
			}
			return animStillLeft.getCurrentFrame();
		}
		else if(lastAnim == 2 )
		{
			if(handler.getKeyManager().attacc)
			{
				
				return attackRight.getCurrentFrame();
			}
			return animStillRight.getCurrentFrame();
		}
		else if(lastAnim == 3)
		{
			if(handler.getKeyManager().attacc)
			{
				
				return attackUp.getCurrentFrame();
			}
			return animStillUp.getCurrentFrame();
		}
		else if(lastAnim == 4)
		{
			if(handler.getKeyManager().attacc)
			{
				
				return attackDown.getCurrentFrame();
			}
			return animStillDown.getCurrentFrame();
		}
		return null;
	
	}
	
	private void checkAttacks()
	{
		attackTimer += System.currentTimeMillis() - lastAttackTimer;
		lastAttackTimer = System.currentTimeMillis();
		if(attackTimer < attackCooldown)
			return;

		Rectangle cb = getCollisionBounds(0,0);
		Rectangle ar = new Rectangle();
		int arSize = 20;
		ar.width = arSize;
		ar.height = arSize;
		
		if(handler.getKeyManager().attacc)
		{
			if(xMove < 0)
			{
				ar.x = cb.x - arSize;
				ar.y = cb.y + cb.height / 2 - arSize /2;
			}
			else if(xMove > 0)
			{
				ar.x = cb.x + cb.width;
				ar.y = cb.y + cb.height /2 - arSize /2;
			}
			else if(yMove < 0)//up
			{
				ar.x = cb.x + cb.width / 2 - arSize / 2;
				ar.y = cb.y - arSize;
			} 
			else
			{
				ar.x = cb.x + cb.width / 2 - arSize /2;
				ar.y = cb.y + cb.height;
			}
			
			attackTimer = 0;
			
			for(Entity e: handler.getWorld().getEntityManager().getEntities())
			{
				if(e.equals(this))
					continue;
					if(e.getCollisionBounds(0, 0).intersects(ar))
					{
						e.hurt(1);
						return;
					}
			}
		}
	}

	@Override
	public void die() 
	{
				
	}
	
	public float getScore()
	{
		return score;
	}

	public void setScore(float score)
	{
		this.score = score;
	}
	
	public boolean offScreen()
	{
		Rectangle r = new Rectangle();
		r.width = 32;
		r.height = 32;
		r.x = 960;
		r.y = 1260;
		
		if(this.getCollisionBounds(0, 0).intersects(r))
				{
					return true;
				}
		else
		{
			return false;
		}
	}
	
	public State exitScreen()
	{
		if(this.offScreen())
		{
			handler.level++;
		}
		return null;
	}

}

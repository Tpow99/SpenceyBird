package states;

import java.awt.Color;
import java.awt.Graphics;

import creatures.Player;
import entities.EntityManager;
import game.Handler;
import gfx.Assets;
import ui.ClickListener;
import ui.UIImageButton;
import ui.UIText;
import ui.UIManager;
import ui.UIRectangle;

public class MenuState extends State {
	
	EntityManager entityManager = new EntityManager(handler, new Player(handler,100,100));

	private UIManager uiManager;

	public MenuState(Handler handler) {
		super(handler);
		uiManager = new UIManager(handler); 
		handler.getMouseManager().setUIManager(uiManager);
		
		uiManager.addObject(new UIRectangle(0,0,800,800,new Color(0,2,85)));
		
		
		
		uiManager.addObject(new UIImageButton(120, 300, 400, 128, Assets.btn_help, new ClickListener() {
			@Override
			public void onClick() {
				handler.getMouseManager().setUIManager(null);
				State.setState(handler.getGame().helpState);
			}
		}));
	
		uiManager.addObject(new UIImageButton(120, 125, 400, 128, Assets.btn_start, new ClickListener(){
			@Override
			public void onClick() {
				handler.getMouseManager().setUIManager(null);
				State.setState(handler.getGame().gameState);
			}
				}));
		
		uiManager.addObject(new UIText(50,100,100,Color.white,"THE MINER"));
	}

	@Override
	public void tick() {
		uiManager.tick();
	
	}

	@Override
	public void render(Graphics g) {
		uiManager.render(g);
		
	}

}

package keon.ldtest.gameloop;

import keon.ldtest.entity.Entity;
import keon.ldtest.entity.World;
import keon.ldtest.helpers.AnimationFactory;

import org.newdawn.slick.Animation;
import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.Image;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.SpriteSheet;
import org.newdawn.slick.state.BasicGameState;
import org.newdawn.slick.state.StateBasedGame;

public class Menu extends BasicGameState{

	Animation a;
	World w = new World();
	
	@Override
	public void init(GameContainer gc, StateBasedGame game) throws SlickException {
		System.out.println("beep bloop");
		try
		{
			a = AnimationFactory.makeAnim("/res/testSheet.png", 64, 64, 200);
		}catch(SlickException e){
			e.printStackTrace();
		}
		for(int i = 0; i<800; i+=64)
		{
			for(int j = 0; j <600; j+=64)
			{
				w.addEntity(new Entity(a, i, j));
			}
		}
			
	}

	@Override
	public void render(GameContainer gc, StateBasedGame game, Graphics g)
			throws SlickException {
		w.render(g);
	}

	@Override
	public void update(GameContainer gc, StateBasedGame game, int delta)
			throws SlickException {
		w.updateAll(delta);
	}

	@Override
	public int getID() {
		return 0;
	}

}

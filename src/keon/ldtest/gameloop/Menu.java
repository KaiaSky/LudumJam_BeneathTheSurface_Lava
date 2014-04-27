package keon.ldtest.gameloop;

import keon.ldtest.helpers.AnimationFactory;
import keon.ldtest.helpers.Config;

import org.newdawn.slick.Animation;
import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.state.BasicGameState;
import org.newdawn.slick.state.StateBasedGame;

public class Menu extends BasicGameState{
	
	boolean flagSwitch = false;
	Animation screen = AnimationFactory.makeAnim(Config.title, 800, 600, 1000);
	
	@Override
	public void init(GameContainer gc, StateBasedGame game) throws SlickException {
	}

	@Override
	public void render(GameContainer gc, StateBasedGame game, Graphics g)
			throws SlickException {
		g.drawAnimation(screen, 0, 0);
	}

	@Override
	public void update(GameContainer gc, StateBasedGame game, int delta)
			throws SlickException {
		if(flagSwitch)
		{
			game.enterState(1);
		}
	}

	@Override
	public int getID() {
		return 0;
	}
	
	@Override
	public void mouseClicked(int button, int x, int y, int clickCount) {
		flagSwitch = true;
	}

}

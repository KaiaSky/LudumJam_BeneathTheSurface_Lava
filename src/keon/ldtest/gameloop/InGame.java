package keon.ldtest.gameloop;

import keon.ldtest.entity.Entity;
import keon.ldtest.entity.TileWorld;
import keon.ldtest.entity.tile.TileHandler;
import keon.ldtest.helpers.AnimationFactory;
import keon.ldtest.helpers.Config;
import keon.ldtest.helpers.InputInfo;
import keon.ldtest.helpers.MapLoader;
import keon.ldtest.render.Camera;

import org.newdawn.slick.Animation;
import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.Image;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.state.BasicGameState;
import org.newdawn.slick.state.StateBasedGame;

public class InGame extends BasicGameState{

	Animation a;
	Camera c = new Camera(600,600);
	TileWorld w = new TileWorld(c, 100, 50);
	
	float mouseX = 0;
	float mouseY = 0;
	boolean mouseClicked = false;
	
	@Override
	public void init(GameContainer gc, StateBasedGame game) throws SlickException {
		
		a = AnimationFactory.makeAnim("/res/testSheet.png", 64, 64, 200);

    	TileHandler.setup();
		MapLoader.loadMapIntoWorld(new Image(Config.map1), w);
		Entity e = new Entity(a, 600,600);
		w.addEntity(e);
	}

	@Override
	public void render(GameContainer gc, StateBasedGame game, Graphics g)
			throws SlickException {
		w.render(g);
	}

	@Override
	public void update(GameContainer gc, StateBasedGame game, int delta)
			throws SlickException {
		InputInfo.updateInfo(gc.getInput());
		w.updateAll(delta);
	}

	@Override
	public int getID() {
		return 1;
	}
	
	@Override
	public void mouseClicked(int button, int x, int y, int clickCount) {
		w.setTileAt((char)9, w.getMouseXPos(), w.getMouseYPos());
	}
	

}

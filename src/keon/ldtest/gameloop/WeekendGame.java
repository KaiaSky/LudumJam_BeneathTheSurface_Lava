package keon.ldtest.gameloop;

import org.newdawn.slick.AppGameContainer;
import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.state.StateBasedGame;

public class WeekendGame extends StateBasedGame {

    public static final int WIDTH = 800;
    public static final int HEIGHT = 600;
    public static final int FPS = 60;
    public static final String VERSION = "0.0.1a",
            TITLE = "Ludum Dare Game";
    private static AppGameContainer app;

    public WeekendGame(String appName) {
        super(appName);
    }

    @Override
    public void initStatesList(GameContainer gc) throws SlickException {
        addState(new Menu());
        addState(new InGame());
    }

    @Override
    protected void preRenderState(GameContainer container, Graphics g)
            throws SlickException {
        super.preRenderState(container, g);
    }
    
    // Main Method
    public static void begin(String[] args) {
        try {
            app = new AppGameContainer(new WeekendGame(TITLE + " v" + VERSION));
            app.setDisplayMode(WIDTH, HEIGHT, false);
            app.setTargetFrameRate(FPS);
            app.setShowFPS(true);
            app.setForceExit(false);
            app.start();
        } catch (SlickException e) {
            e.printStackTrace();
        }
    }

    public static AppGameContainer getAGContainer() {
        return app;
    }
}
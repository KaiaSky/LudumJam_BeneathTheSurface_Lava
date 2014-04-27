package keon.ldtest.entity.tile;

import java.util.HashMap;

import keon.ldtest.helpers.AnimationFactory;
import keon.ldtest.helpers.Config;
import keon.ldtest.render.Camera;

import org.newdawn.slick.Animation;
import org.newdawn.slick.Graphics;

public class TileHandler {

	public static HashMap<Character,Animation> anims;
	public static HashMap<Character,BasicTile> tiles;
	
	public static void setup()
	{
		anims = new HashMap<Character, Animation>();
		anims.put((char) 0, AnimationFactory.makeAnim(Config.airUnused, Config.TILESIZE, Config.TILESIZE, 200));
		anims.put((char) 1, AnimationFactory.makeAnim(Config.stone, Config.TILESIZE, Config.TILESIZE, 200));
		anims.put((char) 2, AnimationFactory.makeAnim(Config.water, Config.TILESIZE, Config.TILESIZE, 200));
		anims.put((char) 3, AnimationFactory.makeAnim(Config.lava, Config.TILESIZE, Config.TILESIZE, 200));
		anims.put((char) 4, AnimationFactory.makeAnim(Config.dirt, Config.TILESIZE, Config.TILESIZE, 200));
		anims.put((char) 5, AnimationFactory.makeAnim(Config.grass, Config.TILESIZE, Config.TILESIZE, 200));
		
		tiles = new HashMap<Character,BasicTile>();

		tiles.put((char) 0, new BasicTile());
		tiles.put((char) 1, new TileStone());
		tiles.put((char) 2, new TileWater());
		tiles.put((char) 3, new TileLava());
		tiles.put((char) 4, new TileDirt());
		tiles.put((char) 5, new TileGrass());
	}
	
	public static void draw(Graphics g, char type, int x, int y, Camera c)
	{
		if(type == 0)
		{
			return;
		}
		else{
			
			g.drawAnimation(anims.get(type), x*Config.TILESIZE-c.getX(), y*Config.TILESIZE-c.getY());
		}
	}
	
	public static void update(char type, char[][] tileList)
	{
		tiles.get(type).update(tileList);
	}
	
}

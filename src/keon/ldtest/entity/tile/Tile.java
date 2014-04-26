package keon.ldtest.entity.tile;

import java.util.HashMap;

import keon.ldtest.helpers.AnimationFactory;
import keon.ldtest.helpers.Config;

import org.newdawn.slick.Animation;
import org.newdawn.slick.Graphics;

public class Tile {

	public static HashMap<Character,Animation> mappings;
	
	public static void setup()
	{
		mappings = new HashMap<Character, Animation>();
		mappings.put((char) 0, AnimationFactory.makeAnim(Config.airUnused, Config.TILESIZE, Config.TILESIZE, 200));
		mappings.put((char) 1, AnimationFactory.makeAnim(Config.stone, Config.TILESIZE, Config.TILESIZE, 200));
	}
	
	public static void draw(Graphics g, char type, int x, int y)
	{
		if(type == 0)
		{
			return;
		}
		else{
			g.drawAnimation(mappings.get(type), x*Config.TILESIZE, y*Config.TILESIZE);
		}
	}
	
}

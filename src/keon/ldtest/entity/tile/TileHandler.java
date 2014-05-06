package keon.ldtest.entity.tile;

import java.util.HashMap;

import keon.ldtest.entity.tile.manmade.TileDrill;
import keon.ldtest.entity.tile.manmade.TileDrillUnpowered;
import keon.ldtest.entity.tile.manmade.TileHQ;
import keon.ldtest.entity.tile.manmade.TileWire;
import keon.ldtest.entity.tiledata.TileData;
import keon.ldtest.helpers.AnimationFactory;
import keon.ldtest.helpers.Config;
import keon.ldtest.render.Camera;
import keon.ldtest.entity.TileWorld;

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
		anims.put((char) 6, AnimationFactory.makeAnim(Config.lava, Config.TILESIZE, Config.TILESIZE, 200));
		anims.put((char) 7, AnimationFactory.makeAnim(Config.water, Config.TILESIZE, Config.TILESIZE, 200));
		anims.put((char) 8, AnimationFactory.makeAnim(Config.wire, Config.TILESIZE, Config.TILESIZE, 200));
		anims.put((char) 9, AnimationFactory.makeAnim(Config.drill, Config.TILESIZE, Config.TILESIZE, 200));
		anims.put((char) 10, AnimationFactory.makeAnim(Config.drillunpowered, Config.TILESIZE, Config.TILESIZE, 200));
		anims.put((char) 11, AnimationFactory.makeAnim(Config.hq, Config.TILESIZE, Config.TILESIZE, 200));
		anims.put((char) 255, AnimationFactory.makeAnim(Config.invis, Config.TILESIZE, Config.TILESIZE, 200));
		
		tiles = new HashMap<Character,BasicTile>();

		tiles.put((char) 0, new BasicTile());
		tiles.put((char) 1, new TileStone());
		tiles.put((char) 2, new TileWater());
		tiles.put((char) 3, new TileLava());
		tiles.put((char) 4, new TileDirt());
		tiles.put((char) 5, new TileGrass());
		tiles.put((char) 6, new TileStillLava());
		tiles.put((char) 7, new TileStillWater());
		tiles.put((char) 8, new TileWire());
		tiles.put((char) 9, new TileDrill());
		tiles.put((char) 10, new TileDrillUnpowered());
		tiles.put((char) 11, new TileHQ());
	}
	
	public static void draw(Graphics g, char type, int x, int y, Camera c, TileData extra)
	{
		if(extra.visible)
		{
			if(type == 0)
			{
				return;
			}
			else{
				g.drawAnimation(anims.get(type), x*Config.TILESIZE-c.getX(), y*Config.TILESIZE-c.getY());
			}
		}else
		{
			g.drawAnimation(anims.get((char)255), x*Config.TILESIZE-c.getX(), y*Config.TILESIZE-c.getY());
		}
	}
	
	public static void update(char type, TileWorld w, int x, int y, TileData data)
	{
		tiles.get(type).update(x, y, w, data);
	}
	
}

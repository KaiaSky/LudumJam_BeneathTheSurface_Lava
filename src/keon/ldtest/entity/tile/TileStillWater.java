package keon.ldtest.entity.tile;

import keon.ldtest.entity.TileWorld;
import keon.ldtest.entity.tiledata.TileData;

public class TileStillWater extends BasicTile {

	@Override
	public void update(int x, int y, TileWorld w, TileData data)
	{
		w.setTileAt((char)2, x, y);
	}
	
}

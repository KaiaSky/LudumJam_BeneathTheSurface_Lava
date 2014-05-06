package keon.ldtest.entity.tile;

import keon.ldtest.entity.TileWorld;
import keon.ldtest.entity.tiledata.TileData;

public class TileStillLava extends BasicTile {

	@Override
	public void update(int x, int y, TileWorld w, TileData data)
	{
		w.setTileAt((char)3, x, y);
	}
	
}

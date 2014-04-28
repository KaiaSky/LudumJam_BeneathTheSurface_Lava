package keon.ldtest.entity.tile;

import keon.ldtest.entity.tiledata.TileData;


public class BasicTile {

	public TileData data = new TileData();
	
	public void update(int x, int y, char[][] tileList, TileData data, TileData[][] dataList)
	{
		return;
	}
	
	public void setTileData(TileData newData)
	{
		data = newData;
	}
	
	public void setup()
	{
		
	}
	
}

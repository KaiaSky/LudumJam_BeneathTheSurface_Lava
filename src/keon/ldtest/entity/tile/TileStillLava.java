package keon.ldtest.entity.tile;

public class TileStillLava extends BasicTile {

	public void update(int x, int y, char[][] tileList)
	{
		tileList[x][y] = (char)3;
	}
	
}

package keon.ldtest.entity;

import keon.ldtest.entity.tile.Tile;

import org.newdawn.slick.Graphics;

public class TileWorld extends World{

	char[][] tiles;
	
	public TileWorld(int xLen, int yLen)
	{
		tiles = new char[xLen][yLen];
	}
	
	public char getTileAt(int x, int y)
	{
		return tiles[x][y];
	}
	
	public void setTileAt(char tile, int x, int y)
	{
		tiles[x][y] = tile;
	}
	
	public void render(Graphics g)
	{
		super.render(g);
		for(int x = 0; x< tiles.length; x++)
		{
			for(int y = 0; y< tiles[0].length;y++)
			{
				Tile.draw(g, tiles[x][y], x, y);
			}
		}
	}
}

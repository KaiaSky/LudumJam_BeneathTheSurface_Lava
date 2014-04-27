package keon.ldtest.entity;

import keon.ldtest.entity.tile.TileHandler;
import keon.ldtest.helpers.Config;
import keon.ldtest.helpers.InputInfo;
import keon.ldtest.render.Camera;

import org.newdawn.slick.Graphics;

public class TileWorld extends World{

	char[][] tiles;
	int tileTimer = 0;
	
	public TileWorld(Camera c, int xLen, int yLen)
	{
		super(c, 0,0, xLen*Config.TILESIZE,yLen*Config.TILESIZE);
		tiles = new char[xLen][yLen];
	}
	
	public char getTileAt(int x, int y)
	{
		return tiles[x][y];
	}
	
	public char getTileFromPos(float x, float y)
	{
		return tiles[(int)(x/Config.TILESIZE)][(int)(y/Config.TILESIZE)];
	}
	
	public int toTilePos(float x)
	{
		return (int)(x/Config.TILESIZE);
	}
	
	public char getTileOfMouse()
	{
		return tiles[(int)((InputInfo.mouseX+this.getCamera().getX())/Config.TILESIZE)][(int)((InputInfo.mouseY+this.getCamera().getY())/Config.TILESIZE)];
	}
	
	public int getMouseXPos()
	{
		return (int)((InputInfo.mouseX + this.getCamera().getX())/Config.TILESIZE);
	}
	
	public int getMouseYPos()
	{
		return (int)((InputInfo.mouseY + this.getCamera().getY())/Config.TILESIZE);
	}
	
	public void setTileAt(char tile, int x, int y)
	{
		tiles[x][y] = tile;
	}
	
	@Override
	public void render(Graphics g)
	{
		for(int x = 0; x< tiles.length; x++)
		{
			for(int y = 0; y< tiles[0].length;y++)
			{
				TileHandler.draw(g, tiles[x][y], x, y, this.getCamera());
			}
		}
		super.render(g);
	}
	
	@Override
	public void updateAll(double delta)
	{
		tileTimer++;
		tileTimer %=10;
		super.updateAll(delta);
		if(tileTimer == 0)
		{
			for(int x = 0; x< tiles.length; x++)
			{
				for(int y = tiles[0].length-1; y>=0 ;y--)
				{
					TileHandler.update(tiles[x][y], tiles, x, y);
				}
			}
		}
		
	}
}

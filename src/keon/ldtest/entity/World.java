package keon.ldtest.entity;

import java.util.ArrayList;

import keon.ldtest.render.Camera;

import org.newdawn.slick.Animation;
import org.newdawn.slick.Graphics;

public class World {

	private ArrayList<Entity> entityList;
	private Camera c;
	private Animation bg;
	
	public float xmin, ymin, xmax, ymax;
	
	public World(Camera cam, float xMin, float yMin, float xMax, float yMax, Animation background)
	{
		entityList = new ArrayList<Entity>();
		c = cam;
		xmin= xMin;
		ymin = yMin;
		xmax = xMax;
		ymax = yMax;
		bg = background;
	}

	public ArrayList<Entity> getEntityList() {
		return entityList;
	}

	public void setEntityList(ArrayList<Entity> entityList) {
		this.entityList = entityList;
	}
	
	public void setCamera(Camera newCam)
	{
		c = newCam;
	}
	
	public Camera getCamera()
	{
		return c;
	}
	
	public Entity getEntityAt(int index)
	{
		return entityList.get(index);
	}
	
	public void addEntity(Entity e)
	{
		this.entityList.add(e);
	}
	
	public void addEntity(int index, Entity e)
	{
		this.entityList.add(index, e);
	}
	
	public boolean removeEntity(Entity e)
	{
		return this.entityList.remove(e);
	}
	
	public void removeEntity(int i)
	{
		this.entityList.remove(i);
	}
	
	public void updateAll(double delta)
	{
		c.update(delta, this);
		for(int i = 0; i < this.entityList.size(); i++)
		{
			this.entityList.get(i).update(delta, this);
		}
	}
	
	public void render(Graphics g)
	{
		for(int i = 0; i < this.entityList.size(); i++)
		{
			this.entityList.get(i).draw(g, c);
		}
	}
	
	public void renderBG(Graphics g)
	{
		g.drawAnimation(bg, 0,0);
	}
}

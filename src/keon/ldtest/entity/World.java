package keon.ldtest.entity;

import java.util.ArrayList;
import java.util.Iterator;

import org.newdawn.slick.Graphics;

public class World {

	private ArrayList<Entity> entityList;
	
	public World()
	{
		entityList = new ArrayList<Entity>();
	}

	public ArrayList<Entity> getEntityList() {
		return entityList;
	}

	public void setEntityList(ArrayList<Entity> entityList) {
		this.entityList = entityList;
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
		for(int i = 0; i < this.entityList.size(); i++)
		{
			System.out.println(i);
			this.entityList.get(i).update(delta, this);
		}
	}
	
	public void render(Graphics g)
	{
		for(int i = 0; i < this.entityList.size(); i++)
		{
			this.entityList.get(i).draw(g);
		}
	}
}

package fr.theflogat.chemicalPhysics.util;

import net.minecraft.world.World;

public class Coordinates {
	
	public int x;
	public int y;
	public int z;
	public World world;
	
	public Coordinates(int par1x, int par2y, int par3z, World par4world){
		this.x = par1x;
		this.y = par2y;
		this.z = par3z;
		this.world = par4world;
	}
	
	public int getX(){
		return this.x;
	}
	
	public int getY(){
		return this.y;
	}
	
	public int getZ(){
		return this.z;
	}
	
	public void setX(int card){
		this.x = card;
	}
	
	public void setY(int card){
		this.y = card;
	}
	
	public void setZ(int card){
		this.z = card;
	}
	
	public World getWorld(){
		return world;
	}
}

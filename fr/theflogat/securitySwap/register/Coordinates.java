package fr.theflogat.securitySwap.register;

import net.minecraft.world.World;;

public class Coordinates {
	
	private int x;
	private int y;
	private int z;
	private World world;
	
	public Coordinates(int x, int y, int z, World world){
		this.x = x;
		this.y = y;
		this.z = z;
		this.world = world;
	}
	
	public int x(){
		return x;
	}
	
	public int y(){
		return y;
	}
	
	public int z(){
		return z;
	}
	
	public World world(){
		return world;
	}
}

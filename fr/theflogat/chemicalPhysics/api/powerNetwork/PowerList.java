package fr.theflogat.chemicalPhysics.api.powerNetwork;

import java.util.logging.Level;

import net.minecraft.block.BlockContainer;
import net.minecraft.block.material.Material;
import net.minecraft.tileentity.TileEntity;

import fr.theflogat.chemicalPhysics.lib.LogHelper;

abstract public class PowerList{


	private boolean direction[] = {false, false, false, false, false, false};
	private char directionL[] = {'T','B','N','S','E','W'};
	
	enum Type{
		PIPE,MACHINE,TURBINE
	}
	
	private static TileEntity[] registeredTiles;
	private static Type[] tileType;
	private static float[] powerLoss;
	private static int[] maxEnergyStored;
	private static float[] maxEnergyInputPerTick;
	private static float[] maxEnergyOutputPerTick;
	private static int length = 0;
	
	/**
	 * @param tile
	 * @param type
	 * @param loss
	 * @param maximumEnergyStored
	 * @param maxEnergyInputEachTick
	 * @param maxEnergyOutputEachTick
	 * 
	 * Loss cannot be greater than 1.0F
	 */
	public static void setNewPowerBlock(TileEntity tile, Type type, float loss, 
			int maximumEnergyStored, float maxEnergyInputEachTick, float maxEnergyOutputEachTick){
		registeredTiles[length] = tile;
		tileType[length] = type;
		powerLoss[length] = loss;
		maxEnergyStored[length] = maximumEnergyStored;
		maxEnergyInputPerTick[length] = maxEnergyInputEachTick;
		maxEnergyOutputPerTick[length] = maxEnergyOutputEachTick;
		length++;
	}
	
	public static TileEntity[] getTiles(){
		return registeredTiles;
	}

	public static Type[] getTypes(){
		return tileType;
	}
	
	public static float[] getLoss(){
		return powerLoss;
	}
	public static int[] getMaxEnerStored(){
		return maxEnergyStored;
	}
	
	public static float[] getMaxEnergyInputPerTick(){
		return maxEnergyInputPerTick;
	}
	public static float[] getMaxEnergyOutputPerTick(){
		return maxEnergyOutputPerTick;
	}
	
	public static int getLenght(){
		return length;
	}
}
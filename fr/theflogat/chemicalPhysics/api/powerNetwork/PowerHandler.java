package fr.theflogat.chemicalPhysics.api.powerNetwork;

import net.minecraft.tileentity.TileEntity;
import fr.theflogat.chemicalPhysics.api.powerNetwork.PowerList.Type;

public class PowerHandler {
	
	public static Type getTypeFromTile(TileEntity tile){
		for(int i = 0;i < PowerList.getLenght();i++){
			if(PowerList.getTiles()[i]==tile){
				return PowerList.getTypes()[i];
			}
		}
		return null;
	}
	
	public static float getPowerLossFromTile(TileEntity tile){
		for(int i = 0;i < PowerList.getLenght();i++){
			if(PowerList.getTiles()[i]==tile){
				return PowerList.getLoss()[i];
			}
		}
		return 0;
	}
	
	public static int getMaxPowerStoredFromTile(TileEntity tile){
		for(int i = 0;i < PowerList.getLenght();i++){
			if(PowerList.getTiles()[i]==tile){
				return PowerList.getMaxEnerStored()[i];
			}
		}
		return 0;
	}
	
	public static float getMaxEnerInputFromTile(TileEntity tile){
		for(int i = 0;i < PowerList.getLenght();i++){
			if(PowerList.getTiles()[i]==tile){
				return PowerList.getMaxEnergyInputPerTick()[i];
			}
		}
		return 0;
	}
	
	public static float getMaxEnerOutputFromTile(TileEntity tile){
		for(int i = 0;i < PowerList.getLenght();i++){
			if(PowerList.getTiles()[i]==tile){
				return PowerList.getMaxEnergyOutputPerTick()[i];
			}
		}
		return 0;
	}
}

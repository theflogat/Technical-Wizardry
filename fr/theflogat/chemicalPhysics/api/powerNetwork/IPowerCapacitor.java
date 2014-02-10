package fr.theflogat.chemicalPhysics.api.powerNetwork;

import net.minecraft.tileentity.TileEntity;

public class IPowerCapacitor {
	
	public int powerStored;
	public int newMaxEnerStored = -1;
	
	
	
	
	public int sendPower(int powerToAdd, TileEntity tile){
		if(powerStored + powerToAdd<=PowerHandler.getMaxPowerStoredFromTile(tile)){
			if(powerToAdd<=PowerHandler.getMaxEnerInputFromTile(tile)){
				powerStored += powerToAdd;
				return 0;
			} else if(newMaxEnerStored!= -1){
				if(powerToAdd<=newMaxEnerStored){
					powerStored += powerToAdd;
					return 0;
				} else {
					powerStored += PowerHandler.getMaxEnerInputFromTile(tile);
					return (int) (Math.ceil(powerToAdd - PowerHandler.getMaxEnerInputFromTile(tile)));
				}
			} else {
				powerStored += PowerHandler.getMaxEnerInputFromTile(tile);
				return (int) (Math.ceil(powerToAdd - PowerHandler.getMaxEnerInputFromTile(tile)));
			}
		}
		return powerToAdd;
	}
	
	public int getPowerStored(){
		return powerStored;
	}
	
	public void setMaxEnergyInputUpgraded(int newVal){
		newMaxEnerStored = newVal;
	}
	
	public void getMaxEnergyInput(){
		
	}
	
	public void getMaxEnergyStored(){
		
	}
}

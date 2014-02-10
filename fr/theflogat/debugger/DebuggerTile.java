package fr.theflogat.debugger;

import net.minecraft.client.Minecraft;
import net.minecraft.inventory.IInventory;
import net.minecraft.tileentity.TileEntity;

public class DebuggerTile extends TileEntity{
	
	public int cooldown = 20;
	
	@Override
	public void updateEntity(){
		if(cooldown==0){
			Minecraft.getMinecraft().ingameGUI.getChatGUI().printChatMessage(Integer.toString((worldObj.getIndirectPowerLevelTo(xCoord, yCoord+1, zCoord, 0))));
			cooldown = 20;
		}else{
			cooldown--;
		}
	}
}

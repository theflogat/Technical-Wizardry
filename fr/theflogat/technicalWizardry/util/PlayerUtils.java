package fr.theflogat.technicalWizardry.util;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.world.World;

public class PlayerUtils {
	public static EntityPlayer getPlayerFromName(String par1string, World par2world){
		for(int i = 0; i<par2world.playerEntities.size(); i++){
			EntityPlayer play;
			play = (EntityPlayer) par2world.playerEntities.get(i);
			if(play.getEntityName() == par1string){
				return play;
			}
		}
		return null;
	}
}

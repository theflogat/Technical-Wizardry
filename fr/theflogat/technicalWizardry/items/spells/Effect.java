package fr.theflogat.technicalWizardry.items.spells;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.world.World;

public class Effect {

	private int cost;
	private int effectId; 
	
	public Effect(int cost, int effectId){
		this.cost = cost;
		this.effectId = effectId;
	}
	
	public int getCost(){
		return cost;
	}
	
	public void getAction(World world, int x, int y, int z, EntityPlayer player){
		switch(effectId){
		
		
		}
	}
}

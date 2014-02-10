package fr.theflogat.chemicalPhysics.api;

import net.minecraft.item.ItemStack;

public class ElectrolyserRecipeHelper {

	public static ItemStack getItemStackOutput1(ItemStack base){
		if(base==null)
			return null;
		int baseId = base.itemID;
		for(int i=0;i<ElectrolyserRecipeHandler.getNbRecipes();i++){
			if(baseId == ElectrolyserRecipeHandler.getAllIdInput()[i] &&
					(ElectrolyserRecipeHandler.getAllMetaInput()[i]==-1 || ElectrolyserRecipeHandler.getAllMetaInput()[i]==base.getItemDamage())){
				if(ElectrolyserRecipeHandler.getAllMeta1()[i]==-1){
					return new ItemStack(ElectrolyserRecipeHandler.getAllOutput1()[i], 1, 0);
				}
				return new ItemStack(ElectrolyserRecipeHandler.getAllOutput1()[i], 1, ElectrolyserRecipeHandler.getAllMeta1()[i]);
			}
		}
		return null;
	}
	
	public static ItemStack getItemStackOutput2(ItemStack base){
		if(base==null)
			return null;
		int baseId = base.itemID;
		for(int i=0;i<ElectrolyserRecipeHandler.getNbRecipes();i++){
			if(baseId == ElectrolyserRecipeHandler.getAllIdInput()[i] &&
					(ElectrolyserRecipeHandler.getAllMetaInput()[i]==-1 || ElectrolyserRecipeHandler.getAllMetaInput()[i]==base.getItemDamage())){
				if(ElectrolyserRecipeHandler.getAllMeta2()[i]==-1){
					return new ItemStack(ElectrolyserRecipeHandler.getAllOutput2()[i], 1, 0);
				}
				return new ItemStack(ElectrolyserRecipeHandler.getAllOutput2()[i], 1, ElectrolyserRecipeHandler.getAllMeta2()[i]);
			}
		}
		return null;
	}
	
	public static ItemStack getItemStackOutput3(ItemStack base){
		if(base==null)
			return null;
		int baseId = base.itemID;
		for(int i=0;i<ElectrolyserRecipeHandler.getNbRecipes();i++){
			if(baseId == ElectrolyserRecipeHandler.getAllIdInput()[i] &&
					(ElectrolyserRecipeHandler.getAllMetaInput()[i]==-1 || ElectrolyserRecipeHandler.getAllMetaInput()[i]==base.getItemDamage())){
				if(ElectrolyserRecipeHandler.getAllMeta3()[i]==-1){
					return new ItemStack(ElectrolyserRecipeHandler.getAllOutput3()[i], 1, 0);
				}
				return new ItemStack(ElectrolyserRecipeHandler.getAllOutput3()[i], 1, ElectrolyserRecipeHandler.getAllMeta3()[i]);
			}
		}
		return null;
	}
	
	public static ItemStack getItemStackOutput4(ItemStack base){
		if(base==null)
			return null;
		int baseId = base.itemID;
		for(int i=0;i<ElectrolyserRecipeHandler.getNbRecipes();i++){
			if(baseId == ElectrolyserRecipeHandler.getAllIdInput()[i] &&
					(ElectrolyserRecipeHandler.getAllMetaInput()[i]==-1 || ElectrolyserRecipeHandler.getAllMetaInput()[i]==base.getItemDamage())){
				if(ElectrolyserRecipeHandler.getAllMeta4()[i]==-1){
					return new ItemStack(ElectrolyserRecipeHandler.getAllOutput4()[i], 1, 0);
				}
				return new ItemStack(ElectrolyserRecipeHandler.getAllOutput4()[i], 1, ElectrolyserRecipeHandler.getAllMeta4()[i]);
			}
		}
		return null;
	}
	
	public static ItemStack getItemStackOutput5(ItemStack base){
		if(base==null)
			return null;
		int baseId = base.itemID;
		for(int i=0;i<ElectrolyserRecipeHandler.getNbRecipes();i++){
			if(baseId == ElectrolyserRecipeHandler.getAllIdInput()[i] &&
					(ElectrolyserRecipeHandler.getAllMetaInput()[i]==-1 || ElectrolyserRecipeHandler.getAllMetaInput()[i]==base.getItemDamage())){
				if(ElectrolyserRecipeHandler.getAllMeta5()[i]==-1){
					return new ItemStack(ElectrolyserRecipeHandler.getAllOutput5()[i], 1, 0);
				}
				return new ItemStack(ElectrolyserRecipeHandler.getAllOutput5()[i], 1, ElectrolyserRecipeHandler.getAllMeta5()[i]);
			}
		}
		return null;
	}
	
	public static boolean hasRecipe(ItemStack base){
		if(base==null)
			return false;
		int baseId = base.itemID;
		for(int i=0;i<ElectrolyserRecipeHandler.getNbRecipes();i++){
			if(baseId == ElectrolyserRecipeHandler.getAllIdInput()[i] &&
					(ElectrolyserRecipeHandler.getAllMetaInput()[i]==-1 || ElectrolyserRecipeHandler.getAllMetaInput()[i]==base.getItemDamage())){
				return true;
			}
		}
		return false;
	}
}

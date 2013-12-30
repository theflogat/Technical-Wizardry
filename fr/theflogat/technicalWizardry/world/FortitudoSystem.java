package fr.theflogat.technicalWizardry.world;

import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.world.WorldSavedData;

public class FortitudoSystem extends WorldSavedData{

	int fortitudoBuildUp;
	public final String TAG_FORTITUDO = "fortitudoBuildUp";
	
	public FortitudoSystem(String par1Str) {
		super(par1Str);
		fortitudoBuildUp = 0;
	}

	@Override
	public void readFromNBT(NBTTagCompound comp) {
		fortitudoBuildUp = comp.getInteger(TAG_FORTITUDO);
	}

	@Override
	public void writeToNBT(NBTTagCompound comp) {
		comp.setInteger(TAG_FORTITUDO, fortitudoBuildUp);
	}
}

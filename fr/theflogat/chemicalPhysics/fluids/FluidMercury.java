package fr.theflogat.chemicalPhysics.fluids;

import java.awt.Color;

import fr.theflogat.chemicalPhysics.lib.config.Names;
import net.minecraftforge.fluids.Fluid;

public class FluidMercury extends Fluid{

	public FluidMercury() {
		super(Names.FluidMercury_FluidName);
		this.setUnlocalizedName(Names.FluidMercury_UnlocalizedName);
	    this.setDensity(2000);
	    this.setViscosity(2000);
	    this.setTemperature(295);
	}
	
	public int getColor()
	{
		return Color.DARK_GRAY.getRGB();
	}
}

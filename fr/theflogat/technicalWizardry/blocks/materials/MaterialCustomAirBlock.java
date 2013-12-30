package fr.theflogat.technicalWizardry.blocks.materials;

import net.minecraft.block.material.*;

public class MaterialCustomAirBlock extends Material{

	public MaterialCustomAirBlock(MapColor par1MapColor) {
		super(par1MapColor);
        this.setReplaceable();
	}

    public boolean isSolid()
    {
        return false;
    }
    
    public boolean getCanBlockGrass()
    {
        return false;
    }
    
    public boolean blocksMovement()
    {
        return false;
    }
}

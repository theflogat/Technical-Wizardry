package fr.theflogat.technicalWizardry.util;

import java.util.Random;


import net.minecraft.entity.item.EntityItem;
import net.minecraft.inventory.IInventory;
import net.minecraft.item.ItemStack;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.world.World;

public class TWUUtils {
	
	static Random random = new Random();
	static TileEntity TEField1;
	
	public static EntityItem spawnItemStack(Coordinates coords, ItemStack item, World world){
		if (item == null) {
			return null;
		}
		double dx = random.nextFloat() * 0.5D - 0.5D;
		double dy = random.nextFloat() * 0.5D - 0.5D;
	    double dz = random.nextFloat() * 0.5D - 0.5D;
	    
	    EntityItem entityitem = new EntityItem(world, coords.getX() + 0.5D, coords.getY() + 0.5D, coords.getZ() + 0.5D, item);
	    entityitem.motionY = (0.2D + random.nextGaussian() * 0.02D);
	    entityitem.motionX = (random.nextGaussian() * 0.02D);
	    entityitem.motionZ = (random.nextGaussian() * 0.02D);
	    world.spawnEntityInWorld(entityitem);
	    return entityitem;
	}
	
	public static LabeledInteger determinatePath(int counting){
		switch(counting%6){
		case 0:
			return new LabeledInteger('x', 1);
		case 1:
			return new LabeledInteger('x', -1);
		case 2:
			return new LabeledInteger('y', 1);
		case 3:
			return new LabeledInteger('y', -1);
		case 4:
			return new LabeledInteger('z', 1);
		case 5:
			return new LabeledInteger('z', -1);
		default:
			return null;
		}
	}
	
	public static TileEntity getTileEntityFromCoordsAndPath(Coordinates coords, LabeledInteger path, World worldObj){
		TEField1 = null;
		if(path.getLabel()=='x'){
			TEField1 = worldObj.getBlockTileEntity(coords.getX()+path.getValue(), coords.getY(), coords.getZ());
			if(TEField1!=null){
				return TEField1;
			}
		} else if(path.getLabel()=='y'){
			TEField1 = worldObj.getBlockTileEntity(coords.getX(), coords.getY()+path.getValue(), coords.getZ());
			if(TEField1!=null){
				return TEField1;
			}
		} else if(path.getLabel()=='z'){
			TEField1 = worldObj.getBlockTileEntity(coords.getX(), coords.getY(), coords.getZ()+path.getValue());
			if(TEField1!=null){
				return TEField1;
			}
		}
		return null;
	}
	
	public static Coordinates getNewCoordsFromCoordsAndPath(Coordinates coords, LabeledInteger path){
		switch(path.getLabel()){
		case 'x':
			return new Coordinates(coords.getX()+path.getValue(), coords.getY(), coords.getZ(), coords.getWorld());
		case 'y':
			return new Coordinates(coords.getX(), coords.getY()+path.getValue(), coords.getZ(), coords.getWorld());
		case 'z':
			return new Coordinates(coords.getX(), coords.getY(), coords.getZ()+path.getValue(), coords.getWorld());
		}
		return null;
	}
}

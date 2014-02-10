package fr.theflogat.chemicalPhysics.items.cells;

import fr.theflogat.chemicalPhysics.fluids.BlockFluidChem;
import net.minecraft.block.Block;
import net.minecraft.block.BlockFluid;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.util.MovingObjectPosition;
import net.minecraft.world.World;
import net.minecraftforge.fluids.BlockFluidClassic;
import net.minecraftforge.fluids.IFluidBlock;

public class ItemCell extends Item{

	private static final String TAG_FLUID_ID = "fluidID";
	private static final String TAG_FILLED_PERCENTAGE = "filledPercentage";

	public ItemCell(int id) {
		super(id);
		this.setMaxDamage(10);
        this.setMaxStackSize(1);
	}

	@Override
	public ItemStack onItemRightClick(ItemStack item, World world,	EntityPlayer player) {
		if(item.stackTagCompound == null)
			item.stackTagCompound = new NBTTagCompound();
		
		MovingObjectPosition movObjPos = this.getMovingObjectPositionFromPlayer(world, player, true);
		int x = movObjPos.blockX;
		int y = movObjPos.blockY;
		int z = movObjPos.blockZ;
		ItemCell itemC = (ItemCell)item.getItem(); 
		int id = itemC.getFluid(item);
		if(getCellFromFluid(world, x, y, z, player)==this){
			return item;
		} else {
			item.itemID = getCellFromFluid(world, x, y, z, player).itemID;
		}
		if(id != -1 && id == world.getBlockId(x, y, z)){
			if(!item.stackTagCompound.hasKey(TAG_FILLED_PERCENTAGE)){
				item.stackTagCompound.setInteger(TAG_FILLED_PERCENTAGE, 2);
			}else{
				int filledPerc = item.stackTagCompound.getInteger(TAG_FILLED_PERCENTAGE);
				filledPerc++;
				item.stackTagCompound.setInteger(TAG_FILLED_PERCENTAGE, filledPerc);
			}
		}else{
			if(Block.blocksList[world.getBlockId(x, y, z)]instanceof IFluidBlock){
				item.stackTagCompound.setInteger(TAG_FLUID_ID, world.getBlockId(x, y, z));
				item.stackTagCompound.setInteger(TAG_FILLED_PERCENTAGE, 1);
			}
		}
		
		return item;
	}
	
	public ItemCell getCellFromFluid(World world, int x, int y, int z, EntityPlayer player){
		int id = world.getBlockId(x, y, z);
		Block b = Block.blocksList[id];
		if(b instanceof BlockFluidChem){
			BlockFluidChem bfc = (BlockFluidChem)b;
			return bfc.getCellFromBlock();
		}
		return this;
	}
	
	public int getFluid(ItemStack item){
		if(item.stackTagCompound == null){
			item.stackTagCompound = new NBTTagCompound();
			return -1;
		}
		int id = item.stackTagCompound.getInteger(TAG_FLUID_ID);
		return id == 0 ? -1:id;
	}
}

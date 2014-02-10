package fr.theflogat.technicalWizardry.items.spells;

import net.minecraft.entity.Entity;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.EnumMovingObjectType;
import net.minecraft.util.MovingObjectPosition;
import net.minecraft.world.World;
import fr.theflogat.technicalWizardry.TechnicalWizardry;
import fr.theflogat.technicalWizardry.entity.Projectile;
import fr.theflogat.technicalWizardry.lib.config.Names;

public class ItemSpell extends Item{

	public ItemSpell(int id) {
		super(id);
		this.setMaxStackSize(1);
		this.setCreativeTab(TechnicalWizardry.CreativeTabTWU);
		this.setUnlocalizedName(Names.ItemSpell_UnlocalizedName);
	}

	@Override
	public ItemStack onItemRightClick(ItemStack items, World world, EntityPlayer player) {
		MovingObjectPosition movObjPos = this.getMovingObjectPositionFromPlayer(world, player, true);
		

		if(movObjPos != null){ 
			if(movObjPos.typeOfHit==EnumMovingObjectType.TILE){
				int x = movObjPos.blockX;
				int y = movObjPos.blockY;
				int z = movObjPos.blockZ;
				Entity proj = new Projectile(world, x, y, z, player);
				world.spawnEntityInWorld(proj);
			} else {
				double x = movObjPos.hitVec.xCoord;
				double y = movObjPos.hitVec.yCoord;
				double z = movObjPos.hitVec.zCoord;
				Entity proj = new Projectile(world, x, y, z, player);
				world.spawnEntityInWorld(proj);
			}
		}
		
		
		return items;
	}
}

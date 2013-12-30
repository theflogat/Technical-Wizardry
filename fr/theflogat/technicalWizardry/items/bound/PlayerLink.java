package fr.theflogat.technicalWizardry.items.bound;

import java.util.List;
import java.util.logging.Level;

import org.lwjgl.input.Keyboard;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import fr.theflogat.technicalWizardry.TechnicalWizardry;
import fr.theflogat.technicalWizardry.lib.LogHelper;
import fr.theflogat.technicalWizardry.lib.References;
import fr.theflogat.technicalWizardry.lib.config.Names;
import net.minecraft.client.renderer.texture.IconRegister;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.nbt.NBTTagEnd;
import net.minecraft.world.World;

public class PlayerLink extends BoundItem{
	
	public PlayerLink(int id) {
		super(id);
		this.setUnlocalizedName(Names.PlayerLink_UnlocalizedName);
	}
	
	public void addInformation(ItemStack par1ItemStack, EntityPlayer par2EntityPlayer, List par3List, boolean par4)
	{
		if (Keyboard.isKeyDown(42)) {
			par3List.add("Links To A Player");
			super.addInformation(par1ItemStack, par2EntityPlayer, par3List, par4);
		} else {
			par3List.add("--Press Shift For More Info--");
		}
	}
	  
	@Override
	@SideOnly(Side.CLIENT)
	public void registerIcons(IconRegister icon){
		itemIcon = icon.registerIcon(References.MOD_ID.toLowerCase() + ":" + Names.PlayerLink_UnlocalizedName);
	}
}

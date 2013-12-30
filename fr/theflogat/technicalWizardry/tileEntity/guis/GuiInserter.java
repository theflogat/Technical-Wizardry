package fr.theflogat.technicalWizardry.tileEntity.guis;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Iterator;

import org.lwjgl.input.Keyboard;
import org.lwjgl.opengl.GL11;

import fr.theflogat.technicalWizardry.lib.References;
import fr.theflogat.technicalWizardry.tileEntity.TEItemInserter;
import fr.theflogat.technicalWizardry.tileEntity.container.ContainerItemInserter;
import fr.theflogat.technicalWizardry.util.Coordinates;
import net.minecraft.client.gui.GuiButton;
import net.minecraft.client.gui.inventory.GuiContainer;
import net.minecraft.entity.player.InventoryPlayer;
import net.minecraft.inventory.Container;
import net.minecraft.inventory.IInventory;
import net.minecraft.inventory.Slot;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.StatCollector;
import net.minecraft.world.World;
import net.minecraft.world.chunk.Chunk;

public class GuiInserter extends GuiContainer{

	public static final ResourceLocation texture = new ResourceLocation(References.MOD_ID.toLowerCase(), "textures/gui/itemins.png");
	public TEItemInserter tile;
	public int cooldown = 0;
	public int slotValue;
	public Coordinates coords;
	
	public GuiInserter(InventoryPlayer invPlayer, TEItemInserter entity, World world, int x, int y, int z) {
		super(new ContainerItemInserter(invPlayer, entity));
		this.tile = entity;
		this.coords = new Coordinates(x, y, z, world);
		this.tile = (TEItemInserter) world.getBlockTileEntity(x, y, z);
		xSize = 176;
		ySize = 165;
	}

	@Override
	public void drawGuiContainerBackgroundLayer(float f, int j, int i) {
		GL11.glColor4f(1F, 1F, 1F, 1F);
		mc.renderEngine.bindTexture(texture);
		drawTexturedModalRect(guiLeft, guiTop, 0, 0, xSize, ySize);
	}
	
	@Override
	public void drawGuiContainerForegroundLayer(int par1, int par2){
		if(Keyboard.isKeyDown(29)){
			this.drawString(fontRenderer, "Can Apply One Speed Upgrade", 2, 2, 1);
		}
	}
	
    @Override
	protected void keyTyped(char par1, int par2){
    	super.keyTyped(par1, par2);
    }
    
    public void updateScreen()
    {
        super.updateScreen();
    }
}

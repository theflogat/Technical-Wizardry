package fr.theflogat.chemicalPhysics.tileEntity.guis;

import java.awt.Color;
import java.util.logging.Level;

import org.lwjgl.opengl.GL11;

import fr.theflogat.chemicalPhysics.lib.LogHelper;
import fr.theflogat.chemicalPhysics.lib.References;
import fr.theflogat.chemicalPhysics.tileEntity.TileEntityElectrolyser;
import fr.theflogat.chemicalPhysics.tileEntity.container.ContainerElectrolyser;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.GuiRenameWorld;
import net.minecraft.client.gui.inventory.GuiContainer;
import net.minecraft.entity.player.InventoryPlayer;
import net.minecraft.inventory.Container;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.common.ForgeDirection;

public class GuiElectrolyser extends GuiContainer{

	public static final ResourceLocation texture = new ResourceLocation(References.MOD_ID.toLowerCase(), "textures/gui/electrolyser.png");
	public TileEntityElectrolyser tile;
	public int powerStored = 0;
	public int cooldown = 0;
	public int maxPow = 64000;
	
	public GuiElectrolyser(InventoryPlayer invPlayer, TileEntityElectrolyser entity) {
		super(new ContainerElectrolyser(invPlayer, entity));
		tile = entity;
		xSize = 176;
		ySize = 165;
		this.powerStored = tile.getEnergy();
	}

	@Override
	protected void drawGuiContainerBackgroundLayer(float f, int i, int j) {
		GL11.glColor4f(1F, 1F, 1F, 1F);
		mc.renderEngine.bindTexture(texture);
		drawTexturedModalRect(guiLeft, guiTop, 0, 0, xSize, ySize);
		
		float filledEn = powerStored / maxPow * 40;
		int barHeight = (int)(filledEn);
		LogHelper.log(Level.INFO, Integer.toString(powerStored));
		if(barHeight>0){
			int scrX = xSize;
			int scrY = 40 - barHeight;
			
			drawTexturedModalRect(guiLeft + 10, guiTop + 40, scrX, scrY, 10, barHeight);
		}
	}
	
	@Override
	public void drawGuiContainerForegroundLayer(int par1, int par2){
		
	}
	
	@Override
    public void updateScreen()
    {       
    }
}

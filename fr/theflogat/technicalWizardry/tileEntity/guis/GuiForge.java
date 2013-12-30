package fr.theflogat.technicalWizardry.tileEntity.guis;

import org.lwjgl.opengl.GL11;

import fr.theflogat.technicalWizardry.lib.References;
import fr.theflogat.technicalWizardry.tileEntity.TEForge;
import fr.theflogat.technicalWizardry.tileEntity.TEItemInserter;
import fr.theflogat.technicalWizardry.tileEntity.container.ContainerForge;
import fr.theflogat.technicalWizardry.tileEntity.container.ContainerItemInserter;

import net.minecraft.client.gui.inventory.GuiContainer;
import net.minecraft.entity.player.InventoryPlayer;
import net.minecraft.inventory.Container;
import net.minecraft.util.ResourceLocation;

public class GuiForge extends GuiContainer{

	public GuiForge(InventoryPlayer invPlayer, TEForge entity) {
		super(new ContainerForge(invPlayer, entity));
		this.tile = entity;
		xSize = 176;
		ySize = 165;
	}

	public static final ResourceLocation texture = new ResourceLocation(References.MOD_ID.toLowerCase(), "textures/gui/forge.png");
	public TEForge tile;
	public int cooldown = 0;
	public int slotValue;
	
	@Override
	public void drawGuiContainerBackgroundLayer(float f, int j, int i) {
		GL11.glColor4f(1F, 1F, 1F, 1F);
		mc.renderEngine.bindTexture(texture);
		drawTexturedModalRect(guiLeft, guiTop, 0, 0, xSize, ySize);


	}
}

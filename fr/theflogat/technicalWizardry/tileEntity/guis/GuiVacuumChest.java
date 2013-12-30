package fr.theflogat.technicalWizardry.tileEntity.guis;

import org.lwjgl.opengl.GL11;

import fr.theflogat.technicalWizardry.lib.References;
import fr.theflogat.technicalWizardry.tileEntity.TEItemInserter;
import fr.theflogat.technicalWizardry.tileEntity.TEVacuumChest;
import fr.theflogat.technicalWizardry.tileEntity.container.ContainerItemInserter;
import fr.theflogat.technicalWizardry.tileEntity.container.ContainerVacuumChest;
import net.minecraft.client.gui.inventory.GuiContainer;
import net.minecraft.entity.player.InventoryPlayer;
import net.minecraft.util.ResourceLocation;

public class GuiVacuumChest extends GuiContainer{

	public static final ResourceLocation texture = new ResourceLocation(References.MOD_ID.toLowerCase(), "textures/gui/vacchest.png");
	public TEVacuumChest tile;
	
	public GuiVacuumChest(InventoryPlayer invPlayer, TEVacuumChest entity) {
		super(new ContainerVacuumChest(invPlayer, entity));
		this.tile = entity;
		xSize = 176;
		ySize = 165;
	}
	
	@Override
	public void drawGuiContainerBackgroundLayer(float f, int j, int i) {
		GL11.glColor4f(1F, 1F, 1F, 1F);
		mc.renderEngine.bindTexture(texture);
		drawTexturedModalRect(guiLeft, guiTop, 0, 0, xSize, ySize);
	}
}

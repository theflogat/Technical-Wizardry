package fr.theflogat.technicalWizardry.tileEntity.guis;

import org.lwjgl.opengl.GL11;

import fr.theflogat.technicalWizardry.lib.References;
import fr.theflogat.technicalWizardry.tileEntity.TEBuffer;
import fr.theflogat.technicalWizardry.tileEntity.TEPlayerLinkedBlock;
import fr.theflogat.technicalWizardry.tileEntity.container.ContainerBuffer;
import fr.theflogat.technicalWizardry.tileEntity.container.ContainerPlayerLinked;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.inventory.GuiContainer;
import net.minecraft.entity.player.InventoryPlayer;
import net.minecraft.inventory.Container;
import net.minecraft.util.ResourceLocation;

public class GuiPlayerLinked extends GuiContainer{

	public static final ResourceLocation texture = new ResourceLocation(References.MOD_ID.toLowerCase(), "textures/gui/playLink.png");
	
	public GuiPlayerLinked(InventoryPlayer invPlayer, TEPlayerLinkedBlock entity) {
		super(new ContainerPlayerLinked(invPlayer, entity));

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

package fr.theflogat.technicalWizardry.tileEntity.guis;

import org.lwjgl.opengl.GL11;

import fr.theflogat.technicalWizardry.lib.References;
import fr.theflogat.technicalWizardry.tileEntity.TEBuffer;
import fr.theflogat.technicalWizardry.tileEntity.container.ContainerBuffer;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.inventory.GuiContainer;
import net.minecraft.entity.player.InventoryPlayer;
import net.minecraft.inventory.Container;
import net.minecraft.util.ResourceLocation;

public class GuiBuffer extends GuiContainer{

	public static final ResourceLocation texture = new ResourceLocation(References.MOD_ID.toLowerCase(), "textures/gui/buffer.png");
	
	public GuiBuffer(InventoryPlayer invPlayer, TEBuffer entity) {
		super(new ContainerBuffer(invPlayer, entity));

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

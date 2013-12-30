package fr.theflogat.technicalWizardry.tileEntity.guis;

import org.lwjgl.opengl.GL11;

import net.minecraft.client.gui.inventory.GuiContainer;
import net.minecraft.entity.player.InventoryPlayer;
import net.minecraft.util.ResourceLocation;
import fr.theflogat.technicalWizardry.lib.References;
import fr.theflogat.technicalWizardry.tileEntity.TEMainRitualStone;
import fr.theflogat.technicalWizardry.tileEntity.container.ContainerMainRitualStone;

public class GuiMainRitualStone extends GuiContainer{
	
	public static final ResourceLocation texture = new ResourceLocation(References.MOD_ID.toLowerCase(), "textures/gui/mainRitStone.png");
	
	public GuiMainRitualStone(InventoryPlayer invPlay, TEMainRitualStone tile){
		super(new ContainerMainRitualStone(invPlay, tile));
		
		xSize = 176;
		ySize = 165;
	}

	@Override
	protected void drawGuiContainerBackgroundLayer(float f, int i, int j) {
		GL11.glColor4f(1F, 1F, 1F, 1F);
		mc.renderEngine.bindTexture(texture);
		drawTexturedModalRect(guiLeft, guiTop, 0, 0, xSize, ySize);
	}

}

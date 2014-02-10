package fr.theflogat.redstoneFluxControl.gui;

import java.awt.Color;

import org.lwjgl.opengl.GL11;

import fr.theflogat.redstoneFluxControl.ContainerRFController;
import fr.theflogat.redstoneFluxControl.TERFController;
import fr.theflogat.redstoneFluxControl.lib.References;
import fr.theflogat.redstoneFluxControl.PacketManager;
import net.minecraft.client.gui.inventory.GuiContainer;
import net.minecraft.entity.player.InventoryPlayer;
import net.minecraft.inventory.Container;
import net.minecraft.util.ResourceLocation;

public class GuiRFController extends GuiContainer{
	
	TERFController tile;
	ResourceLocation texture = new ResourceLocation(References.MOD_ID.toLowerCase(), "textures/gui/cont.png");
	static GuiButtonRectangle[] greaterCond;

	public GuiRFController(InventoryPlayer inventory, TERFController te) {
		super(new ContainerRFController(inventory, te));
		xSize = 176;
		ySize = 165;
		tile = te;
	}
	
	static {
		greaterCond = new GuiButtonRectangle[6];
		
		for(int i=0;i<6;i++){
			greaterCond[i] = new GuiButtonRectangle(32, 16*(i+1), 9, 9, i);
		}
	}

	@Override
	protected void drawGuiContainerBackgroundLayer(float f, int mouseX, int mouseY) {
		this.fontRenderer.drawString(Integer.toString(tile.blockMetadata), guiLeft + 10, guiTop + 10, Color.GRAY.getRGB());
		GL11.glColor4f(1F, 1F, 1F, 1F);
		mc.renderEngine.bindTexture(texture);
		drawTexturedModalRect(guiLeft, guiTop, 0, 0, xSize, ySize);
		
		for(GuiButtonRectangle button : greaterCond){
			button.render(this, xSize, 0);
			if(button.isInRegion(this, mouseX, mouseY)){
				button.render(this, xSize, 9);
			}
		}
		
		this.fontRenderer.drawString("Greater than 0%", guiLeft + 32 + 12, guiTop + 16, Color.GRAY.getRGB());
		this.fontRenderer.drawString("Greater than 20%", guiLeft + 32 + 12, guiTop + 32, Color.GRAY.getRGB());
		this.fontRenderer.drawString("Greater than 40%", guiLeft + 32 + 12, guiTop + 48, Color.GRAY.getRGB());
		this.fontRenderer.drawString("Greater than 60%", guiLeft + 32 + 12, guiTop + 64, Color.GRAY.getRGB());
		this.fontRenderer.drawString("Greater than 80%", guiLeft + 32 + 12, guiTop + 80, Color.GRAY.getRGB());
		this.fontRenderer.drawString("Greater than 100%", guiLeft + 32 + 12, guiTop + 96, Color.GRAY.getRGB());
	}

	public int getLeft(){
		return guiLeft;
	}
	
	public int getTop(){
		return guiTop;
	}
	
	@Override
	protected void mouseClicked(int x, int y, int buttonID) {
		super.mouseClicked(x, y, buttonID);
		
		for(GuiButtonRectangle button : greaterCond){
			if(button.isInRegion(this, x, y)){
				PacketManager.sendButtonPacket(button.id);;
				break;
			}
		}
	}
}

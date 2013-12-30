package fr.theflogat.technicalWizardry.tileEntity.guis;

import net.minecraft.client.gui.inventory.GuiContainer;
import net.minecraft.entity.player.InventoryPlayer;
import net.minecraft.util.ResourceLocation;

import org.lwjgl.input.Keyboard;
import org.lwjgl.opengl.GL11;

import fr.theflogat.technicalWizardry.lib.References;
import fr.theflogat.technicalWizardry.tileEntity.TESpecificItemInserter;
import fr.theflogat.technicalWizardry.tileEntity.container.ContainerSpecificItemInserter;

public class GuiSpecificInserter extends GuiContainer{
	
	public static final ResourceLocation texture = new ResourceLocation(References.MOD_ID.toLowerCase(), "textures/gui/itemins.png");
	public TESpecificItemInserter tile;
	public int cooldown = 0;
	public int slotValue;
	private boolean isActive = false;
	private int reds = 0;
	
	public GuiSpecificInserter(InventoryPlayer invPlayer, TESpecificItemInserter entity) {
		super(new ContainerSpecificItemInserter(invPlayer, entity));
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
	
	@Override
	public void drawGuiContainerForegroundLayer(int par1, int par2){
/*		if(Keyboard.isKeyDown(29)){
			this.drawString(fontRenderer, "Slot:",2, 2, 1);
			reds = tile.getRedsone();
			this.drawString(fontRenderer, Integer.toString(reds) ,2, 2+8, 1);
			this.drawString(fontRenderer, "Can Apply One Speed Upgrade", 2, 2+8+8, 1);
		}*/
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

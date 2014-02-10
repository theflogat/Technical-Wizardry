package fr.theflogat.technicalWizardry.render;

import net.minecraft.client.renderer.tileentity.TileEntitySpecialRenderer;
import net.minecraft.entity.Entity;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.ResourceLocation;

import org.lwjgl.opengl.GL11;

import fr.theflogat.technicalWizardry.entity.Projectile;
import fr.theflogat.technicalWizardry.lib.References;
import fr.theflogat.technicalWizardry.render.models.ModelVacuumChest;
import fr.theflogat.technicalWizardry.tileEntity.TEVacuumChest;

public class RenderVacuumChest extends TileEntitySpecialRenderer{
	
	public static final ResourceLocation texture = new ResourceLocation(References.MOD_ID.toLowerCase(), "textures/render/vacuumChest.png");

    private final ModelVacuumChest model;
   
    public RenderVacuumChest() {
            this.model = new ModelVacuumChest();
    }

	public void RenderingVacuumChest(TEVacuumChest tile, double x, double y, double z, float yaw){
		GL11.glPushMatrix();
		GL11.glTranslatef((float)x, (float)y, (float)z);
		GL11.glScalef(-1F,-1F,1F);
		
		bindTexture(texture);
		
		GL11.glPopMatrix();
	}
	
	@Override
	public void renderTileEntityAt(TileEntity tile, double x, double y, double z, float yaw) {
		RenderingVacuumChest((TEVacuumChest) tile, x, y, z, yaw);
		
	}
}

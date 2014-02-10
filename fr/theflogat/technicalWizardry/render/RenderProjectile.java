package fr.theflogat.technicalWizardry.render;

import org.lwjgl.opengl.GL11;

import fr.theflogat.technicalWizardry.entity.Projectile;
import fr.theflogat.technicalWizardry.lib.References;
import fr.theflogat.technicalWizardry.render.models.ModelProjectile;
import net.minecraft.client.renderer.entity.Render;
import net.minecraft.entity.Entity;
import net.minecraft.util.ResourceLocation;

public class RenderProjectile extends Render{
	
	public ModelProjectile model;
	public ResourceLocation texture = new ResourceLocation(References.MOD_ID.toLowerCase(), "textures/render/proj.png");
	
	public RenderProjectile(){
		this.model = new ModelProjectile();
		shadowSize = 0.5F;
	}
	
	public void RenderProj(Projectile proj, double x, double y, double z, float yaw, float partialTickTime){
		GL11.glPushMatrix();
		GL11.glTranslatef((float)x, (float)y, (float)z);
		GL11.glScalef(-1F,-1F,1F);
		
		bindEntityTexture(proj);
		model.render(proj, 0F, 0F, 0F, 0F, 0F, 0.0625F);
		
		GL11.glPopMatrix();
	}
	
	@Override
	public void doRender(Entity entity, double x, double y, double z, float yaw, float partialTickTime) {
		RenderProj((Projectile) entity, x, y, z, yaw, partialTickTime);
	}

	@Override
	protected ResourceLocation getEntityTexture(Entity entity) {
		return texture;
	}

}

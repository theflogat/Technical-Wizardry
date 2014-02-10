package fr.theflogat.technicalWizardry.render.models;

import java.util.ArrayList;

import net.minecraft.client.model.ModelBase;
import net.minecraft.client.model.ModelRenderer;
import net.minecraft.entity.Entity;

public class ModelProjectile extends ModelBase{

	private ArrayList<ModelRenderer> parts;
	
	public ModelProjectile(){
		textureHeight = 32;
		textureWidth = 32;
		parts = new ArrayList<ModelRenderer>();
		
		ModelRenderer mainA = new ModelRenderer(this, 0, 0);
		mainA.addBox(-4,-4,0,8,8,0);
		mainA.setRotationPoint(0, 0, 0);
		parts.add(mainA);
		
		ModelRenderer mainB = new ModelRenderer(this, 0, 0);
		mainB.addBox(-4,0,-4,8,0,8);
		mainB.setRotationPoint(0, 0, 0);
		parts.add(mainB);
		
		ModelRenderer mainC = new ModelRenderer(this, 0, 0);
		mainC.addBox(0,-4,-4,0,8,8);
		mainC.setRotationPoint(0, 0, 0);
		parts.add(mainC);
	}
	
	@Override
	public void render(Entity entity, float var1, float var2, float var3, float var4, float var5, float mult) {
		for(ModelRenderer part : parts){
			part.render(mult);
		}
	}
}

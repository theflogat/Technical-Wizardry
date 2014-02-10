package fr.theflogat.technicalWizardry.render.models;

import net.minecraft.client.model.ModelBase;
import net.minecraft.client.model.ModelRenderer;
import net.minecraft.entity.Entity;

public class ModelVacuumChest extends ModelBase{
	
	    ModelRenderer Base;
	    ModelRenderer Wall_1;
	    ModelRenderer Wall_2;
	    ModelRenderer Wall_3;
	    ModelRenderer Wall_4;
	    ModelRenderer Top;

	 
	  public ModelVacuumChest()
	  {
	    textureWidth = 64;
	    textureHeight = 64;
	   
	      /**
	       * par1 offsetX
	       * par2 offsetY
	       * par3 offsetZ
	       * par4 width
	       * par5 length
	       * par6 depth
	       */
	    
	      Base = new ModelRenderer(this, 0, 36);
	      Base.addBox(-6, 23, -6, 12, 1, 12);
	      Base.offsetX = 0;
	      Base.offsetY = 0;
	      Base.offsetZ = 0;
	  }
	 
	  public void render(Entity entity, float f, float f1, float f2, float f3, float f4, float f5)
	  {
	    super.render(entity, f, f1, f2, f3, f4, f5);
	    setRotationAngles(f, f1, f2, f3, f4, f5, entity); //add entity here
	    Base.render(f5);
	    /*Pole.render(f5);
	    LightBox.render(f5);
	    Trim.render(f5);
	    FrontTop.render(f5);
	    FrontTopRight.render(f5);
	    FrontTopLeft.render(f5);
	    FrontMidLeft.render(f5);
	    FrontMid.render(f5);
	    FrontBottom.render(f5);
	    FrontBottomLeft.render(f5);
	    FrontMidRight.render(f5);
	    FrontBottomRight.render(f5);*/
	  }
	 
	 
	  private void setRotation(ModelRenderer model, float x, float y, float z)
	  {
	    model.rotateAngleX = x;
	    model.rotateAngleY = y;
	    model.rotateAngleZ = z;
	  }
	 
	  public void setRotationAngles(float f, float f1, float f2, float f3, float f4, float f5, Entity entity)
	  {
	    super.setRotationAngles(f, f1, f2, f3, f4, f5, entity);
	  }

}

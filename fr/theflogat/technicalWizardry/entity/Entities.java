package fr.theflogat.technicalWizardry.entity;

import cpw.mods.fml.common.registry.EntityRegistry;
import fr.theflogat.technicalWizardry.TechnicalWizardry;
import fr.theflogat.technicalWizardry.lib.config.Ids;
import fr.theflogat.technicalWizardry.lib.config.Names;

public class Entities {
	public static void init(){
		EntityRegistry.registerModEntity(Projectile.class, Names.Projectile_EntityName, Ids.ProjectileEntity, TechnicalWizardry.class, 80, 3, true);
	}
}

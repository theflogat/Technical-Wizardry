package fr.theflogat.technicalWizardry.entity;

import cpw.mods.fml.common.registry.EntityRegistry;
import fr.theflogat.technicalWizardry.TechnicalWizardry;

public class Entities {
	public static void init(){
		EntityRegistry.registerModEntity(MagicTransportationAeroplane.class, "Magic Transportation Aeroplane", 1, TechnicalWizardry.class, 80, 3, true);
	}
}

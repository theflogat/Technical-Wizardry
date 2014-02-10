package fr.theflogat.technicalWizardry.items.spells;

public class SpellModifiers {
	public enum Shapes{

		PROJECTILE(0, 50),
		TARGETBLOCK(1, 50),
		TARGETSELF(2, 50);
		
		public int cost;
		public int id;
		
		Shapes(int id, int cost){
			this.cost = cost;
			this.id = id;
		}

	}
	
	public enum ShapesModifier{

		ZONE(0, 50),
		AREA(1, 100);
		
		public int cost;
		public int id;
		
		ShapesModifier(int id, int cost){
			this.cost = cost;
			this.id = id;
		}

	}
	
	public enum Component{

		DAMAGE(0, 50),
		HEAL(1, 100);
		
		public int cost;
		public int id;
		
		Component(int id, int cost){
			this.cost = cost;
			this.id = id;
		}

	}
	
	public enum ComponentsModifier{

		AUGMENTATION(0, 50),
		INVERTED(1, 100);
		
		public int cost;
		public int id;
		
		ComponentsModifier(int id, int cost){
			this.cost = cost;
			this.id = id;
		}
		
		public void getEffect(ComponentsModifier compMod){
			switch(compMod.id){
			
			}
		}
	}
}

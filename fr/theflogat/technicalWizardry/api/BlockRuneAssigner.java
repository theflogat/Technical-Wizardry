package fr.theflogat.technicalWizardry.api;

public class BlockRuneAssigner{
	public enum Value{
		EARTH,
		AIR,
		WATER,
		LAVA,
		DEATH,
		LIFE,
		LIGHT,
		OBSCUR;	
	}

	
	private static int numVals = 0;
	private static int [] allIds = new int[32000];
	private static int[] allMetadata = new int[1200];
	private static Value[] allValue = new Value[2000];
	
	public BlockRuneAssigner() {}
	
	public static void setBlockValue(Value s, int ID, int meta){
		allValue[numVals] = s;
		allIds[numVals] = ID;
		allMetadata[numVals] = meta;
		++numVals;
	}
	
	public static Value[] getAllValues(){
		return allValue;
	}
	
	public static int itsLength(){
		return numVals;
	}
	
	public static int[] getAllIds(){
		return allIds;
	}
	
	public static int[] getAllMeta(){
		return allMetadata;
	}
}
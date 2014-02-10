package fr.theflogat.chemicalPhysics.api;

public class ElectrolyserRecipeHandler {
	
	private static int[] idInput = new int[2000];
	private static int[] metaInput = new int[2000];
	private static int[] idOutput_1 = new int [2000];
	private static int[] idOutput_2 = new int [2000];
	private static int[] idOutput_3 = new int [2000];
	private static int[] idOutput_4 = new int [2000];
	private static int[] idOutput_5 = new int [2000];
	private static int[] idOutput_1Meta = new int [2000];
	private static int[] idOutput_2Meta = new int [2000];
	private static int[] idOutput_3Meta = new int [2000];
	private static int[] idOutput_4Meta = new int [2000];
	private static int[] idOutput_5Meta = new int [2000];
	private static int nbRecipes = 0;
	
	public static void registerRecipe(int idIn, int idOut, int idOut2){
		idInput[nbRecipes] = idIn;
		metaInput[nbRecipes] = -1;
		idOutput_1[nbRecipes] = idOut;
		idOutput_2[nbRecipes] = idOut2;
		idOutput_3[nbRecipes] = -1;
		idOutput_4[nbRecipes] = -1;
		idOutput_5[nbRecipes] = -1;
		idOutput_1Meta[nbRecipes] = -1;
		idOutput_2Meta[nbRecipes] = -1;
		idOutput_3Meta[nbRecipes] = -1;
		idOutput_4Meta[nbRecipes] = -1;
		idOutput_5Meta[nbRecipes] = -1;
		++nbRecipes;
	}
	
	public static void registerRecipe(int idIn, int idOut, int idOut2, int idOut3){
		idInput[nbRecipes] = idIn;
		metaInput[nbRecipes] = -1;
		idOutput_1[nbRecipes] = idOut;
		idOutput_2[nbRecipes] = idOut2;
		idOutput_3[nbRecipes] = idOut3;
		idOutput_4[nbRecipes] = -1;
		idOutput_5[nbRecipes] = -1;
		idOutput_1Meta[nbRecipes] = -1;
		idOutput_2Meta[nbRecipes] = -1;
		idOutput_3Meta[nbRecipes] = -1;
		idOutput_4Meta[nbRecipes] = -1;
		idOutput_5Meta[nbRecipes] = -1;
		++nbRecipes;
	}
	
	public static void registerRecipe(int idIn, int idOut, int idOut2, int idOut3, int idOut4){
		idInput[nbRecipes] = idIn;
		metaInput[nbRecipes] = -1;
		idOutput_1[nbRecipes] = idOut;
		idOutput_2[nbRecipes] = idOut2;
		idOutput_3[nbRecipes] = idOut3;
		idOutput_4[nbRecipes] = idOut4;
		idOutput_5[nbRecipes] = -1;
		idOutput_1Meta[nbRecipes] = -1;
		idOutput_2Meta[nbRecipes] = -1;
		idOutput_3Meta[nbRecipes] = -1;
		idOutput_4Meta[nbRecipes] = -1;
		idOutput_5Meta[nbRecipes] = -1;
		++nbRecipes;
	}
	
	public static void registerRecipe(int idIn, int idOut, int idOut2, int idOut3, int idOut4, int idOut5){
		idInput[nbRecipes] = idIn;
		metaInput[nbRecipes] = -1;
		idOutput_1[nbRecipes] = idOut;
		idOutput_2[nbRecipes] = idOut2;
		idOutput_3[nbRecipes] = idOut3;
		idOutput_4[nbRecipes] = idOut4;
		idOutput_5[nbRecipes] = idOut5;
		idOutput_1Meta[nbRecipes] = -1;
		idOutput_2Meta[nbRecipes] = -1;
		idOutput_3Meta[nbRecipes] = -1;
		idOutput_4Meta[nbRecipes] = -1;
		idOutput_5Meta[nbRecipes] = -1;
		++nbRecipes;
	}
	
	/**
	 * 
	 * @param idIn
	 * @param idOut
	 * @param idOut2
	 * @param idOut3
	 * @param idOut4
	 * @param idOut5
	 * 
	 * input -1 if not wanted
	 */
	
	public static void registerRecipeWithMeta(int idIn, int metIn, int idOut, int idOut2, int idOut3, int idOut4, int idOut5, int metaidOut, int metaidOut2, int metaidOut3, int metaidOut4, int metaidOut5){
		idInput[nbRecipes] = idIn;
		metaInput[nbRecipes] = metIn;
		idOutput_1[nbRecipes] = idOut;
		idOutput_2[nbRecipes] = idOut2;
		idOutput_3[nbRecipes] = idOut3;
		idOutput_4[nbRecipes] = idOut4;
		idOutput_5[nbRecipes] = idOut5;
		idOutput_1Meta[nbRecipes] = metaidOut;
		idOutput_2Meta[nbRecipes] = metaidOut2;
		idOutput_3Meta[nbRecipes] = metaidOut3;
		idOutput_4Meta[nbRecipes] = metaidOut4;
		idOutput_5Meta[nbRecipes] = metaidOut5;
		++nbRecipes;
	}
	
	public static int[] getAllIdInput(){
		return idInput;
	}
	
	public static int[] getAllMetaInput(){
		return metaInput;
	}
	
	public static int[] getAllOutput1(){
		return idOutput_1;
	}

	public static int[] getAllOutput2(){
		return idOutput_2;
	}
	
	public static int[] getAllOutput3(){
		return idOutput_3;
	}
	
	public static int[] getAllOutput4(){
		return idOutput_4;
	}
	
	public static int[] getAllOutput5(){
		return idOutput_5;
	}
	
	public static int getNbRecipes(){
		return nbRecipes;
	}
	
	public static int[] getAllMeta1(){
		return idOutput_1Meta;
	}
	
	public static int[] getAllMeta2(){
		return idOutput_2Meta;
	}
	
	public static int[] getAllMeta3(){
		return idOutput_3Meta;
	}
	
	public static int[] getAllMeta4(){
		return idOutput_4Meta;
	}
	
	public static int[] getAllMeta5(){
		return idOutput_5Meta;
	}
}

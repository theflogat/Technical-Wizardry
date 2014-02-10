package fr.theflogat.chemicalPhysics.util;

public class LabeledInteger {
	
	public char label;
	public int value;
	
	public LabeledInteger(char par1label, int par2value){
		this.label = par1label;
		this.value = par2value;
	}
	
	public char getLabel(){
		return label;
	}

	public int getValue(){
		return value;
	}
}

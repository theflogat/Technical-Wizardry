package fr.theflogat.technicalWizardry.util;

import java.util.Random;

public class Incrementer {

	public LabeledInteger x;
	public LabeledInteger y;
	public LabeledInteger z;
	public Random random;
	public int field1;
	public int count=-1;
	public boolean alt=false;
	
	public Incrementer(Coordinates coords, int actual){
		this.x = new LabeledInteger('x', coords.getX());
		this.y = new LabeledInteger('y', coords.getY());
		this.z = new LabeledInteger('z', coords.getZ());
	}
	
	public LabeledInteger getNextPos(){
		++count;
		if(count==0){
			return this.getNextX();
		} else if(count==1){
			return this.getNextY();
		} else {
			count=-1;
			return this.getNextZ();
		}
	}
	
	public LabeledInteger getNextX(){
		alt=!alt;
		if(alt){
			return new LabeledInteger('x', -1);
		}else{
			return new LabeledInteger('x', 1);
		}
	}
	
	public LabeledInteger getNextY(){
		alt=!alt;
		if(alt){
			return new LabeledInteger('y', -1);
		}else{
			return new LabeledInteger('y', 1);
		}
	}
	
	public LabeledInteger getNextZ(){
		alt=!alt;
		if(alt){
			return new LabeledInteger('z', -1);
		}else{
			return new LabeledInteger('z', 1);
		}
	}
}

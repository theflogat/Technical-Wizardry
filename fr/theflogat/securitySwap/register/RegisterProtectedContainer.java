package fr.theflogat.securitySwap.register;

import com.google.common.annotations.Beta;

import fr.theflogat.securitySwap.world.SavingSecurity;

public class RegisterProtectedContainer {
	
	private static Coordinates[] coords;
	private static String[][] owners;
	private static int length = 0;
	
	private static final String TAG_PROTECTION_DATA = "ProtectedContainers";
	/**
	 * 
	 * @param addedCoords
	 * @param ownerName
	 * 
	 * Should Call ProtectionHelper.isAlreadyPresent(withYourCoords) before using
	 */
	
	
	public static void addNewProtection(Coordinates addedCoords, String ownerName){
		if(ProtectionHelper.isAlreadyPresent(addedCoords)){
			throw new IllegalArgumentException("Attempt to add a new Owner on an already Owned container");
		}
		coords[length] = addedCoords;
		owners[length][0] = ownerName;
		length++;
		SavingSecurity data = new SavingSecurity(TAG_PROTECTION_DATA);
		addedCoords.world().mapStorage.setData(TAG_PROTECTION_DATA, data);
	}
	
	public static void addNewOwnerToListFromCoords(Coordinates coords, String newOwnerName){
		int var1 = ProtectionHelper.getPosOfCoords(coords);
		if(var1<0){
			throw new IllegalArgumentException("Attempt to add a new Owner on a NON Owned container");
		}
		owners[var1][owners[var1].length] = newOwnerName;
	}
	
	public static Coordinates[] getCoords(){
		return coords;
	}
	
	public static String[][] getOwners(){
		return owners;
	}
	
	public static int getLength(){
		return length;
	}
}

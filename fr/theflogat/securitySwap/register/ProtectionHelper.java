package fr.theflogat.securitySwap.register;

public class ProtectionHelper {
	
	public static boolean isAlreadyPresent(Coordinates newCoords){
		Coordinates[] var1 = RegisterProtectedContainer.getCoords();
		int l = RegisterProtectedContainer.getLength();
		for(int i = 0;i<l;i++){
			if(var1[i]==newCoords){
				return false;
			}
		}
		return true;
	}
	
	public static int getPosOfCoords(Coordinates newCoords){
		Coordinates[] var1 = RegisterProtectedContainer.getCoords();
		int l = RegisterProtectedContainer.getLength();
		for(int i = 0;i<l;i++){
			if(var1[i]==newCoords){
				return l;
			}
		}
		return -1;
	}
}

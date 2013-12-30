package fr.theflogat.technicalWizardry.world;

import java.io.Serializable;

import net.minecraft.world.ChunkCoordIntPair;

public class ChunkManagement  implements Serializable{
	  public final int chunkXPos;
	  public final int chunkZPos;

	  public ChunkManagement(int par1, int par2)
	  {
	    this.chunkXPos = par1;
	    this.chunkZPos = par2;
	  }

	  public boolean equals(ChunkManagement par1Obj)
	  {
	    return (par1Obj.chunkXPos == this.chunkXPos) && (par1Obj.chunkZPos == this.chunkZPos);
	  }

	  public boolean equals(ChunkCoordIntPair par1Obj)
	  {
	    ChunkCoordIntPair var2 = par1Obj;
	    return (var2.chunkXPos == this.chunkXPos) && (var2.chunkZPos == this.chunkZPos);
	  }

	  public int getCenterXPos()
	  {
	    return (this.chunkXPos << 4) + 8;
	  }

	  public int getCenterZPosition()
	  {
	    return (this.chunkZPos << 4) + 8;
	  }

	  public String toString()
	  {
	    return "[" + this.chunkXPos + ", " + this.chunkZPos + "]";
	  }
}

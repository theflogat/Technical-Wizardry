package fr.theflogat.chemicalPhysics.handler.events;

import fr.theflogat.chemicalPhysics.api.BlockObjectCPU;
import fr.theflogat.chemicalPhysics.api.ItemObjectCPU;
import net.minecraft.item.ItemStack;
import net.minecraft.util.MovingObjectPosition;
import net.minecraft.world.World;
import net.minecraftforge.event.Event;
import net.minecraftforge.event.ForgeSubscribe;
import net.minecraftforge.event.entity.player.FillBucketEvent;

public class MercuryBucketHandler {
	  @ForgeSubscribe
	  public void onBucketFill(FillBucketEvent event)
	  {
	    ItemStack result = fillCustomBucket(event.world, event.target);

	    if (result == null)
	    {
	      return;
	    }

	    event.result = result;
	    event.setResult(Event.Result.ALLOW);
	  }

	  public ItemStack fillCustomBucket(World world, MovingObjectPosition pos)
	  {
	    int blockID = world.getBlockId(pos.blockX, pos.blockY, pos.blockZ);

	    if ((blockID == BlockObjectCPU.FluidMercury.getBlockID()) && (world.getBlockMetadata(pos.blockX, pos.blockY, pos.blockZ) == 0))
	    {
	      world.setBlock(pos.blockX, pos.blockY, pos.blockZ, 0);
	      return new ItemStack(ItemObjectCPU.MercuryBucket);
	    }

	    return null;
	  }
}

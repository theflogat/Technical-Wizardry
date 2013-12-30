package fr.theflogat.technicalWizardry.world;

import java.util.Random;

import cpw.mods.fml.common.IWorldGenerator;
import fr.theflogat.chemicalPhysics.api.BlockObjectCPU;
import fr.theflogat.technicalWizardry.api.BlockObjectTWU;
import fr.theflogat.technicalWizardry.blocks.Blocks;
import fr.theflogat.technicalWizardry.lib.config.Ids;
import fr.theflogat.technicalWizardry.lib.config.SpecialConfig;
import net.minecraft.block.Block;
import net.minecraft.world.World;
import net.minecraft.world.chunk.IChunkProvider;
import net.minecraft.world.gen.feature.WorldGenMinable;

public class WorldGeneratorTWU implements IWorldGenerator {
	       public void generate(Random random, int chunkX, int chunkZ, World world, IChunkProvider chunkGenerator, IChunkProvider chunkProvider)
	       {
	    	   worldGeneration(random, chunkX, chunkZ, world, true);
	       }
	       
	       public void worldGeneration(Random random, int chunkX, int chunkZ, World world, boolean newGen){
	    	    switch (world.provider.dimensionId) {
	    	    case -1:
	    	      //generateNether(world, random, chunkX, chunkZ, newGen); break;
	    	    case 1:
	    	      break;
	    	    default:
	    	      generateSurface(world, random, chunkX*16, chunkZ*16, newGen);
	    	    }

	    	    if (!newGen)
	    	      world.getChunkFromChunkCoords(chunkX, chunkZ).setChunkModified();
	       }
	       
	       private void generateSurface(World world, Random random, int x, int z, boolean newGen)
	       {
	    	   if(newGen || SpecialConfig.RegenLapidemMagica)
	    		   this.addOreSpawn(BlockObjectTWU.LapidemMagicaOre, world, random, x, z, 16, 16, 4 + random.nextInt(3), 5, 15, 50);
	       }
	       
	       public void addOreSpawn(Block block, World world, Random random, int blockXPos, int blockZPos, int maxX, int maxZ, int maxVeinSize, int chancesToSpawn, int minY, int maxY)
	       {
	             for(int x = 0; x < chancesToSpawn; x++)
	             {
	                    int posX = blockXPos + random.nextInt(maxX);
	                    int posY = minY + random.nextInt(maxY - minY);
	                    int posZ = blockZPos + random.nextInt(maxZ);
	                    (new WorldGenMinable(block.blockID, maxVeinSize)).generate(world, random, posX, posY, posZ);
	             }
	       }
}
package fr.theflogat.chemicalPhysics;

import java.util.Random;

import net.minecraft.block.Block;
import net.minecraft.world.World;
import net.minecraft.world.chunk.IChunkProvider;
import net.minecraft.world.gen.feature.WorldGenMinable;
import cpw.mods.fml.common.IWorldGenerator;
import fr.theflogat.chemicalPhysics.api.BlockObjectCPU;

public class WorldGeneratorCPU implements IWorldGenerator {

    public void generate(Random random, int chunkX, int chunkZ, World world, IChunkProvider chunkGenerator, IChunkProvider chunkProvider)
    {
          switch(world.provider.dimensionId)
          {
          	case 0: generateSurface(world, random, chunkX * 16, chunkZ * 16);
          }
    }
    
	private void generateSurface(World world, Random random, int x, int z)
    {
          this.addOreSpawn(BlockObjectCPU.BlockFluidMercury, world, random, x, z, 16, 16, 20 + random.nextInt(11), 5, 5, 100);
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
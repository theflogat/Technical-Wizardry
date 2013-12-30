package fr.theflogat.technicalWizardry.handler;

import net.minecraft.block.Block;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraftforge.oredict.ShapedOreRecipe;
import cpw.mods.fml.common.registry.GameRegistry;
import fr.theflogat.technicalWizardry.api.BlockObjectTWU;
import fr.theflogat.technicalWizardry.api.BlockRuneAssigner;
import fr.theflogat.technicalWizardry.api.ItemObjectTWU;
import fr.theflogat.technicalWizardry.api.BlockRuneAssigner.Value;
import fr.theflogat.technicalWizardry.lib.config.Names;

public class Recipes {

	public static void init(){
		registerRecipes();
		registerValues();
	}
	
	private static void registerValues() {
			BlockRuneAssigner.setBlockValue(Value.EARTH, Block.dirt.blockID, 0);
			BlockRuneAssigner.setBlockValue(Value.WATER, Block.waterStill.blockID, 0);
			BlockRuneAssigner.setBlockValue(Value.LAVA, Block.lavaStill.blockID, 0);
			BlockRuneAssigner.setBlockValue(Value.DEATH, Block.slowSand.blockID, 0);
			BlockRuneAssigner.setBlockValue(Value.DEATH, Block.netherBrick.blockID, 0);
			BlockRuneAssigner.setBlockValue(Value.LIFE, Block.sapling.blockID, 0);
			BlockRuneAssigner.setBlockValue(Value.LIFE, Block.sapling.blockID, 1);
			BlockRuneAssigner.setBlockValue(Value.LIFE, Block.sapling.blockID, 2);
			BlockRuneAssigner.setBlockValue(Value.LIFE, Block.sapling.blockID, 3);
			BlockRuneAssigner.setBlockValue(Value.LIFE, Block.wood.blockID, 0);
			BlockRuneAssigner.setBlockValue(Value.LIFE, Block.wood.blockID, 1);
			BlockRuneAssigner.setBlockValue(Value.LIFE, Block.wood.blockID, 2);
			BlockRuneAssigner.setBlockValue(Value.LIFE, Block.wood.blockID, 3);
			BlockRuneAssigner.setBlockValue(Value.EARTH, Block.grass.blockID, 0);
			BlockRuneAssigner.setBlockValue(Value.LIGHT, Block.glowStone.blockID, 0);
			BlockRuneAssigner.setBlockValue(Value.OBSCUR, Block.obsidian.blockID, 0);
			BlockRuneAssigner.setBlockValue(Value.WATER, Item.bucketWater.itemID, 0);
			BlockRuneAssigner.setBlockValue(Value.LAVA, Item.bucketLava.itemID, 0);
			BlockRuneAssigner.setBlockValue(Value.AIR, BlockObjectTWU.FeatherBlock.blockID, 0);
			BlockRuneAssigner.setBlockValue(Value.AIR, Item.feather.itemID, 0);
	}

	private static void registerRecipes(){
			GameRegistry.addRecipe(new ItemStack(BlockObjectTWU.FeatherBlock.blockID, 1,0), new Object[]{
				"FF",
				"FF",
				'F', Item.feather
			});
			GameRegistry.addRecipe(new ItemStack(BlockObjectTWU.ShieldBlocks.blockID, 8,0), new Object[]{
				" I ",
				"OOO",
				" I ",
				'I', Block.blockIron, 'O', Block.obsidian
			});
			GameRegistry.addRecipe(new ItemStack(BlockObjectTWU.MagnetBlock.blockID, 1,0), new Object[]{
				"MMM",
				"MIM",
				"MMM",
				'I', Block.blockIron, 'M', new ItemStack(ItemObjectTWU.RuneChaos_Meta, 1, 1)
			});
			GameRegistry.addShapelessRecipe(new ItemStack(Item.feather, 4), new Object[]{
				BlockObjectTWU.FeatherBlock
			});
			GameRegistry.addRecipe(new ItemStack(BlockObjectTWU.Forge, 1 , 0), new Object[]{
				"GCG",
				"GAG",
				"RCR",
				'C', Block.workbench, 'A', ItemObjectTWU.RuneAssembler, 'R', Item.redstone,'G',Item.ingotGold
			});
			GameRegistry.addRecipe(new ItemStack(BlockObjectTWU.ItemInserter, 1 , 0), new Object[]{
				"MHM",
				"SMS",
				"III",
				'H', Block.hopperBlock, 'M', new ItemStack(ItemObjectTWU.RuneChaos_Meta, 1, 1), 'S', Block.stone,'I',Item.ingotIron
			});
			GameRegistry.addRecipe(new ItemStack(BlockObjectTWU.SpecificItemInserter, 1 , 0), new Object[]{
				"RRR",
				"RIR",
				"RRR",
				'R', Item.redstone, 'I', BlockObjectTWU.ItemInserter
			});
			GameRegistry.addRecipe(new ItemStack(ItemObjectTWU.Rune, 1), new Object[]{
			"CIC",
			"CPC",	
			"CIC",
			'C', Block.cobblestone, 'I', Item.clay, 'P', Item.paper
			});
			GameRegistry.addRecipe(new ItemStack(ItemObjectTWU.RuneAssembler, 1), new Object[]{
			"B B",
			"bFb",
			"B B",
			'F', Block.furnaceIdle, 'b', Item.blazePowder,'B', Item.blazeRod
			});
			GameRegistry.addRecipe(new ItemStack(ItemObjectTWU.DimensionalLife, 1), new Object[]{
			"GMG",
			"BSB",
			"DGD",
			'S', ItemObjectTWU.Sacrificer, 'G', Item.ghastTear,'B', Item.blazeRod, 'M', new ItemStack(ItemObjectTWU.RuneChaos_Meta, 1, 1), 'D', new ItemStack(ItemObjectTWU.RuneChaos_Meta, 1, 2)
			});
			GameRegistry.addRecipe(new ItemStack(ItemObjectTWU.SpeedyBread, 1), new Object[]{
			"RRR",
			"RBR",
			"RRR",
			'R', new ItemStack(ItemObjectTWU.RuneChaos_Meta, 1, 1) ,'B', Item.bread
			});
			GameRegistry.addRecipe(new ItemStack(ItemObjectTWU.MovementAmulet, 1, 0), new Object[]{
			"CDC",
			"PRP",
			"AAA",
			'R', ItemObjectTWU.Rune, 'D', Block.blockDiamond, 'P', new ItemStack(Item.potion, 1, 8194), 'C', new ItemStack(ItemObjectTWU.RuneChaos_Meta, 1, 1), 'A', ItemObjectTWU.RuneAir
			});
			GameRegistry.addRecipe(new ItemStack(ItemObjectTWU.Sacrificer, 1), new Object[]{
			"GMG",
			"BSB",
			"DGD",
			'S', Item.swordDiamond, 'G', Item.ghastTear,'B', Item.blazeRod, 'M', new ItemStack(ItemObjectTWU.RuneChaos_Meta, 1, 1), 'D', new ItemStack(ItemObjectTWU.RuneChaos_Meta, 1, 2)
			});
			for(int i = 1; i<Names.MovementAmulet_MetaItemName.length;i++){
				GameRegistry.addRecipe(new ItemStack(ItemObjectTWU.MovementAmulet, 1, i), new Object[]{
					"CDC",
					"PRP",
					"AAA",
				'R', new ItemStack(ItemObjectTWU.MovementAmulet, 1, (i-1)), 'D', Block.blockDiamond, 'P', new ItemStack(Item.potion, 1, 8194), 'C', new ItemStack(ItemObjectTWU.RuneChaos_Meta, 1, 1), 'A', ItemObjectTWU.RuneAir
				});
			}
			GameRegistry.addRecipe(new ItemStack(ItemObjectTWU.SmoothCutter, 1, 0), new Object[]{
					"MSM",
					"OPO",
					"OCO",
					'C', Item.sugar, 'P', Item.pickaxeDiamond, 'M',  new ItemStack(ItemObjectTWU.RuneChaos_Meta, 1, 1), 'S',  new ItemStack(ItemObjectTWU.RuneChaos_Meta, 1, 0), 'O', Block.obsidian
			});
			GameRegistry.addRecipe(new ItemStack(BlockObjectTWU.Buffer, 8 , 0), new Object[]{
				" O ",
				" C ",
				" I ",
				'O',Block.obsidian, 'C',Block.chest, 'I',Item.ingotIron
			});
			GameRegistry.addRecipe(new ItemStack(BlockObjectTWU.VacuumChest, 1 , 0), new Object[]{
				"ERE",
				"GCG",
				"OMO",
				'O',Block.obsidian, 'C',Block.chest, 'G',Item.ingotGold, 'E', Item.enderPearl, 'R',Item.eyeOfEnder, 'M', new ItemStack(ItemObjectTWU.RuneChaos_Meta,1,1)
			});
			GameRegistry.addRecipe(new ItemStack(ItemObjectTWU.SpeedUpgrade, 1 , 0), new Object[]{
				"SRS",
				"GEG",
				"SRS",
				'S', Item.sugar, 'G',Item.ingotGold, 'E', Item.blazePowder, 'R',Item.redstone
			});
			GameRegistry.addRecipe(new ItemStack(ItemObjectTWU.InformationReader, 1 , 0), new Object[]{
				"RPR",
				"MIM",
				"MMM",
				'M', ItemObjectTWU.LapidemMagica, 'P',Item.paper, 'I', new ItemStack(Item.dyePowder,1,0), 'R',Item.redstone
			});
			GameRegistry.addRecipe(new ItemStack(ItemObjectTWU.PlayerLink, 1 , 0), new Object[]{
				"MPM",
				"PIP",
				"MPM",
				'M', ItemObjectTWU.LapidemMagica, 'P',Item.paper, 'I', Item.enderPearl
			});
			GameRegistry.addRecipe(new ShapedOreRecipe(BlockObjectTWU.PlayerLinkedBlock, true, new Object[]{
				"MIM",
				"SCS",
				"MSM",
				Character.valueOf('M'), ItemObjectTWU.LapidemMagica, Character.valueOf('S'), Block.stone, Character.valueOf('I'), Item.enderPearl, Character.valueOf('C'), Block.chest
			}));
			GameRegistry.addShapelessRecipe(new ItemStack(ItemObjectTWU.RuneChaos_Meta, 1, 0), new Object[]{
				ItemObjectTWU.RuneAssembler, ItemObjectTWU.RuneLava, ItemObjectTWU.RuneWater
			});
			GameRegistry.addShapelessRecipe(new ItemStack(ItemObjectTWU.RuneChaos_Meta, 1, 1), new Object[]{
				ItemObjectTWU.RuneAssembler, ItemObjectTWU.RuneAir, ItemObjectTWU.RuneEarth
			});
			GameRegistry.addShapelessRecipe(new ItemStack(ItemObjectTWU.RuneChaos_Meta, 1, 2), new Object[]{
				ItemObjectTWU.RuneAssembler, ItemObjectTWU.RuneLife, ItemObjectTWU.RuneDeath
			});
			GameRegistry.addShapelessRecipe(new ItemStack(ItemObjectTWU.RuneChaos_Meta, 1, 3), new Object[]{
				ItemObjectTWU.RuneAssembler, ItemObjectTWU.RuneLight, ItemObjectTWU.RuneObscurous
			});
	}
}

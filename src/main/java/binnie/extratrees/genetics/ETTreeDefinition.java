package binnie.extratrees.genetics;

import binnie.Constants;
import binnie.core.genetics.ForestryAllele;
import binnie.extratrees.block.EnumExtraTreeLog;
import binnie.extratrees.gen.*;
import forestry.api.arboriculture.*;
import forestry.api.genetics.AlleleManager;
import forestry.api.genetics.IAllele;
import forestry.api.genetics.IChromosomeType;
import forestry.api.genetics.IClassification;
import forestry.api.world.ITreeGenData;
import forestry.arboriculture.PluginArboriculture;
import forestry.arboriculture.genetics.ITreeDefinition;
import forestry.arboriculture.genetics.Tree;
import forestry.arboriculture.tiles.TileLeaves;
import forestry.arboriculture.worldgen.WorldGenLemon;
import forestry.arboriculture.worldgen.WorldGenPlum;
import forestry.core.genetics.alleles.AlleleBoolean;
import forestry.core.tiles.TileUtil;
import net.minecraft.block.Block;
import net.minecraft.block.BlockLog;
import net.minecraft.block.state.IBlockState;
import net.minecraft.item.ItemStack;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.IStringSerializable;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraft.world.gen.feature.WorldGenerator;
import org.apache.commons.lang3.StringUtils;

import com.mojang.authlib.GameProfile;

import java.awt.*;
import java.util.Arrays;
import java.util.Locale;

public enum ETTreeDefinition implements IStringSerializable, ITreeDefinition, ITreeGenerator {
	OrchardApple("malus", "domestica", EnumLeafType.DECIDUOUS, new Color(0x09E67E), new Color(0xFF9CF3),EnumSaplingType.Default, EnumExtraTreeLog.Apple, new Color(0x7B7A7B)){
		
		@Override
		public WorldGenerator getWorldGenerator(ITreeGenData tree) {
			return new WorldGenApple.OrchardApple(tree);
		}
		
		@Override
		protected void setAlleles(AlleleTemplate template) {
			template.set(EnumTreeChromosome.FRUITS, AlleleETFruit.Apple);
			template.set(EnumTreeChromosome.YIELD, ForestryAllele.Yield.Higher.getAllele());
		}

		@Override
		protected void setSpeciesProperties(IAlleleTreeSpeciesBuilder species) {
			species.addFruitFamily(AlleleManager.alleleRegistry.getFruitFamily("forestry.pomes"));
			species.addFruitFamily(AlleleManager.alleleRegistry.getFruitFamily("forestry.prunes"));
			species.addFruitFamily(ETFruitFamily.Citrus);
		}
	},
	SweetCrabapple("malus", "coronaria", EnumLeafType.DECIDUOUS, new Color(0x7A9953), new Color(0xFC359F),EnumSaplingType.Default, EnumExtraTreeLog.Apple, new Color(0x7B7A7B)){
		
		@Override
		public WorldGenerator getWorldGenerator(ITreeGenData tree) {
			return new WorldGenApple.SweetCrabapple(tree);
		}
		
		@Override
		protected void setAlleles(AlleleTemplate template) {
			template.set(EnumTreeChromosome.FRUITS, AlleleETFruit.Crabapple);
			template.set(EnumTreeChromosome.YIELD, ForestryAllele.Yield.High.getAllele());
			template.set(EnumTreeChromosome.SAPPINESS, ForestryAllele.Sappiness.Average.getAllele());
			template.set(EnumTreeChromosome.MATURATION, ForestryAllele.Maturation.Fast.getAllele());
		}

		@Override
		protected void setSpeciesProperties(IAlleleTreeSpeciesBuilder species) {
			species.addFruitFamily(AlleleManager.alleleRegistry.getFruitFamily("forestry.pomes"));
			species.addFruitFamily(AlleleManager.alleleRegistry.getFruitFamily("forestry.prunes"));
			species.addFruitFamily(ETFruitFamily.Citrus);
		}
	},
	FloweringCrabapple("malus", "hopa", EnumLeafType.DECIDUOUS, new Color(0x7A9953), new Color(0xFC359F),EnumSaplingType.Default, EnumExtraTreeLog.Apple, new Color(0x7B7A7B)){
		
		@Override
		public WorldGenerator getWorldGenerator(ITreeGenData tree) {
			return new WorldGenApple.FloweringCrabapple(tree);
		}
		
		@Override
		protected void setAlleles(AlleleTemplate template) {
			template.set(EnumTreeChromosome.FRUITS, AlleleETFruit.Crabapple);
			template.set(EnumTreeChromosome.FERTILITY, ForestryAllele.Saplings.Average.getAllele());
			template.set(EnumTreeChromosome.YIELD, ForestryAllele.Yield.Average.getAllele());
			template.set(EnumTreeChromosome.SAPPINESS, ForestryAllele.Sappiness.Low.getAllele());
			template.set(EnumTreeChromosome.MATURATION, ForestryAllele.Maturation.Fast.getAllele());
		}

		@Override
		protected void setSpeciesProperties(IAlleleTreeSpeciesBuilder species) {
			species.addFruitFamily(AlleleManager.alleleRegistry.getFruitFamily("forestry.pomes"));
			species.addFruitFamily(AlleleManager.alleleRegistry.getFruitFamily("forestry.prunes"));
			species.addFruitFamily(ETFruitFamily.Citrus);
		}
	},
	PrairieCrabapple("malus", "ioensis", EnumLeafType.DECIDUOUS, new Color(0x7A9953), new Color(0xFC359F), EnumSaplingType.Default, EnumExtraTreeLog.Apple, new Color(0x7B7A7B)){
		
		@Override
		public WorldGenerator getWorldGenerator(ITreeGenData tree) {
			return new WorldGenApple.PrairieCrabapple(tree);
		}
		
		@Override
		protected void setAlleles(AlleleTemplate template) {
			template.set(EnumTreeChromosome.FRUITS, AlleleETFruit.Crabapple);
			template.set(EnumTreeChromosome.HEIGHT, ForestryAllele.TreeHeight.Smallest.getAllele());
			template.set(EnumTreeChromosome.FERTILITY, ForestryAllele.Saplings.Low.getAllele());
			template.set(EnumTreeChromosome.YIELD, ForestryAllele.Yield.Average.getAllele());
			template.set(EnumTreeChromosome.SAPPINESS, ForestryAllele.Sappiness.Average.getAllele());
		}

		@Override
		protected void setSpeciesProperties(IAlleleTreeSpeciesBuilder species) {
			species.addFruitFamily(AlleleManager.alleleRegistry.getFruitFamily("forestry.pomes"));
			species.addFruitFamily(AlleleManager.alleleRegistry.getFruitFamily("forestry.prunes"));
			species.addFruitFamily(ETFruitFamily.Citrus);
		}
	},
	Blackthorn("prunus", "spinosa", EnumLeafType.DECIDUOUS, new Color(0x6D8F1E), new Color(0xFF87C7), EnumSaplingType.Fruit, EnumForestryWoodType.PLUM, new Color(0xB68661)){
		
		@Override
		public WorldGenerator getWorldGenerator(ITreeGenData tree) {
			return new WorldGenPlum(tree);
		}
		
		@Override
		protected void setAlleles(AlleleTemplate template)  {
			template.set(EnumTreeChromosome.FRUITS, AlleleETFruit.Blackthorn);
			template.set(EnumTreeChromosome.HEIGHT,ForestryAllele.TreeHeight.Smallest.getAllele());
			template.set(EnumTreeChromosome.YIELD,ForestryAllele.Yield.Low.getAllele());
			template.set(EnumTreeChromosome.SAPPINESS,ForestryAllele.Sappiness.Average.getAllele());
			template.set(EnumTreeChromosome.MATURATION, ForestryAllele.Maturation.Fast.getAllele());
		}

		@Override
		protected void setSpeciesProperties(IAlleleTreeSpeciesBuilder species) {
			species.addFruitFamily(AlleleManager.alleleRegistry.getFruitFamily("forestry.pomes"));
			species.addFruitFamily(AlleleManager.alleleRegistry.getFruitFamily("forestry.prunes"));
			species.addFruitFamily(ETFruitFamily.Citrus);
		}
	},
	CherryPlum("prunus", "cerasifera", EnumLeafType.DECIDUOUS, new Color(0x6D8F1E), new Color(0xFF87C7), EnumSaplingType.Fruit, EnumForestryWoodType.PLUM, new Color(0xB68661)){
		
		@Override
		public WorldGenerator getWorldGenerator(ITreeGenData tree) {
			return new WorldGenPlum(tree);
		}
		
		@Override
		protected void setAlleles(AlleleTemplate template)  {
			template.set(EnumTreeChromosome.FRUITS, AlleleETFruit.CherryPlum);
			template.set(EnumTreeChromosome.HEIGHT, ForestryAllele.TreeHeight.Smallest.getAllele());
			template.set(EnumTreeChromosome.YIELD, ForestryAllele.Yield.Lower.getAllele());
			template.set(EnumTreeChromosome.SAPPINESS,ForestryAllele.Sappiness.Average.getAllele());
			template.set(EnumTreeChromosome.MATURATION, ForestryAllele.Maturation.Fast.getAllele());
		}

		@Override
		protected void setSpeciesProperties(IAlleleTreeSpeciesBuilder species) {
			species.addFruitFamily(AlleleManager.alleleRegistry.getFruitFamily("forestry.pomes"));
			species.addFruitFamily(AlleleManager.alleleRegistry.getFruitFamily("forestry.prunes"));
			species.addFruitFamily(ETFruitFamily.Citrus);
		}
	},
	Peach("prunus", "persica", EnumLeafType.DECIDUOUS, new Color(0x6D8F1E), new Color(0xFF269A), EnumSaplingType.Fruit, EnumForestryWoodType.PLUM, new Color(0xB68661)){
		
		@Override
		public WorldGenerator getWorldGenerator(ITreeGenData tree) {
			return new WorldGenPlum(tree);
		}
		
		@Override
		protected void setAlleles(AlleleTemplate template)  {
			template.set(EnumTreeChromosome.FRUITS, AlleleETFruit.Peach);
			template.set(EnumTreeChromosome.HEIGHT, ForestryAllele.TreeHeight.Smallest.getAllele());
			template.set(EnumTreeChromosome.FERTILITY, ForestryAllele.Saplings.Low.getAllele());
			template.set(EnumTreeChromosome.YIELD, ForestryAllele.Yield.Average.getAllele());
			template.set(EnumTreeChromosome.SAPPINESS, ForestryAllele.Sappiness.Average.getAllele());
		}

		@Override
		protected void setSpeciesProperties(IAlleleTreeSpeciesBuilder species) {
			species.addFruitFamily(AlleleManager.alleleRegistry.getFruitFamily("forestry.pomes"));
			species.addFruitFamily(AlleleManager.alleleRegistry.getFruitFamily("forestry.prunes"));
			species.addFruitFamily(ETFruitFamily.Citrus);
		}
	},
	Nectarine("prunus", "nectarina", EnumLeafType.DECIDUOUS, new Color(0x6D8F1E), new Color(0xFF269A), EnumSaplingType.Fruit, EnumForestryWoodType.PLUM, new Color(0xB68661)){
		
		@Override
		public WorldGenerator getWorldGenerator(ITreeGenData tree) {
			return new WorldGenPlum(tree);
		}
		
		@Override
		protected void setAlleles(AlleleTemplate template)  {
			template.set(EnumTreeChromosome.FRUITS, AlleleETFruit.Nectarine);
			template.set(EnumTreeChromosome.HEIGHT, ForestryAllele.TreeHeight.Smallest.getAllele());
			template.set(EnumTreeChromosome.YIELD, ForestryAllele.Yield.Average.getAllele());
			template.set(EnumTreeChromosome.SAPPINESS, ForestryAllele.Sappiness.Average.getAllele());
		}

		@Override
		protected void setSpeciesProperties(IAlleleTreeSpeciesBuilder species) {
			species.addFruitFamily(AlleleManager.alleleRegistry.getFruitFamily("forestry.pomes"));
			species.addFruitFamily(AlleleManager.alleleRegistry.getFruitFamily("forestry.prunes"));
			species.addFruitFamily(ETFruitFamily.Citrus);
		}
	},
	Apricot("prunus", "armeniaca", EnumLeafType.DECIDUOUS, new Color(0x6D8F1E), new Color(0xF5B8D8), EnumSaplingType.Fruit, EnumForestryWoodType.PLUM, new Color(0xB68661)){
		
		@Override
		public WorldGenerator getWorldGenerator(ITreeGenData tree) {
			return new WorldGenPlum(tree);
		}
		
		@Override
		protected void setAlleles(AlleleTemplate template)  {
			template.set(EnumTreeChromosome.FRUITS, AlleleETFruit.Apricot);
			template.set(EnumTreeChromosome.HEIGHT, ForestryAllele.TreeHeight.Smallest.getAllele());
			template.set(EnumTreeChromosome.YIELD, ForestryAllele.Yield.Low.getAllele());
			template.set(EnumTreeChromosome.SAPPINESS, ForestryAllele.Sappiness.Average.getAllele());
		}

		@Override
		protected void setSpeciesProperties(IAlleleTreeSpeciesBuilder species) {
			species.addFruitFamily(AlleleManager.alleleRegistry.getFruitFamily("forestry.pomes"));
			species.addFruitFamily(AlleleManager.alleleRegistry.getFruitFamily("forestry.prunes"));
			species.addFruitFamily(ETFruitFamily.Citrus);
		}
	},
	Almond("prunus", "amygdalus", EnumLeafType.DECIDUOUS, new Color(0x6D8F1E), new Color(0xF584C0), EnumSaplingType.Fruit, EnumForestryWoodType.PLUM, new Color(0xB68661)){
		
		@Override
		public WorldGenerator getWorldGenerator(ITreeGenData tree) {
			return new WorldGenPlum(tree);
		}
		
		@Override
		protected void setAlleles(AlleleTemplate template)  {
			template.set(EnumTreeChromosome.FRUITS, AlleleETFruit.Almond);
			template.set(EnumTreeChromosome.YIELD, ForestryAllele.Yield.Lower.getAllele());
			template.set(EnumTreeChromosome.SAPPINESS, ForestryAllele.Sappiness.Lower.getAllele());
			template.set(EnumTreeChromosome.MATURATION, ForestryAllele.Maturation.Fast.getAllele());;
		}

		@Override
		protected void setSpeciesProperties(IAlleleTreeSpeciesBuilder species) {
			species.addFruitFamily(AlleleManager.alleleRegistry.getFruitFamily("forestry.pomes"));
			species.addFruitFamily(AlleleManager.alleleRegistry.getFruitFamily("forestry.prunes"));
			species.addFruitFamily(ETFruitFamily.Citrus);
		}
	},
	WildCherry("prunus", "avium", EnumLeafType.DECIDUOUS, new Color(0x6D8F1E), new Color(0xF7EBF6), EnumSaplingType.Fruit, EnumExtraTreeLog.Cherry, new Color(0x716850)){
		
		@Override
		public WorldGenerator getWorldGenerator(ITreeGenData tree) {
			return new WorldGenPlum(tree);
		}
		
		@Override
		protected void setAlleles(AlleleTemplate template)  {
			template.set(EnumTreeChromosome.FRUITS, AlleleETFruit.WildCherry);
			template.set(EnumTreeChromosome.HEIGHT, ForestryAllele.TreeHeight.Smallest.getAllele());
			template.set(EnumTreeChromosome.FERTILITY, ForestryAllele.Saplings.Low.getAllele());
			template.set(EnumTreeChromosome.YIELD, ForestryAllele.Yield.Lower.getAllele());
			template.set(EnumTreeChromosome.SAPPINESS, ForestryAllele.Sappiness.Low.getAllele());
			template.set(EnumTreeChromosome.MATURATION, ForestryAllele.Maturation.Fast.getAllele());
		}

		@Override
		protected void setSpeciesProperties(IAlleleTreeSpeciesBuilder species) {
			species.addFruitFamily(AlleleManager.alleleRegistry.getFruitFamily("forestry.pomes"));
			species.addFruitFamily(AlleleManager.alleleRegistry.getFruitFamily("forestry.prunes"));
			species.addFruitFamily(ETFruitFamily.Citrus);
		}
	},
	SourCherry("prunus", "cerasus", EnumLeafType.DECIDUOUS, new Color(0x6D8F1E), new Color(0xF7EBF6), EnumSaplingType.Fruit, EnumExtraTreeLog.Cherry, new Color(0x716850)){
		
		@Override
		public WorldGenerator getWorldGenerator(ITreeGenData tree) {
			return new WorldGenPlum(tree);
		}
		
		@Override
		protected void setAlleles(AlleleTemplate template)  {
			template.set(EnumTreeChromosome.FRUITS, AlleleETFruit.SourCherry);
			template.set(EnumTreeChromosome.YIELD, ForestryAllele.Yield.Lower.getAllele());
			template.set(EnumTreeChromosome.SAPPINESS, ForestryAllele.Sappiness.Low.getAllele());;
		}

		@Override
		protected void setSpeciesProperties(IAlleleTreeSpeciesBuilder species) {
			species.addFruitFamily(AlleleManager.alleleRegistry.getFruitFamily("forestry.pomes"));
			species.addFruitFamily(AlleleManager.alleleRegistry.getFruitFamily("forestry.prunes"));
			species.addFruitFamily(ETFruitFamily.Citrus);
		}
	},
	BlackCherry("prunus", "serotina", EnumLeafType.DECIDUOUS, new Color(0x6D8F1E), new Color(0xFAE1F8), EnumSaplingType.Fruit, EnumExtraTreeLog.Cherry, new Color(0x716850)){
		
		@Override
		public WorldGenerator getWorldGenerator(ITreeGenData tree) {
			return new WorldGenPlum(tree);
		}
		
		@Override
		protected void setAlleles(AlleleTemplate template) {
			template.set(EnumTreeChromosome.FRUITS, AlleleETFruit.BlackCherry);
			template.set(EnumTreeChromosome.HEIGHT, ForestryAllele.TreeHeight.Smallest.getAllele());
			template.set(EnumTreeChromosome.FERTILITY, ForestryAllele.Saplings.Lowest.getAllele());
			template.set(EnumTreeChromosome.YIELD, ForestryAllele.Yield.Average.getAllele());
			template.set(EnumTreeChromosome.SAPPINESS, ForestryAllele.Sappiness.Lower.getAllele());
			template.set(EnumTreeChromosome.MATURATION, ForestryAllele.Maturation.Fast.getAllele());
		}

		@Override
		protected void setSpeciesProperties(IAlleleTreeSpeciesBuilder species) {
			species.addFruitFamily(AlleleManager.alleleRegistry.getFruitFamily("forestry.pomes"));
			species.addFruitFamily(AlleleManager.alleleRegistry.getFruitFamily("forestry.prunes"));
			species.addFruitFamily(ETFruitFamily.Citrus);
		}
	},
	Orange("citrus", "sinensis", EnumLeafType.JUNGLE, new Color(0x88AF54), new Color(0xA3B850), EnumSaplingType.Fruit, EnumForestryWoodType.CITRUS, new Color(0x5B4B39)){
		
		@Override
		public WorldGenerator getWorldGenerator(ITreeGenData tree) {
			return new WorldGenLemon(tree);
		}
		
		@Override
		protected void setAlleles(AlleleTemplate template)  {
			template.set(EnumTreeChromosome.FRUITS, AlleleETFruit.Orange);
			template.set(EnumTreeChromosome.HEIGHT, ForestryAllele.TreeHeight.Smallest.getAllele());
			template.set(EnumTreeChromosome.YIELD, ForestryAllele.Yield.Average.getAllele());
			template.set(EnumTreeChromosome.SAPPINESS, ForestryAllele.Sappiness.Average.getAllele());
			template.set(EnumTreeChromosome.MATURATION, ForestryAllele.Maturation.Fast.getAllele());
		}

		@Override
		protected void setSpeciesProperties(IAlleleTreeSpeciesBuilder species) {
			species.addFruitFamily(AlleleManager.alleleRegistry.getFruitFamily("forestry.pomes"));
			species.addFruitFamily(AlleleManager.alleleRegistry.getFruitFamily("forestry.prunes"));
			species.addFruitFamily(ETFruitFamily.Citrus);
		}
	},
	Manderin("citrus", "reticulata", EnumLeafType.JUNGLE, new Color(0x88AF54), new Color(0xA3B850), EnumSaplingType.Fruit, EnumForestryWoodType.CITRUS, new Color(0x5B4B39)){
		
		@Override
		public WorldGenerator getWorldGenerator(ITreeGenData tree) {
			return new WorldGenLemon(tree);
		}
		
		@Override
		protected void setAlleles(AlleleTemplate template)  {
			template.set(EnumTreeChromosome.FRUITS, AlleleETFruit.Manderin);
			template.set(EnumTreeChromosome.HEIGHT, ForestryAllele.TreeHeight.Smallest.getAllele());
			template.set(EnumTreeChromosome.FERTILITY, ForestryAllele.Saplings.Low.getAllele());
			template.set(EnumTreeChromosome.YIELD, ForestryAllele.Yield.High.getAllele());
			template.set(EnumTreeChromosome.SAPPINESS, ForestryAllele.Sappiness.Low.getAllele());
		}

		@Override
		protected void setSpeciesProperties(IAlleleTreeSpeciesBuilder species) {
			species.addFruitFamily(AlleleManager.alleleRegistry.getFruitFamily("forestry.pomes"));
			species.addFruitFamily(AlleleManager.alleleRegistry.getFruitFamily("forestry.prunes"));
			species.addFruitFamily(ETFruitFamily.Citrus);
		}
	},
	Satsuma("citrus", "unshiu", EnumLeafType.JUNGLE, new Color(0x88AF54), new Color(0xA3B850), EnumSaplingType.Fruit, EnumForestryWoodType.CITRUS, new Color(0x5B4B39)){
		
		@Override
		public WorldGenerator getWorldGenerator(ITreeGenData tree) {
			return new WorldGenLemon(tree);
		}
		
		@Override
		protected void setAlleles(AlleleTemplate template)  {
			template.set(EnumTreeChromosome.FRUITS, AlleleETFruit.Satsuma);
			template.set(EnumTreeChromosome.HEIGHT, ForestryAllele.TreeHeight.Smallest.getAllele());
			template.set(EnumTreeChromosome.YIELD, ForestryAllele.Yield.Low.getAllele());
			template.set(EnumTreeChromosome.SAPPINESS, ForestryAllele.Sappiness.Low.getAllele());
			template.set(EnumTreeChromosome.MATURATION, ForestryAllele.Maturation.Fast.getAllele());
		}

		@Override
		protected void setSpeciesProperties(IAlleleTreeSpeciesBuilder species) {
			species.addFruitFamily(AlleleManager.alleleRegistry.getFruitFamily("forestry.pomes"));
			species.addFruitFamily(AlleleManager.alleleRegistry.getFruitFamily("forestry.prunes"));
			species.addFruitFamily(ETFruitFamily.Citrus);
		}
	},
	Tangerine("citrus", "tangerina", EnumLeafType.JUNGLE, new Color(0x88AF54), new Color(0xA3B850), EnumSaplingType.Fruit, EnumForestryWoodType.CITRUS, new Color(0x5B4B39)){
		
		@Override
		public WorldGenerator getWorldGenerator(ITreeGenData tree) {
			return new WorldGenLemon(tree);
		}
		
		@Override
		protected void setAlleles(AlleleTemplate template)  {
			template.set(EnumTreeChromosome.FRUITS, AlleleETFruit.Tangerine);
			template.set(EnumTreeChromosome.HEIGHT, ForestryAllele.TreeHeight.Smallest.getAllele());
			template.set(EnumTreeChromosome.FERTILITY, ForestryAllele.Saplings.Low.getAllele());
			template.set(EnumTreeChromosome.YIELD, ForestryAllele.Yield.Average.getAllele());
			template.set(EnumTreeChromosome.SAPPINESS, ForestryAllele.Sappiness.Average.getAllele());
			template.set(EnumTreeChromosome.MATURATION, ForestryAllele.Maturation.Faster.getAllele());
		}

		@Override
		protected void setSpeciesProperties(IAlleleTreeSpeciesBuilder species) {
			species.addFruitFamily(AlleleManager.alleleRegistry.getFruitFamily("forestry.pomes"));
			species.addFruitFamily(AlleleManager.alleleRegistry.getFruitFamily("forestry.prunes"));
			species.addFruitFamily(ETFruitFamily.Citrus);
		}
	},
	Lime("citrus", "latifolia", EnumLeafType.JUNGLE, new Color(0x88AF54), new Color(0xA3B850), EnumSaplingType.Fruit, EnumForestryWoodType.CITRUS, new Color(0x5B4B39)){
		
		@Override
		public WorldGenerator getWorldGenerator(ITreeGenData tree) {
			return new WorldGenLemon(tree);
		}
		
		@Override
		protected void setAlleles(AlleleTemplate template)  {
			template.set(EnumTreeChromosome.FRUITS, AlleleETFruit.Lime);
			template.set(EnumTreeChromosome.HEIGHT, ForestryAllele.TreeHeight.Smallest.getAllele());
			template.set(EnumTreeChromosome.YIELD, ForestryAllele.Yield.Average.getAllele());
			template.set(EnumTreeChromosome.SAPPINESS, ForestryAllele.Sappiness.Low.getAllele());
		}

		@Override
		protected void setSpeciesProperties(IAlleleTreeSpeciesBuilder species) {
			species.addFruitFamily(AlleleManager.alleleRegistry.getFruitFamily("forestry.pomes"));
			species.addFruitFamily(AlleleManager.alleleRegistry.getFruitFamily("forestry.prunes"));
			species.addFruitFamily(ETFruitFamily.Citrus);
		}
	},
	KeyLime("citrus", "aurantifolia", EnumLeafType.JUNGLE, new Color(0x88AF54), new Color(0xA3B850), EnumSaplingType.Fruit, EnumForestryWoodType.CITRUS, new Color(0x5B4B39)){
		
		@Override
		public WorldGenerator getWorldGenerator(ITreeGenData tree) {
			return new WorldGenLemon(tree);
		}
		
		@Override
		protected void setAlleles(AlleleTemplate template)  {
			template.set(EnumTreeChromosome.FRUITS, AlleleETFruit.KeyLime);
			template.set(EnumTreeChromosome.HEIGHT, ForestryAllele.TreeHeight.Smallest.getAllele());
			template.set(EnumTreeChromosome.FERTILITY, ForestryAllele.Saplings.Lowest.getAllele());
			template.set(EnumTreeChromosome.YIELD, ForestryAllele.Yield.Average.getAllele());
			template.set(EnumTreeChromosome.SAPPINESS, ForestryAllele.Sappiness.Low.getAllele());
			template.set(EnumTreeChromosome.MATURATION, ForestryAllele.Maturation.Fast.getAllele());
		}

		@Override
		protected void setSpeciesProperties(IAlleleTreeSpeciesBuilder species) {
			species.addFruitFamily(AlleleManager.alleleRegistry.getFruitFamily("forestry.pomes"));
			species.addFruitFamily(AlleleManager.alleleRegistry.getFruitFamily("forestry.prunes"));
			species.addFruitFamily(ETFruitFamily.Citrus);
		}
	},
	FingerLime("citrus", "australasica", EnumLeafType.JUNGLE, new Color(0x88AF54), new Color(0xA3B850), EnumSaplingType.Fruit, EnumForestryWoodType.CITRUS, new Color(0x5B4B39)){
		
		@Override
		public WorldGenerator getWorldGenerator(ITreeGenData tree) {
			return new WorldGenLemon(tree);
		}
		
		@Override
		protected void setAlleles(AlleleTemplate template)  {
			template.set(EnumTreeChromosome.FRUITS, AlleleETFruit.FingerLime);
			template.set(EnumTreeChromosome.HEIGHT, ForestryAllele.TreeHeight.Smallest.getAllele());
			template.set(EnumTreeChromosome.YIELD, ForestryAllele.Yield.High.getAllele());
			template.set(EnumTreeChromosome.SAPPINESS, ForestryAllele.Sappiness.Low.getAllele());
			template.set(EnumTreeChromosome.MATURATION, ForestryAllele.Maturation.Fast.getAllele());
		}

		@Override
		protected void setSpeciesProperties(IAlleleTreeSpeciesBuilder species) {
			species.addFruitFamily(AlleleManager.alleleRegistry.getFruitFamily("forestry.pomes"));
			species.addFruitFamily(AlleleManager.alleleRegistry.getFruitFamily("forestry.prunes"));
			species.addFruitFamily(ETFruitFamily.Citrus);
		}
	},
	Pomelo("citrus", "maxima", EnumLeafType.JUNGLE, new Color(0x88AF54), new Color(0xA3B850), EnumSaplingType.Fruit, EnumForestryWoodType.CITRUS, new Color(0x5B4B39)){
		
		@Override
		public WorldGenerator getWorldGenerator(ITreeGenData tree) {
			return new WorldGenLemon(tree);
		}
		
		@Override
		protected void setAlleles(AlleleTemplate template)  {
			template.set(EnumTreeChromosome.FRUITS, AlleleETFruit.Pomelo);
			template.set(EnumTreeChromosome.HEIGHT, ForestryAllele.TreeHeight.Smallest.getAllele());
			template.set(EnumTreeChromosome.FERTILITY, ForestryAllele.Saplings.Low.getAllele());
			template.set(EnumTreeChromosome.YIELD, ForestryAllele.Yield.Average.getAllele());
			template.set(EnumTreeChromosome.SAPPINESS, ForestryAllele.Sappiness.Lower.getAllele());
		}

		@Override
		protected void setSpeciesProperties(IAlleleTreeSpeciesBuilder species) {
			species.addFruitFamily(AlleleManager.alleleRegistry.getFruitFamily("forestry.pomes"));
			species.addFruitFamily(AlleleManager.alleleRegistry.getFruitFamily("forestry.prunes"));
			species.addFruitFamily(ETFruitFamily.Citrus);
		}
	},
	Grapefruit("citrus", "paradisi", EnumLeafType.JUNGLE, new Color(0x88AF54), new Color(0xA3B850), EnumSaplingType.Fruit, EnumForestryWoodType.CITRUS, new Color(0x5B4B39)){
		
		@Override
		public WorldGenerator getWorldGenerator(ITreeGenData tree) {
			return new WorldGenLemon(tree);
		}
		
		@Override
		protected void setAlleles(AlleleTemplate template)  {
			template.set(EnumTreeChromosome.FRUITS, AlleleETFruit.Grapefruit);
			template.set(EnumTreeChromosome.HEIGHT, ForestryAllele.TreeHeight.Smallest.getAllele());
			template.set(EnumTreeChromosome.FERTILITY, ForestryAllele.Saplings.Low.getAllele());
			template.set(EnumTreeChromosome.YIELD, ForestryAllele.Yield.Average.getAllele());
			template.set(EnumTreeChromosome.SAPPINESS, ForestryAllele.Sappiness.Low.getAllele());
			template.set(EnumTreeChromosome.MATURATION, ForestryAllele.Maturation.Fast.getAllele());
		}

		@Override
		protected void setSpeciesProperties(IAlleleTreeSpeciesBuilder species) {
			species.addFruitFamily(AlleleManager.alleleRegistry.getFruitFamily("forestry.pomes"));
			species.addFruitFamily(AlleleManager.alleleRegistry.getFruitFamily("forestry.prunes"));
			species.addFruitFamily(ETFruitFamily.Citrus);
		}
	},
	Kumquat("citrus", "margarita", EnumLeafType.JUNGLE, new Color(0x88AF54), new Color(0xA3B850), EnumSaplingType.Fruit, EnumForestryWoodType.CITRUS, new Color(0x5B4B39)){
		
		@Override
		public WorldGenerator getWorldGenerator(ITreeGenData tree) {
			return new WorldGenLemon(tree);
		}
		
		@Override
		protected void setAlleles(AlleleTemplate template)  {
			template.set(EnumTreeChromosome.FRUITS, AlleleETFruit.Kumquat);
			template.set(EnumTreeChromosome.HEIGHT, ForestryAllele.TreeHeight.Smallest.getAllele());
			template.set(EnumTreeChromosome.YIELD, ForestryAllele.Yield.High.getAllele());
			template.set(EnumTreeChromosome.SAPPINESS, ForestryAllele.Sappiness.Low.getAllele());
		}

		@Override
		protected void setSpeciesProperties(IAlleleTreeSpeciesBuilder species) {
			species.addFruitFamily(AlleleManager.alleleRegistry.getFruitFamily("forestry.pomes"));
			species.addFruitFamily(AlleleManager.alleleRegistry.getFruitFamily("forestry.prunes"));
			species.addFruitFamily(ETFruitFamily.Citrus);
		}
	},
	Citron("citrus", "medica", EnumLeafType.JUNGLE, new Color(0x88AF54), new Color(0xA3B850), EnumSaplingType.Fruit, EnumForestryWoodType.CITRUS, new Color(0x5B4B39)){
		
		@Override
		public WorldGenerator getWorldGenerator(ITreeGenData tree) {
			return new WorldGenLemon(tree);
		}
		
		@Override
		protected void setAlleles(AlleleTemplate template)  {
			template.set(EnumTreeChromosome.FRUITS, AlleleETFruit.Citron);
			template.set(EnumTreeChromosome.HEIGHT, ForestryAllele.TreeHeight.Smallest.getAllele());
			template.set(EnumTreeChromosome.YIELD, ForestryAllele.Yield.High.getAllele());
			template.set(EnumTreeChromosome.SAPPINESS, ForestryAllele.Sappiness.Average.getAllele());
		}

		@Override
		protected void setSpeciesProperties(IAlleleTreeSpeciesBuilder species) {
			species.addFruitFamily(AlleleManager.alleleRegistry.getFruitFamily("forestry.pomes"));
			species.addFruitFamily(AlleleManager.alleleRegistry.getFruitFamily("forestry.prunes"));
			species.addFruitFamily(ETFruitFamily.Citrus);
		}
	},
	BuddhaHand("citrus", "sarcodactylus", EnumLeafType.JUNGLE, new Color(0x88AF54), new Color(0xA3B850), EnumSaplingType.Fruit, EnumForestryWoodType.CITRUS, new Color(0x5B4B39)){
		
		@Override
		public WorldGenerator getWorldGenerator(ITreeGenData tree) {
			return new WorldGenLemon(tree);
		}
		
		@Override
		protected void setAlleles(AlleleTemplate template)  {
			template.set(EnumTreeChromosome.FRUITS, AlleleETFruit.BuddhaHand);
			template.set(EnumTreeChromosome.YIELD, ForestryAllele.Yield.Average.getAllele());
			template.set(EnumTreeChromosome.SAPPINESS, ForestryAllele.Sappiness.Low.getAllele());
		}

		@Override
		protected void setSpeciesProperties(IAlleleTreeSpeciesBuilder species) {
			species.addFruitFamily(AlleleManager.alleleRegistry.getFruitFamily("forestry.pomes"));
			species.addFruitFamily(AlleleManager.alleleRegistry.getFruitFamily("forestry.prunes"));
			species.addFruitFamily(ETFruitFamily.Citrus);
		}
	},
	Banana("musa", "sinensis", EnumLeafType.PALM, new Color(0xA1CD8E), new Color(0x44E500), EnumSaplingType.Default, EnumExtraTreeLog.Banana, new Color(0x85924F)){
		
		@Override
		public WorldGenerator getWorldGenerator(ITreeGenData tree) {
			return new WorldGenBanana(tree);
		}
		
		@Override
		protected void setAlleles(AlleleTemplate template)  {
			template.set(EnumTreeChromosome.FRUITS, AlleleETFruit.Banana);
			template.set(EnumTreeChromosome.YIELD, ForestryAllele.Yield.Low.getAllele());
			template.set(EnumTreeChromosome.SAPPINESS, ForestryAllele.Sappiness.Low.getAllele());
			template.set(EnumTreeChromosome.MATURATION, ForestryAllele.Maturation.Fast.getAllele());
		}

		@Override
		protected void setSpeciesProperties(IAlleleTreeSpeciesBuilder species) {
			species.addFruitFamily(AlleleManager.alleleRegistry.getFruitFamily("forestry.nuts"));
			species.addFruitFamily(AlleleManager.alleleRegistry.getFruitFamily("forestry.jungle"));
		}
	},
	RedBanana("musa", "rubra", EnumLeafType.PALM, new Color(0xA1CD8E), new Color(0x44E500), EnumSaplingType.Default, EnumExtraTreeLog.Banana, new Color(0x85924F)){
		
		@Override
		public WorldGenerator getWorldGenerator(ITreeGenData tree) {
			return new WorldGenBanana(tree);
		}
		
		@Override
		protected void setAlleles(AlleleTemplate template)  {
			template.set(EnumTreeChromosome.FRUITS, AlleleETFruit.RedBanana);
		}

		@Override
		protected void setSpeciesProperties(IAlleleTreeSpeciesBuilder species) {
			species.addFruitFamily(AlleleManager.alleleRegistry.getFruitFamily("forestry.nuts"));
			species.addFruitFamily(AlleleManager.alleleRegistry.getFruitFamily("forestry.jungle"));
		}
	},
	Plantain("musa", "paradisiaca", EnumLeafType.PALM, new Color(0xA1CD8E), new Color(0x44E500), EnumSaplingType.Default, EnumExtraTreeLog.Banana, new Color(0x85924F)){
		
		@Override
		public WorldGenerator getWorldGenerator(ITreeGenData tree) {
			return new WorldGenBanana(tree);
		}
		
		@Override
		protected void setAlleles(AlleleTemplate template)  {
			template.set(EnumTreeChromosome.FRUITS, AlleleETFruit.Plantain);
			template.set(EnumTreeChromosome.HEIGHT, ForestryAllele.TreeHeight.Average.getAllele());
			template.set(EnumTreeChromosome.YIELD, ForestryAllele.Yield.Lower.getAllele());
		}

		@Override
		protected void setSpeciesProperties(IAlleleTreeSpeciesBuilder species) {
			species.addFruitFamily(AlleleManager.alleleRegistry.getFruitFamily("forestry.nuts"));
			species.addFruitFamily(AlleleManager.alleleRegistry.getFruitFamily("forestry.jungle"));
		}
	},
	Butternut("juglans", "cinerea", EnumLeafType.DECIDUOUS, new Color(0x82B58C), new Color(0x82DD8C), EnumSaplingType.Default, EnumExtraTreeLog.Butternut, new Color(0xB7ADA0)){
		
		@Override
		public WorldGenerator getWorldGenerator(ITreeGenData tree) {
			return new WorldGenWalnut.Butternut(tree);
		}
		
		@Override
		protected void setAlleles(AlleleTemplate template)  {
			template.set(EnumTreeChromosome.FRUITS, AlleleETFruit.Butternut);
			template.set(EnumTreeChromosome.GIRTH,  ForestryAllele.Int.Int2.getAllele());
			template.set(EnumTreeChromosome.HEIGHT, ForestryAllele.TreeHeight.Smaller.getAllele());
			template.set(EnumTreeChromosome.YIELD, ForestryAllele.Yield.Low.getAllele());
		}

		@Override
		protected void setSpeciesProperties(IAlleleTreeSpeciesBuilder species) {
			species.addFruitFamily(AlleleManager.alleleRegistry.getFruitFamily("forestry.pomes"));
			species.addFruitFamily(AlleleManager.alleleRegistry.getFruitFamily("forestry.prunes"));
			species.addFruitFamily(AlleleManager.alleleRegistry.getFruitFamily("forestry.nuts"));
			species.addFruitFamily(ETFruitFamily.Citrus);
		}
	},
	Rowan("sorbus", "aucuparia", EnumLeafType.DECIDUOUS, new Color(0x9EC79B), new Color(0x9EE8B2), EnumSaplingType.Default, EnumExtraTreeLog.Rowan, new Color(0xB6B09B)){
		
		@Override
		public WorldGenerator getWorldGenerator(ITreeGenData tree) {
			return new WorldGenSorbus.Rowan(tree);
		}
		
		@Override
		protected void setAlleles(AlleleTemplate template)  {
			template.set(EnumTreeChromosome.HEIGHT, ForestryAllele.TreeHeight.Larger.getAllele());
			template.set(EnumTreeChromosome.FERTILITY, ForestryAllele.Saplings.Low.getAllele());
			template.set(EnumTreeChromosome.SAPPINESS, ForestryAllele.Sappiness.Lower.getAllele());
		}

		@Override
		protected void setSpeciesProperties(IAlleleTreeSpeciesBuilder species) {
			species.addFruitFamily(AlleleManager.alleleRegistry.getFruitFamily("forestry.nuts"));
			species.addFruitFamily(ETFruitFamily.Berry);
		}
	},
	Hemlock("tsuga", "heterophylla", EnumLeafType.CONIFERS, new Color(0x5CAC72), new Color(0x5CD172), EnumSaplingType.Default, EnumExtraTreeLog.Hemlock, new Color(0xADA39B)){
		
		@Override
		public WorldGenerator getWorldGenerator(ITreeGenData tree) {
			return new WorldGenConifer.WesternHemlock(tree);
		}
		
		@Override
		protected void setAlleles(AlleleTemplate template)  {
			template.set(EnumTreeChromosome.HEIGHT, ForestryAllele.TreeHeight.Average.getAllele());
			template.set(EnumTreeChromosome.FERTILITY, ForestryAllele.Saplings.Low.getAllele());
			template.set(EnumTreeChromosome.MATURATION, ForestryAllele.Maturation.Slower.getAllele());
			template.set(EnumTreeChromosome.GIRTH, ForestryAllele.Int.Int2.getAllele());
		}
	},
	Ash("fraxinus", "excelsior", EnumLeafType.DECIDUOUS, new Color(0x488E2B), new Color(0x48E42B), EnumSaplingType.Default, EnumExtraTreeLog.Ash, new Color(0x898982)){
		
		@Override
		public WorldGenerator getWorldGenerator(ITreeGenData tree) {
			return new WorldGenAsh.CommonAsh(tree);
		}
		
		@Override
		protected void setAlleles(AlleleTemplate template)  {
			template.set(EnumTreeChromosome.FERTILITY, ForestryAllele.Saplings.Low.getAllele());
			template.set(EnumTreeChromosome.SAPPINESS, ForestryAllele.Sappiness.Lower.getAllele());
		}

		@Override
		protected void setSpeciesProperties(IAlleleTreeSpeciesBuilder species) {
			species.addFruitFamily(AlleleManager.alleleRegistry.getFruitFamily("forestry.pomes"));
			species.addFruitFamily(AlleleManager.alleleRegistry.getFruitFamily("forestry.prunes"));
			species.addFruitFamily(AlleleManager.alleleRegistry.getFruitFamily("forestry.nuts"));
			species.addFruitFamily(ETFruitFamily.Citrus);
		}
	},
	Alder("alnus", "glutinosa", EnumLeafType.DECIDUOUS, new Color(0x698A33), new Color(0x69AE33), EnumSaplingType.Default, EnumExtraTreeLog.Alder, new Color(0xC6C0B8)){
		
		@Override
		public WorldGenerator getWorldGenerator(ITreeGenData tree) {
			return new WorldGenAlder.CommonAlder(tree);
		}
		
		@Override
		protected void setAlleles(AlleleTemplate template)  {
			template.set(EnumTreeChromosome.HEIGHT, ForestryAllele.TreeHeight.Average.getAllele());
			template.set(EnumTreeChromosome.SAPPINESS, ForestryAllele.Sappiness.Lower.getAllele());
		}

		@Override
		protected void setSpeciesProperties(IAlleleTreeSpeciesBuilder species) {
			species.addFruitFamily(AlleleManager.alleleRegistry.getFruitFamily("forestry.pomes"));
			species.addFruitFamily(AlleleManager.alleleRegistry.getFruitFamily("forestry.prunes"));
			species.addFruitFamily(AlleleManager.alleleRegistry.getFruitFamily("forestry.nuts"));
		}
	},
	Beech("fagus", "sylvatica", EnumLeafType.DECIDUOUS, new Color(0x83A04C), new Color(0x83C64C), EnumSaplingType.Default, EnumExtraTreeLog.Beech, new Color(0xB2917E)){
		
		@Override
		public WorldGenerator getWorldGenerator(ITreeGenData tree) {
			return new WorldGenBeech.CommonBeech(tree);
		}
		
		@Override
		protected void setAlleles(AlleleTemplate template)  {
			template.set(EnumTreeChromosome.FRUITS, AlleleETFruit.Beechnut);
			template.set(EnumTreeChromosome.HEIGHT, ForestryAllele.TreeHeight.Average.getAllele());
			template.set(EnumTreeChromosome.YIELD, ForestryAllele.Yield.Lower.getAllele());
		}

		@Override
		protected void setSpeciesProperties(IAlleleTreeSpeciesBuilder species) {
			species.addFruitFamily(AlleleManager.alleleRegistry.getFruitFamily("forestry.prunes"));
			species.addFruitFamily(AlleleManager.alleleRegistry.getFruitFamily("forestry.nuts"));
		}
	},
	CopperBeech("fagus", "purpurea", EnumLeafType.DECIDUOUS, new Color(0x801318), new Color(0xD15B4D), EnumSaplingType.Default, EnumExtraTreeLog.Beech, new Color(0xB2917E)){
		
		@Override
		public WorldGenerator getWorldGenerator(ITreeGenData tree) {
			return new WorldGenBeech.CopperBeech(tree);
		}
		
		@Override
		protected void setAlleles(AlleleTemplate template)  {
			template.set(EnumTreeChromosome.FRUITS, AlleleETFruit.Beechnut);
			template.set(EnumTreeChromosome.MATURATION, ForestryAllele.Maturation.Slow.getAllele());
		}

		@Override
		protected void setSpeciesProperties(IAlleleTreeSpeciesBuilder species) {
			species.addFruitFamily(AlleleManager.alleleRegistry.getFruitFamily("forestry.prunes"));
			species.addFruitFamily(AlleleManager.alleleRegistry.getFruitFamily("forestry.nuts"));
		}
	},
	Aspen("populus", "tremula", EnumLeafType.DECIDUOUS, new Color(0x8ACC37), new Color(0x8AE18F), EnumSaplingType.Default, EnumForestryWoodType.POPLAR, new Color(0x8CA687)){
		
		@Override
		public WorldGenerator getWorldGenerator(ITreeGenData tree) {
			return new WorldGenPoplar.Aspen(tree);
		}
		
		@Override
		protected void setAlleles(AlleleTemplate template)  {
			template.set(EnumTreeChromosome.FERTILITY, ForestryAllele.Saplings.Average.getAllele());
			template.set(EnumTreeChromosome.SAPPINESS, ForestryAllele.Sappiness.Lower.getAllele());
		}

		@Override
		protected void setSpeciesProperties(IAlleleTreeSpeciesBuilder species) {
			species.addFruitFamily(AlleleManager.alleleRegistry.getFruitFamily("forestry.prunes"));
			species.addFruitFamily(AlleleManager.alleleRegistry.getFruitFamily("forestry.nuts"));
		}
	},
	Yew("taxus", "baccata", EnumLeafType.CONIFERS, new Color(0x948A4D), new Color(0x94AE4D), EnumSaplingType.Default, EnumExtraTreeLog.Yew, new Color(0xD1BBC1)){
		
		@Override
		public WorldGenerator getWorldGenerator(ITreeGenData tree) {
			return new WorldGenConifer.Yew(tree);
		}
		
		@Override
		protected void setAlleles(AlleleTemplate template)  {
			template.set(EnumTreeChromosome.HEIGHT, ForestryAllele.TreeHeight.Large.getAllele());
			template.set(EnumTreeChromosome.SAPPINESS, ForestryAllele.Sappiness.Lower.getAllele());
		}
	},
	Cypress("chamaecyparis", "lawsoniana", EnumLeafType.CONIFERS, new Color(0x89C9A7), new Color(0x89DDC6), EnumSaplingType.Poplar, EnumExtraTreeLog.Cypress, new Color(0x9A8483)){
		
		@Override
		public WorldGenerator getWorldGenerator(ITreeGenData tree) {
			return new WorldGenConifer.Cypress(tree);
		}
		
		@Override
		protected void setAlleles(AlleleTemplate template)  {
			template.set(EnumTreeChromosome.HEIGHT, ForestryAllele.TreeHeight.Larger.getAllele());
			template.set(EnumTreeChromosome.FERTILITY, ForestryAllele.Saplings.Low.getAllele());
			template.set(EnumTreeChromosome.SAPPINESS, ForestryAllele.Sappiness.Lower.getAllele());
			template.set(EnumTreeChromosome.MATURATION, ForestryAllele.Maturation.Slow.getAllele());
		}
	},
	DouglasFir("pseudotsuga", "menziesii", EnumLeafType.CONIFERS, new Color(0x99B582), new Color(0x99D1AA), EnumSaplingType.Default, EnumExtraTreeLog.Fir, new Color(0x828382)){
		
		@Override
		public WorldGenerator getWorldGenerator(ITreeGenData tree) {
			return new WorldGenFir.DouglasFir(tree);
		}
		
		@Override
		protected void setAlleles(AlleleTemplate template)  {
			template.set(EnumTreeChromosome.GIRTH,  ForestryAllele.Int.Int2.getAllele());
			template.set(EnumTreeChromosome.HEIGHT, ForestryAllele.TreeHeight.Smaller.getAllele());
			template.set(EnumTreeChromosome.FERTILITY, ForestryAllele.Saplings.Low.getAllele());
			template.set(EnumTreeChromosome.MATURATION, ForestryAllele.Maturation.Slower.getAllele());
		}
	},
	Hazel("Corylus", "avellana", EnumLeafType.DECIDUOUS, new Color(0x9BB552), new Color(0x9BE152), EnumSaplingType.Default, EnumExtraTreeLog.Hazel, new Color(0xAA986F)){
		
		@Override
		public WorldGenerator getWorldGenerator(ITreeGenData tree) {
			return new WorldGenTree3.Hazel(tree);
		}
		
		@Override
		protected void setAlleles(AlleleTemplate template)  {
			template.set(EnumTreeChromosome.FRUITS, AlleleETFruit.Hazelnut);
			template.set(EnumTreeChromosome.HEIGHT, ForestryAllele.TreeHeight.Average.getAllele());
			template.set(EnumTreeChromosome.FERTILITY, ForestryAllele.Saplings.Low.getAllele());
			template.set(EnumTreeChromosome.YIELD, ForestryAllele.Yield.Low.getAllele());
			template.set(EnumTreeChromosome.SAPPINESS, ForestryAllele.Sappiness.Lower.getAllele());
		}

		@Override
		protected void setSpeciesProperties(IAlleleTreeSpeciesBuilder species) {
			species.addFruitFamily(AlleleManager.alleleRegistry.getFruitFamily("forestry.prunes"));
			species.addFruitFamily(AlleleManager.alleleRegistry.getFruitFamily("forestry.nuts"));
		}
	},
	Sycamore("ficus", "sycomorus", EnumLeafType.DECIDUOUS, new Color(0xA0A52F), new Color(0xB4D55C), EnumSaplingType.Default, EnumExtraTreeLog.Fig, new Color(0x807357)){
		
		@Override
		public WorldGenerator getWorldGenerator(ITreeGenData tree) {
			return new WorldGenTree3.Sycamore(tree);
		}
		
		@Override
		protected void setAlleles(AlleleTemplate template)  {
			template.set(EnumTreeChromosome.FRUITS, AlleleETFruit.Fig);
			template.set(EnumTreeChromosome.FERTILITY, ForestryAllele.Saplings.Lowest.getAllele());
			template.set(EnumTreeChromosome.SAPPINESS, ForestryAllele.Sappiness.Lower.getAllele());
		}

		@Override
		protected void setSpeciesProperties(IAlleleTreeSpeciesBuilder species) {
			species.addFruitFamily(AlleleManager.alleleRegistry.getFruitFamily("forestry.prunes"));
			species.addFruitFamily(AlleleManager.alleleRegistry.getFruitFamily("forestry.nuts"));
			species.addFruitFamily(ETFruitFamily.Citrus);
		}
	},
	Whitebeam("sorbus", "aria", EnumLeafType.DECIDUOUS, new Color(0xBACE99), new Color(0x72863F), EnumSaplingType.Default, EnumExtraTreeLog.Whitebeam, new Color(0x786A6D)){
		
		@Override
		public WorldGenerator getWorldGenerator(ITreeGenData tree) {
			return new WorldGenSorbus.Whitebeam(tree);
		}
		
		@Override
		protected void setAlleles(AlleleTemplate template)  {
			template.set(EnumTreeChromosome.HEIGHT, ForestryAllele.TreeHeight.Smaller.getAllele());
		}

		@Override
		protected void setSpeciesProperties(IAlleleTreeSpeciesBuilder species) {
			species.addFruitFamily(AlleleManager.alleleRegistry.getFruitFamily("forestry.pomes"));
			species.addFruitFamily(AlleleManager.alleleRegistry.getFruitFamily("forestry.prunes"));
		}
	},
	Hawthorn("crataegus", "monogyna", EnumLeafType.DECIDUOUS, new Color(0x6BA84A), new Color(0x98B77B), EnumSaplingType.Default, EnumExtraTreeLog.Hawthorn, new Color(0x5F5745)){
		
		@Override
		public WorldGenerator getWorldGenerator(ITreeGenData tree) {
			return new WorldGenTree3.Hawthorn(tree);
		}
		
		@Override
		protected void setAlleles(AlleleTemplate template)  {
			template.set(EnumTreeChromosome.HEIGHT, ForestryAllele.TreeHeight.Average.getAllele());
		}

		@Override
		protected void setSpeciesProperties(IAlleleTreeSpeciesBuilder species) {
			species.addFruitFamily(AlleleManager.alleleRegistry.getFruitFamily("forestry.prunes"));
			species.addFruitFamily(AlleleManager.alleleRegistry.getFruitFamily("forestry.nuts"));
		}
	},
	Pecan("carya", "illinoinensis", EnumLeafType.DECIDUOUS, new Color(0x85B674), new Color(0x2C581B), EnumSaplingType.Default, EnumExtraTreeLog.Hickory, new Color(0x3E3530)){
		
		@Override
		public WorldGenerator getWorldGenerator(ITreeGenData tree) {
			return new WorldGenTree3.Pecan(tree);
		}
		
		@Override
		protected void setAlleles(AlleleTemplate template)  {
			template.set(EnumTreeChromosome.FRUITS, AlleleETFruit.Pecan);
			template.set(EnumTreeChromosome.HEIGHT, ForestryAllele.TreeHeight.Large.getAllele());
			template.set(EnumTreeChromosome.SAPPINESS, ForestryAllele.Sappiness.Lower.getAllele());
			template.set(EnumTreeChromosome.MATURATION, ForestryAllele.Maturation.Slow.getAllele());
		}

		@Override
		protected void setSpeciesProperties(IAlleleTreeSpeciesBuilder species) {
			species.addFruitFamily(AlleleManager.alleleRegistry.getFruitFamily("forestry.pomes"));
			species.addFruitFamily(AlleleManager.alleleRegistry.getFruitFamily("forestry.prunes"));
			species.addFruitFamily(AlleleManager.alleleRegistry.getFruitFamily("forestry.nuts"));
			species.addFruitFamily(ETFruitFamily.Citrus);
		}
	},
	Elm("ulmus", "procera", EnumLeafType.DECIDUOUS, new Color(0x7C9048), new Color(0x7CBE48), EnumSaplingType.Default, EnumExtraTreeLog.Elm, new Color(0x848386)){
		
		@Override
		public WorldGenerator getWorldGenerator(ITreeGenData tree) {
			return new WorldGenTree3.Elm(tree);
		}
		
		@Override
		protected void setAlleles(AlleleTemplate template)  {
			template.set(EnumTreeChromosome.HEIGHT, ForestryAllele.TreeHeight.Smaller.getAllele());
			template.set(EnumTreeChromosome.FERTILITY, ForestryAllele.Saplings.Low.getAllele());
			template.set(EnumTreeChromosome.SAPPINESS, ForestryAllele.Sappiness.Average.getAllele());
		}

		@Override
		protected void setSpeciesProperties(IAlleleTreeSpeciesBuilder species) {
			species.addFruitFamily(AlleleManager.alleleRegistry.getFruitFamily("forestry.pomes"));
			species.addFruitFamily(AlleleManager.alleleRegistry.getFruitFamily("forestry.prunes"));
		}
	},
	Elder("sambucus", "nigra", EnumLeafType.DECIDUOUS, new Color(0xAEB873), new Color(0xE0E7BD), EnumSaplingType.Default, EnumExtraTreeLog.Elder, new Color(0xD8B874)){
		
		@Override
		public WorldGenerator getWorldGenerator(ITreeGenData tree) {
			return new WorldGenTree3.Elder(tree);
		}
		
		@Override
		protected void setAlleles(AlleleTemplate template)  {
			template.set(EnumTreeChromosome.FRUITS, AlleleETFruit.Elderberry);
			template.set(EnumTreeChromosome.HEIGHT, ForestryAllele.TreeHeight.Smaller.getAllele());
			template.set(EnumTreeChromosome.SAPPINESS, ForestryAllele.Sappiness.Low.getAllele());
		}

		@Override
		protected void setSpeciesProperties(IAlleleTreeSpeciesBuilder species) {
			species.addFruitFamily(AlleleManager.alleleRegistry.getFruitFamily("forestry.prunes"));
			species.addFruitFamily(AlleleManager.alleleRegistry.getFruitFamily("forestry.nuts"));
			species.addFruitFamily(ETFruitFamily.Berry);
			species.addFruitFamily(ETFruitFamily.Citrus);
		}
	},
	Holly("ilex", "aquifolium", EnumLeafType.DECIDUOUS, new Color(0x254B4C), new Color(0x6E9284), EnumSaplingType.Default, EnumExtraTreeLog.Holly, new Color(0xB5AA85)){
		
		@Override
		public WorldGenerator getWorldGenerator(ITreeGenData tree) {
			return new WorldGenHolly.Holly(tree);
		}
		
		@Override
		protected void setAlleles(AlleleTemplate template)  {
			template.set(EnumTreeChromosome.HEIGHT, ForestryAllele.TreeHeight.Average.getAllele());
			template.set(EnumTreeChromosome.SAPPINESS, ForestryAllele.Sappiness.Low.getAllele());
		}

		@Override
		protected void setSpeciesProperties(IAlleleTreeSpeciesBuilder species) {
			species.addFruitFamily(AlleleManager.alleleRegistry.getFruitFamily("forestry.pomes"));
			species.addFruitFamily(AlleleManager.alleleRegistry.getFruitFamily("forestry.prunes"));
			species.addFruitFamily(ETFruitFamily.Citrus);
		}
	},
	Hornbeam("carpinus", "betulus", EnumLeafType.DECIDUOUS, new Color(0x96A71B), new Color(0x96DD1B), EnumSaplingType.Default, EnumExtraTreeLog.Hornbeam, new Color(0xA39276)){
		
		@Override
		public WorldGenerator getWorldGenerator(ITreeGenData tree) {
			return new WorldGenTree3.Hornbeam(tree);
		}
		
		@Override
		protected void setAlleles(AlleleTemplate template)  {
			template.set(EnumTreeChromosome.HEIGHT, ForestryAllele.TreeHeight.Smaller.getAllele());
			template.set(EnumTreeChromosome.FERTILITY, ForestryAllele.Saplings.Low.getAllele());
			template.set(EnumTreeChromosome.YIELD, ForestryAllele.Yield.Lower.getAllele());
			template.set(EnumTreeChromosome.MATURATION, ForestryAllele.Maturation.Slow.getAllele());
		}

		@Override
		protected void setSpeciesProperties(IAlleleTreeSpeciesBuilder species) {
			species.addFruitFamily(AlleleManager.alleleRegistry.getFruitFamily("forestry.prunes"));
			species.addFruitFamily(AlleleManager.alleleRegistry.getFruitFamily("forestry.nuts"));
		}
	},
	Sallow("salix", "caprea", EnumLeafType.WILLOW, new Color(0xAEB323), new Color(0xB7EC25), EnumSaplingType.Default, EnumForestryWoodType.WILLOW, new Color(0xA19A95)){
		
		@Override
		public WorldGenerator getWorldGenerator(ITreeGenData tree) {
			return new WorldGenTree3.Sallow(tree);
		}
		
		@Override
		protected void setAlleles(AlleleTemplate template)  {
			template.set(EnumTreeChromosome.HEIGHT, ForestryAllele.TreeHeight.Large.getAllele());
			template.set(EnumTreeChromosome.FERTILITY, ForestryAllele.Saplings.Low.getAllele());
		}

		@Override
		protected void setSpeciesProperties(IAlleleTreeSpeciesBuilder species) {
			species.addFruitFamily(AlleleManager.alleleRegistry.getFruitFamily("forestry.pomes"));
			species.addFruitFamily(AlleleManager.alleleRegistry.getFruitFamily("forestry.prunes"));
			species.addFruitFamily(ETFruitFamily.Citrus);
		}
	},
	AcornOak("quercus", "robur", EnumLeafType.DECIDUOUS, new Color(0x66733E), new Color(0x9EA231), EnumSaplingType.Default, EnumVanillaWoodType.OAK, new Color(0x614D30)){
		
		@Override
		public WorldGenerator getWorldGenerator(ITreeGenData tree) {
			return new WorldGenTree3.AcornOak(tree);
		}
		
		@Override
		protected void setAlleles(AlleleTemplate template)  {
			template.set(EnumTreeChromosome.FRUITS, AlleleETFruit.Acorn);
			template.set(EnumTreeChromosome.GIRTH,  ForestryAllele.Int.Int2.getAllele());
			template.set(EnumTreeChromosome.HEIGHT, ForestryAllele.TreeHeight.Large.getAllele());
			template.set(EnumTreeChromosome.YIELD, ForestryAllele.Yield.Low.getAllele());
			template.set(EnumTreeChromosome.SAPPINESS, ForestryAllele.Sappiness.Lower.getAllele());
		}

		@Override
		protected void setSpeciesProperties(IAlleleTreeSpeciesBuilder species) {
			species.addFruitFamily(AlleleManager.alleleRegistry.getFruitFamily("forestry.pomes"));
			species.addFruitFamily(AlleleManager.alleleRegistry.getFruitFamily("forestry.prunes"));
			species.addFruitFamily(AlleleManager.alleleRegistry.getFruitFamily("forestry.nuts"));
		}
	},
	Fir("abies", "alba", EnumLeafType.CONIFERS, new Color(0x6F7C20), new Color(0x6FD120), EnumSaplingType.Default, EnumExtraTreeLog.Fir, new Color(0x828382)){
		
		@Override
		public WorldGenerator getWorldGenerator(ITreeGenData tree) {
			return new WorldGenFir.SilverFir(tree);
		}
		
		@Override
		protected void setAlleles(AlleleTemplate template)  {
			template.set(EnumTreeChromosome.HEIGHT, ForestryAllele.TreeHeight.Large.getAllele());
			template.set(EnumTreeChromosome.SAPPINESS, ForestryAllele.Sappiness.Lower.getAllele());
			template.set(EnumTreeChromosome.MATURATION, ForestryAllele.Maturation.Slow.getAllele());
		}
	},
	Cedar("cedrus", "libani", EnumLeafType.CONIFERS, new Color(0x95A370), new Color(0x95E870), EnumSaplingType.Default, EnumExtraTreeLog.Cedar, new Color(0xAD764F)){
		
		@Override
		public WorldGenerator getWorldGenerator(ITreeGenData tree) {
			return new WorldGenConifer.Cedar(tree);
		}
		
		@Override
		protected void setAlleles(AlleleTemplate template)  {
			template.set(EnumTreeChromosome.GIRTH,  ForestryAllele.Int.Int2.getAllele());
			template.set(EnumTreeChromosome.HEIGHT, ForestryAllele.TreeHeight.Smaller.getAllele());
			template.set(EnumTreeChromosome.SAPPINESS, ForestryAllele.Sappiness.Lower.getAllele());
			template.set(EnumTreeChromosome.MATURATION, ForestryAllele.Maturation.Slower.getAllele());
		}
	},
	Olive("olea", "europaea", EnumLeafType.DECIDUOUS, new Color(0x3C4834), new Color(0x3C4834), EnumSaplingType.Default, EnumExtraTreeLog.Olive, new Color(0x7B706A)){
		
		@Override
		public WorldGenerator getWorldGenerator(ITreeGenData tree) {
			return new WorldGenTree2.Olive(tree);
		}
		
		@Override
		protected void setAlleles(AlleleTemplate template)  {
			template.set(EnumTreeChromosome.FRUITS, AlleleETFruit.Olive);
			template.set(EnumTreeChromosome.YIELD, ForestryAllele.Yield.Average.getAllele());
		}

		@Override
		protected void setSpeciesProperties(IAlleleTreeSpeciesBuilder species) {
			species.addFruitFamily(AlleleManager.alleleRegistry.getFruitFamily("forestry.prunes"));
			species.addFruitFamily(AlleleManager.alleleRegistry.getFruitFamily("forestry.nuts"));
			species.addFruitFamily(ETFruitFamily.Citrus);
		}
	},
	RedMaple("acer", "ubrum", EnumLeafType.MAPLE, new Color(0xE82E17), new Color(0xE82E17), EnumSaplingType.Default, EnumForestryWoodType.MAPLE, new Color(0x8A8781)){
		
		@Override
		public WorldGenerator getWorldGenerator(ITreeGenData tree) {
			return new WorldGenMaple.RedMaple(tree);
		}
		
		@Override
		protected void setAlleles(AlleleTemplate template)  {
			template.set(EnumTreeChromosome.FERTILITY, ForestryAllele.Saplings.Average.getAllele());
			template.set(EnumTreeChromosome.SAPPINESS, ForestryAllele.Sappiness.High.getAllele());
		}

		@Override
		protected void setSpeciesProperties(IAlleleTreeSpeciesBuilder species) {
			species.addFruitFamily(AlleleManager.alleleRegistry.getFruitFamily("forestry.pomes"));
			species.addFruitFamily(AlleleManager.alleleRegistry.getFruitFamily("forestry.prunes"));
			species.addFruitFamily(ETFruitFamily.Citrus);
		}
	},
	BalsamFir("abies", "balsamea", EnumLeafType.CONIFERS, new Color(0x74A07C), new Color(0x74A07C), EnumSaplingType.Default, EnumExtraTreeLog.Fir, new Color(0x828382)){
		
		@Override
		public WorldGenerator getWorldGenerator(ITreeGenData tree) {
			return new WorldGenFir.BalsamFir(tree);
		}
		
		@Override
		protected void setAlleles(AlleleTemplate template)  {
			template.set(EnumTreeChromosome.HEIGHT, ForestryAllele.TreeHeight.Average.getAllele());
			template.set(EnumTreeChromosome.SAPPINESS, ForestryAllele.Sappiness.Lower.getAllele());
			template.set(EnumTreeChromosome.MATURATION, ForestryAllele.Maturation.Slow.getAllele());
		}
	},
	LoblollyPine("pinus", "taeda", EnumLeafType.CONIFERS, new Color(0x6F8A47), new Color(0x6F8A47), EnumSaplingType.Default, EnumForestryWoodType.PINE, new Color(0x735649)){
		
		@Override
		public WorldGenerator getWorldGenerator(ITreeGenData tree) {
			return new WorldGenConifer.LoblollyPine(tree);
		}
		
		@Override
		protected void setAlleles(AlleleTemplate template)  {
			template.set(EnumTreeChromosome.HEIGHT, ForestryAllele.TreeHeight.Smaller.getAllele());
			template.set(EnumTreeChromosome.SAPPINESS, ForestryAllele.Sappiness.Lower.getAllele());
			template.set(EnumTreeChromosome.MATURATION, ForestryAllele.Maturation.Slow.getAllele());
		}
	},
	Sweetgum("liquidambar", "styraciflua", EnumLeafType.DECIDUOUS, new Color(0x8B8762), new Color(0x8B8762), EnumSaplingType.Default, EnumExtraTreeLog.Sweetgum, new Color(0xA1A19C)){
		
		@Override
		public WorldGenerator getWorldGenerator(ITreeGenData tree) {
			return new WorldGenTree2.Sweetgum(tree);
		}
		
		@Override
		protected void setAlleles(AlleleTemplate template)  {
			template.set(EnumTreeChromosome.HEIGHT, ForestryAllele.TreeHeight.Average.getAllele());
			template.set(EnumTreeChromosome.FERTILITY, ForestryAllele.Saplings.High.getAllele());
			template.set(EnumTreeChromosome.YIELD, ForestryAllele.Yield.Low.getAllele());
			template.set(EnumTreeChromosome.SAPPINESS, ForestryAllele.Sappiness.Average.getAllele());
		}

		@Override
		protected void setSpeciesProperties(IAlleleTreeSpeciesBuilder species) {
			species.addFruitFamily(AlleleManager.alleleRegistry.getFruitFamily("forestry.nuts"));
		}
	},
	Locust("robinia", "pseudoacacia", EnumLeafType.DECIDUOUS, new Color(0x887300), new Color(0x887300), EnumSaplingType.Default, EnumExtraTreeLog.Locust, new Color(0xADACBC)){
		
		@Override
		public WorldGenerator getWorldGenerator(ITreeGenData tree) {
			return new WorldGenTree2.Locust(tree);
		}
		
		@Override
		protected void setAlleles(AlleleTemplate template)  {
			template.set(EnumTreeChromosome.HEIGHT, ForestryAllele.TreeHeight.Smallest.getAllele());
		}

		@Override
		protected void setSpeciesProperties(IAlleleTreeSpeciesBuilder species) {
			species.addFruitFamily(AlleleManager.alleleRegistry.getFruitFamily("forestry.prunes"));
			species.addFruitFamily(AlleleManager.alleleRegistry.getFruitFamily("forestry.nuts"));
			species.addFruitFamily(ETFruitFamily.Citrus);
		}
	},
	Pear("pyrus", "communis", EnumLeafType.DECIDUOUS, new Color(0x5E8826), new Color(0x5E8826), EnumSaplingType.Default, EnumExtraTreeLog.Pear, new Color(0xA89779)){
		
		@Override
		public WorldGenerator getWorldGenerator(ITreeGenData tree) {
			return new WorldGenTree2.Pear(tree);
		}
		
		@Override
		protected void setAlleles(AlleleTemplate template)  {
			template.set(EnumTreeChromosome.FRUITS, AlleleETFruit.Pear);
			template.set(EnumTreeChromosome.HEIGHT, ForestryAllele.TreeHeight.Smaller.getAllele());
			template.set(EnumTreeChromosome.FERTILITY, ForestryAllele.Saplings.Low.getAllele());
			template.set(EnumTreeChromosome.YIELD, ForestryAllele.Yield.High.getAllele());
			template.set(EnumTreeChromosome.SAPPINESS, ForestryAllele.Sappiness.Lower.getAllele());
			template.set(EnumTreeChromosome.MATURATION, ForestryAllele.Maturation.Fast.getAllele());
		}

		@Override
		protected void setSpeciesProperties(IAlleleTreeSpeciesBuilder species) {
			species.addFruitFamily(AlleleManager.alleleRegistry.getFruitFamily("forestry.pomes"));
			species.addFruitFamily(AlleleManager.alleleRegistry.getFruitFamily("forestry.prunes"));
			species.addFruitFamily(ETFruitFamily.Citrus);
		}
	},
	OsangeOsange("maclura", "pomifera", EnumLeafType.JUNGLE, new Color(0x687A50), new Color(0x687A50), EnumSaplingType.Default, EnumExtraTreeLog.Maclura, new Color(0x8B5734)){
		
		@Override
		public WorldGenerator getWorldGenerator(ITreeGenData tree) {
			return new WorldGenJungle.OsangeOsange(tree);
		}
		
		@Override
		protected void setAlleles(AlleleTemplate template)  {
			template.set(EnumTreeChromosome.FRUITS, AlleleETFruit.OsangeOsange);
			template.set(EnumTreeChromosome.YIELD, ForestryAllele.Yield.Lower.getAllele());
		}

		@Override
		protected void setSpeciesProperties(IAlleleTreeSpeciesBuilder species) {
			species.addFruitFamily(AlleleManager.alleleRegistry.getFruitFamily("forestry.pomes"));
			species.addFruitFamily(AlleleManager.alleleRegistry.getFruitFamily("forestry.prunes"));
			species.addFruitFamily(AlleleManager.alleleRegistry.getFruitFamily("forestry.jungle"));
			species.addFruitFamily(ETFruitFamily.Citrus);
		}
	},
	OldFustic("maclura", "tinctoria", EnumLeafType.JUNGLE, new Color(0x687A50), new Color(0x687A50), EnumSaplingType.Default, EnumExtraTreeLog.Maclura, new Color(0x8B5734)){
		
		@Override
		public WorldGenerator getWorldGenerator(ITreeGenData tree) {
			return new WorldGenJungle.OldFustic(tree);
		}
		
		@Override
		protected void setAlleles(AlleleTemplate template)  {
			template.set(EnumTreeChromosome.HEIGHT, ForestryAllele.TreeHeight.Smaller.getAllele());
			template.set(EnumTreeChromosome.SAPPINESS, ForestryAllele.Sappiness.Lower.getAllele());
		}

		@Override
		protected void setSpeciesProperties(IAlleleTreeSpeciesBuilder species) {
			species.addFruitFamily(AlleleManager.alleleRegistry.getFruitFamily("forestry.jungle"));
		}
	},
	Brazilwood("caesalpinia", "echinata", EnumLeafType.JUNGLE, new Color(0x607459), new Color(0x607459), EnumSaplingType.Default, EnumExtraTreeLog.Brazilwood, new Color(0x9E8068)){
		
		@Override
		public WorldGenerator getWorldGenerator(ITreeGenData tree) {
			return new WorldGenJungle.Brazilwood(tree);
		}
		
		@Override
		protected void setAlleles(AlleleTemplate template)  {
			template.set(EnumTreeChromosome.HEIGHT, ForestryAllele.TreeHeight.Smaller.getAllele());
			template.set(EnumTreeChromosome.FERTILITY, ForestryAllele.Saplings.Low.getAllele());
			template.set(EnumTreeChromosome.YIELD, ForestryAllele.Yield.Lower.getAllele());
			template.set(EnumTreeChromosome.SAPPINESS, ForestryAllele.Sappiness.Lower.getAllele());
		}

		@Override
		protected void setSpeciesProperties(IAlleleTreeSpeciesBuilder species) {
			species.addFruitFamily(AlleleManager.alleleRegistry.getFruitFamily("forestry.jungle"));
		}
	},
	Logwood("haematoxylum", "campechianum", EnumLeafType.JUNGLE, new Color(0x889F6B), new Color(0x889F6B), EnumSaplingType.Default, EnumExtraTreeLog.Logwood, new Color(0xF9E2D2)){
		
		@Override
		public WorldGenerator getWorldGenerator(ITreeGenData tree) {
			return new WorldGenJungle.Logwood(tree);
		}
		
		@Override
		protected void setAlleles(AlleleTemplate template)  {
			template.set(EnumTreeChromosome.HEIGHT, ForestryAllele.TreeHeight.Average.getAllele());
			template.set(EnumTreeChromosome.FERTILITY, ForestryAllele.Saplings.Low.getAllele());
			template.set(EnumTreeChromosome.SAPPINESS, ForestryAllele.Sappiness.Lower.getAllele());
		}

		@Override
		protected void setSpeciesProperties(IAlleleTreeSpeciesBuilder species) {
			species.addFruitFamily(AlleleManager.alleleRegistry.getFruitFamily("forestry.jungle"));
		}
	},
	Rosewood("dalbergia", "latifolia", EnumLeafType.JUNGLE, new Color(0x879B22), new Color(0x879B22), EnumSaplingType.Default, EnumExtraTreeLog.Rosewood, new Color(0x998666)){
		
		@Override
		public WorldGenerator getWorldGenerator(ITreeGenData tree) {
			return new WorldGenJungle.Rosewood(tree);
		}
		
		@Override
		protected void setAlleles(AlleleTemplate template)  {
			template.set(EnumTreeChromosome.HEIGHT, ForestryAllele.TreeHeight.Average.getAllele());
			template.set(EnumTreeChromosome.SAPPINESS, ForestryAllele.Sappiness.Lowest.getAllele());
		}

		@Override
		protected void setSpeciesProperties(IAlleleTreeSpeciesBuilder species) {
			species.addFruitFamily(AlleleManager.alleleRegistry.getFruitFamily("forestry.jungle"));
		}
	},
	Purpleheart("peltogyne", "spp", EnumLeafType.JUNGLE, new Color(0x778F55), new Color(0x778F55), EnumSaplingType.Default, EnumExtraTreeLog.Purpleheart, new Color(0x9392A2)){
		
		@Override
		public WorldGenerator getWorldGenerator(ITreeGenData tree) {
			return new WorldGenJungle.Purpleheart(tree);
		}
		
		@Override
		protected void setAlleles(AlleleTemplate template)  {
			template.set(EnumTreeChromosome.HEIGHT, ForestryAllele.TreeHeight.Large.getAllele());
			template.set(EnumTreeChromosome.SAPPINESS, ForestryAllele.Sappiness.Lower.getAllele());
		}

		@Override
		protected void setSpeciesProperties(IAlleleTreeSpeciesBuilder species) {
			species.addFruitFamily(AlleleManager.alleleRegistry.getFruitFamily("forestry.jungle"));
		}
	},
	Iroko("milicia", "excelsa", EnumLeafType.DECIDUOUS, new Color(0xAFC86C), new Color(0xAFC86C), EnumSaplingType.Default, EnumExtraTreeLog.Iroko, new Color(0x605C5B)){
		
		@Override
		public WorldGenerator getWorldGenerator(ITreeGenData tree) {
			return new WorldGenTree2.Iroko(tree);
		}
		
		@Override
		protected void setAlleles(AlleleTemplate template)  {
			template.set(EnumTreeChromosome.HEIGHT, ForestryAllele.TreeHeight.Average.getAllele());
			template.set(EnumTreeChromosome.FERTILITY, ForestryAllele.Saplings.Low.getAllele());
		}

		@Override
		protected void setSpeciesProperties(IAlleleTreeSpeciesBuilder species) {
			species.addFruitFamily(AlleleManager.alleleRegistry.getFruitFamily("forestry.jungle"));
			species.addFruitFamily(AlleleManager.alleleRegistry.getFruitFamily("forestry.nuts"));
		}
	},
	Gingko("ginkgo", "biloba", EnumLeafType.JUNGLE, new Color(0x719651), new Color(0x719651), EnumSaplingType.Default, EnumExtraTreeLog.Gingko, new Color(0xADAE9C)){
		
		@Override
		public WorldGenerator getWorldGenerator(ITreeGenData tree) {
			return new WorldGenTree2.Gingko(tree);
		}
		
		@Override
		protected void setAlleles(AlleleTemplate template)  {
			template.set(EnumTreeChromosome.FRUITS, AlleleETFruit.GingkoNut);
			template.set(EnumTreeChromosome.HEIGHT, ForestryAllele.TreeHeight.Large.getAllele());
			template.set(EnumTreeChromosome.YIELD, ForestryAllele.Yield.Lower.getAllele());
			template.set(EnumTreeChromosome.SAPPINESS, ForestryAllele.Sappiness.Low.getAllele());
		}

		@Override
		protected void setSpeciesProperties(IAlleleTreeSpeciesBuilder species) {
			species.addFruitFamily(AlleleManager.alleleRegistry.getFruitFamily("forestry.jungle"));
			species.addFruitFamily(AlleleManager.alleleRegistry.getFruitFamily("forestry.nuts"));
		}
	},
	Brazilnut("bertholletia", "excelsa", EnumLeafType.JUNGLE, new Color(0x7C8F7B), new Color(0x7C8F7B), EnumSaplingType.Default, EnumVanillaWoodType.JUNGLE, new Color(0x53411A)){
		
		@Override
		public WorldGenerator getWorldGenerator(ITreeGenData tree) {
			return new WorldGenJungle.BrazilNut(tree);
		}
		
		@Override
		protected void setAlleles(AlleleTemplate template)  {
			template.set(EnumTreeChromosome.FRUITS, AlleleETFruit.BrazilNut);
			template.set(EnumTreeChromosome.HEIGHT, ForestryAllele.TreeHeight.Larger.getAllele());
			template.set(EnumTreeChromosome.YIELD, ForestryAllele.Yield.Low.getAllele());
			template.set(EnumTreeChromosome.SAPPINESS, ForestryAllele.Sappiness.Low.getAllele());
		}

		@Override
		protected void setSpeciesProperties(IAlleleTreeSpeciesBuilder species) {
			species.addFruitFamily(AlleleManager.alleleRegistry.getFruitFamily("forestry.jungle"));
			species.addFruitFamily(AlleleManager.alleleRegistry.getFruitFamily("forestry.nuts"));
		}
	},
	RoseGum("eucalyptus", "grandis", EnumLeafType.JUNGLE, new Color(0x9CA258), new Color(0x9CA258), EnumSaplingType.Default, EnumExtraTreeLog.Eucalyptus, new Color(0xEADEDA)){
		
		@Override
		public WorldGenerator getWorldGenerator(ITreeGenData tree) {
			return new WorldGenEucalyptus.RoseGum(tree);
		}
		
		@Override
		protected void setAlleles(AlleleTemplate template)  {
			template.set(EnumTreeChromosome.HEIGHT, ForestryAllele.TreeHeight.Largest.getAllele());
			template.set(EnumTreeChromosome.FERTILITY, ForestryAllele.Saplings.Low.getAllele());
			template.set(EnumTreeChromosome.YIELD, ForestryAllele.Yield.Lower.getAllele());
			template.set(EnumTreeChromosome.SAPPINESS, ForestryAllele.Sappiness.Low.getAllele());
			template.set(EnumTreeChromosome.MATURATION, ForestryAllele.Maturation.Slowest.getAllele());
		}

		@Override
		protected void setSpeciesProperties(IAlleleTreeSpeciesBuilder species) {
			species.addFruitFamily(AlleleManager.alleleRegistry.getFruitFamily("forestry.jungle"));
		}
	},
	SwampGum("eucalyptus", "grandis", EnumLeafType.JUNGLE, new Color(0xA2C686), new Color(0xA2C686), EnumSaplingType.Default, EnumExtraTreeLog.Eucalyptus2, new Color(0x867E65)){
		
		@Override
		public WorldGenerator getWorldGenerator(ITreeGenData tree) {
			return new WorldGenEucalyptus.SwampGum(tree);
		}
		
		@Override
		protected void setAlleles(AlleleTemplate template)  {
			template.set(EnumTreeChromosome.GIRTH,  ForestryAllele.Int.Int2.getAllele());
			template.set(EnumTreeChromosome.HEIGHT, ForestryAllele.TreeHeight.Smallest.getAllele());
			template.set(EnumTreeChromosome.FERTILITY, ForestryAllele.Saplings.Lowest.getAllele());
			template.set(EnumTreeChromosome.MATURATION, ForestryAllele.Maturation.Slower.getAllele());
		}

		@Override
		protected void setSpeciesProperties(IAlleleTreeSpeciesBuilder species) {
			species.addFruitFamily(AlleleManager.alleleRegistry.getFruitFamily("forestry.jungle"));
		}
	},
	Box("boxus", "sempervirens", EnumLeafType.DECIDUOUS, new Color(0x72996D), new Color(0x72996D), EnumSaplingType.Default, EnumExtraTreeLog.Box, new Color(0xAB6F57)){
		
		@Override
		public WorldGenerator getWorldGenerator(ITreeGenData tree) {
			return new WorldGenTree2.Box(tree);
		}
		
		@Override
		protected void setAlleles(AlleleTemplate template)  {
			template.set(EnumTreeChromosome.HEIGHT, ForestryAllele.TreeHeight.Smaller.getAllele());
			template.set(EnumTreeChromosome.MATURATION, ForestryAllele.Maturation.Faster.getAllele());
		}

		@Override
		protected void setSpeciesProperties(IAlleleTreeSpeciesBuilder species) {
			species.addFruitFamily(AlleleManager.alleleRegistry.getFruitFamily("forestry.prunes"));
			species.addFruitFamily(AlleleManager.alleleRegistry.getFruitFamily("forestry.pomes"));
			species.addFruitFamily(AlleleManager.alleleRegistry.getFruitFamily("forestry.nuts"));
			species.addFruitFamily(ETFruitFamily.Citrus);
		}
	},
	Clove("syzygium", "aromaticum", EnumLeafType.DECIDUOUS, new Color(0x7A821F), new Color(0x7A821F), EnumSaplingType.Default, EnumExtraTreeLog.Syzgium, new Color(0xAB6F57)){
		
		@Override
		public WorldGenerator getWorldGenerator(ITreeGenData tree) {
			return new WorldGenTree2.Clove(tree);
		}
		
		@Override
		protected void setAlleles(AlleleTemplate template)  {
			template.set(EnumTreeChromosome.FRUITS, AlleleETFruit.Clove);
			template.set(EnumTreeChromosome.HEIGHT, ForestryAllele.TreeHeight.Smaller.getAllele());
			template.set(EnumTreeChromosome.FERTILITY, ForestryAllele.Saplings.Low.getAllele());
			template.set(EnumTreeChromosome.YIELD, ForestryAllele.Yield.High.getAllele());
			template.set(EnumTreeChromosome.SAPPINESS, ForestryAllele.Sappiness.Lower.getAllele());
			template.set(EnumTreeChromosome.MATURATION, ForestryAllele.Maturation.Fast.getAllele());
		}

		@Override
		protected void setSpeciesProperties(IAlleleTreeSpeciesBuilder species) {
			species.addFruitFamily(AlleleManager.alleleRegistry.getFruitFamily("forestry.jungle"));
			species.addFruitFamily(AlleleManager.alleleRegistry.getFruitFamily("forestry.nuts"));
		}
	},
	Coffee("coffea", "arabica", EnumLeafType.JUNGLE, new Color(0x6F9065), new Color(0x6F9065), EnumSaplingType.Default, EnumVanillaWoodType.JUNGLE, new Color(0x53411A)){
		
		@Override
		public WorldGenerator getWorldGenerator(ITreeGenData tree) {
			return new WorldGenJungle.Coffee(tree);
		}
		
		@Override
		protected void setAlleles(AlleleTemplate template)  {
			template.set(EnumTreeChromosome.FRUITS, AlleleETFruit.Coffee);
			template.set(EnumTreeChromosome.HEIGHT, ForestryAllele.TreeHeight.Large.getAllele());
			template.set(EnumTreeChromosome.YIELD, ForestryAllele.Yield.Average.getAllele());
			template.set(EnumTreeChromosome.MATURATION, ForestryAllele.Maturation.Fast.getAllele());
		}

		@Override
		protected void setSpeciesProperties(IAlleleTreeSpeciesBuilder species) {
			species.addFruitFamily(AlleleManager.alleleRegistry.getFruitFamily("forestry.jungle"));
			species.addFruitFamily(AlleleManager.alleleRegistry.getFruitFamily("forestry.nuts"));
		}
	},
	MonkeyPuzzle("araucaria", "araucana", EnumLeafType.CONIFERS, new Color(0x576158), new Color(0x576158), EnumSaplingType.Default, EnumForestryWoodType.PINE, new Color(0x735649)){
		
		@Override
		public WorldGenerator getWorldGenerator(ITreeGenData tree) {
			return new WorldGenConifer.MonkeyPuzzle(tree);
		}
		
		@Override
		protected void setAlleles(AlleleTemplate template)  {
			template.set(EnumTreeChromosome.GIRTH,  ForestryAllele.Int.Int2.getAllele());
			template.set(EnumTreeChromosome.HEIGHT, ForestryAllele.TreeHeight.Average.getAllele());
			template.set(EnumTreeChromosome.YIELD, ForestryAllele.Yield.Lower.getAllele());
			template.set(EnumTreeChromosome.SAPPINESS, ForestryAllele.Sappiness.Low.getAllele());
		}

		@Override
		protected void setSpeciesProperties(IAlleleTreeSpeciesBuilder species) {
			species.addFruitFamily(AlleleManager.alleleRegistry.getFruitFamily("forestry.jungle"));
			species.addFruitFamily(AlleleManager.alleleRegistry.getFruitFamily("forestry.nuts"));
		}
	},
	RainbowGum("eucalyptus", "deglupta", EnumLeafType.JUNGLE, new Color(0xB7F025), new Color(0xB7F025), EnumSaplingType.Default, EnumExtraTreeLog.Eucalyptus3, new Color(0x6CB03F)){
		
		@Override
		public WorldGenerator getWorldGenerator(ITreeGenData tree) {
			return new WorldGenEucalyptus.RainbowGum(tree);
		}
		
		@Override
		protected void setAlleles(AlleleTemplate template)  {
			template.set(EnumTreeChromosome.FERTILITY, ForestryAllele.Saplings.Low.getAllele());
			template.set(EnumTreeChromosome.YIELD, ForestryAllele.Yield.Lower.getAllele());
		}

		@Override
		protected void setSpeciesProperties(IAlleleTreeSpeciesBuilder species) {
			species.addFruitFamily(AlleleManager.alleleRegistry.getFruitFamily("forestry.jungle"));
			species.addFruitFamily(AlleleManager.alleleRegistry.getFruitFamily("forestry.nuts"));
		}
	},
	PinkIvory("berchemia", "zeyheri", EnumLeafType.DECIDUOUS, new Color(0x7C9159), new Color(0x7C9159), EnumSaplingType.Default, EnumExtraTreeLog.PinkIvory, new Color(0x7F6554)){
		
		@Override
		public WorldGenerator getWorldGenerator(ITreeGenData tree) {
			return new WorldGenTree(tree);
		}
		
		@Override
		protected void setAlleles(AlleleTemplate template)  {
			template.set(EnumTreeChromosome.HEIGHT, ForestryAllele.TreeHeight.Smallest.getAllele());
		}

		@Override
		protected void setSpeciesProperties(IAlleleTreeSpeciesBuilder species) {
			species.addFruitFamily(AlleleManager.alleleRegistry.getFruitFamily("forestry.jungle"));
			species.addFruitFamily(AlleleManager.alleleRegistry.getFruitFamily("forestry.nuts"));
		}
	},
	Blackcurrant("ribes", "nigrum", EnumLeafType.DECIDUOUS, new Color(0xA6DA5C), new Color(0xA6DA5C), EnumSaplingType.Shrub, EnumExtraTreeLog.EMPTY, new Color(0xFFFFFF)){
		
		@Override
		public WorldGenerator getWorldGenerator(ITreeGenData tree) {
			return new WorldGenShrub.Shrub(tree);
		}
		
		@Override
		protected void setAlleles(AlleleTemplate template)  {
			template.set(EnumTreeChromosome.FRUITS, AlleleETFruit.Blackcurrant);
			template.set(EnumTreeChromosome.HEIGHT, ForestryAllele.TreeHeight.Smallest.getAllele());
			template.set(EnumTreeChromosome.FERTILITY, ForestryAllele.Saplings.Low.getAllele());
			template.set(EnumTreeChromosome.YIELD, ForestryAllele.Yield.Average.getAllele());
			template.set(EnumTreeChromosome.SAPPINESS, ForestryAllele.Sappiness.Lower.getAllele());
			template.set(EnumTreeChromosome.MATURATION, ForestryAllele.Maturation.Faster.getAllele());
		}

		@Override
		protected void setSpeciesProperties(IAlleleTreeSpeciesBuilder species) {
			species.addFruitFamily(AlleleManager.alleleRegistry.getFruitFamily("forestry.prunes"));
			species.addFruitFamily(AlleleManager.alleleRegistry.getFruitFamily("forestry.nuts"));
			species.addFruitFamily(ETFruitFamily.Berry);
		}
	},
	Redcurrant("ribes", "rubrum", EnumLeafType.DECIDUOUS, new Color(0x74AC00), new Color(0x74AC00), EnumSaplingType.Shrub, EnumExtraTreeLog.EMPTY, new Color(0xFFFFFF)){
		
		@Override
		public WorldGenerator getWorldGenerator(ITreeGenData tree) {
			return new WorldGenShrub.Shrub(tree);
		}
		
		@Override
		protected void setAlleles(AlleleTemplate template)  {
			template.set(EnumTreeChromosome.FRUITS, AlleleETFruit.Redcurrant);
			template.set(EnumTreeChromosome.HEIGHT, ForestryAllele.TreeHeight.Smallest.getAllele());
			template.set(EnumTreeChromosome.FERTILITY, ForestryAllele.Saplings.Average.getAllele());
			template.set(EnumTreeChromosome.YIELD, ForestryAllele.Yield.Average.getAllele());
			template.set(EnumTreeChromosome.SAPPINESS, ForestryAllele.Sappiness.Low.getAllele());
			template.set(EnumTreeChromosome.MATURATION, ForestryAllele.Maturation.Faster.getAllele());
		}

		@Override
		protected void setSpeciesProperties(IAlleleTreeSpeciesBuilder species) {
			species.addFruitFamily(AlleleManager.alleleRegistry.getFruitFamily("forestry.prunes"));
			species.addFruitFamily(AlleleManager.alleleRegistry.getFruitFamily("forestry.nuts"));
			species.addFruitFamily(ETFruitFamily.Berry);
		}
	},
	Blackberry("rubus", "fruticosus", EnumLeafType.DECIDUOUS, new Color(0x92C15B), new Color(0x92C15B), EnumSaplingType.Shrub, EnumExtraTreeLog.EMPTY, new Color(0xFFFFFF)){
		
		@Override
		public WorldGenerator getWorldGenerator(ITreeGenData tree) {
			return new WorldGenShrub.Shrub(tree);
		}
		
		@Override
		protected void setAlleles(AlleleTemplate template)  {
			template.set(EnumTreeChromosome.FRUITS, AlleleETFruit.Blackberry);
			template.set(EnumTreeChromosome.HEIGHT, ForestryAllele.TreeHeight.Smallest.getAllele());
			template.set(EnumTreeChromosome.YIELD, ForestryAllele.Yield.High.getAllele());
			template.set(EnumTreeChromosome.SAPPINESS, ForestryAllele.Sappiness.Lower.getAllele());
			template.set(EnumTreeChromosome.MATURATION, ForestryAllele.Maturation.Faster.getAllele());
		}

		@Override
		protected void setSpeciesProperties(IAlleleTreeSpeciesBuilder species) {
			species.addFruitFamily(AlleleManager.alleleRegistry.getFruitFamily("forestry.prunes"));
			species.addFruitFamily(AlleleManager.alleleRegistry.getFruitFamily("forestry.nuts"));
			species.addFruitFamily(ETFruitFamily.Berry);
		}
	},
	Raspberry("rubus", "idaeus", EnumLeafType.DECIDUOUS, new Color(0x83B96E), new Color(0x83B96E), EnumSaplingType.Shrub, EnumExtraTreeLog.EMPTY, new Color(0xFFFFFF)){
		
		@Override
		public WorldGenerator getWorldGenerator(ITreeGenData tree) {
			return new WorldGenShrub.Shrub(tree);
		}
		
		@Override
		protected void setAlleles(AlleleTemplate template)  {
			template.set(EnumTreeChromosome.FRUITS, AlleleETFruit.Raspberry);
			template.set(EnumTreeChromosome.HEIGHT, ForestryAllele.TreeHeight.Smallest.getAllele());
			template.set(EnumTreeChromosome.FERTILITY, ForestryAllele.Saplings.Low.getAllele());
			template.set(EnumTreeChromosome.YIELD, ForestryAllele.Yield.Average.getAllele());
			template.set(EnumTreeChromosome.SAPPINESS, ForestryAllele.Sappiness.Lower.getAllele());
			template.set(EnumTreeChromosome.MATURATION, ForestryAllele.Maturation.Faster.getAllele());
		}

		@Override
		protected void setSpeciesProperties(IAlleleTreeSpeciesBuilder species) {
			species.addFruitFamily(AlleleManager.alleleRegistry.getFruitFamily("forestry.prunes"));
			species.addFruitFamily(AlleleManager.alleleRegistry.getFruitFamily("forestry.nuts"));
			species.addFruitFamily(ETFruitFamily.Berry);
		}
	},
	Blueberry("vaccinium", "corymbosum", EnumLeafType.DECIDUOUS, new Color(0x72C750), new Color(0x72C750), EnumSaplingType.Shrub, EnumExtraTreeLog.EMPTY, new Color(0xFFFFFF)){
		
		@Override
		public WorldGenerator getWorldGenerator(ITreeGenData tree) {
			return new WorldGenShrub.Shrub(tree);
		}
		
		@Override
		protected void setAlleles(AlleleTemplate template)  {
			template.set(EnumTreeChromosome.FRUITS, AlleleETFruit.Blueberry);
			template.set(EnumTreeChromosome.HEIGHT, ForestryAllele.TreeHeight.Smallest.getAllele());
			template.set(EnumTreeChromosome.FERTILITY, ForestryAllele.Saplings.Average.getAllele());
			template.set(EnumTreeChromosome.YIELD, ForestryAllele.Yield.Average.getAllele());
			template.set(EnumTreeChromosome.SAPPINESS, ForestryAllele.Sappiness.Low.getAllele());
			template.set(EnumTreeChromosome.MATURATION, ForestryAllele.Maturation.Faster.getAllele());
		}

		@Override
		protected void setSpeciesProperties(IAlleleTreeSpeciesBuilder species) {
			species.addFruitFamily(AlleleManager.alleleRegistry.getFruitFamily("forestry.prunes"));
			species.addFruitFamily(AlleleManager.alleleRegistry.getFruitFamily("forestry.nuts"));
			species.addFruitFamily(ETFruitFamily.Berry);
		}
	},
	Cranberry("vaccinium", "oxycoccos", EnumLeafType.DECIDUOUS, new Color(0x96D179), new Color(0x96D179), EnumSaplingType.Shrub, EnumExtraTreeLog.EMPTY, new Color(0xFFFFFF)){
		
		@Override
		public WorldGenerator getWorldGenerator(ITreeGenData tree) {
			return new WorldGenShrub.Shrub(tree);
		}
		
		@Override
		protected void setAlleles(AlleleTemplate template)  {
			template.set(EnumTreeChromosome.FRUITS, AlleleETFruit.Cranberry);
			template.set(EnumTreeChromosome.HEIGHT, ForestryAllele.TreeHeight.Smallest.getAllele());
			template.set(EnumTreeChromosome.FERTILITY, ForestryAllele.Saplings.Average.getAllele());
			template.set(EnumTreeChromosome.YIELD, ForestryAllele.Yield.High.getAllele());
			template.set(EnumTreeChromosome.SAPPINESS, ForestryAllele.Sappiness.Low.getAllele());
			template.set(EnumTreeChromosome.MATURATION, ForestryAllele.Maturation.Faster.getAllele());
		}

		@Override
		protected void setSpeciesProperties(IAlleleTreeSpeciesBuilder species) {
			species.addFruitFamily(AlleleManager.alleleRegistry.getFruitFamily("forestry.prunes"));
			species.addFruitFamily(AlleleManager.alleleRegistry.getFruitFamily("forestry.nuts"));
			species.addFruitFamily(ETFruitFamily.Berry);
		}
	},
	Juniper("juniperus", "communis", EnumLeafType.CONIFERS, new Color(0x90B149), new Color(0x90B149), EnumSaplingType.Shrub, EnumExtraTreeLog.EMPTY, new Color(0xFFFFFF)){
		
		@Override
		public WorldGenerator getWorldGenerator(ITreeGenData tree) {
			return new WorldGenShrub.Shrub(tree);
		}
		
		@Override
		protected void setAlleles(AlleleTemplate template)  {
			template.set(EnumTreeChromosome.FRUITS, AlleleETFruit.Juniper);
			template.set(EnumTreeChromosome.HEIGHT, ForestryAllele.TreeHeight.Smallest.getAllele());
			template.set(EnumTreeChromosome.FERTILITY, ForestryAllele.Saplings.Low.getAllele());
			template.set(EnumTreeChromosome.YIELD, ForestryAllele.Yield.Low.getAllele());
			template.set(EnumTreeChromosome.SAPPINESS, ForestryAllele.Sappiness.Low.getAllele());
			template.set(EnumTreeChromosome.MATURATION, ForestryAllele.Maturation.Faster.getAllele());
		}

		@Override
		protected void setSpeciesProperties(IAlleleTreeSpeciesBuilder species) {
			species.addFruitFamily(AlleleManager.alleleRegistry.getFruitFamily("forestry.prunes"));
			species.addFruitFamily(AlleleManager.alleleRegistry.getFruitFamily("forestry.nuts"));
			species.addFruitFamily(ETFruitFamily.Berry);
		}
	},
	Gooseberry("ribes", "grossularia", EnumLeafType.DECIDUOUS, new Color(0x79BB00), new Color(0x79BB00), EnumSaplingType.Shrub, EnumExtraTreeLog.EMPTY, new Color(0xFFFFFF)){
		
		@Override
		public WorldGenerator getWorldGenerator(ITreeGenData tree) {
			return new WorldGenShrub.Shrub(tree);
		}
		
		@Override
		protected void setAlleles(AlleleTemplate template)  {
			template.set(EnumTreeChromosome.FRUITS, AlleleETFruit.Gooseberry);
			template.set(EnumTreeChromosome.HEIGHT, ForestryAllele.TreeHeight.Smallest.getAllele());
			template.set(EnumTreeChromosome.FERTILITY, ForestryAllele.Saplings.High.getAllele());
			template.set(EnumTreeChromosome.YIELD, ForestryAllele.Yield.High.getAllele());
			template.set(EnumTreeChromosome.MATURATION, ForestryAllele.Maturation.Faster.getAllele());
		}

		@Override
		protected void setSpeciesProperties(IAlleleTreeSpeciesBuilder species) {
			species.addFruitFamily(AlleleManager.alleleRegistry.getFruitFamily("forestry.prunes"));
			species.addFruitFamily(AlleleManager.alleleRegistry.getFruitFamily("forestry.nuts"));
			species.addFruitFamily(ETFruitFamily.Berry);
		}
	},
	GoldenRaspberry("rubus", "occidentalis", EnumLeafType.DECIDUOUS, new Color(0x83B96E), new Color(0x83B96E), EnumSaplingType.Shrub, EnumExtraTreeLog.EMPTY, new Color(0xFFFFFF)){
		
		@Override
		public WorldGenerator getWorldGenerator(ITreeGenData tree) {
			return new WorldGenShrub.Shrub(tree);
		}
		
		@Override
		protected void setAlleles(AlleleTemplate template)  {
			template.set(EnumTreeChromosome.FRUITS, AlleleETFruit.GoldenRaspberry);
			template.set(EnumTreeChromosome.HEIGHT, ForestryAllele.TreeHeight.Smaller.getAllele());
			template.set(EnumTreeChromosome.FERTILITY, ForestryAllele.Saplings.Low.getAllele());
			template.set(EnumTreeChromosome.YIELD, ForestryAllele.Yield.Average.getAllele());
			template.set(EnumTreeChromosome.SAPPINESS, ForestryAllele.Sappiness.Lower.getAllele());
			template.set(EnumTreeChromosome.MATURATION, ForestryAllele.Maturation.Fastest.getAllele());
		}

		@Override
		protected void setSpeciesProperties(IAlleleTreeSpeciesBuilder species) {
			species.addFruitFamily(AlleleManager.alleleRegistry.getFruitFamily("forestry.prunes"));
			species.addFruitFamily(AlleleManager.alleleRegistry.getFruitFamily("forestry.nuts"));
			species.addFruitFamily(ETFruitFamily.Berry);
		}
	},
	Cinnamon("cinnamomum", "cassia", EnumLeafType.JUNGLE, new Color(0x738E0B), new Color(0x738E0B), EnumSaplingType.Default, EnumExtraTreeLog.Cinnamon, new Color(0x86583C)){
		
		@Override
		public WorldGenerator getWorldGenerator(ITreeGenData tree) {
			return new WorldGenLazy.Tree(tree);
		}
		
		@Override
		protected void setAlleles(AlleleTemplate template)  {
			template.set(EnumTreeChromosome.HEIGHT, ForestryAllele.TreeHeight.Average.getAllele());
			template.set(EnumTreeChromosome.YIELD, ForestryAllele.Yield.Lower.getAllele());
			template.set(EnumTreeChromosome.MATURATION, ForestryAllele.Maturation.Fast.getAllele());
		}

		@Override
		protected void setSpeciesProperties(IAlleleTreeSpeciesBuilder species) {
			species.addFruitFamily(AlleleManager.alleleRegistry.getFruitFamily("forestry.jungle"));
			species.addFruitFamily(AlleleManager.alleleRegistry.getFruitFamily("forestry.nuts"));
		}
	},
	Coconut("cocous", "nucifera", EnumLeafType.PALM, new Color(0x649923), new Color(0x649923), EnumSaplingType.Default, EnumVanillaWoodType.JUNGLE, new Color(0x53411A)){
		
		@Override
		public WorldGenerator getWorldGenerator(ITreeGenData tree) {
			return new WorldGenPalm.Coconut(tree);
		}
		
		@Override
		protected void setAlleles(AlleleTemplate template)  {
			template.set(EnumTreeChromosome.FRUITS, AlleleETFruit.Coconut);
			template.set(EnumTreeChromosome.HEIGHT, ForestryAllele.TreeHeight.Smaller.getAllele());
			template.set(EnumTreeChromosome.FERTILITY, ForestryAllele.Saplings.Low.getAllele());
			template.set(EnumTreeChromosome.YIELD, ForestryAllele.Yield.Average.getAllele());
			template.set(EnumTreeChromosome.MATURATION, ForestryAllele.Maturation.Fast.getAllele());
		}

		@Override
		protected void setSpeciesProperties(IAlleleTreeSpeciesBuilder species) {
			species.addFruitFamily(AlleleManager.alleleRegistry.getFruitFamily("forestry.jungle"));
		}
	},
	Cashew("anacardium", "occidentale", EnumLeafType.JUNGLE, new Color(0xABB962), new Color(0xABB962), EnumSaplingType.Default, EnumVanillaWoodType.JUNGLE, new Color(0x53411A)){
		
		@Override
		public WorldGenerator getWorldGenerator(ITreeGenData tree) {
			return new WorldGenLazy.Tree(tree);
		}
		
		@Override
		protected void setAlleles(AlleleTemplate template)  {
			template.set(EnumTreeChromosome.FRUITS, AlleleETFruit.Cashew);
			template.set(EnumTreeChromosome.YIELD, ForestryAllele.Yield.Low.getAllele());
		}

		@Override
		protected void setSpeciesProperties(IAlleleTreeSpeciesBuilder species) {
			species.addFruitFamily(AlleleManager.alleleRegistry.getFruitFamily("forestry.jungle"));
			species.addFruitFamily(AlleleManager.alleleRegistry.getFruitFamily("forestry.nuts"));
		}
	},
	Avacado("persea", "americana", EnumLeafType.JUNGLE, new Color(0x96A375), new Color(0x96A375), EnumSaplingType.Default, EnumVanillaWoodType.JUNGLE, new Color(0x53411A)){
		
		@Override
		public WorldGenerator getWorldGenerator(ITreeGenData tree) {
			return new WorldGenLazy.Tree(tree);
		}
		
		@Override
		protected void setAlleles(AlleleTemplate template)  {
			template.set(EnumTreeChromosome.FRUITS, AlleleETFruit.Avacado);
			template.set(EnumTreeChromosome.HEIGHT, ForestryAllele.TreeHeight.Smallest.getAllele());
			template.set(EnumTreeChromosome.YIELD, ForestryAllele.Yield.Average.getAllele());
		}

		@Override
		protected void setSpeciesProperties(IAlleleTreeSpeciesBuilder species) {
			species.addFruitFamily(AlleleManager.alleleRegistry.getFruitFamily("forestry.prunes"));
			species.addFruitFamily(AlleleManager.alleleRegistry.getFruitFamily("forestry.jungle"));
			species.addFruitFamily(ETFruitFamily.Citrus);
		}
	},
	Nutmeg("myristica", "fragrans", EnumLeafType.JUNGLE, new Color(0x488D4C), new Color(0x488D4C), EnumSaplingType.Default, EnumVanillaWoodType.JUNGLE, new Color(0x53411A)){
		
		@Override
		public WorldGenerator getWorldGenerator(ITreeGenData tree) {
			return new WorldGenLazy.Tree(tree);
		}
		
		@Override
		protected void setAlleles(AlleleTemplate template)  {
			template.set(EnumTreeChromosome.FRUITS, AlleleETFruit.Nutmeg);
			template.set(EnumTreeChromosome.HEIGHT, ForestryAllele.TreeHeight.Smaller.getAllele());
			template.set(EnumTreeChromosome.YIELD, ForestryAllele.Yield.High.getAllele());
			template.set(EnumTreeChromosome.SAPPINESS, ForestryAllele.Sappiness.Low.getAllele());
		}

		@Override
		protected void setSpeciesProperties(IAlleleTreeSpeciesBuilder species) {
			species.addFruitFamily(AlleleManager.alleleRegistry.getFruitFamily("forestry.jungle"));
			species.addFruitFamily(AlleleManager.alleleRegistry.getFruitFamily("forestry.nuts"));
		}
	},
	Allspice("pimenta", "dioica", EnumLeafType.JUNGLE, new Color(0x7C9724), new Color(0x7C9724), EnumSaplingType.Default, EnumVanillaWoodType.JUNGLE, new Color(0x53411A)){
		
		@Override
		public WorldGenerator getWorldGenerator(ITreeGenData tree) {
			return new WorldGenLazy.Tree(tree);
		}
		
		@Override
		protected void setAlleles(AlleleTemplate template)  {
			template.set(EnumTreeChromosome.FRUITS, AlleleETFruit.Allspice);
			template.set(EnumTreeChromosome.HEIGHT, ForestryAllele.TreeHeight.Smallest.getAllele());
			template.set(EnumTreeChromosome.FERTILITY, ForestryAllele.Saplings.Low.getAllele());
			template.set(EnumTreeChromosome.YIELD, ForestryAllele.Yield.High.getAllele());
		}

		@Override
		protected void setSpeciesProperties(IAlleleTreeSpeciesBuilder species) {
			species.addFruitFamily(AlleleManager.alleleRegistry.getFruitFamily("forestry.jungle"));
			species.addFruitFamily(AlleleManager.alleleRegistry.getFruitFamily("forestry.nuts"));
		}
	},
	Chilli("capsicum", "annuum", EnumLeafType.JUNGLE, new Color(0x2A9F01), new Color(0x2A9F01), EnumSaplingType.Default, EnumVanillaWoodType.JUNGLE, new Color(0x53411A)){
		
		@Override
		public WorldGenerator getWorldGenerator(ITreeGenData tree) {
			return new WorldGenLazy.Tree(tree);
		}
		
		@Override
		protected void setAlleles(AlleleTemplate template)  {
			template.set(EnumTreeChromosome.FRUITS, AlleleETFruit.Chilli);
			template.set(EnumTreeChromosome.HEIGHT, ForestryAllele.TreeHeight.Smaller.getAllele());
			template.set(EnumTreeChromosome.YIELD, ForestryAllele.Yield.Higher.getAllele());
			template.set(EnumTreeChromosome.SAPPINESS, ForestryAllele.Sappiness.Lower.getAllele());
			template.set(EnumTreeChromosome.MATURATION, ForestryAllele.Maturation.Fast.getAllele());
		}

		@Override
		protected void setSpeciesProperties(IAlleleTreeSpeciesBuilder species) {
			species.addFruitFamily(AlleleManager.alleleRegistry.getFruitFamily("forestry.jungle"));
			species.addFruitFamily(AlleleManager.alleleRegistry.getFruitFamily("forestry.nuts"));
		}
	},
	StarAnise("illicium", "verum", EnumLeafType.JUNGLE, new Color(0x7FC409), new Color(0x7FC409), EnumSaplingType.Default, EnumVanillaWoodType.JUNGLE, new Color(0x53411A)){
		
		@Override
		public WorldGenerator getWorldGenerator(ITreeGenData tree) {
			return new WorldGenLazy.Tree(tree);
		}
		
		@Override
		protected void setAlleles(AlleleTemplate template)  {
			template.set(EnumTreeChromosome.FRUITS, AlleleETFruit.StarAnise);
			template.set(EnumTreeChromosome.HEIGHT, ForestryAllele.TreeHeight.Average.getAllele());
			template.set(EnumTreeChromosome.YIELD, ForestryAllele.Yield.High.getAllele());
		}

		@Override
		protected void setSpeciesProperties(IAlleleTreeSpeciesBuilder species) {
			species.addFruitFamily(AlleleManager.alleleRegistry.getFruitFamily("forestry.jungle"));
			species.addFruitFamily(AlleleManager.alleleRegistry.getFruitFamily("forestry.nuts"));
		}
	},
	Mango("mangifera", "indica", EnumLeafType.JUNGLE, new Color(0x87B574), new Color(0x87B574), EnumSaplingType.Default, EnumVanillaWoodType.JUNGLE, new Color(0x53411A)){
		
		@Override
		public WorldGenerator getWorldGenerator(ITreeGenData tree) {
			return new WorldGenTropical.Mango(tree);
		}
		
		@Override
		protected void setAlleles(AlleleTemplate template)  {
			template.set(EnumTreeChromosome.FRUITS, AlleleETFruit.Mango);
			template.set(EnumTreeChromosome.HEIGHT, ForestryAllele.TreeHeight.Smaller.getAllele());
			template.set(EnumTreeChromosome.FERTILITY, ForestryAllele.Saplings.Low.getAllele());
			template.set(EnumTreeChromosome.YIELD, ForestryAllele.Yield.Average.getAllele());
			template.set(EnumTreeChromosome.SAPPINESS, ForestryAllele.Sappiness.Lower.getAllele());
			template.set(EnumTreeChromosome.MATURATION, ForestryAllele.Maturation.Fast.getAllele());
		}

		@Override
		protected void setSpeciesProperties(IAlleleTreeSpeciesBuilder species) {
			species.addFruitFamily(AlleleManager.alleleRegistry.getFruitFamily("forestry.prunes"));
			species.addFruitFamily(AlleleManager.alleleRegistry.getFruitFamily("forestry.pomes"));
			species.addFruitFamily(AlleleManager.alleleRegistry.getFruitFamily("forestry.jungle"));
			species.addFruitFamily(ETFruitFamily.Citrus);
		}
	},
	Starfruit("averrhoa", "carambola", EnumLeafType.JUNGLE,  new Color(0x6DA92D), new Color(0x6DA92D), EnumSaplingType.Default, EnumVanillaWoodType.JUNGLE, new Color(0x53411A)){
		
		@Override
		public WorldGenerator getWorldGenerator(ITreeGenData tree) {
			return new WorldGenLazy.Tree(tree);
		}
		
		@Override
		protected void setAlleles(AlleleTemplate template)  {
			template.set(EnumTreeChromosome.FRUITS, AlleleETFruit.Starfruit);
			template.set(EnumTreeChromosome.YIELD, ForestryAllele.Yield.Average.getAllele());
			template.set(EnumTreeChromosome.MATURATION, ForestryAllele.Maturation.Fast.getAllele());
		}

		@Override
		protected void setSpeciesProperties(IAlleleTreeSpeciesBuilder species) {
			species.addFruitFamily(AlleleManager.alleleRegistry.getFruitFamily("forestry.prunes"));
			species.addFruitFamily(AlleleManager.alleleRegistry.getFruitFamily("forestry.jungle"));
			species.addFruitFamily(ETFruitFamily.Citrus);
		}
	},
	Candlenut("aleurites", "moluccana", EnumLeafType.DECIDUOUS, new Color(0x8AA36C), new Color(0x8AA36C), EnumSaplingType.Default, EnumVanillaWoodType.JUNGLE, new Color(0x53411A)){
		
		@Override
		public WorldGenerator getWorldGenerator(ITreeGenData tree) {
			return new WorldGenLazy.Tree(tree);
		}
		
		@Override
		protected void setAlleles(AlleleTemplate template)  {
			template.set(EnumTreeChromosome.FRUITS, AlleleETFruit.Candlenut);
			template.set(EnumTreeChromosome.HEIGHT, ForestryAllele.TreeHeight.Smallest.getAllele());
			template.set(EnumTreeChromosome.FERTILITY, ForestryAllele.Saplings.Lowest.getAllele());
			template.set(EnumTreeChromosome.YIELD, ForestryAllele.Yield.Low.getAllele());
			template.set(EnumTreeChromosome.SAPPINESS, ForestryAllele.Sappiness.Low.getAllele());
		}

		@Override
		protected void setSpeciesProperties(IAlleleTreeSpeciesBuilder species) {
			species.addFruitFamily(AlleleManager.alleleRegistry.getFruitFamily("forestry.jungle"));
			species.addFruitFamily(AlleleManager.alleleRegistry.getFruitFamily("forestry.nuts"));
		}
	},
	DwarfHazel("Corylus", "americana", EnumLeafType.DECIDUOUS, new Color(0x9BB552), new Color(0x9BE152), EnumSaplingType.Shrub, EnumExtraTreeLog.Hazel, new Color(0xAA986F)){
		
		@Override
		public WorldGenerator getWorldGenerator(ITreeGenData tree) {
			return new WorldGenShrub.Shrub(tree);
		}
		
		@Override
		protected void setAlleles(AlleleTemplate template)  {
			template.set(EnumTreeChromosome.FRUITS, AlleleETFruit.Hazelnut);
			template.set(EnumTreeChromosome.FERTILITY, ForestryAllele.Saplings.Average.getAllele());
			template.set(EnumTreeChromosome.SAPPINESS, ForestryAllele.Sappiness.Lower.getAllele());
			template.set(EnumTreeChromosome.MATURATION, ForestryAllele.Maturation.Faster.getAllele());
		}

		@Override
		protected void setSpeciesProperties(IAlleleTreeSpeciesBuilder species) {
			species.addFruitFamily(AlleleManager.alleleRegistry.getFruitFamily("forestry.prunes"));
			species.addFruitFamily(AlleleManager.alleleRegistry.getFruitFamily("forestry.nuts"));
		}
	};
	
	public static ETTreeDefinition[] VALUES = values();

	private String branchName;
	private String binomial;
	private Color leafColor;
	private Color leafPollinatedColor;
	private Color woodColor;
	private EnumLeafType leafType;
	private ILeafSpriteProvider leafSpriteProvider;
	private EnumSaplingType saplingType;
	private IWoodType woodType;
	private IWoodProvider woodProvider;
	private IClassification branch;
	private IAlleleTreeSpecies species;
	private ITreeGenome genome;
	private AlleleTemplate template;
	private static final String unlocalizedName = "extratrees.species.%s.name";
	private static final String unlocalizedDesc = "extratrees.species.%s.desc";

	ETTreeDefinition(String branch, String binomial, EnumLeafType leafType, Color leafColor, Color leafPollinatedColor, EnumSaplingType saplingType, IWoodType woodType, Color woodColor) {
		this.binomial = binomial;
		this.leafType = leafType;
		this.leafColor = leafColor;
		this.leafPollinatedColor = leafPollinatedColor;
		this.leafSpriteProvider = TreeManager.treeFactory.getLeafIconProvider(leafType, leafColor, leafPollinatedColor);
		this.saplingType = saplingType;
		this.woodType = woodType;
		this.woodProvider = new WoodProvider(woodType);
		this.woodColor = woodColor;
		this.branchName = branch;


	}

	public static void initTrees() {
		for (ETTreeDefinition tree : values()) {
			tree.init();
		}
		for (ETTreeDefinition tree : values()) {
			tree.registerMutations();
		}
	}

	public static void preInitTrees() {
		for (ETTreeDefinition tree : values()) {
			tree.preInit();
		}
	}

	public void preInit() {
		final String scientific = StringUtils.capitalize(branchName);
		final String uid = "trees." + branchName;
		branch = AlleleManager.alleleRegistry.getClassification("genus." + uid);
		if (branch == null) {
			branch = AlleleManager.alleleRegistry.createAndRegisterClassification(IClassification.EnumClassLevel.GENUS, uid, scientific);
		}
		IAlleleTreeSpeciesBuilder speciesBuilder = TreeManager.treeFactory.createSpecies(getUID(), String.format(unlocalizedName, getUID()), getAuthority(), String.format(unlocalizedDesc, getUID()), isDominant(),
				branch, getBinomial(), Constants.EXTRA_TREES_MOD_ID, leafSpriteProvider, saplingType.getGermlingModelProvider(leafColor, woodColor), woodProvider, this, new ETLeafProvider());
		setSpeciesProperties(speciesBuilder);
		species = speciesBuilder.build();
		branch.addMemberSpecies(species);
	}

	public void init() {
		template = new AlleleTemplate();
		template.set(EnumTreeChromosome.SPECIES, species);
		setAlleles(template);
		genome = TreeManager.treeRoot.templateAsGenome(template.getAlleles());
		TreeManager.treeRoot.registerTemplate(template.getAlleles());
	}
	
	@Override
	public final ITreeGenome getGenome() {
		return genome;
	}
	
	@Override
	public final ITree getIndividual() {
		return new Tree(genome);
	}

	@Override
	public final ItemStack getMemberStack(EnumGermlingType treeType) {
		ITree tree = getIndividual();
		return TreeManager.treeRoot.getMemberStack(tree, treeType);
	}
	
	@Override
	public final IAllele[] getTemplate() {
		IAllele[] alleles = template.getAlleles();
		return Arrays.copyOf(alleles, alleles.length);
	}

	protected void setSpeciesProperties(IAlleleTreeSpeciesBuilder species) {

	}

	protected void setAlleles(AlleleTemplate template) {

	}

	protected void registerMutations() {

	}

	public String getUID() {
		return name().toLowerCase();
	}

	public boolean isDominant() {
		return true;
	}

	public String getBinomial() {
		return binomial;
	}

	public String getAuthority() {
		return "Binnie";
	}

	public Color getLeafColor() {
		return leafColor;
	}

	public Color getWoodColor() {
		return woodColor;
	}

	public String getBranchName() {
		return branchName;
	}

	public IAlleleTreeSpecies getSpecies() {
		return species;
	}
	
	public int getMetadata() {
		return ordinal();
	}

	public static ETTreeDefinition byMetadata(int meta) {
		if (meta < 0 || meta >= VALUES.length) {
			meta = 0;
		}
		return VALUES[meta];
	}
	
	@Override
	public String getName() {
		return name().toLowerCase(Locale.ENGLISH);
	}
	
	@Override
	public boolean setLogBlock(ITreeGenome genome, World world, BlockPos pos, EnumFacing facing) {
		AlleleBoolean fireproofAllele = (AlleleBoolean) genome.getActiveAllele(EnumTreeChromosome.FIREPROOF);
		boolean fireproof = fireproofAllele.getValue();
		IBlockState logBlock = TreeManager.woodAccess.getBlock(woodType, WoodBlockKind.LOG, fireproof);

		BlockLog.EnumAxis axis = BlockLog.EnumAxis.fromFacingAxis(facing.getAxis());
		return world.setBlockState(pos, logBlock.withProperty(BlockLog.LOG_AXIS, axis));
	}

	@Override
	public boolean setLeaves(ITreeGenome genome, World world, GameProfile owner, BlockPos pos) {
		boolean placed = world.setBlockState(pos, PluginArboriculture.blocks.leaves.getDefaultState());
		if (!placed) {
			return false;
		}

		Block block = world.getBlockState(pos).getBlock();
		if (PluginArboriculture.blocks.leaves != block) {
			world.setBlockToAir(pos);
			return false;
		}

		TileLeaves tileLeaves = TileUtil.getTile(world, pos, TileLeaves.class);
		if (tileLeaves == null) {
			world.setBlockToAir(pos);
			return false;
		}

		tileLeaves.getOwnerHandler().setOwner(owner);
		tileLeaves.setTree(new Tree(genome));

		world.markBlockRangeForRenderUpdate(pos, pos);
		return true;
	}

	private static class AlleleTemplate {
		IAllele[] alleles;

		protected AlleleTemplate() {
			alleles = TreeManager.treeRoot.getDefaultTemplate();
		}

		protected AlleleTemplate(IAllele[] alleles) {
			this.alleles = alleles;
		}

		public <T extends Enum<T> & IChromosomeType> void set(T chromosomeType, IAllele allele) {
			if (allele == null) {
				throw new NullPointerException("Allele must not be null");
			}
			if (!chromosomeType.getAlleleClass().isInstance(allele)) {
				throw new IllegalArgumentException("Allele is the wrong type. Expected: " + chromosomeType + " Got: " + allele);
			}
			alleles[chromosomeType.ordinal()] = allele;
		}

		public IAllele[] getAlleles() {
			return alleles;
		}
	}
}
package ua.artstood.TestMod2.init;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.block.model.ModelResourceLocation;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;
import net.minecraft.item.ItemBlock;
import net.minecraftforge.client.event.ModelRegistryEvent;
import net.minecraftforge.client.model.ModelLoader;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import ua.artstood.TestMod2.Reference;
import ua.artstood.TestMod2.blocks.BlockBasic;
import ua.artstood.TestMod2.blocks.BlockOre;

@Mod.EventBusSubscriber(modid=Reference.MODID)
public class ModBlocks {
	
	static Block tutorialBlock;
	static Block tutorialOre;
	
	public static void init() {
		tutorialBlock = new BlockBasic("tutorial_block", Material.ROCK).setCreativeTab(CreativeTabs.BUILDING_BLOCKS).setHardness(2.5f).setLightLevel(0f);
		tutorialBlock.setHarvestLevel("pickaxe", 0);
		tutorialOre = new BlockOre("tutorial_ore", Material.ROCK, ModItems.tutorialItem, 1, 5).setHardness(3f).setResistance(5f).setCreativeTab(CreativeTabs.BUILDING_BLOCKS);
		tutorialOre.setHarvestLevel("pickaxe", 0);
	}
	
	@SubscribeEvent
	public static void registerBlocks(RegistryEvent.Register<Block> event) {
		event.getRegistry().registerAll(tutorialBlock);
		event.getRegistry().registerAll(tutorialOre);
	}
	
	@SubscribeEvent
	public static void registerItemBlocks(RegistryEvent.Register<Item> event) {
		event.getRegistry().registerAll(new ItemBlock(tutorialBlock).setRegistryName(tutorialBlock.getRegistryName()));
		event.getRegistry().registerAll(new ItemBlock(tutorialOre).setRegistryName(tutorialOre.getRegistryName()));
	}
	
	@SubscribeEvent
	public static void registerRenders(ModelRegistryEvent event) {
		registerRender(Item.getItemFromBlock(tutorialBlock));
		registerRender(Item.getItemFromBlock(tutorialOre));
	}
	
	public static void registerRender(Item item) {
		ModelLoader.setCustomModelResourceLocation(item, 0, new ModelResourceLocation(item.getRegistryName(),"inventory"));
	}
}

package ua.artstood.TestMod2.init;



import net.minecraft.client.renderer.block.model.ModelResourceLocation;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;
import net.minecraftforge.client.event.ModelRegistryEvent;
import net.minecraftforge.client.model.ModelLoader;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import ua.artstood.TestMod2.Reference;
import ua.artstood.TestMod2.items.ItemBasic;

@Mod.EventBusSubscriber(modid=Reference.MODID)
public class ModItems {
	
	static Item tutorialItem;
	static Item tutorialBrick;
	
	public static void init() {
			tutorialItem = new ItemBasic("tutorial_item").setCreativeTab(CreativeTabs.MATERIALS).setMaxStackSize(32);
			tutorialBrick = new ItemBasic("tutorial_brick").setCreativeTab(CreativeTabs.MATERIALS).setMaxStackSize(100);
	}
	
	@SubscribeEvent
	public static void registerItems(RegistryEvent.Register<Item> event) {
		event.getRegistry().registerAll(tutorialItem);
		event.getRegistry().registerAll(tutorialBrick);
	}
	
	@SubscribeEvent
	public static void registerRenders(ModelRegistryEvent event) {
		registerRender(tutorialItem);
		registerRender(tutorialBrick);
	}
	
	private static void registerRender(Item item) {
		ModelLoader.setCustomModelResourceLocation(item, 0, new ModelResourceLocation(item.getRegistryName(),"inventory"));
	}
}
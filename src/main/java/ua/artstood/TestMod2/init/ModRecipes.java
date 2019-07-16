package ua.artstood.TestMod2.init;

import net.minecraft.item.ItemStack;
import net.minecraftforge.fml.common.registry.GameRegistry;

public class ModRecipes {
	public static void init() {
		GameRegistry.addSmelting(ModItems.tutorialItem,new ItemStack(ModItems.tutorialBrick, 1), 0f);
	}
}

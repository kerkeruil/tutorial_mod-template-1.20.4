package net.kerkeruil.tut_mod;

import net.fabricmc.api.ModInitializer;

import net.fabricmc.fabric.api.registry.FuelRegistry;
import net.kerkeruil.tut_mod.block.ModBlocks;
import net.kerkeruil.tut_mod.enchantment.ModEnchantments;
import net.kerkeruil.tut_mod.item.ModItemGroups;
import net.kerkeruil.tut_mod.item.ModItems;
import net.kerkeruil.tut_mod.util.ModRegistries;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class TutorialMod implements ModInitializer {
	// This logger is used to write text to the console and the log file.
	// It is considered best practice to use your mod id as the logger's name.
	// That way, it's clear which mod wrote info, warnings, and errors.
	public static final String mod_ID = "tutorialmod";
    public static final Logger LOGGER = LoggerFactory.getLogger(mod_ID);

	@Override
	public void onInitialize() {
		// This code runs as soon as Minecraft is in a mod-load-ready state.
		// However, some things (like resources) may still be uninitialized.
		// Proceed with mild caution.
		ModItemGroups.registerItemGroups();
		ModItems.registerModItems();
		ModBlocks.registerModBlocks();
		ModEnchantments.registerModEnchantments();

		ModRegistries.registerModStuffs();

		FuelRegistry.INSTANCE.add(ModItems.COAL_BRIQUETTE, 200);
	}
}
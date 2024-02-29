package net.kerkeruil.tut_mod;

import net.fabricmc.api.ModInitializer;

import net.fabricmc.fabric.api.registry.FuelRegistry;
import net.kerkeruil.tut_mod.Potion.ModPotions;
import net.kerkeruil.tut_mod.block.ModBlocks;
import net.kerkeruil.tut_mod.block.entity.ModBlockEntities;
import net.kerkeruil.tut_mod.effect.ModEffects;
import net.kerkeruil.tut_mod.enchantment.ModEnchantments;
import net.kerkeruil.tut_mod.fluid.ModFluids;
import net.kerkeruil.tut_mod.item.ModItemGroups;
import net.kerkeruil.tut_mod.item.ModItems;
import net.kerkeruil.tut_mod.painting.ModPaintings;
import net.kerkeruil.tut_mod.particle.ModParticles;
import net.kerkeruil.tut_mod.recipe.ModRecipes;
import net.kerkeruil.tut_mod.sounds.ModSounds;
import net.kerkeruil.tut_mod.util.ModLootTableModifiers;
import net.kerkeruil.tut_mod.util.ModRegistries;
import net.kerkeruil.tut_mod.world.gen.ModWorldGeneration;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import static net.kerkeruil.tut_mod.sounds.ModSounds.registerSounds;

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

		ModRegistries.registerModStuffs();
		ModEnchantments.registerModEnchantments();
		ModSounds.registerSounds();;

		ModLootTableModifiers.modifyLootTables();
		ModPaintings.registerPaintings();
		ModEffects.registerEffects();
		ModPotions.registerPotions();

//		Has to be called here?
		ModParticles.registerParticles();
		ModFluids.registerFluids();
		ModBlockEntities.registerBlockEntities();
		ModRecipes.registerRecipes();

		ModWorldGeneration.generateModWorldGeneration();
	}
}
package net.kerkeruil.tut_mod.datagen;

import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricTagProvider;
import net.kerkeruil.tut_mod.block.ModBlocks;
import net.kerkeruil.tut_mod.item.ModItems;
import net.kerkeruil.tut_mod.sounds.ModSounds;
import net.minecraft.registry.RegistryWrapper;
import net.minecraft.registry.tag.ItemTags;

import java.util.concurrent.CompletableFuture;

public class ModItemTagProvider extends FabricTagProvider.ItemTagProvider {
    public ModItemTagProvider(FabricDataOutput output, CompletableFuture<RegistryWrapper.WrapperLookup> completableFuture) {
        super(output, completableFuture);
    }

    @Override
    protected void configure(RegistryWrapper.WrapperLookup arg) {
        getOrCreateTagBuilder(ItemTags.TRIMMABLE_ARMOR)
//              Ruby armor
                .add(ModItems.RUBY_HELMET,
                ModItems.RUBY_CHESTPLATE,
                ModItems.RUBY_LEGGINGS,
                ModItems.RUBY_BOOTS,

//              Hazmat armor
                ModItems.HAZMAT_SUIT_HELMET,
                ModItems.HAZMAT_SUIT_CHESTPLATE,
                ModItems.HAZMAT_SUIT_LEGGINGS,
                ModItems.HAZMAT_SUIT_BOOTS);

    getOrCreateTagBuilder(ItemTags.MUSIC_DISCS)
            .add(ModItems.BAR_BRAWL_MUSIC_DISC);

//      So they are used for smelting recipes
        getOrCreateTagBuilder(ItemTags.LOGS_THAT_BURN)
                .add(ModBlocks.DRIFTWOOD_LOG.asItem(), ModBlocks.DRIFTWOOD_WOOD.asItem(),
                        ModBlocks.STRIPPED_DRIFTWOOD_LOG.asItem(), ModBlocks.STRIPPED_DRIFTWOOD_WOOD.asItem());

//      For crafting non wood specific recipes
        getOrCreateTagBuilder(ItemTags.PLANKS)
                .add(ModBlocks.DRIFTWOOD_PLANKS.asItem());
    }
}

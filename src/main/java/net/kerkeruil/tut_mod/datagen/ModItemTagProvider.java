package net.kerkeruil.tut_mod.datagen;

import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricTagProvider;
import net.kerkeruil.tut_mod.item.ModItems;
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
    }
}

package net.kerkeruil.tut_mod.util;

import net.kerkeruil.tut_mod.TutorialMod;
import net.kerkeruil.tut_mod.item.ModItems;
import net.minecraft.client.item.ModelPredicateProviderRegistry;
import net.minecraft.util.Identifier;

public class ModModelPredicateProvider {
    public static void registerModModels() {
        ModelPredicateProviderRegistry.register(ModItems.DATA_TABLET, new Identifier(TutorialMod.mod_ID, "on"),
                (stack, world, entity, seed) -> stack.hasNbt() ? 1f : 0f);
    }
}
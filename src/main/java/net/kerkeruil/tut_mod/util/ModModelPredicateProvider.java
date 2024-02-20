package net.kerkeruil.tut_mod.util;

import net.kerkeruil.tut_mod.TutorialMod;
import net.kerkeruil.tut_mod.item.ModItems;
import net.minecraft.client.item.ModelPredicateProviderRegistry;
import net.minecraft.item.Item;
import net.minecraft.item.Items;
import net.minecraft.util.Identifier;

public class ModModelPredicateProvider {
    public static void registerModModels() {
        ModelPredicateProviderRegistry.register(ModItems.DATA_TABLET, new Identifier(TutorialMod.mod_ID, "on"),
                (stack, world, entity, seed) -> stack.hasNbt() ? 1f : 0f);

        registerBow(ModItems.RUBY_BOW);

        ModelPredicateProviderRegistry.register(ModItems.RUBY_SHIELD, new Identifier("blocking"), (stack, world, entity, seed) -> entity != null && entity.isUsingItem() && entity.getActiveItem() == stack ? 1.0f : 0.0f);

    }

    private static void registerBow(Item bow) {
        ModelPredicateProviderRegistry.register(bow, new Identifier("pull"), (stack, world, entity, seed) -> {
            if (entity == null) {
                return 0.0f;
            }
            if (entity.getActiveItem() != stack) {
                return 0.0f;
            }
            return (float)(stack.getMaxUseTime() - entity.getItemUseTimeLeft()) / 20.0f;
        });
        ModelPredicateProviderRegistry.register(bow, new Identifier("pulling"),
                ((stack, world, entity, seed) -> entity != null && entity.isUsingItem() && entity.getActiveItem() == stack ? 1.0f : 0.0f));
    }
}
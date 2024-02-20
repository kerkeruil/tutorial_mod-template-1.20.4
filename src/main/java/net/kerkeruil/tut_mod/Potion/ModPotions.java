package net.kerkeruil.tut_mod.Potion;

import net.kerkeruil.tut_mod.TutorialMod;
import net.kerkeruil.tut_mod.effect.ModEffects;
import net.minecraft.entity.effect.StatusEffectInstance;
import net.minecraft.potion.Potion;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;

public class ModPotions {
    public static final Potion SLIMEY_POTION = registerPotion("slimey_potion",
            new Potion(new StatusEffectInstance(ModEffects.SLIMEY, 200, 0)));
    private static Potion registerPotion(String name, Potion potion) {
        return Registry.register(Registries.POTION, new Identifier(TutorialMod.mod_ID, name), potion);
    }
    public static void registerPotions(){
        TutorialMod.LOGGER.info("Registering Potions for " + TutorialMod.mod_ID);
    }
}

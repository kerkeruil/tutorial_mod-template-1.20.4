package net.kerkeruil.tut_mod.enchantment;

import net.kerkeruil.tut_mod.TutorialMod;
import net.minecraft.enchantment.Enchantment;
import net.minecraft.enchantment.EnchantmentTarget;
import net.minecraft.entity.EquipmentSlot;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;


public class ModEnchantments {

    public static final Enchantment LIGHTNING_STRIKER = register("lightning_striker",
            new LightningStrikerEnchantment(Enchantment.Rarity.COMMON,
                    EnchantmentTarget.WEAPON, EquipmentSlot.MAINHAND));
    private static Enchantment register(String name, Enchantment enchantment) {
        return Registry.register(Registries.ENCHANTMENT, new Identifier(TutorialMod.mod_ID, name), enchantment);
    }
    public static void registerModEnchantments() {
        TutorialMod.LOGGER.info("Registering ModEnchantments for " + TutorialMod.mod_ID);
    }
}

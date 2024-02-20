package net.kerkeruil.tut_mod.effect;

import net.kerkeruil.tut_mod.TutorialMod;
import net.minecraft.entity.attribute.EntityAttributeModifier;
import net.minecraft.entity.attribute.EntityAttributes;
import net.minecraft.entity.effect.StatusEffect;
import net.minecraft.entity.effect.StatusEffectCategory;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;
public class ModEffects {
    public static final StatusEffect SLIMEY = registerStatusEffect("slimey",
            new SlimeyEffect(StatusEffectCategory.NEUTRAL, 0x36ebab)
                    .addAttributeModifier(EntityAttributes.GENERIC_MOVEMENT_SPEED,
//                          Random uuid?
                            "7107DE5E-7CE8-4030-940E-514C1F160890", -0.25f,
                            EntityAttributeModifier.Operation.MULTIPLY_TOTAL));


    private static StatusEffect registerStatusEffect(String name, StatusEffect statusEffect) {
        return Registry.register(Registries.STATUS_EFFECT, new Identifier(TutorialMod.mod_ID, name), statusEffect);
    }

    public static void registerEffects() {
        TutorialMod.LOGGER.info("Registering Mod Effects for " + TutorialMod.mod_ID);
    }
}
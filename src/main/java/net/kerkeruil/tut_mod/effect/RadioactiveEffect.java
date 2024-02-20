package net.kerkeruil.tut_mod.effect;

import net.fabricmc.fabric.api.object.builder.v1.entity.FabricEntityTypeBuilder;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.effect.StatusEffect;
import net.minecraft.entity.effect.StatusEffectCategory;
import net.minecraft.util.math.Vec3d;

// Not slimey, rather sticky I would think
// Climbing Effect by SameDifferent: https://github.com/samedifferent/TrickOrTreat/blob/master/LICENSE
// MIT License!
public class RadioactiveEffect extends StatusEffect {
    protected RadioactiveEffect(StatusEffectCategory category, int color) {
        super(category, color);
    }

    @Override
    public void applyUpdateEffect(LivingEntity entity, int amplifier) {
        super.applyUpdateEffect(entity, amplifier);
        if (entity.getHealth() > 1.0f) {
            entity.damage(entity.getDamageSources().cactus(), 1.0f);
        }
    }

//  Apply tick everytime when just returning true (could maybe make this dependent of smt?)
    @Override
    public boolean canApplyUpdateEffect(int duration, int amplifier) {
        return true;
    }
}
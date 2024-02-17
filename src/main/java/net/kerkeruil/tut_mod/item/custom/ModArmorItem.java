package net.kerkeruil.tut_mod.item.custom;

import com.google.common.collect.ImmutableMap;
import net.kerkeruil.tut_mod.TutorialMod;
import net.kerkeruil.tut_mod.item.ModArmorMaterials;
import net.minecraft.entity.Entity;
import net.minecraft.entity.effect.StatusEffectInstance;
import net.minecraft.entity.effect.StatusEffects;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.ArmorItem;
import net.minecraft.item.ArmorMaterial;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;

import java.util.Map;

public class ModArmorItem extends ArmorItem {
//  Only works with custom armor materials and can only do this once per Material
    private static final Map<ArmorMaterial, StatusEffectInstance> MATERIAL_TO_EFFECT_MAP =
            new ImmutableMap.Builder<ArmorMaterial, StatusEffectInstance>()
                    .put(ModArmorMaterials.RUBY, new StatusEffectInstance(StatusEffects.HASTE, 400, 1))
//                    .put(ModArmorMaterials.ANTI_RADIATION, new StatusEffectInstance(StatusEffects., 400, 1))
                    .build();
    public ModArmorItem(ArmorMaterial material, Type type, Settings settings) {
        super(material, type, settings);
    }

//   Check if player is wearing armor
    @Override
    public void inventoryTick(ItemStack stack, World world, Entity entity, int slot, boolean selected) {
        if(!world.isClient() && entity instanceof PlayerEntity player) {
            if (hasFullSuitOfArmorOn(player)) {
                evaluateArmorEffects(player);
            }
        }

            super.inventoryTick(stack, world, entity, slot, selected);
        }

    private boolean hasFullSuitOfArmorOn(PlayerEntity player) {
            ItemStack boots = player.getInventory().getArmorStack(0);
            ItemStack leggings = player.getInventory().getArmorStack(1);
            ItemStack chestplate = player.getInventory().getArmorStack(2);
            ItemStack helmet = player.getInventory().getArmorStack(3);

            return !boots.isEmpty() && !leggings.isEmpty() && !chestplate.isEmpty() && !helmet.isEmpty();
    }

    private void evaluateArmorEffects(PlayerEntity player) {
        for(Map.Entry<ArmorMaterial, StatusEffectInstance> entry : MATERIAL_TO_EFFECT_MAP.entrySet()) {
            ArmorMaterial mapArmorMaterial = entry.getKey();
            StatusEffectInstance mapStatusEffect = entry.getValue();

            if(hasCorrectArmorOn(mapArmorMaterial, player)){
                addStatusEffectForMaterial(player, mapStatusEffect);
                break; // Cannot wear multiple types of armor, useful when having a lot of armor
            }
        }
    }

    private void addStatusEffectForMaterial(PlayerEntity player, StatusEffectInstance mapStatusEffect) {
        boolean hasPlayerEffectAlready = player.hasStatusEffect(mapStatusEffect.getEffectType());

        if(!hasPlayerEffectAlready){
//          Create new instance everytime because once it's used it's gone
            player.addStatusEffect(new StatusEffectInstance(mapStatusEffect.getEffectType(),
                    mapStatusEffect.getDuration(), mapStatusEffect.getAmplifier()));
        }
    }
    private boolean hasCorrectArmorOn(ArmorMaterial mapArmorMaterial, PlayerEntity player){
        for(ItemStack armorStack : player.getArmorItems()) {
            if(!(armorStack.getItem() instanceof ArmorItem)) {
                return false;
            }
        }

        ArmorItem boots = ((ArmorItem) player.getInventory().getArmorStack(0).getItem());
        ArmorItem leggings = ((ArmorItem) player.getInventory().getArmorStack(1).getItem());
        ArmorItem chestplate = ((ArmorItem) player.getInventory().getArmorStack(2).getItem());
        ArmorItem helmet = ((ArmorItem) player.getInventory().getArmorStack(3).getItem());

        return boots.getMaterial() == mapArmorMaterial && leggings.getMaterial() == mapArmorMaterial &&
                chestplate.getMaterial() == mapArmorMaterial && helmet.getMaterial() == mapArmorMaterial;
    }
}

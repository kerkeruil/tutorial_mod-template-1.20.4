package net.kerkeruil.tut_mod.util;

import net.fabricmc.fabric.api.object.builder.v1.entity.FabricDefaultAttributeRegistry;
import net.kerkeruil.tut_mod.entities.ModEntities;
import net.kerkeruil.tut_mod.entities.custom.PorcupineEntity;

public class ModRegistries {
    public static void registerModStuffs() {
        registerAttributes();
    }
    private static void registerAttributes() {
        FabricDefaultAttributeRegistry.register(ModEntities.PORCUPINE, PorcupineEntity.createPorcupineAttributes());
    }

}

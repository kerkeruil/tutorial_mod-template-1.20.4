package net.kerkeruil.tut_mod.block.entity;


import net.fabricmc.fabric.api.object.builder.v1.block.entity.FabricBlockEntityTypeBuilder;
import net.kerkeruil.tut_mod.TutorialMod;
import net.kerkeruil.tut_mod.block.ModBlocks;
import net.minecraft.block.entity.BlockEntityType;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;

public class ModBlockEntities {
    public static final BlockEntityType<GemEmpoweringStationBlockEntity> GEM_EMPOWERING_STATION_BE =
            Registry.register(Registries.BLOCK_ENTITY_TYPE, new Identifier(TutorialMod.mod_ID, "gem_empowering_block_entity"),
                    FabricBlockEntityTypeBuilder.create(GemEmpoweringStationBlockEntity::new,
                            ModBlocks.GEM_EMPOWERING_STATION).build(null));

    public static void registerBlockEntities() {
        TutorialMod.LOGGER.info("Registering Block Entities for " + TutorialMod.mod_ID);
    }
}
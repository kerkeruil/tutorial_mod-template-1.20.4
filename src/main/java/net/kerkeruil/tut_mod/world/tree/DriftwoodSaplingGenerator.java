package net.kerkeruil.tut_mod.world.tree;



import net.kerkeruil.tut_mod.world.ModConfiguredFeatures;
import net.minecraft.block.SaplingGenerator;
import net.minecraft.registry.RegistryKey;
import net.minecraft.world.gen.feature.ConfiguredFeature;

import java.util.Optional;

public class DriftwoodSaplingGenerator {
    public static final SaplingGenerator DRIFTWOOD_SAPLING_GENERATOR = new SaplingGenerator("driftwood_sapling_generator", 0f, Optional.empty(),
            Optional.empty(),
            Optional.of(ModConfiguredFeatures.DRIFTWOOD_KEY),
            Optional.empty(),
            Optional.empty(),
            Optional.empty());

//    public static final SaplingGenerator DRIFTWOOD_SAPLING_GENERATOR;

//    public DriftwoodSaplingGenerator() {
//    }
//    private static SaplingGenerator simpleGrower(String name, Optional<RegistryKey<ConfiguredFeature<?, ?>>> configuredFeatureResourceKey) {
//        return new SaplingGenerator(name, Optional.empty(), configuredFeatureResourceKey, Optional.empty());
//    }
//
//    static {
//        DRIFTWOOD_SAPLING_GENERATOR = simpleGrower("driftwood_sapling_generator", Optional.of(ModConfiguredFeatures.DRIFTWOOD_KEY));
//    }
}
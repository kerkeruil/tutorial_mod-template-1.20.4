package net.kerkeruil.tut_mod.datagen;


import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricTagProvider;
import net.kerkeruil.tut_mod.fluid.ModFluids;
import net.minecraft.registry.RegistryWrapper;
import net.minecraft.registry.tag.FluidTags;

import java.util.concurrent.CompletableFuture;

public class ModFluidTagProvider extends FabricTagProvider.FluidTagProvider {
    public ModFluidTagProvider(FabricDataOutput output, CompletableFuture<RegistryWrapper.WrapperLookup> completableFuture) {
        super(output, completableFuture);
    }

    @Override
    protected void configure(RegistryWrapper.WrapperLookup arg) {
//      When choosing lava it will behave like water
        this.getOrCreateTagBuilder(FluidTags.WATER)
                .add(ModFluids.FLOWING_SOAP_WATER)
                .add(ModFluids.STILL_SOAP_WATER)
                .add(ModFluids.FLOWING_SLUDGE)
                .add(ModFluids.STILL_SLUDGE);

//        this.getOrCreateTagBuilder(FluidTags.LAVA)
//                .add(ModFluids.FLOWING_SLUDGE)
//                .add(ModFluids.STILL_SLUDGE);
    }
}
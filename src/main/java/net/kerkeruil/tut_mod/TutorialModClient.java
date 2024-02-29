package net.kerkeruil.tut_mod;

import net.fabricmc.api.ClientModInitializer;
import net.fabricmc.fabric.api.blockrenderlayer.v1.BlockRenderLayerMap;
import net.fabricmc.fabric.api.client.model.ModelLoadingRegistry;
import net.fabricmc.fabric.api.client.particle.v1.ParticleFactoryRegistry;
import net.fabricmc.fabric.api.client.render.fluid.v1.FluidRenderHandlerRegistry;
import net.fabricmc.fabric.api.client.render.fluid.v1.SimpleFluidRenderHandler;
import net.fabricmc.fabric.api.client.rendering.v1.EntityModelLayerRegistry;
import net.fabricmc.fabric.api.client.rendering.v1.EntityRendererRegistry;
import net.kerkeruil.tut_mod.block.ModBlocks;
import net.minecraft.client.render.block.entity.SignBlockEntityRenderer;
import net.minecraft.client.render.block.entity.HangingSignBlockEntityRenderer;


import net.kerkeruil.tut_mod.block.entity.ModBlockEntities;
import net.kerkeruil.tut_mod.block.entity.renderer.GemEmpoweringBlockEntityRenderer;
import net.kerkeruil.tut_mod.entities.ModEntities;
import net.kerkeruil.tut_mod.entities.client.PorcupineModel;
import net.kerkeruil.tut_mod.entities.client.PorcupineRenderer;
import net.kerkeruil.tut_mod.entities.layer.ModModelLayers;
import net.kerkeruil.tut_mod.fluid.ModFluids;
import net.kerkeruil.tut_mod.networking.ModMessages;
import net.kerkeruil.tut_mod.particle.ModParticles;
import net.kerkeruil.tut_mod.particle.NuclearSignParticle;
import net.kerkeruil.tut_mod.particle.PinkGarnetParticle;
import net.kerkeruil.tut_mod.screen.GemEmpoweringScreen;
import net.kerkeruil.tut_mod.screen.ModScreenHandlers;
import net.kerkeruil.tut_mod.util.ModModelPredicateProvider;
import net.kerkeruil.tut_mod.util.ModWoodTypes;
import net.minecraft.client.gui.screen.ingame.HandledScreens;
import net.minecraft.client.render.RenderLayer;
import net.minecraft.client.render.TexturedRenderLayers;
import net.minecraft.client.render.block.entity.BlockEntityRendererFactories;
import net.minecraft.client.util.ModelIdentifier;

public class TutorialModClient implements ClientModInitializer {
    @Override
    public void onInitializeClient() {
        BlockRenderLayerMap.INSTANCE.putBlock(ModBlocks.RUBY_DOOR, RenderLayer.getCutout());
        BlockRenderLayerMap.INSTANCE.putBlock(ModBlocks.RUBY_TRAPDOOR, RenderLayer.getCutout());

        BlockRenderLayerMap.INSTANCE.putBlock(ModBlocks.CAULIFLOWER_CROP, RenderLayer.getCutout());

        BlockRenderLayerMap.INSTANCE.putBlock(ModBlocks.PETUNIA, RenderLayer.getCutout());
        BlockRenderLayerMap.INSTANCE.putBlock(ModBlocks.POTTED_PETUNIA, RenderLayer.getCutout());

        ModModelPredicateProvider.registerModModels();

        EntityModelLayerRegistry.registerModelLayer(ModModelLayers.PORCUPINE, PorcupineModel::getTexturedModelData);
        EntityRendererRegistry.register(ModEntities.PORCUPINE, PorcupineRenderer::new);

        ParticleFactoryRegistry.getInstance().register(ModParticles.PINK_GARNET_PARTICLE, PinkGarnetParticle.Factory::new);
        ParticleFactoryRegistry.getInstance().register(ModParticles.NUCLEAR_SIGN_PARTICLE, NuclearSignParticle.Factory::new);

        FluidRenderHandlerRegistry.INSTANCE.register(ModFluids.STILL_SOAP_WATER, ModFluids.FLOWING_SOAP_WATER,
                SimpleFluidRenderHandler.coloredWater(0xA1E038D0));
        BlockRenderLayerMap.INSTANCE.putFluids(RenderLayer.getTranslucent(),
                ModFluids.STILL_SOAP_WATER, ModFluids.FLOWING_SOAP_WATER);

        FluidRenderHandlerRegistry.INSTANCE.register(ModFluids.STILL_SLUDGE, ModFluids.FLOWING_SLUDGE,
                SimpleFluidRenderHandler.coloredWater(0x32a852));
        BlockRenderLayerMap.INSTANCE.putFluids(RenderLayer.getTranslucent(),
                ModFluids.STILL_SLUDGE, ModFluids.FLOWING_SLUDGE);

        ModelLoadingRegistry.INSTANCE.registerModelProvider((manager, out) -> new ModelIdentifier(TutorialMod.mod_ID, "radiation_staff_3d", "inventory"));

        HandledScreens.register(ModScreenHandlers.GEM_EMPOWERING_SCREEN_HANDLER, GemEmpoweringScreen::new);
        ModMessages.registerS2CPackets();
        BlockEntityRendererFactories.register(ModBlockEntities.GEM_EMPOWERING_STATION_BE, GemEmpoweringBlockEntityRenderer::new);

        BlockRenderLayerMap.INSTANCE.putBlock(ModBlocks.DRIFTWOOD_SAPLING, RenderLayer.getCutout());
        BlockEntityRendererFactories.register(ModBlockEntities.MOD_SIGN_BLOCK_ENTITY, SignBlockEntityRenderer::new);
        BlockEntityRendererFactories.register(ModBlockEntities.MOD_HANGING_SIGN_BLOCK_ENTITY, HangingSignBlockEntityRenderer::new);

        TexturedRenderLayers.SIGN_TYPE_TEXTURES.put(ModWoodTypes.DRIFTWOOD, TexturedRenderLayers.getSignTextureId(ModWoodTypes.DRIFTWOOD));

    }
}

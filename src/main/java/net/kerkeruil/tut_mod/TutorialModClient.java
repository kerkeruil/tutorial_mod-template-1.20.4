package net.kerkeruil.tut_mod;

import net.fabricmc.api.ClientModInitializer;
import net.fabricmc.fabric.api.blockrenderlayer.v1.BlockRenderLayerMap;
import net.fabricmc.fabric.api.client.particle.v1.ParticleFactoryRegistry;
import net.fabricmc.fabric.api.client.rendering.v1.EntityModelLayerRegistry;
import net.fabricmc.fabric.api.client.rendering.v1.EntityRendererRegistry;
import net.kerkeruil.tut_mod.block.ModBlocks;
import net.kerkeruil.tut_mod.entities.ModEntities;
import net.kerkeruil.tut_mod.entities.client.PorcupineModel;
import net.kerkeruil.tut_mod.entities.client.PorcupineRenderer;
import net.kerkeruil.tut_mod.entities.layer.ModModelLayers;
import net.kerkeruil.tut_mod.particle.ModParticles;
import net.kerkeruil.tut_mod.particle.NuclearSignParticle;
import net.kerkeruil.tut_mod.particle.PinkGarnetParticle;
import net.kerkeruil.tut_mod.util.ModModelPredicateProvider;
import net.minecraft.client.render.RenderLayer;

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
    }
}

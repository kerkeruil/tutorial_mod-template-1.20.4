package net.kerkeruil.tut_mod;

import net.fabricmc.api.ClientModInitializer;
import net.fabricmc.fabric.api.client.rendering.v1.EntityModelLayerRegistry;
import net.fabricmc.fabric.api.client.rendering.v1.EntityRendererRegistry;
import net.kerkeruil.tut_mod.entities.ModEntities;
import net.kerkeruil.tut_mod.entities.client.PorcupineModel;
import net.kerkeruil.tut_mod.entities.client.PorcupineRenderer;
import net.kerkeruil.tut_mod.entities.layer.ModModelLayers;

public class TutorialModClient implements ClientModInitializer {
    @Override
    public void onInitializeClient() {

        EntityModelLayerRegistry.registerModelLayer(ModModelLayers.PORCUPINE, PorcupineModel::getTexturedModelData);
        EntityRendererRegistry.register(ModEntities.PORCUPINE, PorcupineRenderer::new);
    }
}

package net.kerkeruil.tut_mod.entities.client;

import net.kerkeruil.tut_mod.TutorialMod;
import net.kerkeruil.tut_mod.entities.custom.PorcupineEntity;
import net.kerkeruil.tut_mod.entities.layer.ModModelLayers;
import net.minecraft.client.render.VertexConsumerProvider;
import net.minecraft.client.render.entity.EntityRendererFactory;
import net.minecraft.client.render.entity.MobEntityRenderer;
import net.minecraft.client.util.math.MatrixStack;
import net.minecraft.util.Identifier;

public class PorcupineRenderer extends MobEntityRenderer<PorcupineEntity, PorcupineModel<PorcupineEntity>> {
    private static final Identifier TEXTURE = new Identifier(TutorialMod.mod_ID, "textures/entity/porcupine.png");

    public PorcupineRenderer(EntityRendererFactory.Context ctx) {
        super(ctx, new PorcupineModel<>(ctx.getPart(ModModelLayers.PORCUPINE)), 0.6f);
    }

    @Override
    public Identifier getTexture(PorcupineEntity entity) {
        return TEXTURE;
    }

    @Override
    public void render(PorcupineEntity livingEntity, float f, float g, MatrixStack matrixStack,
                       VertexConsumerProvider vertexConsumerProvider, int i) {
        if(livingEntity.isBaby()) {
            matrixStack.scale(0.5f, 0.5f, 0.5f);
        } else {
            matrixStack.scale(1f, 1f, 1f);
        }

        super.render(livingEntity, f, g, matrixStack, vertexConsumerProvider, i);
    }
}
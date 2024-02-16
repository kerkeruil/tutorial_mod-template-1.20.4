package net.kerkeruil.tut_mod.entities.layer;

import net.kerkeruil.tut_mod.TutorialMod;
import net.minecraft.client.render.entity.model.EntityModelLayer;
import net.minecraft.util.Identifier;

public class ModModelLayers {
    public static final EntityModelLayer PORCUPINE =
            new EntityModelLayer(new Identifier(TutorialMod.mod_ID, "porcupine"), "main");
}

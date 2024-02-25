package net.kerkeruil.tut_mod.recipe;


import net.kerkeruil.tut_mod.TutorialMod;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;

public class ModRecipes {
    public static void registerRecipes() {
        Registry.register(Registries.RECIPE_SERIALIZER, new Identifier(TutorialMod.mod_ID, GemEmpoweringRecipe.Serializer.ID),
                GemEmpoweringRecipe.Serializer.INSTANCE);
        Registry.register(Registries.RECIPE_TYPE, new Identifier(TutorialMod.mod_ID, GemEmpoweringRecipe.Type.ID),
                GemEmpoweringRecipe.Type.INSTANCE);

    }
}

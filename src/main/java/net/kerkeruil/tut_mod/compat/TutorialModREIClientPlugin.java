package net.kerkeruil.tut_mod.compat;


import me.shedaniel.math.Rectangle;
import me.shedaniel.rei.api.client.plugins.REIClientPlugin;
import me.shedaniel.rei.api.client.registry.category.CategoryRegistry;
import me.shedaniel.rei.api.client.registry.display.DisplayRegistry;
import me.shedaniel.rei.api.client.registry.screen.ScreenRegistry;
import me.shedaniel.rei.api.common.util.EntryStacks;
import net.kerkeruil.tut_mod.block.ModBlocks;
import net.kerkeruil.tut_mod.recipe.GemEmpoweringRecipe;
import net.kerkeruil.tut_mod.screen.GemEmpoweringScreen;


public class TutorialModREIClientPlugin implements REIClientPlugin {
    @Override
    public void registerCategories(CategoryRegistry registry) {
        registry.add(new GemEmpoweringCategory());

        registry.addWorkstations(GemEmpoweringCategory.GEM_EMPOWERING, EntryStacks.of(ModBlocks.GEM_EMPOWERING_STATION));
    }

    @Override
    public void registerDisplays(DisplayRegistry registry) {
        registry.registerRecipeFiller(GemEmpoweringRecipe.class, GemEmpoweringRecipe.Type.INSTANCE,
                GemEmpoweringDisplay::new);

    }

    @Override
    public void registerScreens(ScreenRegistry registry) {
        registry.registerClickArea(screen -> new Rectangle(((screen.width - 176) / 2) + 78,
                        ((screen.height - 166) / 2) + 30, 20, 25),
                GemEmpoweringScreen.class,
                GemEmpoweringCategory.GEM_EMPOWERING);
    }
}
package net.kerkeruil.tut_mod.datagen;

import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricAdvancementProvider;
import net.kerkeruil.tut_mod.TutorialMod;
import net.kerkeruil.tut_mod.item.ModItems;
import net.minecraft.advancement.Advancement;
import net.minecraft.advancement.AdvancementDisplay;
import net.minecraft.advancement.AdvancementEntry;
import net.minecraft.advancement.AdvancementFrame;
import net.minecraft.advancement.criterion.InventoryChangedCriterion;
import net.minecraft.item.ItemStack;
import net.minecraft.text.Text;
import net.minecraft.util.Identifier;

import java.util.Optional;
import java.util.function.Consumer;

public class ModAdvancementProvider extends FabricAdvancementProvider {
    public ModAdvancementProvider(FabricDataOutput output) {
        super(output);
    }

    @Override
    public void generateAdvancement(Consumer<AdvancementEntry> consumer) {
        AdvancementEntry rootAdvancement = Advancement.Builder.create()
                .display(new AdvancementDisplay(new ItemStack(ModItems.COAL_BRIQUETTE),
                        Text.literal("MC Course"), Text.literal("The Power lies in the Pink Garnet!"),
                        Optional.of(new Identifier(TutorialMod.mod_ID, "textures/block/ruby_ore.png")), AdvancementFrame.TASK,
                        true, true, false))
                .criterion("has_pink_garnet", InventoryChangedCriterion.Conditions.items(ModItems.RUBY))
                .build(consumer, TutorialMod.mod_ID + ":tutorialmod");

        AdvancementEntry metalDetector = Advancement.Builder.create()
                .display(new AdvancementDisplay(new ItemStack(ModItems.METAL_DETECTOR),
                        Text.literal("Metal Detector"), Text.literal("Batteries not included! (Actually doesn't need batteries)"),
                        Optional.of(new Identifier(TutorialMod.mod_ID, "block/pink_garnet_ore")), AdvancementFrame.TASK,
                        true, true, false))
                .criterion("has_used_metal_detector", InventoryChangedCriterion.Conditions.items(ModItems.METAL_DETECTOR))
                .parent(rootAdvancement)
                .build(consumer, TutorialMod.mod_ID + ":metal_detector");
    }
}
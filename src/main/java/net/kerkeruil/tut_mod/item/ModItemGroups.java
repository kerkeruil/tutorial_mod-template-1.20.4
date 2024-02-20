package net.kerkeruil.tut_mod.item;

import net.fabricmc.fabric.api.itemgroup.v1.FabricItemGroup;
import net.kerkeruil.tut_mod.TutorialMod;
import net.kerkeruil.tut_mod.block.ModBlocks;
import net.kerkeruil.tut_mod.block.custom.RubyLampBlock;
import net.minecraft.block.Blocks;
import net.minecraft.block.enums.WireConnection;
import net.minecraft.data.client.*;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.state.property.Properties;
import net.minecraft.text.Text;
import net.minecraft.util.Identifier;

public class ModItemGroups {
    public static final ItemGroup RUBY_GROUP = Registry.register(Registries.ITEM_GROUP,
            new Identifier(TutorialMod.mod_ID, "ruby"),
            FabricItemGroup.builder().displayName(Text.translatable("itemgroup.ruby"))
                    .icon(() -> new ItemStack(ModItems.RUBY)).entries((displayContext, entries) -> {
//                      Items
                        entries.add(ModItems.RUBY);
                        entries.add(ModItems.RAW_RUBY);
                        entries.add(ModItems.METAL_DETECTOR);
                        entries.add(ModItems.TOMATO);
                        entries.add(ModItems.COAL_BRIQUETTE);
                        entries.add(ModItems.DATA_TABLET);

                        entries.add(ModItems.CAULIFLOWER_SEEDS);
                        entries.add(ModItems.CAULIFLOWER);

                        entries.add(ModItems.BAR_BRAWL_MUSIC_DISC);

                        entries.add(ModBlocks.PETUNIA);

//                      Tools
                        entries.add(ModItems.RUBY_SWORD);
                        entries.add(ModItems.RUBY_AXE);
                        entries.add(ModItems.RUBY_PICKAXE);
                        entries.add(ModItems.RUBY_SHOVEL);
                        entries.add(ModItems.RUBY_HOE);
                        entries.add(ModItems.RUBY_PAXEL);
                        entries.add(ModItems.RADIATION_STAFF);
                        entries.add(ModItems.RUBY_BOW);
                        entries.add(ModItems.RUBY_SHIELD);


//                      Armor
                        entries.add(ModItems.RUBY_HELMET);
                        entries.add(ModItems.RUBY_CHESTPLATE);
                        entries.add(ModItems.RUBY_LEGGINGS);
                        entries.add(ModItems.RUBY_BOOTS);
                        entries.add(ModItems.RUBY_HORSE_ARMOR);

                        entries.add(ModItems.HAZMAT_SUIT_HELMET);
                        entries.add(ModItems.HAZMAT_SUIT_CHESTPLATE);
                        entries.add(ModItems.HAZMAT_SUIT_LEGGINGS);
                        entries.add(ModItems.HAZMAT_SUIT_BOOTS);


//                      Blocks
                        entries.add(ModBlocks.RUBY_BLOCK);
                        entries.add(ModBlocks.RAW_RUBY_BLOCK);
                        entries.add(ModBlocks.RUBY_ORE);
                        entries.add(ModBlocks.SOUND_BLOCK);

                        entries.add(ModBlocks.RUBY_LAMP_BLOCK);

//                      Non-blocks
                        entries.add(ModBlocks.RUBY_STAIRS);
                        entries.add(ModBlocks.RUBY_SLAB);
                        entries.add(ModBlocks.RUBY_BUTTON);
                        entries.add(ModBlocks.RUBY_PRESSURE_PLATE);
                        entries.add(ModBlocks.RUBY_FENCE);
                        entries.add(ModBlocks.RUBY_FENCE_GATE);
                        entries.add(ModBlocks.RUBY_WALL);
                        entries.add(ModBlocks.RUBY_DOOR);
                        entries.add(ModBlocks.RUBY_TRAPDOOR);
                        entries.add(ModBlocks.GEM_EMPOWERING_STATION);


//                      Custom blocks
                        entries.add(ModBlocks.NUCLEAR_BARREL_BLOCK);
                        entries.add(ModBlocks.BARBED_WIRE_BLOCK);

//                      Spawn Egg
                        entries.add(ModItems.PORCUPINE_SPAWN_EGG);
                    }).build());

    public static void registerItemGroups() {
        TutorialMod.LOGGER.info("Registering Item Groups for " + TutorialMod.mod_ID);
    }
}

package net.kerkeruil.tut_mod.block;

import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.fabricmc.fabric.api.object.builder.v1.block.FabricBlockSettings;
import net.kerkeruil.tut_mod.TutorialMod;
import net.kerkeruil.tut_mod.block.custom.CauliflowerCropBlock;
import net.kerkeruil.tut_mod.block.custom.RubyLampBlock;
import net.kerkeruil.tut_mod.block.custom.SoundBlock;
import net.kerkeruil.tut_mod.sounds.ModSounds;
import net.minecraft.block.*;
import net.minecraft.block.enums.Instrument;
import net.minecraft.entity.effect.StatusEffect;
import net.minecraft.entity.effect.StatusEffects;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.sound.BlockSoundGroup;
import net.minecraft.util.Identifier;

import java.awt.*;

public class ModBlocks {
    public static final Block RUBY_BLOCK = registerBlock("ruby_block",
//          use .create for a total new block
//          or just at copyOf(Blocks.IRON_BLOCK).sound() to override for example the sound
            new Block(FabricBlockSettings.copyOf(Blocks.IRON_BLOCK).sounds(BlockSoundGroup.AMETHYST_BLOCK)));
    public static final Block RAW_RUBY_BLOCK = registerBlock("raw_ruby_block", new Block(FabricBlockSettings.copyOf(Blocks.IRON_BLOCK).sounds(BlockSoundGroup.AMETHYST_BLOCK)));
    public static final Block RUBY_ORE = registerBlock("ruby_ore", new Block(FabricBlockSettings.copyOf(Blocks.IRON_ORE).sounds(BlockSoundGroup.AMETHYST_BLOCK)));
    public static final Block SOUND_BLOCK = registerBlock("sound_block", new SoundBlock(FabricBlockSettings.copyOf(Blocks.IRON_BLOCK).sounds(BlockSoundGroup.AMETHYST_BLOCK)));
    public static final Block RUBY_STAIRS = registerBlock("ruby_stairs", new StairsBlock(ModBlocks.RUBY_BLOCK.getDefaultState(), FabricBlockSettings.copyOf(Blocks.IRON_BLOCK)));
    public static final Block RUBY_SLAB = registerBlock("ruby_slab", new SlabBlock(FabricBlockSettings.copyOf(Blocks.IRON_BLOCK)));

    //  Ticks is how long it stays pressed. 10 is half a second.
//  BlockSetType are thinks like, being opened by hand and such.
    public static final Block RUBY_BUTTON = registerBlock("ruby_button", new ButtonBlock(BlockSetType.IRON, 10, FabricBlockSettings.copyOf(Blocks.STONE_BUTTON)));
    public static final Block RUBY_PRESSURE_PLATE = registerBlock("ruby_pressure_plate", new PressurePlateBlock(BlockSetType.IRON, FabricBlockSettings.copyOf(Blocks.STONE_PRESSURE_PLATE)));
    public static final Block RUBY_FENCE = registerBlock("ruby_fence", new FenceBlock(FabricBlockSettings.copyOf(Blocks.IRON_BLOCK)));
    public static final Block RUBY_FENCE_GATE = registerBlock("ruby_fence_gate", new FenceGateBlock(WoodType.OAK, FabricBlockSettings.copyOf(Blocks.IRON_BLOCK)));
    public static final Block RUBY_WALL = registerBlock("ruby_wall", new WallBlock(FabricBlockSettings.copyOf(Blocks.IRON_BLOCK)));
    public static final Block RUBY_DOOR = registerBlock("ruby_door",
            new DoorBlock(BlockSetType.IRON, FabricBlockSettings.copyOf(Blocks.IRON_DOOR)));
    public static final Block RUBY_TRAPDOOR = registerBlock("ruby_trapdoor",
            new TrapdoorBlock(BlockSetType.IRON, FabricBlockSettings.copyOf(Blocks.IRON_TRAPDOOR)));

    public static final Block RUBY_LAMP_BLOCK = registerBlock("ruby_lamp_block",
            new RubyLampBlock( FabricBlockSettings.create()
                    .mapColor(MapColor.PINK)
                    .instrument(Instrument.BASEDRUM)
                    .strength(4f)
                    .requiresTool()
                    .luminance(state -> state.get(RubyLampBlock.CLICKED) ? 15 : 0)
                    .sounds(ModSounds.PINK_GARNET_LAMP_SOUNDS)));

    public static final Block CAULIFLOWER_CROP = registerBlockWithoutBlockItem("cauliflower_crop",
            new CauliflowerCropBlock(FabricBlockSettings.copyOf(Blocks.WHEAT)));

    //  Fuel
    public static final Block PETUNIA = registerBlock("petunia",
            new FlowerBlock(StatusEffects.BAD_OMEN, 4, FabricBlockSettings.copyOf(Blocks.ALLIUM)));
    public static final Block POTTED_PETUNIA = registerBlockWithoutBlockItem("potted_petunia",
            new FlowerPotBlock(PETUNIA, FabricBlockSettings.copyOf(Blocks.ALLIUM)));



    private static Block registerBlock(String name, Block block) {
        registerBlockItem(name, block);
        return Registry.register(Registries.BLOCK, new Identifier(TutorialMod.mod_ID, name), block);
    }

    private static Block registerBlockWithoutBlockItem(String name, Block block) {
        return Registry.register(Registries.BLOCK, new Identifier(TutorialMod.mod_ID, name), block);
    }
    private static Item registerBlockItem(String name, Block block) {
        return Registry.register(Registries.ITEM, new Identifier(TutorialMod.mod_ID, name),
                new BlockItem(block, new FabricItemSettings()));
    }
    public static void registerModBlocks() {
        TutorialMod.LOGGER.info("Registering ModBlocks for " + TutorialMod.mod_ID);
    }
}

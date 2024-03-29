package net.kerkeruil.tut_mod.datagen;

import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricModelProvider;
import net.kerkeruil.tut_mod.block.ModBlocks;
import net.kerkeruil.tut_mod.block.custom.CauliflowerCropBlock;
import net.kerkeruil.tut_mod.block.custom.RubyLampBlock;
import net.kerkeruil.tut_mod.fluid.ModFluids;
import net.kerkeruil.tut_mod.item.ModItems;
import net.minecraft.block.Blocks;
import net.minecraft.data.client.*;
import net.minecraft.data.family.BlockFamilies;
import net.minecraft.item.ArmorItem;
import net.minecraft.util.Identifier;

import java.util.Optional;

public class ModModelProvider extends FabricModelProvider {
    public ModModelProvider(FabricDataOutput output) {
        super(output);
    }

    @Override
    public void generateBlockStateModels(BlockStateModelGenerator blockStateModelGenerator) {
        BlockStateModelGenerator.BlockTexturePool rubyTexturePool = blockStateModelGenerator.registerCubeAllModelTexturePool(ModBlocks.RUBY_BLOCK);
        blockStateModelGenerator.registerSimpleCubeAll(ModBlocks.RAW_RUBY_BLOCK);
        blockStateModelGenerator.registerSimpleCubeAll(ModBlocks.RUBY_ORE);
        blockStateModelGenerator.registerSimpleCubeAll(ModBlocks.SOUND_BLOCK);

        rubyTexturePool.stairs(ModBlocks.RUBY_STAIRS);
        rubyTexturePool.slab(ModBlocks.RUBY_SLAB);
        rubyTexturePool.button(ModBlocks.RUBY_BUTTON);
        rubyTexturePool.pressurePlate(ModBlocks.RUBY_PRESSURE_PLATE);
        rubyTexturePool.fence(ModBlocks.RUBY_FENCE);
        rubyTexturePool.fenceGate(ModBlocks.RUBY_FENCE_GATE);
        rubyTexturePool.wall(ModBlocks.RUBY_WALL);

//      Door texture is different for blocks and items so need to be added to both folders
        blockStateModelGenerator.registerDoor(ModBlocks.RUBY_DOOR);
        blockStateModelGenerator.registerTrapdoor(ModBlocks.RUBY_TRAPDOOR);

        registerCustomLamp(blockStateModelGenerator);

        blockStateModelGenerator.registerCrop(ModBlocks.CAULIFLOWER_CROP, CauliflowerCropBlock.AGE, 0, 1, 2, 3, 4, 5, 6);
        blockStateModelGenerator.registerFlowerPotPlant(ModBlocks.PETUNIA, ModBlocks.POTTED_PETUNIA, BlockStateModelGenerator.TintType.NOT_TINTED);

        blockStateModelGenerator.registerNorthDefaultHorizontalRotation(ModBlocks.GEM_EMPOWERING_STATION);

//      Custom
        blockStateModelGenerator.registerAxisRotated(ModBlocks.NUCLEAR_BARREL_BLOCK, TexturedModel.END_FOR_TOP_CUBE_COLUMN, TexturedModel.END_FOR_TOP_CUBE_COLUMN_HORIZONTAL);
        blockStateModelGenerator.registerNorthDefaultHorizontalRotation(ModBlocks.BARBED_WIRE_BLOCK);

//      Wood
        blockStateModelGenerator.registerLog(ModBlocks.DRIFTWOOD_LOG).log(ModBlocks.DRIFTWOOD_LOG).wood(ModBlocks.DRIFTWOOD_WOOD);
        blockStateModelGenerator.registerLog(ModBlocks.STRIPPED_DRIFTWOOD_LOG).log(ModBlocks.STRIPPED_DRIFTWOOD_LOG).wood(ModBlocks.STRIPPED_DRIFTWOOD_WOOD);
        blockStateModelGenerator.registerSimpleCubeAll(ModBlocks.DRIFTWOOD_LEAVES);
        blockStateModelGenerator.registerTintableCrossBlockState(ModBlocks.DRIFTWOOD_SAPLING, BlockStateModelGenerator.TintType.NOT_TINTED);

        BlockStateModelGenerator.BlockTexturePool tPlnaks = blockStateModelGenerator.registerCubeAllModelTexturePool(ModBlocks.DRIFTWOOD_PLANKS);
        tPlnaks.family(BlockFamilies.register(ModBlocks.DRIFTWOOD_PLANKS).sign(ModBlocks.DRIFTWOOD_SIGN, ModBlocks.DRIFTWOOD_WALL_SIGN).build());

        blockStateModelGenerator.registerHangingSign(ModBlocks.STRIPPED_DRIFTWOOD_LOG, ModBlocks.DRIFTWOOD_HANGING_SIGN, ModBlocks.DRIFTWOOD_HANGING_WALL_SIGN);


    }


    // Use BlockStateModelGenerator for custom block generation. Add "BlockStateModelGenerator blockStateModelGenerator" as
    // input arguments for the function.
//    BlockStateModelGenerator
    private void registerCustomLamp(BlockStateModelGenerator blockStateModelGenerator) {
        Identifier identifier = TexturedModel.CUBE_ALL.upload(ModBlocks.RUBY_LAMP_BLOCK, blockStateModelGenerator.modelCollector);
        Identifier identifier2 = blockStateModelGenerator.createSubModel(ModBlocks.RUBY_LAMP_BLOCK, "_on", Models.CUBE_ALL, TextureMap::all);
        blockStateModelGenerator.blockStateCollector.accept(VariantsBlockStateSupplier.create(ModBlocks.RUBY_LAMP_BLOCK)
                .coordinate(BlockStateModelGenerator.createBooleanModelMap(RubyLampBlock.CLICKED, identifier2, identifier)));
    }
    @Override
    public void generateItemModels(ItemModelGenerator itemModelGenerator) {
        itemModelGenerator.register(ModItems.RUBY, Models.GENERATED);
        itemModelGenerator.register(ModItems.RAW_RUBY, Models.GENERATED);
        itemModelGenerator.register(ModItems.COAL_BRIQUETTE, Models.GENERATED);
        itemModelGenerator.register(ModItems.TOMATO, Models.GENERATED);
        itemModelGenerator.register(ModItems.CAULIFLOWER, Models.GENERATED);
        itemModelGenerator.register(ModItems.METAL_DETECTOR, Models.GENERATED);
        itemModelGenerator.register(ModItems.BAR_BRAWL_MUSIC_DISC, Models.GENERATED);
        itemModelGenerator.register(ModFluids.SOAP_WATER_BUCKET, Models.GENERATED);
        itemModelGenerator.register(ModFluids.SLUDGE_BUCKET, Models.GENERATED);

//        itemModelGenerator.register(ModItems.DATA_TABLET, Models.GENERATED);

        itemModelGenerator.register(ModItems.RUBY_SWORD, Models.HANDHELD);
        itemModelGenerator.register(ModItems.RUBY_PICKAXE, Models.HANDHELD);
        itemModelGenerator.register(ModItems.RUBY_SHOVEL, Models.HANDHELD);
        itemModelGenerator.register(ModItems.RUBY_AXE, Models.HANDHELD);
        itemModelGenerator.register(ModItems.RUBY_HOE, Models.HANDHELD);

        itemModelGenerator.register(ModItems.RUBY_PAXEL, Models.HANDHELD);

        itemModelGenerator.registerArmor(((ArmorItem) ModItems.RUBY_HELMET));
        itemModelGenerator.registerArmor(((ArmorItem) ModItems.RUBY_CHESTPLATE));
        itemModelGenerator.registerArmor(((ArmorItem) ModItems.RUBY_LEGGINGS));
        itemModelGenerator.registerArmor(((ArmorItem) ModItems.RUBY_BOOTS));

        itemModelGenerator.register(ModItems.RUBY_HORSE_ARMOR, Models.GENERATED);

        itemModelGenerator.registerArmor(((ArmorItem) ModItems.HAZMAT_SUIT_HELMET));
        itemModelGenerator.registerArmor(((ArmorItem) ModItems.HAZMAT_SUIT_CHESTPLATE));
        itemModelGenerator.registerArmor(((ArmorItem) ModItems.HAZMAT_SUIT_LEGGINGS));
        itemModelGenerator.registerArmor(((ArmorItem) ModItems.HAZMAT_SUIT_BOOTS));


        itemModelGenerator.register(ModItems.PORCUPINE_SPAWN_EGG,
                new Model(Optional.of(new Identifier("item/template_spawn_egg")), Optional.empty()));
    }

}

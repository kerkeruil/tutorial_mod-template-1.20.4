package net.kerkeruil.tut_mod.item;

import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.fabricmc.fabric.api.itemgroup.v1.FabricItemGroupEntries;
import net.fabricmc.fabric.api.itemgroup.v1.ItemGroupEvents;
import net.kerkeruil.tut_mod.TutorialMod;
import net.kerkeruil.tut_mod.block.ModBlocks;
import net.kerkeruil.tut_mod.entities.ModEntities;
import net.kerkeruil.tut_mod.item.custom.*;
import net.kerkeruil.tut_mod.sounds.ModSounds;
import net.minecraft.item.*;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;

public class ModItems {
    public static final Item RUBY = registerItem("ruby", new Item(new FabricItemSettings()));
    public static final Item RAW_RUBY = registerItem("raw_ruby", new Item(new FabricItemSettings()));
    public static final Item METAL_DETECTOR = registerItem("metal_detector",
            new MetalDetectorItem(new FabricItemSettings().maxDamage(64)));

//  Food
    public static final Item TOMATO = registerItem("tomato", new Item(new FabricItemSettings().food(ModFoodComponents.TOMATO)));

//  Crops
    public static final Item CAULIFLOWER = registerItem("cauliflower", new Item(new FabricItemSettings().food(ModFoodComponents.CAULIFLOWER)));
    public static final Item CAULIFLOWER_SEEDS = registerItem("cauliflower_seeds", new AliasedBlockItem(ModBlocks.CAULIFLOWER_CROP, new FabricItemSettings()));

//  Fuel
    public static final Item COAL_BRIQUETTE = registerItem("coal_briquette", new Item(new FabricItemSettings()));

//  Tools
    public static final Item RUBY_SWORD = registerItem("ruby_sword",
            new ModPoisonSwordItem(ModToolMaterial.RUBY, 2, 2f, new FabricItemSettings()));
    public static final Item RUBY_PICKAXE = registerItem("ruby_pickaxe",
            new PickaxeItem(ModToolMaterial.RUBY, 1, 1f, new FabricItemSettings()));
    public static final Item RUBY_SHOVEL = registerItem("ruby_shovel",
            new ShovelItem(ModToolMaterial.RUBY, 1, 1f, new FabricItemSettings()));
    public static final Item RUBY_AXE = registerItem("ruby_axe",
            new AxeItem(ModToolMaterial.RUBY, 6, -2f, new FabricItemSettings()));
    public static final Item RUBY_HOE = registerItem("ruby_hoe",
            new HoeItem(ModToolMaterial.RUBY, 0, 0.5f, new FabricItemSettings()));
    public static final Item RUBY_PAXEL = registerItem("ruby_paxel",
            new PaxelItem(ModToolMaterial.RUBY, 2, 1, new FabricItemSettings()));

//  Armor
//  Only change one armoritem a modarmor item, because this kicks off all the checks for statuseffect which can only happen when having a full set anyway
    public static final Item RUBY_HELMET = registerItem("ruby_helmet",  new ModArmorItem(ModArmorMaterials.RUBY, ArmorItem.Type.HELMET, new FabricItemSettings()));
    public static final Item RUBY_CHESTPLATE = registerItem("ruby_chestplate", new ArmorItem(ModArmorMaterials.RUBY, ArmorItem.Type.CHESTPLATE, new FabricItemSettings()));
    public static final Item RUBY_LEGGINGS = registerItem("ruby_leggings", new ArmorItem(ModArmorMaterials.RUBY, ArmorItem.Type.LEGGINGS, new FabricItemSettings()));
    public static final Item RUBY_BOOTS = registerItem("ruby_boots", new ArmorItem(ModArmorMaterials.RUBY, ArmorItem.Type.BOOTS, new FabricItemSettings()));

    public static final Item RUBY_HORSE_ARMOR = registerItem("ruby_horse_armor",
            new HorseArmorItem(14, "ruby", new FabricItemSettings()));

    public static final Item HAZMAT_SUIT_HELMET = registerItem("hazmat_suit_helmet", new ArmorItem(ModArmorMaterials.ANTI_RADIATION, ArmorItem.Type.HELMET, new FabricItemSettings()));
    public static final Item HAZMAT_SUIT_CHESTPLATE = registerItem("hazmat_suit_chestplate", new ArmorItem(ModArmorMaterials.ANTI_RADIATION, ArmorItem.Type.CHESTPLATE, new FabricItemSettings()));
    public static final Item HAZMAT_SUIT_LEGGINGS = registerItem("hazmat_suit_leggings", new ArmorItem(ModArmorMaterials.ANTI_RADIATION, ArmorItem.Type.LEGGINGS, new FabricItemSettings()));
    public static final Item HAZMAT_SUIT_BOOTS = registerItem("hazmat_suit_boots", new ArmorItem(ModArmorMaterials.ANTI_RADIATION, ArmorItem.Type.BOOTS, new FabricItemSettings()));

    public static final Item PORCUPINE_SPAWN_EGG = registerItem("porcupine_spawn_egg",
            new SpawnEggItem(ModEntities.PORCUPINE, 0xa86518, 0x3b260f, new FabricItemSettings()));

//   Other
    public static final Item DATA_TABLET = registerItem("data_tablet",
        new DataTabletItem(new FabricItemSettings().maxCount(1)));
    public static final Item BAR_BRAWL_MUSIC_DISC = registerItem("bar_brawl_music_disc",
            new MusicDiscItem(9, ModSounds.BAR_BRAWL, new FabricItemSettings().maxCount(1), 122));

    public static final Item RADIATION_STAFF =  registerItem("radiation_staff", new Item(new FabricItemSettings()));
    public static final Item RUBY_BOW =  registerItem("ruby_bow", new BowItem(new FabricItemSettings().maxDamage(500)));

    private static void addItemsToIngredientItemGroup(FabricItemGroupEntries entries) {
        entries.add(RUBY);
        entries.add(RAW_RUBY);
    }

    private static Item registerItem(String name, Item item) {
        return Registry.register(Registries.ITEM, new Identifier(TutorialMod.mod_ID, name), item);
    }

    public static void registerModItems() {
        TutorialMod.LOGGER.info("Registering Mod Items for " + TutorialMod.mod_ID);

        ItemGroupEvents.modifyEntriesEvent(ItemGroups.INGREDIENTS).register(ModItems::addItemsToIngredientItemGroup);
    }
}

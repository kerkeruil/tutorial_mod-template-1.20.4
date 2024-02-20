package net.kerkeruil.tut_mod.util;

import net.fabricmc.fabric.api.command.v2.CommandRegistrationCallback;
import net.fabricmc.fabric.api.entity.event.v1.ServerPlayerEvents;
import net.fabricmc.fabric.api.event.player.AttackEntityCallback;
import net.fabricmc.fabric.api.object.builder.v1.trade.TradeOfferHelper;
import net.fabricmc.fabric.api.registry.FuelRegistry;
import net.kerkeruil.tut_mod.Potion.ModPotions;
import net.kerkeruil.tut_mod.command.ReturnHomeCommand;
import net.kerkeruil.tut_mod.command.SetHomeCommand;
import net.kerkeruil.tut_mod.event.AttackEntityHandler;
import net.kerkeruil.tut_mod.event.PlayerCopyHandler;
import net.kerkeruil.tut_mod.item.ModItems;
import net.kerkeruil.tut_mod.mixin.BrewingRecipeRegistryMixin;
import net.kerkeruil.tut_mod.villager.ModVillagers;
import net.minecraft.block.ComposterBlock;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraft.potion.Potions;
import net.minecraft.village.TradeOffer;
import net.minecraft.village.VillagerProfession;

public class ModRegistries {
    public static void registerModStuffs() {
        registerFuels();
        registerModCompostables();
        registerCommands();
        registerEvents();
        registerPotionRecipes();
        registerCustomTrades();
    }

    private static void registerFuels() {
        FuelRegistry registry = FuelRegistry.INSTANCE;

        registry.add(ModItems.COAL_BRIQUETTE, 200);
    }

    private static void registerModCompostables() {
        ComposterBlock.ITEM_TO_LEVEL_INCREASE_CHANCE.put(ModItems.TOMATO, 0.5f);

        ComposterBlock.ITEM_TO_LEVEL_INCREASE_CHANCE.put(ModItems.CAULIFLOWER, 0.5f);
        ComposterBlock.ITEM_TO_LEVEL_INCREASE_CHANCE.put(ModItems.CAULIFLOWER_SEEDS, 0.25f);
    }

    private static void registerCommands() {
        CommandRegistrationCallback.EVENT.register(SetHomeCommand::register);
        CommandRegistrationCallback.EVENT.register(ReturnHomeCommand::register);
    }

    private static void registerEvents() {
        AttackEntityCallback.EVENT.register(new AttackEntityHandler());
        ServerPlayerEvents.COPY_FROM.register(new PlayerCopyHandler());
    }

    private static void registerPotionRecipes() {
        BrewingRecipeRegistryMixin.invokeRegisterPotionRecipe(Potions.AWKWARD, ModItems.RUBY, ModPotions.SLIMEY_POTION);
    }


    private static void registerCustomTrades() {
        TradeOfferHelper.registerVillagerOffers(VillagerProfession.FARMER, 1,
                factories -> {
                    factories.add((entity, random) -> new TradeOffer(
                            new ItemStack(Items.EMERALD, 2), // What to pay
                            new ItemStack(ModItems.CAULIFLOWER, 2), 6, 2, 0.02f // What you get
                    ));
                });

        TradeOfferHelper.registerVillagerOffers(VillagerProfession.TOOLSMITH, 3,
                factories -> {
                    factories.add((entity, random) -> new TradeOffer(
                            new ItemStack(Items.EMERALD, 16),
                            new ItemStack(ModItems.RUBY_PAXEL, 1), 2, 6, 0.08f
                    ));
                });

        TradeOfferHelper.registerVillagerOffers(ModVillagers.SOUND_MASTER, 1,
                factories -> {
                    factories.add((entity, random) -> new TradeOffer(
                            new ItemStack(Items.EMERALD, 4),
                            new ItemStack(ModItems.RADIATION_STAFF, 1), 6, 19, 0.08f
                    ));
                });

        TradeOfferHelper.registerVillagerOffers(ModVillagers.SOUND_MASTER, 2,
                factories -> {
                    factories.add((entity, random) -> new TradeOffer(
                            new ItemStack(Items.EMERALD, 16),
                            new ItemStack(ModItems.METAL_DETECTOR, 1), 1, 5, 0.08f
                    ));
                });
    }
}

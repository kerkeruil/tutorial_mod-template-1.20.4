package net.kerkeruil.tut_mod.screen;

import net.fabricmc.fabric.api.screenhandler.v1.ExtendedScreenHandlerType;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.screen.ScreenHandlerType;
import net.minecraft.util.Identifier;
import net.kerkeruil.tut_mod.TutorialMod;

public class ModScreenHandlers {
    public static final ScreenHandlerType<GemEmpoweringScreenHandler> GEM_EMPOWERING_SCREEN_HANDLER =
            Registry.register(Registries.SCREEN_HANDLER, new Identifier(TutorialMod.mod_ID, "gem_empowering_screen_handler"),
                    new ExtendedScreenHandlerType<>(GemEmpoweringScreenHandler::new));


    public static void registerScreenHandler() {
        TutorialMod.LOGGER.info("Registering Screen Handlers for " + TutorialMod.mod_ID);
    }
}
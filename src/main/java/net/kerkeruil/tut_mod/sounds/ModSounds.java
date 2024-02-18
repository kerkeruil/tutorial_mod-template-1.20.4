package net.kerkeruil.tut_mod.sounds;


import net.kerkeruil.tut_mod.TutorialMod;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.sound.SoundEvent;
import net.minecraft.util.Identifier;

public class ModSounds {
    public static final SoundEvent METAL_DETECTOR_FOUND_ORE = registerSoundEvent("metal_detector_found_ore");

    private static SoundEvent registerSoundEvent(String name) {
        Identifier identifier = new Identifier(TutorialMod.mod_ID, name);
        return Registry.register(Registries.SOUND_EVENT, identifier, SoundEvent.of(identifier));
    }

    public static void registerSounds() {
        TutorialMod.LOGGER.info("Registering Mod Sounds for " + TutorialMod.mod_ID);
    }
}

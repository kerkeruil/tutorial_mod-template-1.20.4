package net.kerkeruil.tut_mod.particle;

import net.fabricmc.fabric.api.particle.v1.FabricParticleTypes;
import net.kerkeruil.tut_mod.TutorialMod;
import net.minecraft.particle.DefaultParticleType;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;

public class ModParticles {
    public static final DefaultParticleType PINK_GARNET_PARTICLE =
            registerParticle("pink_garnet_particle", FabricParticleTypes.simple());


    private static DefaultParticleType registerParticle(String name, DefaultParticleType particleType) {
        return Registry.register(Registries.PARTICLE_TYPE, new Identifier(TutorialMod.mod_ID, name), particleType);
    }

    public static void registerParticles() {
        TutorialMod.LOGGER.info("Registering Particles for " + TutorialMod.mod_ID);
    }
}
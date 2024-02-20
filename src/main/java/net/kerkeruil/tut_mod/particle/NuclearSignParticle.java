package net.kerkeruil.tut_mod.particle;

import net.minecraft.client.particle.*;
import net.minecraft.client.world.ClientWorld;
import net.minecraft.particle.DefaultParticleType;

public class NuclearSignParticle extends SpriteBillboardParticle {
    public NuclearSignParticle(ClientWorld world, double xCoord, double yCoord, double zCoord,
                               SpriteProvider spriteSet, double xd, double yd, double zd) {
        super(world, xCoord, yCoord, zCoord, xd, yd, zd);
        this.gravityStrength = -0.125f;
        this.velocityMultiplier = 0.85f;
        this.setBoundingBoxSpacing(0.02f, 0.02f);
        this.scale *= this.random.nextFloat() * 0.6f + 0.2f;
        this.velocityX = xd * (double)0.2f + (Math.random() * 2.0 - 1.0) * (double)0.02f;
        this.velocityY = yd * (double)0.2f + (Math.random() * 2.0 - 1.0) * (double)0.02f;
        this.velocityZ = zd * (double)0.2f + (Math.random() * 2.0 - 1.0) * (double)0.02f;
        this.maxAge = (int)(15.0 / (Math.random() * 0.8 + 0.2));

        this.setSpriteForAge(spriteSet);


    }

    @Override
    public ParticleTextureSheet getType() {
        return ParticleTextureSheet.PARTICLE_SHEET_TRANSLUCENT;
    }

    public static class Factory implements ParticleFactory<DefaultParticleType> {
        private final SpriteProvider sprites;

        public Factory(SpriteProvider spriteProvider) {
            this.sprites = spriteProvider;
        }

        public Particle createParticle(DefaultParticleType particleType, ClientWorld clientWorld,
                                       double x, double y, double z, double xd, double yd, double zd) {
            return new NuclearSignParticle(clientWorld, x, y, z, this.sprites, xd, yd, zd);
        }
    }
}
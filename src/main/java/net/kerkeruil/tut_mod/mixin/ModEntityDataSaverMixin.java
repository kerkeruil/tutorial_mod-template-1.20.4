package net.kerkeruil.tut_mod.mixin;

import net.kerkeruil.tut_mod.util.IEntityDataSaver;
import net.minecraft.entity.Entity;
import net.minecraft.nbt.NbtCompound;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

import javax.security.auth.callback.Callback;

@Mixin(Entity.class)
public abstract class ModEntityDataSaverMixin implements IEntityDataSaver {
    private NbtCompound persistentData;

    @Override
    public NbtCompound getPersistentData() {
        if(this.persistentData == null) {
            this.persistentData = new NbtCompound();
        }
        return persistentData;
    }

    @Inject(method = "writeNbt", at = @At("head"))
    protected void injectWriteMethod(NbtCompound nbt, CallbackInfoReturnable<NbtCompound> info) {
        if(this.persistentData != null) {
            nbt.put("tutorialmod.custom_data", persistentData);
        }
    }
    @Inject(method = "readNbt", at = @At("head"))

    protected void injectReadMethod(NbtCompound nbt, CallbackInfo info) {
        if(nbt.contains("tutorialmod.custom_data", 10)) {
            this.persistentData = nbt.getCompound("tutorialmod.custom_data");
        }
    }
}

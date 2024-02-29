package net.kerkeruil.tut_mod.util;


import net.fabricmc.fabric.api.object.builder.v1.block.type.WoodTypeBuilder;
import net.kerkeruil.tut_mod.TutorialMod;
import net.minecraft.block.BlockSetType;
import net.minecraft.block.WoodType;
import net.minecraft.util.Identifier;

public class ModWoodTypes {
    public static final WoodType DRIFTWOOD = new WoodTypeBuilder().register(new Identifier(TutorialMod.mod_ID, "driftwood"), BlockSetType.OAK);
}

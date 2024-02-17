package net.kerkeruil.tut_mod.item.custom;

import net.kerkeruil.tut_mod.item.ModItems;
import net.kerkeruil.tut_mod.util.ModTags;
import net.minecraft.block.Block;
import net.minecraft.item.MiningToolItem;
import net.minecraft.item.ToolMaterial;
import net.minecraft.registry.tag.TagKey;

public class PaxelItem extends MiningToolItem {
//  Mines like axe, shovel and pixaxe
    public PaxelItem(ToolMaterial material, float attackDamage, float attackSpeed, Settings settings) {
        super(attackDamage, attackSpeed, material, ModTags.Blocks.PAXEL_MINEABLE, settings);
    }
}

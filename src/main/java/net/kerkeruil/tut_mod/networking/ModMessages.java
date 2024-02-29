package net.kerkeruil.tut_mod.networking;


import net.fabricmc.fabric.api.client.networking.v1.ClientPlayNetworking;
import net.kerkeruil.tut_mod.TutorialMod;
import net.kerkeruil.tut_mod.networking.packet.ItemStackSyncS2CPacket;
import net.minecraft.util.Identifier;

public class ModMessages {
    public static final Identifier ITEM_SYNC = new Identifier(TutorialMod.mod_ID, "item_sync");


    public static void registerS2CPackets() {
        ClientPlayNetworking.registerGlobalReceiver(ITEM_SYNC, ItemStackSyncS2CPacket::receive);
    }
}
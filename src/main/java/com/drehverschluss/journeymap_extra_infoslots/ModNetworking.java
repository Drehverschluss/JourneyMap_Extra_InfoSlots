
package com.drehverschluss.journeymap_extra_infoslots;

import net.minecraft.resources.ResourceLocation;
import net.minecraft.server.level.ServerPlayer;
import net.neoforged.neoforge.network.event.RegisterPayloadHandlersEvent;

public class ModNetworking {
    public static final ResourceLocation CHANNEL_NAME = ResourceLocation.fromNamespaceAndPath(JourneyMapExtraInfoSlots.MODID, "mob_level_at_pos");

    public static void register(RegisterPayloadHandlersEvent event) {
        event.registrar("main").playToClient(MobLevelAtPosPacket.TYPE, MobLevelAtPosPacket.STREAM_CODEC, (payload, context) -> {
            JourneyMapJMInfoSlot.setLastMobLevelAtPos(payload.getMobLevel());
        });
    }

    public static void sendMobLevelToClient(ServerPlayer player, int mobLevel) {
        player.connection.send(new MobLevelAtPosPacket(mobLevel));
    }
}

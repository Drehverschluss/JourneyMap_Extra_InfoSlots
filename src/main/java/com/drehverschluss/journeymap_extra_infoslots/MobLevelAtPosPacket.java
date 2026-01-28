

package com.drehverschluss.journeymap_extra_infoslots;

import net.minecraft.resources.ResourceLocation;
import net.minecraft.network.FriendlyByteBuf;
import net.minecraft.network.protocol.common.custom.CustomPacketPayload;
import net.minecraft.network.codec.StreamCodec;

public class MobLevelAtPosPacket implements CustomPacketPayload {
    public static final Type<MobLevelAtPosPacket> TYPE = new Type<>(
        ResourceLocation.fromNamespaceAndPath(JourneyMapExtraInfoSlots.MODID, "mob_level_at_pos")
    );

    public static final StreamCodec<FriendlyByteBuf, MobLevelAtPosPacket> STREAM_CODEC =
        CustomPacketPayload.codec(MobLevelAtPosPacket::write, MobLevelAtPosPacket::new);

    private final int mobLevel;



    public MobLevelAtPosPacket(int mobLevel) {
        this.mobLevel = mobLevel;
    }

    public MobLevelAtPosPacket(FriendlyByteBuf buf) {
        this(buf.readInt());
    }





    public void write(FriendlyByteBuf buf) {
        buf.writeInt(mobLevel);
    }

    @Override
    public Type<? extends CustomPacketPayload> type() {
        return TYPE;
    }

    public int getMobLevel() {
        return mobLevel;
    }
}

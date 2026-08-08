package com.drehverschluss.journeymap_extra_infoslots;

import dev.muon.dynamic_difficulty.api.LevelingAPI;
import net.minecraft.client.Minecraft;
import net.minecraft.client.player.LocalPlayer;

// Isolated in its own class so client-only types are never resolved when JourneyMap
// scans @JourneyMapPlugin classes on a dedicated server (would throw for invalid dist).
final class ClientPlayerLevelAccess {
    private ClientPlayerLevelAccess() {}

    static Integer getPlayerLevel() {
        LocalPlayer player = Minecraft.getInstance().player;
        return player != null ? LevelingAPI.getLevel(player) : null;
    }
}

package com.drehverschluss.journeymap_extra_infoslots;

import dev.muon.dynamic_difficulty.api.LevelingAPI;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.monster.Zombie;
import net.neoforged.neoforge.common.NeoForge;
import net.neoforged.neoforge.event.tick.ServerTickEvent;

public class ServerTickLevelLogger {
    // 20 Ticks = 1 Sekunde, passend zum 1000ms-Poll-Intervall des InfoSlots
    private static final int UPDATE_INTERVAL_TICKS = 20;
    private static int tickCounter = 0;

    public static void register() {
        NeoForge.EVENT_BUS.addListener(ServerTickLevelLogger::onServerTick);
    }

    private static void onServerTick(ServerTickEvent.Post event) {
        tickCounter++;
        if (tickCounter >= UPDATE_INTERVAL_TICKS) {
            tickCounter = 0;
            for (ServerPlayer player : event.getServer().getPlayerList().getPlayers()) {
                // Dummy-Zombie an Spielerposition erzeugen (nicht spawnen)
                Zombie dummy = EntityType.ZOMBIE.create(player.level());
                if (dummy != null) {
                    dummy.moveTo(player.getX(), player.getY(), player.getZ(), player.getYRot(), player.getXRot());
                    int mobLevel = LevelingAPI.calculateLevelForEntity(dummy);
                    // Sende Wert an Client
                    ModNetworking.sendMobLevelToClient(player, mobLevel);
                    // Optional: Logging
                    //JourneyMapExtraInfoSlots.LOGGER.info("[ServerTickLevelLogger] Player {}: MobLevelAtPos (Zombie) = {}", player.getGameProfile().getName(), mobLevel);
                }
            }
        }
    }
}
package com.drehverschluss.journeymap_extra_infoslots;

import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.monster.Zombie;
import dev.muon.dynamic_difficulty.api.LevelingAPI;
import net.fabricmc.fabric.api.event.lifecycle.v1.ServerTickEvents;
import net.minecraft.server.level.ServerPlayer;

@SuppressWarnings("unused")
public class ServerTickLevelLogger {
    private static int tickCounter = 0;

    public static void register() {
        // Registriert einen Callback, der bei jedem Server-Tick aufgerufen wird
        ServerTickEvents.END_SERVER_TICK.register(server -> {
            tickCounter++;
            if (tickCounter >= 100) { // 5 Sekunden bei 20 Ticks/Sekunde
                tickCounter = 0;
                for (ServerPlayer player : server.getPlayerList().getPlayers()) {
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
        });
    }
}
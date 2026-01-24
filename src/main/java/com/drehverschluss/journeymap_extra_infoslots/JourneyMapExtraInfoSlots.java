package com.drehverschluss.journeymap_extra_infoslots;

import org.slf4j.Logger;

import com.mojang.logging.LogUtils;

import net.neoforged.bus.api.IEventBus;
import net.neoforged.fml.ModContainer;
import net.neoforged.fml.common.Mod;

// The value here should match an entry in the META-INF/neoforge.mods.toml file
@Mod(JourneyMapExtraInfoSlots.MODID)
public class JourneyMapExtraInfoSlots {
    // Define mod id in a common place for everything to reference
    public static final String MODID = "journeymap_extra_infoslots";
    // Directly reference a slf4j logger
    public static final Logger LOGGER = LogUtils.getLogger();

    // The constructor for the mod class is the first code that is run when your mod is loaded.
    // FML will recognize some parameter types like IEventBus or ModContainer and pass them in automatically.
    public JourneyMapExtraInfoSlots(IEventBus modEventBus, ModContainer modContainer) {
        LOGGER.info("JourneyMap Extra InfoSlots mod initialized");
    }
}

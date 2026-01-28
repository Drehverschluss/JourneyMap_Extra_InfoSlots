package com.drehverschluss.journeymap_extra_infoslots;


import org.jetbrains.annotations.NotNull;

import dev.muon.dynamic_difficulty.api.LevelingAPI;
import journeymap.api.v2.client.IClientAPI;
import journeymap.api.v2.client.IClientPlugin;
import journeymap.api.v2.client.JourneyMapPlugin;
import journeymap.api.v2.client.event.RegistryEvent.InfoSlotRegistryEvent;
import journeymap.api.v2.common.event.ClientEventRegistry;
import net.minecraft.client.Minecraft;
import net.minecraft.network.chat.Component;

@JourneyMapPlugin(apiVersion = "2.0.0")
public class JourneyMapJMInfoSlot implements IClientPlugin {
	private static JourneyMapJMInfoSlot INSTANCE;
	private Minecraft mc;
	private final String infoKeyString1 = "menu.journeymapextrainfoslots.infodisplay.info1";
	private final String infoKeyString2 = "menu.journeymapextrainfoslots.infodisplay.info2";
	private final Component infoKey1 = Component.translatable(infoKeyString1);
	private final Component infoKey2 = Component.translatable(infoKeyString2);

	public JourneyMapJMInfoSlot() {}

	public static JourneyMapJMInfoSlot getInstance() {
		return INSTANCE;
	}

	@Override
	public void initialize(@NotNull IClientAPI api) {
		INSTANCE = this;
		this.mc = Minecraft.getInstance();

		ClientEventRegistry.INFO_SLOT_REGISTRY_EVENT.subscribe(this.getModId(), this::infoSlotRegistryEvent);
	}

	@Override
	public String getModId() {
		return "journeymap_extra_infoslots";
	}

	private void infoSlotRegistryEvent(InfoSlotRegistryEvent event) {
		event.register(getModId(), infoKey1, 1000L, this::getInfoHudText1);
		event.register(getModId(), infoKey2, 1000L, this::getInfoHudText2);
	}

	private Component getInfoHudText1() {
		   if (mc != null && mc.player != null) {
			   int playerLevel = LevelingAPI.getLevel(mc.player);
			   return Component.literal("Player Level: " + playerLevel);
		   } else {
			   return Component.literal("Player Level: N/A");
		   }
	}

	private Component getInfoHudText2() {
		return Component.literal("InfoSlot 2 ist aktiv!");
	}
}

package com.drehverschluss.journeymap_extra_infoslots;

import journeymap.api.v2.client.IClientAPI;
import journeymap.api.v2.client.IClientPlugin;
import journeymap.api.v2.client.JourneyMapPlugin;
import journeymap.api.v2.client.event.InfoSlotDisplayEvent;
import journeymap.api.v2.client.event.RegistryEvent.InfoSlotRegistryEvent;
import journeymap.api.v2.client.event.RegistryEvent.OptionsRegistryEvent;
import journeymap.api.v2.common.event.ClientEventRegistry;
import journeymap.api.v2.common.event.MinimapEventRegistry;
import net.minecraft.client.Minecraft;
import net.minecraft.network.chat.Component;
import org.jetbrains.annotations.NotNull;

@JourneyMapPlugin(apiVersion = "2.0.0")
public class JourneyMapJMInfoSlot implements IClientPlugin {
	private static JourneyMapJMInfoSlot INSTANCE;
	private IClientAPI api;
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
		this.api = api;
		this.mc = Minecraft.getInstance();

		ClientEventRegistry.INFO_SLOT_REGISTRY_EVENT.subscribe(this.getModId(), this::infoSlotRegistryEvent);
		ClientEventRegistry.OPTIONS_REGISTRY_EVENT.subscribe(this.getModId(), this::optionsRegistryEvent);
		MinimapEventRegistry.INFO_SLOT_DISPLAY_EVENT.subscribe(this.getModId(), this::infoSlotDisplayEvent);
	}

	@Override
	public String getModId() {
		return "journeymap_extra_infoslots";
	}

	private void infoSlotRegistryEvent(InfoSlotRegistryEvent event) {
		if (ModConfigs.extraInfoConfig.showInfoSlot1) {
			event.register(getModId(), infoKey1, 1000L, this::getInfoHudText1);
		}
		if (ModConfigs.extraInfoConfig.showInfoSlot2) {
			event.register(getModId(), infoKey2, 1000L, this::getInfoHudText2);
		}
	}

	private void optionsRegistryEvent(OptionsRegistryEvent event) {
		// Optionale Einstellungen für den InfoSlot können hier hinzugefügt werden
	}

	private void infoSlotDisplayEvent(InfoSlotDisplayEvent event) {
		// Hier kann das Verhalten beim Anzeigen angepasst werden
	}

	private Component getInfoHudText1() {
		if (mc != null && mc.player != null) {
			int difficulty = 0; // Platzhalter für echten Wert
			return Component.literal("Dynamic Difficulty: " + difficulty);
		} else {
			return Component.literal("Dynamic Difficulty: N/A");
		}
	}

	private Component getInfoHudText2() {
		return Component.literal("InfoSlot 2 ist aktiv!");
	}
}

package com.drehverschluss.journeymap_extra_infoslots;

import me.fzzyhmstrs.fzzy_config.config.Config;
import net.minecraft.resources.ResourceLocation;

public class ExtraInfoConfig extends Config {
    public boolean showInfoSlot1 = true;
    public boolean showInfoSlot2 = true;

    public ExtraInfoConfig() {
        super(ResourceLocation.fromNamespaceAndPath("journeymap_extra_infoslots", "extra_info"));
    }
}

package com.drehverschluss.journeymap_extra_infoslots;

import me.fzzyhmstrs.fzzy_config.api.ConfigApiJava;

public class ModConfigs {
    public static ExtraInfoConfig extraInfoConfig = ConfigApiJava.registerAndLoadConfig(ExtraInfoConfig::new);
    public static void init() {}
}

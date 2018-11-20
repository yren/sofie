package me.lokvin.kiwi.sofe.annotations;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class KiwiSettings {

    private static final Logger logger = LoggerFactory.getLogger(KiwiSettings.class);


    public static <T extends KiwiApplicationSettings> T createApplicationSettings(String configName, Class container, RefreshContext refreshContext) {
        T settings = null;
        return settings;
    }
}

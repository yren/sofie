package me.lokvin.kiwi.sofe.annotations;

import org.apache.commons.configuration2.Configuration;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class KiwiSettings {

    private static final Logger logger = LoggerFactory.getLogger(KiwiSettings.class);
    private static ApplicationSettingsIdentity identity;
    private static final Object mutex = new Object();


    public static void setIdentity(ApplicationSettingsIdentity identity) {
        synchronized (mutex) {
            KiwiSettings.identity = identity;
        }
    }

    public static ApplicationSettingsIdentity getIdentity() {
        return identity;
    }

    public static <T extends KiwiApplicationSettings> T createApplicationSettings(String configName, Class container) {
        T settings = null;
        identity.getConfigurationLock().lock();
        try {
            Configuration config = PropsConfigLoader.load(identity, configName);

        } finally {
            identity.getConfigurationLock().unlock();
        }
        return settings;
    }
}

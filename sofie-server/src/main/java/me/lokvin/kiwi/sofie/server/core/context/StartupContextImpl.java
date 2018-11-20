package me.lokvin.kiwi.sofie.server.core.context;

import me.lokvin.kiwi.sofe.annotations.ApplicationSettingsIdentity;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class StartupContextImpl implements StartupContext {

    private Logger logger = LoggerFactory.getLogger(StartupContextImpl.class);
    private String staticConfName;
    private String dynamicConfName;
    private ApplicationSettingsIdentity identity;

    public StartupContextImpl(String appName) {
        staticConfName = appName + "-static";
        dynamicConfName = appName + "-dynamic";
        identity = new ApplicationSettingsIdentity(appName);
        logger.info("static config file: {}, dynamic config file: {}", staticConfName, dynamicConfName);
    }

    public String getStaticConfName() {
        return staticConfName;
    }

    public String getDynamicConfName() {
        return dynamicConfName;
    }
}

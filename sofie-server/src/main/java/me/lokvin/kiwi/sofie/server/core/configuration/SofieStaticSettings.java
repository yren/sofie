package me.lokvin.kiwi.sofie.server.core.configuration;

import me.lokvin.kiwi.sofe.annotations.KiwiApplicationSettings;
import me.lokvin.kiwi.sofe.annotations.definitions.KiwiConfigProperty;
import me.lokvin.kiwi.sofe.annotations.definitions.KiwiConfigPropertyList;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.List;

public class SofieStaticSettings extends KiwiApplicationSettings {
    private static final Logger logger = LoggerFactory.getLogger(SofieStaticSettings.class);

    @KiwiConfigProperty private Class dynamicConfigClass;
    @KiwiConfigPropertyList(canBeNull = true, modifiable = false) private List<String> configurationGroups = null;
}
